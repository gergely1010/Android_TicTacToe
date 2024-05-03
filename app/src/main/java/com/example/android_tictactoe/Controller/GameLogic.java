package com.example.android_tictactoe.Controller;

import android.widget.Button;
import android.widget.TextView;

public class GameLogic {
     public int[][] getGameBoard() {
         return gameBoard;
     }

     private Button playAgainBTN;
     private Button homeBTN;
     private TextView playerTurn;

    public void setHomeBTN(Button homeBTN) {
        this.homeBTN = homeBTN;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    private int player = 1;

     public void setPlayer(int player) {
         this.player = player;
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

      public int getPlayer(){
         return player;
      }
     public boolean updateGameBoard(int row, int col){
         if(gameBoard[row-1][col-1] == 0)
         {
             gameBoard[row-1][col-1] = player;
         }
         else
         {
            return  false;
         }
         return  true;
     }

     public void Reset(){
         for(int x = 0; x < 3; x++ ){
             for (int y = 0; y < 3; y++){
                 gameBoard[x][y] = 0;
             }
         }
     }

    public void setPlayAgainBTN(Button playAgainBTN){
        this.playAgainBTN = playAgainBTN;
    }


}
