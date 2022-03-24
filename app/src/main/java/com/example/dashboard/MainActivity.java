package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView Email;
    private TextView Password;
    private Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Email = (TextView) findViewById(R.id.inputEmail);
        Password= (TextView) findViewById(R.id.inputPassword);
        Login = (Button) findViewById(R.id.btnLogin);
        if(Build.VERSION.SDK_INT>=19){
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }else{
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Email.getText().toString(),Password.getText().toString());


            }
        });
    }

    private void validate(String userEmail,String password){
        if((userEmail.equals("has")) && (password.equals("has"))){
            Intent intent =new Intent(MainActivity.this,NewuserActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this,"Email Or Password Field is Empty",Toast.LENGTH_SHORT).show();
        }
    }
}