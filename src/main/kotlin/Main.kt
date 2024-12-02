package org.example

fun main() {

    val mut2DList = mutableListOf(
        mutableListOf<Char>('_','_','_'),
        mutableListOf<Char>('_','_','_'),
        mutableListOf<Char>('_','_','_')
    )

    var gameIsOver = false
    var playerOneTurn = true
    var playerTwoTurn = false
    var horizontalCheck1: Boolean
    var horizontalCheck2: Boolean
    var horizontalCheck3: Boolean
    var verticalCheck1: Boolean
    var verticalCheck2: Boolean
    var verticalCheck3: Boolean
    var diagonalCheck1: Boolean
    var diagonalCheck2: Boolean


    fun showGrid(){
        println("---------")
        print("| " + mut2DList[0][0])
        print(" "+mut2DList[0][1]+" ")
        println(mut2DList[0][2] + " |")
        print("| " + mut2DList[1][0])
        print(" "+mut2DList[1][1]+" ")
        println(mut2DList[1][2] + " |")
        print("| " + mut2DList[2][0])
        print(" "+mut2DList[2][1]+" ")
        println(mut2DList[2][2] + " |")
        println("---------")
    }

    showGrid()


    fun victoryCheck (){
        //horizontal checks
        horizontalCheck1 = mut2DList[0][0] == mut2DList[0][1] && mut2DList[0][0] == mut2DList[0][2] && mut2DList[0][0] !='_'
        horizontalCheck2 = mut2DList[1][0] == mut2DList[1][1] && mut2DList[1][0] == mut2DList[1][2] && mut2DList[1][0] !='_'
        horizontalCheck3 = mut2DList[2][0] == mut2DList[2][1] && mut2DList[2][0] == mut2DList[2][2] && mut2DList[2][0] !='_'

        //Vertical checks
        verticalCheck1 = mut2DList[0][0] == mut2DList[1][0] && mut2DList[0][0] == mut2DList[2][0] && mut2DList[0][0] !='_'
        verticalCheck2 = mut2DList[0][1] == mut2DList[1][1] && mut2DList[0][1] == mut2DList[2][1] && mut2DList[0][1] !='_'
        verticalCheck3 = mut2DList[0][2] == mut2DList[1][2] && mut2DList[0][2] == mut2DList[2][2] && mut2DList[0][2] !='_'

        //Diagonal checks
        diagonalCheck1 = mut2DList[0][0] == mut2DList[1][1] && mut2DList[0][0] == mut2DList[2][2] && mut2DList[0][0] !='_'
        diagonalCheck2 = mut2DList[0][2] == mut2DList[1][1] && mut2DList[0][2] == mut2DList[2][0] && mut2DList[0][2] !='_'

        when{
            horizontalCheck1 -> {print(mut2DList[0][0]+" wins"); gameIsOver = true}
            horizontalCheck2 -> {print(mut2DList[1][0]+" wins"); gameIsOver = true}
            horizontalCheck3 -> {print(mut2DList[2][0]+" wins"); gameIsOver = true}
            verticalCheck1 -> {print(mut2DList[0][0]+" wins"); gameIsOver = true}
            verticalCheck2 -> {print(mut2DList[0][1]+" wins"); gameIsOver = true}
            verticalCheck3 -> {print(mut2DList[0][2]+" wins"); gameIsOver = true}
            diagonalCheck1 -> {print(mut2DList[0][0]+" wins"); gameIsOver = true}
            diagonalCheck2 -> {print(mut2DList[0][2]+" wins"); gameIsOver = true}
            !mut2DList[0].contains('_') && !mut2DList[1].contains('_') && !mut2DList[2].contains('_') && !horizontalCheck1 && !horizontalCheck2 && !horizontalCheck3 && !verticalCheck1 && !verticalCheck2 && !verticalCheck3 && !diagonalCheck1 && !diagonalCheck2 -> {print("Draw"); gameIsOver = true}
        }
    }

    var playerCoordinate1 = 0
    var playerCoordinate2 = 0

    var input2 = readln()
    var isInputValid = false

    fun checkIfInputIsValid(input : String) {

        try{
            playerCoordinate1 = input[0].digitToInt()
            playerCoordinate2 = input[2].digitToInt()

            if(playerCoordinate1>3 || playerCoordinate2>3 || playerCoordinate1==0 || playerCoordinate2 ==0){
                println("Coordinates should be from 1 to 3!")
            }

            else{
                isInputValid = true
            }

        }
        catch (e :Exception){
            println("You should enter numbers!")
        }

    }

    while(!gameIsOver){
        while (!isInputValid){
            checkIfInputIsValid(input2)
            if(!isInputValid){
                input2 = readln()
            }
            else if (mut2DList[playerCoordinate1-1][playerCoordinate2-1] != '_'){
                isInputValid = false
                println("This cell is occupied! Choose another one!")
                input2 = readln()
            }
            else if (playerOneTurn) {
                mut2DList[playerCoordinate1-1][playerCoordinate2-1] = 'X'
                playerOneTurn = false
                playerTwoTurn = true
                showGrid()
                victoryCheck()
                if(!gameIsOver){
                    isInputValid = false
                    input2 = readln()
                }
            }
            else if(playerTwoTurn){
                mut2DList[playerCoordinate1-1][playerCoordinate2-1] = 'O'
                playerOneTurn = true
                playerTwoTurn = false
                showGrid()
                victoryCheck()
                if(!gameIsOver){
                    isInputValid = false
                    input2 = readln()
                }
            }
        }

    }
}