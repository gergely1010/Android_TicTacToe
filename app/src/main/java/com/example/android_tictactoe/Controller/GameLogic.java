package com.example.android_tictactoe.Controller;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameLogic {

    //attribútum
    public String[] playerNames = {"First Player", "Second Player"};
    private Button playAgainBTN;
    private Button homeBTN;
    private TextView playerTurn;
    private int player = 1;
    public int[][] gameBoard;


    public GameLogic(){

        gameBoard = new int[3][3];

        for(int x = 0; x < 3; x++ ){
            for (int y = 0; y < 3; y++){
                gameBoard[x][y] = 0;
            }
        }
    }
    //getter setter
    public String[] getPlayerNames() {
        return playerNames;
    }
    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }
    public void setPlayAgainBTN(Button playAgainBTN){
        this.playAgainBTN = playAgainBTN;
    }
    public void setHomeBTN(Button homeBTN) {
        this.homeBTN = homeBTN;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }
    public void setPlayer(int player) {
        this.player = player;
    }
    public int[][] getGameBoard() {
         return gameBoard;
     }

     public int getPlayer(){
         return player;
      }
      public boolean updateGameBoard(int row, int col){
          if(playAgainBTN.getVisibility() == View.VISIBLE){
              return true;
          }
         if(gameBoard[row-1][col-1] == 0) {
             gameBoard[row-1][col-1] = player;
             if(WinnerCheck()){
                 return true;
             }
             else
             {
                 if(player == 1)
                 {
                     playerTurn.setText(playerNames[1].toString() + "'s turn");
                 }
                 else
                 {
                     playerTurn.setText(playerNames[0] + "'s turn");
                 }
             }
         }
         else
         {
            return false;
         }
         return true;
     }

     public boolean WinnerCheck(){
         boolean haveWinner = false;

         for(int x = 0; x < 3; x++ ){
             if(gameBoard[x][0] == gameBoard[x][1] && gameBoard[x][0] == gameBoard[x][2]  && gameBoard[x][0] != 0){
                 WeHaveWinner();
                 return true;
             }
         }
         for(int y = 0; y < 3; y++ ){
             if(gameBoard[0][y] == gameBoard[1][y] && gameBoard[0][y] == gameBoard[2][y]  && gameBoard[0][y] != 0){
                 WeHaveWinner();
                 return true;
             }
         }
         if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2]  && gameBoard[0][0] != 0){
             WeHaveWinner();
             return true;
         }
         if(gameBoard[2][0] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[0][2]  && gameBoard[0][2] != 0){
             WeHaveWinner();
             return true;
         }
         int boardFilled = 0;
         for(int x = 0; x < 3; x++ ){
             for (int y = 0; y < 3; y++){
                 if (gameBoard[x][y] != 0){
                     boardFilled++;
                 }
             }
         }
         if(boardFilled == 9){
             playAgainBTN.setVisibility(View.VISIBLE);
             homeBTN.setVisibility(View.VISIBLE);
             playerTurn.setText(("DRAW :/ !"));
         }
         return false;
     }
     public void WeHaveWinner(){
         playAgainBTN.setVisibility(View.VISIBLE);
         homeBTN.setVisibility(View.VISIBLE);
         playerTurn.setText((playerNames[player-1] + " WE HAVE WINNER!!!!"));
     }
     public void Reset(){
         for(int x = 0; x < 3; x++ ){
             for (int y = 0; y < 3; y++){
                 gameBoard[x][y] = 0;
             }
         }
         playAgainBTN.setVisibility(View.INVISIBLE);
         homeBTN.setVisibility(View.INVISIBLE);
         playerTurn.setText("");
     }
}
