import java.util.Scanner

private var board = Board(0)
private const val player1 = "X"
private const val player2 = "O"
private var currentPlayer = ""

fun main(){
    println("Please enter the size of you Board:")
    val scanner = Scanner(System.`in`)
    val size =  Integer.parseInt(scanner.nextLine())

    board = Board(size)
    board.printBoard()

    while (!board.isGameOver){
        takeTurns()
        println("${currentPlayer}'s turn")

        println("Enter row number:")
        val row = Integer.parseInt(scanner.nextLine())
        println("Enter column number:")
        val column = Integer.parseInt(scanner.nextLine())
        board.placePiece(row-1, column-1, currentPlayer)

        if(board.isGameOver){
            println("Do you wan to play again? Type y for yes")
            val nextGame = scanner.nextLine()
            if(isPlayingAgain(nextGame)){
                board.resetBoard()
                }
        }
    }
}

fun takeTurns(){
    currentPlayer = if (player1 == currentPlayer) {
        player2
    } else {
        player1
    }
}

fun isPlayingAgain(nextGame: String): Boolean {
    return nextGame.equals("y", ignoreCase = true)
}

fun getCurrentPlayer(): String {
    return currentPlayer
}