package com.example.intentschallange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Contactinformation extends AppCompatActivity implements View.OnClickListener
{
 EditText  etnameid,etnumberid,etsite,etlocation;
 ImageView iv1,iv2,iv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactinformation);

        etnameid=findViewById(R.id.etnameid);
        etnumberid=findViewById(R.id.etnumberid);
        etsite=findViewById(R.id.etsite);
        etlocation=findViewById(R.id.etlocation);

        iv1=findViewById(R.id.iv1);
        iv2=findViewById(R.id.iv2);
        iv3=findViewById(R.id.iv3);

iv1.setOnClickListener(this);
iv2.setOnClickListener(this);
iv3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
if (etnameid.getText().toString().isEmpty()|| etnumberid.getText().toString().isEmpty()||etsite.getText().toString().isEmpty()
||etlocation.getText().toString().isEmpty())
{
    Toast.makeText(this,"Please Fill All Fields",Toast.LENGTH_SHORT).show();
}else{
    Intent intent=new Intent();
    intent.putExtra("name",etnameid.getText().toString());
    intent.putExtra("number",etnumberid.getText().toString());
    intent.putExtra("location",etlocation.getText().toString());
    intent.putExtra("web",etsite.getText().toString());

    if(view.getId()==R.id.iv1){
      intent.putExtra("mood","happy");
    }
else if(view.getId()==R.id.iv2){
        intent.putExtra("mood","ok");
    }
else {
        intent.putExtra("mood","sad");
    }
setResult(RESULT_OK,intent);
Contactinformation.this.finish();

}
    }

}
