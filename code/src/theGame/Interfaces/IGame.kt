package theGame.Interfaces
import theGame.Classes.Card
import theGame.Classes.PlayerDTO

interface IGame {
    fun DrawCard(playerDTO: PlayerDTO): Card?
    fun Play()
    fun DistributeCards( playerDTO: PlayerDTO)
}