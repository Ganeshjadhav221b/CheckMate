package constants

class Messages {
    companion object Message {
        val NewGame: String = "----Starting new game-----"

        val ShuffleDeck: String = "Hold tight, shuffling the decks for ya!"
        val DeckShuffled: String = "Deck's shuffled. Good to go..."
        val playerDrawnCards:String = "Player has drawn:"
        val Busted: String = " is busted."
        val Draw: String = "Its a draw."
        val Stand: String = "Woops! It's a checkmate."

        val CardsExhausted: String = "All cards exhausted."
        val GameEnded: String = "----Game's ended-----"
    }
}