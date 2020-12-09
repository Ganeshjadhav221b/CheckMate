package theGame.Classes

class PlayerDTO(player:Player): Player(player.Email,player.Password,player.UserName,player.BankRoll) {
    val cardsInhand = mutableListOf<Card>()
    var total:Int = 0
}