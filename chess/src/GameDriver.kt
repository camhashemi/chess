class GameDriver {
  val turn = true
  val board = Board()

  fun usrInput(color : Color): Move {
    while (true)  {
      print("$color please enter your move : ")
      val input = readLine()
      val move = if (input == null) null else stringParser(input)
      if (move == null){
        print("Invalid input, please try again \n")
      }
      else {
        return move
      }
    }
  }

  private fun stringParser(str: String): Move? {
    val digitString = str.filter { it.isDigit() }
    if (digitString.length != 4) return null
    val (x1, y1, x2, y2) = digitString.map(Character::getNumericValue)
    return Move(Position(x1, y1), Position(x2, y2))
  }
}

fun main(args : Array<String>){
  val game = GameDriver()
  val gameOver = false
  var toMove = Color.White
  while (true) {
    val move = game.usrInput(toMove)
    game.board.move(move)
    toMove = if (toMove == Color.White) Color.Black else Color.White
    print(game.board)
  }

}

