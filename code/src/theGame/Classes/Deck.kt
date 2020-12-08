package theGame.Classes

import kotlin.random.Random

class Deck {
    var cards = ArrayList<Card>()

    init
    {
        for(i in 0 until 4)
        {
            for(j in 1..13)
            {
                cards.add(Card(i,j))
            }
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