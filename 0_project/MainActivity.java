package com.example.myediary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RadioGroup rg = (RadioGroup)findViewById(R.id.degree);
        final RadioGroup aa = (RadioGroup)findViewById(R.id.emotion1);
        final RadioGroup ab = (RadioGroup)findViewById(R.id.emotion2);
        final RadioGroup ac = (RadioGroup)findViewById(R.id.emotion3);
        final RadioGroup ad = (RadioGroup)findViewById(R.id.emotion4);
        final RadioGroup ae = (RadioGroup)findViewById(R.id.emotion5);

        Button b = (Button)findViewById(R.id.confirm);
        final TextView tv = (TextView)findViewById(R.id.tv1);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int id = rg.getCheckedRadioButtonId();
                int ea = aa.getCheckedRadioButtonId();
                int eb = ab.getCheckedRadioButtonId();
                int ec = ac.getCheckedRadioButtonId();
                int ed = ad.getCheckedRadioButtonId();
                int ee = ae.getCheckedRadioButtonId();


                //감정 별로 일기 따로 db 저장 후 ID 필요

                int gloomy; //우울 연속 누적 횟수
                int bored; //심심 연속 누적 횟수
                int angry; //화남 연속 누적 횟수
                int hate; //싫음 연속 누적 횟수
                int worry; //걱정 연속 누적 횟수
                int sad; //슬픔 연속 누적 횟수




                String result;
                if(eb == R.id.e10){
                    if(gloomy == 14) {
                        tv.setText("특별한 이유 없이 14일째 우울함을 느끼고 있습니다. 자가진단 테스트를 해보시겠습니까?");
                    }
                    else {
                        tv.setText("최근 위안을 얻었던 날이 있습니다. 그 날의 일기를 읽어보는 건 어떨까요?");
                    }
                }
                else if((ed == R.id.e18)||(ed == R.id.e19)||(ee == R.id.e25)){
                    if(bored >= 3) {
                        tv.setText("평소 해보고 싶었던 일이 있다면 지금 시작해보는건 어떨까요?");
                    }
                    else {
                        tv.setText("요즘 인기인 음악/영화를 추천해드릴까요?");
                    }
                }
                else if(((ea == R.id.e1)||(ea == R.id.e2)||(ea == R.id.e3)||(ea == R.id.e4)||(ea == R.id.e5)||(eb == R.id.e6)) && (id == R.id.degree5)){
                    tv.setText("오늘 있었던 일을 SNS(instagram , facebook)에 게시물로 남겨보는 것은 어떨까요?");
                }
                else if(((ee == R.id.e22)||(ee == R.id.e23)||(ee == R.id.e24)) && ((id == R.id.degree4)||(id == R.id.degree5))){
                    tv.setText("오늘 하루 위안이 되어준 사람에게 고마움을 표시해보는 것은 어떨까요?");
                }
                else if((ec == R.id.e13) && ((id == R.id.degree4)||(id == R.id.degree5))){
                    tv.setText("미안.작은 선물 을 해보는 건 어떨까요?");
                }
                else if(((eb == R.id.e7)||(eb == R.id.e8)||(eb == R.id.e9)) && ((id == R.id.degree4)||(id == R.id.degree5))){
                    if(angry >= 3) {
                        tv.setText("최근 행복했던 날의 일기를 다시 읽어 보시겠습니까?");
                    }
                    else {
                        tv.setText("마음이 잔잔해지는 음악/영화를 추천해드릴까요?");
                    }
                }
                else if(((ed == R.id.e20)||(ee == R.id.e21)) && ((id == R.id.degree4)||(id == R.id.degree5))){
                    if(hate >= 4) {
                        tv.setText("몇 일째 같은 감정을 느꼈습니다. 이전의 일기를 돌아보고 해결책을 생각해 보는 것은 어떨까요?");
                    }
                    else {
                        tv.setText("마음이 잔잔해지는 음악/영화를 추천해드릴까요?");
                    }
                }
                else if(((ec == R.id.e14)||(ec == R.id.e15)||(ed == R.id.e16) ||(ed == R.id.e17))  && ((id == R.id.degree4)||(id == R.id.degree5))){
                    if(worry >= 4) {
                        tv.setText("몇 일째 같은 감정을 느꼈습니다. 이전의 일기를 돌아보고 해결책을 생각해 보는 것은 어떨까요?");
                    }
                    else {
                        tv.setText("걱정.마음이 잔잔해지는 음악/영화를 추천해드릴까요?");
                    }
                }
                else if(((ec == R.id.e11)||(ec == R.id.e12))  && ((id == R.id.degree4)||(id == R.id.degree5))){
                    if(sad >= 4) {
                        tv.setText("몇 일째 같은 감정을 느꼈습니다. 이전의 일기를 돌아보고 해결책을 생각해 보는 것은 어떨까요?");
                    }
                    else {
                        tv.setText("기분 전환에 좋은 음악/영화를 추천해드릴까요?");
                    }
                }

                else{
                    tv.setText("오늘 하루 기록");
                }






                //특정 단어에 링크
                Linkify.TransformFilter mTransform = new Linkify.TransformFilter() {
                    @Override
                    public String transformUrl(Matcher match, String url) {
                        return null;
                    }
                };
                Pattern pattern1 = Pattern.compile("instagram");
                Pattern pattern2 = Pattern.compile("facebook");
                Pattern pattern3 = Pattern.compile("선물");
                Pattern pattern4 = Pattern.compile("자가진단 테스트");
                Linkify.addLinks(tv, pattern1, "https://www.nstagram.com/?hl=ko",null,mTransform);
                Linkify.addLinks(tv, pattern2, "https://ko-kr.facebook.com/",null,mTransform);
                Linkify.addLinks(tv, pattern3, "https://business.kakao.com/info/gift/",null,mTransform);
                Linkify.addLinks(tv, pattern4, "http://depressive.aiselftest.com/",null,mTransform);





            }

        });



    }
}
