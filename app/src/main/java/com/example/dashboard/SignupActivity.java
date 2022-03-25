package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dashboard.db.AppDatabase;
import com.example.dashboard.db.Dao;
import com.example.dashboard.db.PEntity;

public class SignupActivity extends AppCompatActivity {
    private TextView Email,UserName,Password,RepeatPassword;
    private Button Register,Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);
        Email=(TextView) findViewById(R.id.txtEmail);
        UserName=(TextView) findViewById(R.id.txtuserName);
        Password=(TextView) findViewById(R.id.txtPassword);
        Register=(Button) findViewById(R.id.btnRegister);
        Login=(Button) findViewById(R.id.btnLoginS);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailText=Email.getText().toString();
                String userNameText=UserName.getText().toString();
                String passwordText=Password.getText().toString();
                if(emailText.isEmpty() || userNameText.isEmpty() || passwordText.isEmpty()
                ){
                    Toast.makeText(getApplicationContext(),
                            "fields can not empty",Toast.LENGTH_SHORT).show();

                }else{
                   saveInfo(emailText,userNameText,passwordText);
                   Toast.makeText(getApplicationContext(),"successfully registered",
                           Toast.LENGTH_SHORT).show();
                   Email.setText("");
                   Password.setText("");
                   UserName.setText("");
                }

            }
        });
    }

    public void saveInfo(String email, String username, String password) {
       AppDatabase db = AppDatabase.getInstance(this.getApplicationContext());
        PEntity userEntity = new PEntity();
        userEntity.email=email;
        userEntity.userName=username;
        userEntity.password=password;

        db.dao().insertUser(userEntity);
        Log.d("NEW BOOK SAVE", "TRUE");


    }
}