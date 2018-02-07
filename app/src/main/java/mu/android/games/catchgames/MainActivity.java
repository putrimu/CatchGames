package mu.android.games.catchgames;

import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView iv_11, iv_12, iv_13,
            iv_21, iv_22, iv_23,
            iv_31, iv_32, iv_33,
            iv_41, iv_42, iv_43,
            iv_51, iv_52, iv_53;

    Button b_play;
    TextView tv_time, tv_score, tv_best;
    Random r;
    int rockLocationRow1, rockLocationRow2, rockLocationRow3, rockLocationRow4, rockLocationRow5;
    int frameImage, pawInFrameImage, emptyImage;

    int currentScore = 0;
    int bestScore;

    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        bestScore = preferences.getInt("highscore", 0);


        iv_11 = (ImageView) findViewById(R.id.iv_11);
        iv_12 = (ImageView) findViewById(R.id.iv_12);
        iv_13 = (ImageView) findViewById(R.id.iv_13);

        iv_21 = (ImageView) findViewById(R.id.iv_21);
        iv_22 = (ImageView) findViewById(R.id.iv_22);
        iv_23 = (ImageView) findViewById(R.id.iv_23);

        iv_31 = (ImageView) findViewById(R.id.iv_31);
        iv_32 = (ImageView) findViewById(R.id.iv_32);
        iv_33 = (ImageView) findViewById(R.id.iv_33);

        iv_41 = (ImageView) findViewById(R.id.iv_41);
        iv_42 = (ImageView) findViewById(R.id.iv_42);
        iv_43 = (ImageView) findViewById(R.id.iv_43);

        iv_51 = (ImageView) findViewById(R.id.iv_51);
        iv_52 = (ImageView) findViewById(R.id.iv_52);
        iv_53 = (ImageView) findViewById(R.id.iv_53);

        b_play = (Button) findViewById(R.id.b_play);

        tv_score = (TextView) findViewById(R.id.tv_score);
        tv_score.setText("SCORE : " + currentScore);

        tv_best = (TextView) findViewById(R.id.tv_best);
        tv_best.setText("BEST : " + bestScore);

        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_time.setText("TIME : " + milliaToTime(15000) );

        r = new Random();

        timer = new CountDownTimer(15000, 500) {
            @Override
            public void onTick(long milliaUntilFinished) {
                tv_time.setText("TIME : " + milliaToTime(milliaUntilFinished) +1 );
            }


            @Override
            public void onFinish() {
                tv_time.setText("TIME : " + milliaToTime(0) );

                iv_31.setEnabled(false);
                iv_32.setEnabled(false);
                iv_33.setEnabled(false);
                b_play.setVisibility(View.VISIBLE );

                iv_11.setImageResource(emptyImage);
                iv_12.setImageResource(emptyImage);
                iv_13.setImageResource(emptyImage);


                iv_21.setImageResource(emptyImage);
                iv_22.setImageResource(emptyImage);
                iv_23.setImageResource(emptyImage);


                iv_31.setImageResource(emptyImage);
                iv_32.setImageResource(emptyImage);
                iv_33.setImageResource(emptyImage);


                iv_41.setImageResource(emptyImage);
                iv_42.setImageResource(emptyImage);
                iv_43.setImageResource(emptyImage);


                iv_51.setImageResource(emptyImage);
                iv_52.setImageResource(emptyImage);
                iv_53.setImageResource(emptyImage);

                Toast.makeText(MainActivity.this, "Game Over!", Toast.LENGTH_SHORT).show();

                if(currentScore > bestScore){
                    bestScore = currentScore;
                    tv_best.setText("BEST: " + bestScore);

                    SharedPreferences preferences1 = getSharedPreferences("PREFS", 0);
                    SharedPreferences.Editor editor = preferences1.edit();
                    editor.putInt("hightscore", bestScore);
                    editor.apply();

                }

            }

            };

            loadImages();

        }



    private int milliaToTime(long millis){
        return (int) millis / 1000;
    }

    private void loadImages(){
        frameImage = R.drawable.frame_a;
        frameImage = R.drawable.frame_b;
        frameImage = R.drawable.frame_c;
        frameImage = R.drawable.frame_d;
        frameImage = R.drawable.frame_icon2;

    }
}







