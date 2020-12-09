package theGame.Classes

import kotlin.random.Random

class Deck {
    var cards = mutableListOf<Card>()

    init
    {
        for(i in 0 until 4)
        {
            for(j in 2..constants.CardValue.Ace)
            {
                cards.add(Card(i,j))
            }
            cards.add(Card(i,10))
            cards.add(Card(i,10))
            cards.add(Card(i,10))
        }
    }

    fun Shuffle()
    {
        for(i in 0 until cards.size)
        {
            var index = Random.nextInt(0,cards.size);
            cards[i] = cards[index].also { cards[index] = cards[i] }
        }
    }

}