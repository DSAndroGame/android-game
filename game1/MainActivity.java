package edu.kean.game1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {


    private GameView gameView;
    public Button button1;

    public void init (){
       //gameView=new GameView(this);
        //setContentView(gameView);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                Intent toy= new Intent(MainActivity.this,Game.class);
                startActivity(toy);
            }
                                   }
        );


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();



    }
}
