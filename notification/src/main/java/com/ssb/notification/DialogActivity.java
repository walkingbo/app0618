package com.ssb.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        TextView txt =(TextView)findViewById(R.id.txt);
        for(int i=1; i<=10; i=i+1){
            try{
                Thread.sleep(1000);
                txt.setText(i+"");
            }catch (Exception e){

            }
        }

        Button basic =(Button)findViewById(R.id.basic);
        basic.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                //대화상자 생성
                Dialog dlg =new Dialog(DialogActivity.this);
                //대화 상자에 출력할 뷰를 생성
                TextView txt = new TextView(DialogActivity.this);
                txt.setText("대화상자에 출력할 뷰를 직접생성");
                //대화상자에 출력할 뷰를 설정
                dlg.setContentView(txt);
                //대화상자의 타이틀 설정
                dlg.setTitle("대화상자");
                //대화상자를 출력
                dlg.show();
            }
        });

        Button alert =(Button)findViewById(R.id.alert);
        alert.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                new AlertDialog.Builder(DialogActivity.this)
                .setTitle("alert box")
                .setMessage("warning!!!")
                .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("confirm",null)
                        .setNegativeButton("cancel",null)
                .show();

                //액티비티를 닫는 메소드 호출
               //finish();

                Toast.makeText(DialogActivity.this,
                        "toast printout",Toast.LENGTH_LONG).show();


            }
        });
    }
}
