package com.abelcorrea.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        //setContentView(R.layout.activity_main);

        addListeners();

    }

    /**
     *  Adds the listeners for the buttons.
     */
    public void addListeners(){


        /* listener of Team A's goal */
        ImageButton goalImgBtnA = (ImageButton) findViewById(R.id.img_goal_a);

        goalImgBtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goalA();
            }
        });

        /* listener of Team B's goal */

        ImageButton goalImgBtnB = (ImageButton) findViewById(R.id.img_goal_b);

        goalImgBtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goalB();
            }
        });

        /* listener of Team A's foul */
        ImageButton foulImgBtnA = (ImageButton) findViewById(R.id.img_foul_a);

        foulImgBtnA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                foulA();
            }
        });

        /* listener of Team B's foul */
        ImageButton foulImgBtnB = (ImageButton) findViewById(R.id.img_foul_b);

        foulImgBtnB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                foulB();
            }
        });

        /* listener of Team A's yellow card */
        ImageButton yellowCardImgBtnA = (ImageButton) findViewById(R.id.img_yellowcard_a);

        yellowCardImgBtnA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                yellowA();
            }
        });

        /* listener of Team B's yellow card */
        ImageButton yellowCardImgBtnB = (ImageButton) findViewById(R.id.img_yellowcard_b);

        yellowCardImgBtnB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                yellowB();
            }
        });

        /* listener of Team A's red card */
        ImageButton redCardImgBtnA = (ImageButton) findViewById(R.id.img_redcard_a);

        redCardImgBtnA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                redA();
            }
        });

        /* listener of Team B's red card */
        ImageButton redCardImgBtnB = (ImageButton) findViewById(R.id.img_redcard_b);

        redCardImgBtnB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                redB();
            }
        });
    }

    /**
     *  Reset the values of the game stats.
     */
    public void reset(View v){

        Toast.makeText(MainActivity.this, "TOAAASSTYY", Toast.LENGTH_SHORT).show();
        TextView goalA = (TextView) findViewById(R.id.team_a_score);
        goalA.setText("0");
        TextView goalB = (TextView) findViewById(R.id.team_b_score);
        goalB.setText("0");

        LinearLayout foulA = (LinearLayout) findViewById(R.id.foul_value_a);
        foulA.removeAllViewsInLayout();
        LinearLayout foulB = (LinearLayout) findViewById(R.id.foul_value_b);
        foulB.removeAllViewsInLayout();

        LinearLayout cardA = (LinearLayout) findViewById(R.id.cards_value_a);
        cardA.removeAllViewsInLayout();
        LinearLayout cardB = (LinearLayout) findViewById(R.id.cards_value_b);
        cardB.removeAllViewsInLayout();

    }

    // ##############################################################################

    /**
     *  Goal of the Team A
     */
    private void goalA(){
        increaseGoal(R.id.team_a_score);
    }

    /**
     *  Goal of the Team B
     */
    private void goalB(){
        increaseGoal(R.id.team_b_score);
    }

    /**
     * Increase the goals scoreboard.
     *
     * @param id Id of the layout where the goals should be rendered.
     */
    private void increaseGoal(int id){
        TextView goalView = (TextView) findViewById(id);
        Integer score = Integer.parseInt(goalView.getText().toString());
        score = score + 1;
        goalView.setText(score.toString());
        Toast.makeText(MainActivity.this, R.string.goal_warn, Toast.LENGTH_SHORT).show();
    }

    // ##############################################################################

    /**
     * Foul of the team A
     */
    private void foulA(){
        increaseFoul(R.id.foul_value_a);

    }

    /**
     * Foul of the Team B
     */
    private void foulB(){
        increaseFoul(R.id.foul_value_b);
    }

    /**
     *  Yellow card to the Team A player
     */
    private void yellowA(){
        increaseYellowCard(R.id.cards_value_a);
    }

    /**
     *  Yellow card to the Team B player
     */
    private void yellowB(){
        increaseYellowCard(R.id.cards_value_b);
    }

    /**
     *  Red card to the Team A player
     */
    private void redA(){
        increaseRedCard(R.id.cards_value_a);
    }

    /**
     *  Red card to the Team B player
     */
    private void redB(){
        increaseRedCard(R.id.cards_value_b);
    }

    /**
     * Increase the fouls
     *
     * @param id id of the layout blockFouls
     */
    private void increaseFoul(int id){
        increase(id, R.drawable.x, R.string.foul_warn);
    }


    // ##############################################################################

    /**
     *
     * @param id id of the layout blockCards
     */
    private void increaseRedCard(int id){
        increase(id, R.drawable.red_card, R.string.redcard_warn);
    }

    /**
     *
     * @param id id of the layout blockCards
     */
    private void increaseYellowCard(int id){
        increase(id, R.drawable.yellow_card, R.string.yellowcard_warn);
    }

    // ##############################################################################

    /**
     *  Generic increase method for image counters
     *
     * @param id Id of the layout where image should be rendered.
     * @param drawableId Id of the drawable image
     * @param warnId Id of the string of the message
     */
    private void increase(int id, int drawableId, int warnId){

        LinearLayout block = (LinearLayout) findViewById(id);
        if(block.getChildCount() < 10){
            ImageView img = new ImageView(this);
            img.setImageResource(drawableId);

            /** @TODO (1) the value 15 corresponds to the dip of the images in the fouls block. It is a good idea keep these parameters in a xml in values. */
            /** @var DIP of the images in the fouls block converted into pixels.  */
            int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, getResources().getDisplayMetrics());
            img.setLayoutParams(new LinearLayout.LayoutParams(width,LinearLayout.LayoutParams.MATCH_PARENT));

            block.addView(img);
            Toast.makeText(MainActivity.this, warnId, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, R.string.lbl_ad_premium, Toast.LENGTH_LONG).show();
        }

    }


}
