package com.example.android_tictactoe.Controller;

 public class GameLogic {
     public int[][] getGameBoard() {
         return gameBoard;
     }

     /// X = 1
     /// O = 2
     public int[][] gameBoard;
     public GameLogic(){

         gameBoard = new int[3][3];

         for(int x = 0; x < 3; x++ ){
             for (int y = 0; y < 3; y++){
                 gameBoard[x][y] = 0;
             }
         }
     }

     public void GameBoardAddX(int row, int col){
         gameBoard[row][col] = 1;
     }

     public void GameBoardAddO(int row, int col){
         gameBoard[row][col] = 2;
     }
}
