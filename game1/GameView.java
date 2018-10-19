package edu.kean.game1;

//Imported packages 
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.content.Context;
import android.graphics.Paint;


public class GameView extends View {


    //Objects
    private Bitmap ghost;
    private Bitmap background;
    private Bitmap coins;

    //canvas
    private int canvasHeight;
    private int canvasWidth;

    //ghost
    private int ghostX=10;
    private int ghostY;
    private int ghostSpeed;

    private boolean touch= false;

    //Score
    private Paint score = new Paint();

    //Level
    private Paint level = new Paint();

    public GameView(Context context){

        super(context);
        background= BitmapFactory.decodeResource(getResources(), R.drawable.background1);
        ghost= BitmapFactory.decodeResource(getResources(), R.drawable.ghost);
        coins= BitmapFactory.decodeResource(getResources(), R.drawable.coin);

        //Score set up
        score.setColor(Color.WHITE);
        score.setTextSize(70);
        score.setTypeface(Typeface.DEFAULT_BOLD);
        score.setAntiAlias(true);

        //Level Set up
        score.setColor(Color.WHITE);
        score.setTextSize(70);
        score.setTypeface(Typeface.DEFAULT_BOLD);
        score.setAntiAlias(true);
    }

    //Display images on the screen
    protected void onDraw(Canvas canvas){

        canvasWidth= canvas.getWidth();
        canvasHeight= canvas.getHeight();



        canvas.drawBitmap(background,0,0, null);

        //ghost
        //canvas.drawBitmap(ghost,0,300, null);
        int minGhostY = ghost.getHeight();
        int maxGhostY = canvasHeight - ghost.getHeight() * 3;

        ghostY += ghostSpeed;
        if(ghostY < minGhostY) ghostY= minGhostY;
        if(ghostY > maxGhostY) ghostY = maxGhostY;
        ghostSpeed += 2;

        if(touch){

            canvas.drawBitmap(ghost, ghostX, ghostY, null);
            touch= false;
        }

        else {
            canvas.drawBitmap(ghost, ghostX, ghostY, null);
        }

        //position of the ghost
        //ghostY= 0;

        //display coins, score and level on the screen
       // canvas.drawBitmap(coins,200,300, null);
        canvas.drawText("Coins: 0", 20, 70, score);
        canvas.drawText("LVL: 0", 800, 70, score);



    }

    //get inputs from the screen (touch)
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            touch= true;
            ghostSpeed = -20;
        }
        return true;

    }

}
