package com.google.connectthree;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ConnectThreeActivitiy extends AppCompatActivity {
    private static final int RED_CODE = 0;
    private static final int YELLOW_CODE = 1;
    private static final int NOT_PLAYED = 2;
    private int ACTIVE_CODE = 0;
    private int winner = -1;
    private int[] gameStatus = {
            NOT_PLAYED, NOT_PLAYED, NOT_PLAYED,
            NOT_PLAYED, NOT_PLAYED, NOT_PLAYED,
            NOT_PLAYED, NOT_PLAYED, NOT_PLAYED
    };
    private int[][] winnerStatus = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_three_activitiy);
    }

    public void dropIn(View v) {
        int tag = Integer.parseInt(v.getTag().toString());
        if (winner == -1 && gameStatus[tag] == NOT_PLAYED) {
            ImageView iv = (ImageView) v;
            iv.setTranslationY(-2000f);
            if (ACTIVE_CODE == RED_CODE) {
                iv.setImageResource(R.drawable.red);
                ACTIVE_CODE = YELLOW_CODE;
                gameStatus[tag] = RED_CODE;
            } else if (ACTIVE_CODE == YELLOW_CODE) {
                iv.setImageResource(R.drawable.yellow);
                ACTIVE_CODE = RED_CODE;
                gameStatus[tag] = YELLOW_CODE;
            }
            iv.animate().translationY(0f);
            int winner = checkWinner();
            if(winner != -1)
                if (winner == RED_CODE)
                    Toast.makeText(this, "Winner is RED" , Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Winner is YELLOW" , Toast.LENGTH_SHORT).show();

        }
    }

    private int checkWinner() {
        for (int i = 0; i < winnerStatus.length; i++) {
            if (
                            (gameStatus[winnerStatus[i][0]] == gameStatus[winnerStatus[i][1]]) &&
                            (gameStatus[winnerStatus[i][1]] == gameStatus[winnerStatus[i][2]]) &&
                            (gameStatus[winnerStatus[i][0]] != NOT_PLAYED)
                    ) { 
                winner =gameStatus[winnerStatus[i][0]];
                return winner;
            }
        }
        return winner;
    }
}
