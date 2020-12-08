package theGame.Classes

class Card( val cardSuit:Int, val value: Int) {

    fun getSuit(card:Int):String
    {
        var suit:String = ""
        when(card)
        {
            0-> suit = "Clubs"
            1-> suit = "Diamonds"
            2-> suit = "Hearts"
            3-> suit = "Spades"
        }
        return suit
    }
    override fun toString(): String {
        return "$value of ${getSuit(cardSuit)}"
    }

}