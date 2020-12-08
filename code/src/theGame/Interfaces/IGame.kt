package theGame.Interfaces
import theGame.Classes.Card

interface IGame {
    fun Draw(): Card
    fun Play()
}