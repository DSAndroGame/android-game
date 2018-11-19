package edu.kean.game1;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.icu.util.Output;
import android.util.Log;
import android.view.Display;
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
    private Bitmap enemy;

    //canvas
    private int canvasHeight;
    private int canvasWidth;

    //ghost
    private int ghostX=10;
    private int ghostY;
    private int ghostSpeed;

    private boolean touch= false;


    //Coins
    private int coinX;
    private int coinY;
    private int coinSpeed = 15;
    private Paint coinPaint= new Paint();

    //enemy
    private int enemyX;
    private int enemyY;
    private int enemySpeed = 15;
    private Paint enemyPaint= new Paint();


    //Score
    private Paint scorePaint = new Paint();
    private int score;

    //Level
    private Paint levelPaint = new Paint();

    public GameView(Context context){

        super(context);
        background= BitmapFactory.decodeResource(getResources(), R.drawable.background1);
        ghost= BitmapFactory.decodeResource(getResources(), R.drawable.ghost);

        coins= BitmapFactory.decodeResource(getResources(), R.drawable.coin);
       // enemy= BitmapFactory.decodeResource(getResources(), R.drawable.enemy);

        coinPaint.setAntiAlias(false);
        //Score set up
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        //enemy color balls
        enemyPaint.setColor(Color.WHITE);

        //Level Set up
        levelPaint.setColor(Color.WHITE);
        levelPaint.setTextSize(70);
        levelPaint.setTypeface(Typeface.DEFAULT_BOLD);
        levelPaint.setAntiAlias(true);

        //size for enemy hits

        enemyPaint.setColor(Color.WHITE);
        enemyPaint.setTextSize(200);
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
        score = 0;

        //display coins, score and level on the screen
        //canvas.drawBitmap(coins,200,300, null);
        //Coins
        coinX -= coinSpeed;

        if(hitCheck(coinX, coinY)){
            score += 10;
            coinX = -100;


        }


        if(coinX < 0){

            coinX = canvasWidth + 10;
            coinY = (int) Math.floor(Math.random() * (maxGhostY - minGhostY)) + minGhostY;

        }

        canvas.drawBitmap(coins,coinX,coinY, coinPaint);


        //canvas.drawBitmap(enemy,400,40, null);
        canvas.drawText("Coins: "+ score, 20, 70, scorePaint);
        canvas.drawText("LVL: 1", 800, 70, levelPaint);

        //enemy
        enemyX -= enemySpeed;
        if(hitCheck(enemyX, enemyY)){
            score = 0;
            enemyX = -100;
            canvas.drawText("NO!!", 500, 500, enemyPaint);


        }

        if(enemyX < 0){
            enemyX = canvasWidth + 200;
            enemyY = (int) Math.floor(Math.random() * (maxGhostY - minGhostY)) + minGhostY;
        }
        canvas.drawCircle(enemyX, enemyY,40, enemyPaint);

    }

    //get inputs from the screen (touch)
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            touch= true;
            ghostSpeed = -20;
        }
        return true;

    }

    public boolean hitCheck(int x, int y){
        if (ghostX < x && x < (ghostX + ghost.getWidth()) &&
                ghostY < y && y < (ghostY + ghost.getHeight())){
            return true;
        }
        return false;
    }

}
