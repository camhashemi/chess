interface Piece

data class King (val color: Boolean) : Piece
data class Queen (val color : Boolean) : Piece
data class Knight (val color : Boolean): Piece
data class Rook (val color : Boolean): Piece
data class Bishop (val color : Boolean): Piece
data class Pawn (val color : Boolean): Piece
