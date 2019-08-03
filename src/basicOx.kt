var round = 0
var windy = 0
val table = arrayOf(
    arrayOf(' ', '1', '2', '3'),
    arrayOf('1', '-', '-', '-'),
    arrayOf('2', '-', '-', '-'),
    arrayOf('3', '-', '-', '-')
)

fun checkRound() {
    if(round % 2 == 0){
        print("Tune X ")
    }else{
        print("Tune O ")
    }
}


fun showTabel() {
    for( row in table ){
        for( col in row) {
            print("$col ")
        }
        println()
    }
}

fun inputRowCol() {
    while (true){
        try {
            checkRound()
            print("Please input R C: ")
            val input = readLine()
            val rcList = input?.split(" ")
            if(rcList?.size != 2) {
                println("Error: Must input 2 number R C (Ex: 1 2)")
                continue
            }
            val rowIndex = rcList[0].toInt()
            val colIndex = rcList[1].toInt()
            if (rowIndex <= 0  && colIndex <= 0 ){
                println("Error: Must be number more than 0")
                continue
            }
            if (table[rowIndex][colIndex] == '-') {
                if (round % 2 == 0) {
                    table[rowIndex][colIndex] = 'X'
                } else {
                    table[rowIndex][colIndex] = 'O'
                }
                round += 1
            }
            break
        }catch (t: Throwable){
            println("Error: ${t.message} ,Must be numbers R C (Ex: 1 2)")
        }
    }
}
fun checkWin() {
    if (table[1][1] == 'X' && table[1][2] == 'X' && table[1][3] == 'X'
        || table[2][1] == 'X' && table[2][2] == 'X' && table[2][3] == 'X'
        || table[3][1] == 'X' && table[3][2] == 'X' && table[3][3] == 'X'
        || table[1][1] == 'X' && table[2][1] == 'X' && table[3][1] == 'X'
        || table[1][2] == 'X' && table[2][2] == 'X' && table[3][2] == 'X'
        || table[1][3] == 'X' && table[2][3] == 'X' && table[3][3] == 'X'
        || table[1][1] == 'X' && table[2][2] == 'X' && table[3][3] == 'X'
        || table[3][1] == 'X' && table[2][2] == 'X' && table[1][3] == 'X'){
        println("Win X")
        windy = 1
    }else if (table[1][1] == 'O' && table[1][2] == 'O' && table[1][3] == 'O'
        || table[2][1] == 'O' && table[2][2] == 'O' && table[2][3] == 'O'
        || table[3][1] == 'O' && table[3][2] == 'O' && table[3][3] == 'O'
        || table[1][1] == 'O' && table[2][1] == 'O' && table[3][1] == 'O'
        || table[1][2] == 'O' && table[2][2] == 'O' && table[3][2] == 'O'
        || table[1][3] == 'O' && table[2][3] == 'O' && table[3][3] == 'O'
        || table[1][1] == 'O' && table[2][2] == 'O' && table[3][3] == 'O'
        || table[3][1] == 'O' && table[2][2] == 'O' && table[1][3] == 'O'){
        println("Win O")
        windy = 2
    }
}



fun main() {
    println("Welcome to OX Game")
    showTabel()
    while (round < 9){
        inputRowCol()
        showTabel()
        checkWin()
        if(windy == 1 || windy == 2){
            break
        }else if (round > 8){
            print("Draw")
        }
    }


}