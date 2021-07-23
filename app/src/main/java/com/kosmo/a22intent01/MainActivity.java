package com.kosmo.a22intent01;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 투표수를 저장할 배열
    int[] votes = new int[9];

    // 이미지 뷰를 저장할 배열
    ImageView[] imageViews = new ImageView[9];

    String[] titles = {
            "블랙팬서","스파이더맨","아이언맨","인피니티워","앤트맨&와스프",
            "인크레더블헐크","시빌워","윈터솔져","토르나그나로크"
    };


    /*
    ImageView의 리소스 아이디를 저장하기 위한 배열로 안드로이드에는
    리소스 아이디를 내부적으로 처리할때 int형으로 사용한다.
     */
    int[] resourceIds = {
            R.id.iv1,R.id.iv2,R.id.iv3,
            R.id.iv4,R.id.iv5,R.id.iv6,
            R.id.iv7,R.id.iv8,R.id.iv9};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 앱의 타이틀 설정(메인 액티비티에서만 적용된다)
        setTitle("당신이 좋아하는 영화는?");
        setContentView(R.layout.activity_main);

        for(int i=0; i<votes.length; i++) {
            // 영화개수만큼 반복하면서 이미지를 얻어와서 리스너 부착
            final int index = i;
            imageViews[i] = (ImageView)findViewById(resourceIds[i]);
            imageViews[i].setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    // 투표는 최대 5번까지만 가능함
                    if (votes[index] < 5) {
                        // 5번 미만일때는 투표수를 증가시킴
                        votes[index]++;
                        Toast.makeText(MainActivity.this,
                                String.format("%s:%d표", titles[index], votes[index]),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this,
                                "5점이 최고점수입니다.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });

            // 투표 결과보기 버튼
            ((Button)findViewById(R.id.btn_result)).setOnClickListener(
                    new View.OnClickListener(){
                        @Override
                        public void onClick(View view) {
                            // 새로운 액티비티를 실행하기 위해 Intent객체 생성
                            Intent intent = new Intent(view.getContext(),
                                    ResultActivity.class);
                            // 부가 데이터를 전달하기 위해 putExtra() 메소드를 사용
                            intent.putExtra("votes",votes);
                            intent.putExtra("titles",titles);
                            // 액티비티 실행
                            startActivity(intent);
                        }
                    }
            );

        }




    }
}