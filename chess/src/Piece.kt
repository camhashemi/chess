import java.util.*

abstract class Piece

data class King (val color: Color) : Piece()
data class Queen (val color : Color) : Piece()
data class Knight (val color : Color): Piece()
data class Rook (val color : Color): Piece()
data class Bishop (val color : Color): Piece()
data class Pawn (val color: Color): Piece()

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
            arrayOf(
                    Rook(color),
                    Knight(color),
                    Bishop(color),
                    Queen(color),
                    King(color),
                    Bishop(color),
                    Knight(color),
                    Rook(color))
    private fun createPawnRow(color: Color): Array<Piece?> {
        val row = arrayOfNulls<Piece?>(8)
        for (i in 0..7) {
            row[i] = Pawn(color)
        }
        return row
    }

    override fun toString(): String = Arrays.toString(grid)
}

fun main(args: Array<String>) {
    println(Board())
}