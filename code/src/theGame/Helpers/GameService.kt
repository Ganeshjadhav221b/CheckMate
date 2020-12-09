package theGame
import constants.CardValue
import constants.CardSuit
import constants.Messages
import theGame.Classes.*
import theGame.Interfaces.IGame
import theGame.Interfaces.IGameService

fun initialize()
{
//    println(CardSuit.CLUBS)
//    println(CardValue.Ace)
//    println(Messages.NewGame)
        val deck: Deck = Deck()
        //print(deck.cards)
//    var card: Card = deck.cards[0]
//    println("Card is $card")
//
//    deck.Shuffle()
//      card = deck.cards[0]
//    println("Card $card")
//    //deck.cards.remove(card)
//    println("Size ${deck.cards.size}")
    val player1: Player = Player("ganeshjadhav221b@gmail.com","root1234","Ganesh",100)
    val dealer1: Player = Player("dealer@acmecasinos.com","root1234","dealer",1000)
    val table1:Table = Table("Earth",100)
    val game : Game = Game(player1,dealer1,table1)
    //println("Drawn: ${game.DrawCard()}")
    game.Play()

}

class GameService: IGameService
{
    override fun NewGame() {
        TODO("Not yet implemented")
    }

    override fun RestartGame() {
        TODO("Not yet implemented")
    }

    override fun EndGame() {
        TODO("Not yet implemented")
    }
}