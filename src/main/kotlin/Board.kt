import kotlin.math.pow

class Board(private val n: Int){

    private val empty = "___"
    private var moveCount = 0
    var isGameOver = false
    private var board = Array(n) {Array(n) {empty} }

    fun resetBoard() {
        board = Array(n) {Array(n) {empty} }
    }

    fun printBoard() {
        board.forEach { row ->
            row.forEach { element ->
                if (element == empty) {
                    print("|${element}|")
                } else
                    print("| ${element} |")
            }
            println()
        }
        println()
    }

    fun placePiece(x: Int, y:Int, move: String){
        if(!isGameOver && isValidPosition(x,y))
        {
            if (board[x][y] != empty) {
                println("Position ($x, $y) is already occupied. Please choose another position.")
                return
            }

            moveCount++
            board[x][y] = move
            printBoard()
            isGameOver = isWinningMove(x, y, move) || isDraw()
            if(isGameOver && !isDraw()){
                println("You won")
            } else if(isDraw()) {
                println("It's a Draw!")
            }
        }
    }

    private fun isValidPosition(x: Int, y: Int): Boolean{
        return ((x in 0..<n) && (y in 0..<n))
    }

   private fun isWinningMove(x: Int, y: Int, move: String): Boolean {
       // for row
        for (i in 0 ..<n){
            if(board[x][i] != move){
                break
            }
            if(i==n -1){
                return true
            }
        }

       // for column
       for (i in 0 ..<n){
           if(board[i][y] != move){
               break
           }
           if(i==n -1){
               return true
           }
       }

       //for diagnol
       if(x==y) {
           for(i in 0 ..<n){
               if(board[i][i] != move){
                   break
               }
               if (i==n -1){
                   return true
               }
           }
       }

       //for anti-diagnol
       if(x+y == n-1){
           for (i in 0 ..<n){
               if(board[i][(n-1) - i] != move){
                   break
               }
               if(i==n-1){
                   return true
               }
           }
       }
       return false
    }

    fun isDraw():Boolean{
        return (moveCount == (n.toDouble().pow(2) -1).toInt())
    }

    fun resetGame(){
        resetBoard()
        isGameOver = false
        moveCount = 0
    }
}