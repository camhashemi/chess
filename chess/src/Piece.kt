sealed class Piece(val color: Color)
class King (color: Color) : Piece(color)
class Queen (color : Color) : Piece(color)
class Knight (color : Color): Piece(color)
class Rook (color : Color): Piece(color)
class Bishop (color : Color): Piece(color)
class Pawn (color: Color): Piece(color)

enum class Color {
  White,
  Black
}

typealias Position = Pair<Int, Int>
typealias Grid = Array<Array<Piece?>>
class Board {

  private val grid: Grid = createBoard()

  private fun createBoard(): Grid = arrayOf(
      createBaseRow(Color.White),
      createPawnRow(Color.White),
      createEmptyRow(),
      createEmptyRow(),
      createEmptyRow(),
      createEmptyRow(),
      createPawnRow(Color.Black),
      createBaseRow(Color.Black))

  fun move(startPos: Position, endPos: Position ) {
    val removedOpt = remove(startPos)
    if (removedOpt != null) add(removedOpt, endPos)
  }
  private fun remove(pos: Position): Piece? {
    val removedPiece = grid[pos.first][pos.second]
    grid[pos.first][pos.second] = null
    return removedPiece
  }
  private fun add(piece: Piece, pos: Position) {
    grid[pos.first][pos.second] = piece
  }

  private fun createEmptyRow(): Array<Piece?> = arrayOfNulls(8)
  private fun createBaseRow(color: Color): Array<Piece?> =
      arrayOf(Rook(color), Knight(color), Bishop(color), Queen(color), King(color), Bishop(color), Knight(color), Rook(color))

  private fun createPawnRow(color: Color): Array<Piece?> {
    val row = arrayOfNulls<Piece?>(8)
    for (i in 0..7) {
        row[i] = Pawn(color)
    }
    return row
  }

  override fun toString(): String =
      grid.reversedArray()
          .map { it.joinToString() }
          .reduce { rows, row -> "$rows\n$row" }
}


// todo: stdout pretty print
// todo: JS UI
// todo: JSON
fun main(args: Array<String>) {
  val board = Board()
  println(board)

  board.move(Position(1, 1), Position(2, 2))
  println()
  println(board)
}
