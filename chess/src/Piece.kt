sealed class Piece(val color: Color) {
  override fun toString() = "${color.shortString()}${javaClass.canonicalName[0]}"
}
class King(color: Color) : Piece(color)
class Queen(color: Color) : Piece(color)
class Knight(color: Color): Piece(color)
class Rook(color: Color): Piece(color)
class Bishop(color: Color): Piece(color)
class Pawn(color: Color): Piece(color)

enum class Color {
  White,
  Black;

  fun shortString() : String = if (this == White) "W" else "B"
}

typealias Position = Pair<Int, Int>
typealias Move = Pair<Position, Position> //Todo change move.first & move.second | create class
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

  fun move(move: Move) {
    val removedOpt = remove(move.first)
    if (removedOpt != null) add(removedOpt, move.second)
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
          .map {
            it.joinToString(prefix = "[", separator = "][", postfix = "]")
                .replace("null", "  ")
          }
          .reduce { rows, row -> "$rows\n$row" } + "\n"
}
// todo: JS UI
// todo: JSON
