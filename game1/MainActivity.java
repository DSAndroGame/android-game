package edu.kean.game1;

//Imported packages
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.*;
import java.util.Timer;
import java.util.TimerTask;



public class MainActivity extends AppCompatActivity {


    private GameView gameView;
    public Button button1;

    private Handler handler = new Handler();
    private final static long TIMER_INTERVAL = 60;

    //buttum set Up
//    public void init (){
//        //gameView=new GameView(this);
//        //setContentView(gameView);
//
//        button1 = (Button) findViewById(R.id.button1);
//        button1.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v){
//                Intent toy= new Intent(MainActivity.this,Game.class);
//                startActivity(toy);
//                }
//                }
//        );
//
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //init();
        gameView=new GameView(this);
        setContentView(gameView);

        Timer timer = new Timer();
        timer.schedule(new TimerTask(){

            public void run(){
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        gameView.invalidate();
                    }
                });

            }
        }, 0, TIMER_INTERVAL);



    }
}
