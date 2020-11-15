package com.example.intentschallange;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    ImageView ivMood, ivWeb, ivPhone, ivLocation;
     final int CREATE_CONTACT=1;
     String name="",number="",web="",map="",mood="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivMood = findViewById(R.id.ivMood);
        ivWeb = findViewById(R.id.ivWeb);
        ivLocation = findViewById(R.id.iv2);
        ivPhone = findViewById(R.id.iv3);

        ivMood.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivLocation.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(MainActivity.this,com.example.intentschallange.Contactinformation.class);
            startActivityForResult(intent,CREATE_CONTACT);
            }
        });

        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + web));
                startActivity(intent);
            }
        });

        ivLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+map));
                startActivity(intent);
            }
        });

        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
            startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==CREATE_CONTACT){
   if (resultCode==RESULT_OK){
       ivMood.setVisibility(View.VISIBLE);
       ivPhone.setVisibility(View.VISIBLE);
       ivLocation.setVisibility(View.VISIBLE);
       ivWeb.setVisibility(View.VISIBLE);

       name=data.getStringExtra("name");
       number=data.getStringExtra("number");
       map=data.getStringExtra("location");
       web=data.getStringExtra("web");
       mood=data.getStringExtra("mood");

       if(mood.equals("happy")){
           ivMood.setImageResource(R.drawable.goodface);
       }
       else if(mood.equals("ok")){
           ivMood.setImageResource(R.drawable.neutralface);
       }
       else{ivMood.setImageResource(R.drawable.sadface);}


   }

        }
    }
}
