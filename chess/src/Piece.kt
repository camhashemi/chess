sealed class Piece {
  abstract val color: Color
  override fun toString() = "$color ${javaClass.canonicalName}"
}
class King (override val color: Color) : Piece()
class Queen (override val color : Color) : Piece()
class Knight (override val color : Color): Piece()
class Rook (override val color : Color): Piece()
class Bishop (override val color : Color): Piece()
class Pawn (override val color: Color): Piece()

enum class Color {
  White,
  Black
}

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
      grid.map { it.joinToString() }
          .reduce { rows, row -> "$rows\n$row" }
}

fun main(args: Array<String>) {
  println(Board())
}
