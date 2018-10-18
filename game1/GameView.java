package edu.kean.game1;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.content.Context;
import android.graphics.Paint;


public class GameView extends View {


    //Variables
    private Bitmap ghost;
    private Bitmap background;

    //Score
    private Paint score = new Paint();

    //Level
    private Paint level = new Paint();

    public GameView(Context context){

        super(context);
        background= BitmapFactory.decodeResource(getResources(), R.drawable.background1);
        ghost= BitmapFactory.decodeResource(getResources(), R.drawable.ghost);

        //Score set up
        score.setColor(Color.WHITE);
        score.setTextSize(50);
        score.setTypeface(Typeface.DEFAULT_BOLD);
        score.setAntiAlias(true);

        //Level Set up
        
        score.setColor(Color.WHITE);
        score.setTextSize(50);
        score.setTypeface(Typeface.DEFAULT_BOLD);
        score.setAntiAlias(true);
    }


    protected void onDraw(Canvas canvas){

        canvas.drawBitmap(background,0,0, null);
        canvas.drawBitmap(ghost,0,300, null);
        canvas.drawText("Coins: 0", 20, 60, score);
        canvas.drawText("LVL: 0", 800, 60, score);


    }
}
