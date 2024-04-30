package com.example.android_tictactoe.Data;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android_tictactoe.R;

public class TicTacToe extends View {
    private final int boardColor;
    private final int xColor;
    private final int oColor;
    private final int winnigLineColor;
    private final Paint paint = new Paint();
    private  int cellSize = getWidth()/3;

    public TicTacToe(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray board = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TicTacToeBoard, 0, 0);
        try
        {
            boardColor = board.getInteger(R.styleable.TicTacToeBoard_boardColor, 0);
            xColor = board.getInteger(R.styleable.TicTacToeBoard_XColor, 0);
            oColor = board.getInteger(R.styleable.TicTacToeBoard_XColor, 0);
            winnigLineColor = board.getInteger(R.styleable.TicTacToeBoard_WinnigLineColor, 0);
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
    }

    private void drawGameBoard(Canvas canvas) {
        paint.setColor(boardColor);

        for(int c = 1; c < 3; c++)
        {
            canvas.drawLine(cellSize * c, 0, cellSize * c, canvas.getWidth(), paint);
        }

        for(int r = 1; r < 3; r++)
        {
            canvas.drawLine(0, cellSize * r, cellSize * r, canvas.getWidth(), paint);
        }

    }
}
