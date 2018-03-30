package com.abelcorrea.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    int score = 0;

    /**
     *  Reset the values of the game stats.
     */
    public void reset(View v){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        //setContentView(R.layout.activity_main);
    }

    private void goal(String team){
        TextView goalView = (TextView) findViewById()
    }


    /**
     *  Shows the current status of a given team
     *
     * @param stats
     */
    private void displayStatsForTeam(Map<String,Integer> stats) {
        TextView goalView = (TextView) findViewById(R.id.team_a_score);
        goalView.setText(stats.get(this.stat[0]).toString());

        TextView foulView = (TextView) findViewById(R.id.foul_value);
        foulView.setText(stats.get(this.stat[1]).toString());

        TextView obstructionView = (TextView) findViewById(R.id.obstruction_value);
        obstructionView.setText(stats.get(this.stat[2]).toString());

        TextView redCardView = (TextView) findViewById(R.id.redcard_value);
        redCardView.setText(stats.get(this.stat[3]).toString());

        TextView yellowCardView = (TextView) findViewById(R.id.yellowcard_value);
        yellowCardView.setText(stats.get(this.stat[4]).toString());
    }


    /**
     *
     * @param team name of the team
     * @param stat statistic value that needs to be updated
     */
    private void increaseStat(String team, String stat) {
        int score = this.gameStats.get(team).get(stat);
        score = score + 1;
        this.gameStats.get(team).put(stat,score);
    }


    /* stats methods */
    public void goal(String team){
        this.increaseStat(team, this.stat[0]);
        TextView viewTmp = (TextView) findViewById(R.id.team_a_score);
        viewTmp.setText(this.getStat(team, this.stat[0]).toString());

    }

    public void foul(String team){
        this.increaseStat(team, this.stat[1]);
        TextView viewTmp = (TextView) findViewById(R.id.foul_value);
        viewTmp.setText(this.getStat(team, this.stat[1]).toString());
    }

    public void obstruction(String team){
        this.increaseStat(team, this.stat[2]);
        TextView viewTmp = (TextView) findViewById(R.id.obstruction_value);
        viewTmp.setText(this.getStat(team, this.stat[2]).toString());
    }

    public void redCard(String team){
        this.increaseStat(team, this.stat[3]);
        TextView viewTmp = (TextView) findViewById(R.id.redcard_value);
        viewTmp.setText(this.getStat(team, this.stat[3]).toString());
    }

    public void yellowCard(String team){
        this.increaseStat(team, this.stat[4]);
        TextView viewTmp = (TextView) findViewById(R.id.yellowcard_value);
        viewTmp.setText(this.getStat(team, this.stat[4]).toString());
    }


}
