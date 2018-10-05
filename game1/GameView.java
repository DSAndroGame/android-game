package edu.kean.game1;

import android.graphics.BitmapFactory;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.content.Context;


public class GameView extends View {


    //boy
    private Bitmap zombie;
    private Bitmap background;

    public GameView(Context context){

       super(context);
        zombie= BitmapFactory.decodeResource(getResources(), R.drawable.zombie);
        background= BitmapFactory.decodeResource(getResources(), R.drawable.city);
    }


    protected void onDraw(Canvas canvas){
        canvas.drawBitmap(background, 0,0,null);
        canvas.drawBitmap(zombie,0,0, null);


    }
}
