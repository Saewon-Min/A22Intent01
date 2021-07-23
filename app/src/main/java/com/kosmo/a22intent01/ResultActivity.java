package com.kosmo.a22intent01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    // TextView와 RatingBar의 아이디를 저장할 정수형 배열
    int[] tvResourceIds = {
        R.id.tv1,R.id.tv2,R.id.tv3,
            R.id.tv4,R.id.tv5,R.id.tv6,
            R.id.tv7,R.id.tv8,R.id.tv9};

    int[] rbResourceIds = {
            R.id.rb1,R.id.rb2,R.id.rb3,
            R.id.rb4,R.id.rb5,R.id.rb6,
            R.id.rb7,R.id.rb8,R.id.rb9
            };

    TextView[] texts = new TextView[9];
    RatingBar[] ratings = new RatingBar[9];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        /*
        Intent를 통해 전달되는 부가데이터는 Bundle 객체에 담겨
        액티비티간에 전송된다. 액티비티가 실행될때 제일 처음 실행되는
        생명주기 메소드가 onCreate()인데 이때 파라미터의 형태로 전송
        받게 된다.
         */
        Intent intent = getIntent(); // 메소드를 통해 Intent 객체를 얻어옴
        Bundle bundle = intent.getExtras(); // 번들 객체 얻어옴
        int[] votes = bundle.getIntArray("votes"); // 투표수를 꺼내옴
        String[] titles = intent.getStringArrayExtra("titles"); // 영화제목

        // 얻어온 값을 TextView의 RatingBar에 설정한다.
        for(int i=0; i<votes.length; i++){

            ((TextView)findViewById(tvResourceIds[i])).setText(titles[i]);
            ((RatingBar)findViewById(rbResourceIds[i])).setRating(votes[i]);
        }

        // 메인으로 돌아가기 버튼을 누르면 액티비티가 종료된다.
        ((Button)findViewById(R.id.btn_main)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                }

        );




    }
}