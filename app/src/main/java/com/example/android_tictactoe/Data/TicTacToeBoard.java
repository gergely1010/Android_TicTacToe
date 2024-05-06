package com.example.android_tictactoe.Data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android_tictactoe.Controller.GameLogic;
import com.example.android_tictactoe.R;

public class TicTacToeBoard extends View {
    private final int boardColor;
    private final int xColor;
    private final int oColor;
    private final int winningLineColor;
    private final Paint paint = new Paint();
    private  int cellSize = getWidth()/3;
    private GameLogic game;

    public TicTacToeBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        game = new GameLogic();
        TypedArray board = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TicTacToeBoard, 0, 0);
        try
        {
            boardColor = board.getInteger(R.styleable.TicTacToeBoard_boardColor, 0);
            xColor = board.getInteger(R.styleable.TicTacToeBoard_xColor, 0);
            oColor = board.getInteger(R.styleable.TicTacToeBoard_oColor, 0);
            winningLineColor = board.getInteger(R.styleable.TicTacToeBoard_winnigLineColor, 0);
        }
        finally{
            board.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int demensions = Math.min(getMeasuredWidth(), getMeasuredHeight());
        cellSize = demensions / 3;

        setMeasuredDimension(demensions, demensions);
    }
    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        
        drawGameBoard(canvas);
        drawMarkers(canvas);

        if(game.winningLine){
            drawWinnignLine(canvas);
        }

    }
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();

        int action = event.getAction();

        if(action == MotionEvent.ACTION_DOWN){
            int row = (int) Math.ceil(y/cellSize);
            int col = (int) Math.ceil(x/cellSize);

            if(game.updateGameBoard(row, col)){
                invalidate();

                if(game.getPlayer() % 2 == 0){
                    game.setPlayer(game.getPlayer()-1);
                }
                else
                {
                    game.setPlayer(game.getPlayer()+1);
                }
            }

            invalidate();


            return true;
        }
        return false;
    }
    private void drawGameBoard(Canvas canvas) {
        paint.setColor(boardColor);

        for(int c = 1; c < 3; c++)
        {
            canvas.drawLine(cellSize * c, 0, cellSize * c, canvas.getWidth(), paint);
        }

        for(int r = 1; r < 3; r++)
        {
            canvas.drawLine(0, cellSize * r, canvas.getHeight(),cellSize * r,  paint);
        }

    }
    private void drawMarkers(Canvas canvas){
        for(int x = 0; x < 3; x++ ){
            for (int y = 0; y < 3; y++){
                if(game.gameBoard[x][y] != 0)
                {
                    if(game.gameBoard[x][y] == 1)
                    {
                        drawXColor(canvas, x, y);
                    }else
                    {
                        drawOColor(canvas, x, y);
                    }
                }
            }
        }

    }
    private void drawXColor(Canvas canvas, int row, int col) {
        paint.setColor(xColor);

        canvas.drawLine((col+1)*cellSize, row*cellSize, col*cellSize, (row+1)*cellSize, paint);

        canvas.drawLine(col*cellSize, row*cellSize, (col+1)*cellSize, (row+1)*cellSize, paint);

    }
    private void drawOColor(Canvas canvas, int row, int col) {

        paint.setColor(oColor);

        canvas.drawOval(col*cellSize, row*cellSize, col*cellSize+cellSize, row*cellSize+cellSize, paint);
    }
    private void drawHorizontalLine(Canvas canvas, int row, int col){
        paint.setColor(winningLineColor);
        canvas.drawLine(col, row*cellSize+cellSize/2, col*3, row*cellSize+cellSize/2, paint);
    }
    private void drawVerticalLine(Canvas canvas, int row, int col){
        paint.setColor(winningLineColor);
        canvas.drawLine(col*cellSize+cellSize/2, row, col*cellSize+cellSize/2, cellSize*3, paint);
    }

    private void drawGrownLine(Canvas canvas, int row, int col){
        paint.setColor(winningLineColor);
        canvas.drawLine(0, 0, cellSize*3, cellSize*3, paint);
    }
    private void drawDesLine(Canvas canvas, int row, int col){
        paint.setColor(winningLineColor);
        canvas.drawLine(0, cellSize*3, cellSize*3, 0, paint);

    }
    private void drawWinnignLine(Canvas canvas){
        int row = game.getWinType()[0];
        int col = game.getWinType()[1];

        switch (game.getWinType()[2]){
            case 1:
                drawHorizontalLine(canvas, row, col);
                break;
            case 2:
                drawVerticalLine(canvas, row, col);
                break;
            case 3:
                drawGrownLine(canvas, row, col);
                break;
            case 4:
                drawDesLine(canvas, row, col);
                break;
        }
    }
    public void setUpGame(Button playAgain, Button home, TextView playerDisplay,  String[] names){
        game.setPlayAgainBTN(playAgain);
        game.setHomeBTN(home);
        game.setPlayerTurn(playerDisplay);
        game.setPlayerNames(names);
     }
    public void resetGame(){
        game.Reset();

    }
}
