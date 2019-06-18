package com.ssb.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SoundActivity extends AppCompatActivity {
    MediaPlayer player ;
    Ringtone ringtone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        Button vib = (Button)findViewById(R.id.vib);
        Button syssound = (Button)findViewById(R.id.syssound);
        Button ressound = (Button)findViewById(R.id.ressound);
        Button stop1 =(Button)findViewById(R.id.stop1);

        vib.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                //진동객체 생성
                Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                //진동
                vibrator.vibrate(3000);
            }
        });

        syssound.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                //시스템 사운드의 경로를 가져옴
                Uri noti = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
                //재생가능한 사운드 만들기
                ringtone = RingtoneManager.getRingtone(getApplicationContext(), noti);
                //재생
                ringtone.play();

            }
        });

        ressound.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                player = MediaPlayer.create(getApplicationContext(),R.raw.ending);
                player.start();
            }
        });

        Button toast =(Button)findViewById(R.id.toast);
        toast.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),"토스트문자열",Toast.LENGTH_LONG).show();
            }
        });


        stop1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(player != null){
                player.stop();
                }
                if(ringtone != null) {
                    ringtone.stop();
                }
            }
        });



    }
}
