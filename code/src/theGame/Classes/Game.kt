package theGame.Classes

import theGame.Interfaces.IGame
import kotlin.random.Random

class Game(): IGame {
    private var deck:Deck = Deck()

    override fun Draw():Card {
        val index = Random.nextInt(0,deck.cards.size);
        val cardSuit = deck.cards[index].cardSuit
        val cardValue = deck.cards[index].value
        return Card(cardSuit,cardValue)
    }

    override fun Play() {
        TODO("Not yet implemented")
    }
}