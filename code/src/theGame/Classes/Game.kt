package theGame.Classes

import theGame.Interfaces.IGame
import kotlin.random.Random

class Game(val Player: Player, Dealer: Player, Table: Table) : IGame {
    private val deck: Deck = Deck()

    //to know who's turn it is, at any point of time.
    private val turn: Byte = 0 //0 for player, 1 for dealer
    private val player: PlayerDTO = PlayerDTO(player = Player)
    private val dealer: PlayerDTO = PlayerDTO(player = Dealer)
    private var winner: String = ""


    override fun Play() {
        deck.Shuffle()
        DistributeCards(player)
        DistributeCards(dealer)
        //Handle all the logic after drawing card
        val gameEnded: Boolean = gamePostDistribution(player)
        if (!gameEnded)
            gamePostDistribution(dealer)
        println("${constants.Messages.GameEnded}")
    }

    override fun DistributeCards(turnPlayer: PlayerDTO) {
        val firstCard: Card? = DrawCard(turnPlayer)
        val secondCard: Card? = DrawCard(turnPlayer)
        if (firstCard == null || secondCard == null) {
            print("${constants.Messages.CardsExhausted}")
            return
        }
        turnPlayer.cardsInhand.add(firstCard)
        turnPlayer.cardsInhand.add(secondCard)
        turnPlayer.total = firstCard.value + secondCard.value
        println("${constants.Messages.playerDrawnCards.replace("Player", turnPlayer.UserName)}")
        println("$firstCard")
        if (turnPlayer.UserName != "dealer") {
            println("$secondCard")
            println("${turnPlayer.UserName}'s total: ${turnPlayer.total}")
        }
    }

    override fun DrawCard(turnPlayer: PlayerDTO): Card? {
        val index = Random.nextInt(0, until = deck.cards.size - 1);
        val cardDrawSuccessful: Boolean = removeCard(index)
        if (!cardDrawSuccessful)
            return null

        val cardSuit = deck.cards[index].cardSuit
        var cardValue = deck.cards[index].value

        //Handling the soft state
        if (cardValue == constants.CardValue.Ace &&
            turnPlayer.total > (constants.GameConstants.MaxScore - constants.CardValue.Ace)
        )
        {
            println("Here: ${turnPlayer.total}, ${constants.GameConstants.MaxScore} , ${constants.CardValue.Ace}, $cardValue")
            cardValue = constants.GameConstants.HardValueForAce
        }
        return Card(cardSuit, cardValue)
    }

    private fun removeCard(index: Int): Boolean {
        //Keep a check for if all cards are exhausted
        if (deck.cards.size == 0)
            return false
        return deck.cards.remove(deck.cards[index])
    }

    private fun gamePostDistribution(turnPlayer: PlayerDTO): Boolean {
        val stand: Int = if (turnPlayer.UserName == constants.GameConstants.Dealer) 1 else Random.nextInt(0, 2)
        var card: Card?

        //player gets 21 score in first 2 cards.
        if(turnPlayer.total.toByte() == constants.GameConstants.MaxScore){
            winner = turnPlayer.UserName
            println("$winner has won with score ${turnPlayer.total}")
            return true
        }
        while (true) {
            if (stand == 1) {
                card = DrawCard(turnPlayer)
                if (card == null)
                    return true
                println("${turnPlayer.UserName} has drawn again - $card")
                turnPlayer.cardsInhand.add(card)
                turnPlayer.total += card.value
                println("${turnPlayer.UserName}'s new total : ${turnPlayer.total}")

                if (turnPlayer.total > constants.GameConstants.MaxScore) {
                    println("${turnPlayer.UserName} ${constants.Messages.Busted}")
                    return true
                }
                if (turnPlayer.UserName == constants.GameConstants.Dealer) {
                    if (turnPlayer.total < constants.GameConstants.MinScoreFordealer) {
                        continue
                    }
                    if (turnPlayer.total > player.total) {
                        winner = constants.GameConstants.Dealer
                        println("${constants.GameConstants.Dealer}  has won with score ${turnPlayer.total}")
                        return true
                    } else if (turnPlayer.total == player.total) {
                        println("${constants.Messages.Draw}")
                        return true
                    }
                }
            } else {
                println("${player.UserName}'s done(stand) at ${player.total}")
                break
            }
        }
        return false
    }
}