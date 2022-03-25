package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dashboard.db.AppDatabase;
import com.example.dashboard.db.Dao;
import com.example.dashboard.db.PEntity;

public class LoginActivity extends AppCompatActivity {
    private TextView Email,NewUser;
    private TextView Password;
    private Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Email = (TextView) findViewById(R.id.inputEmail);
        Password= (TextView) findViewById(R.id.inputPassword);
        NewUser=(TextView)findViewById(R.id.newUser);
        Login = (Button) findViewById(R.id.btnLogin);
        if(Build.VERSION.SDK_INT>=19){
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }else{
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        NewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailText=Email.getText().toString();
                String passwordText= Password.getText().toString();
                if(emailText.isEmpty() || passwordText.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Fill all feilds",Toast.LENGTH_SHORT).show();
                }else{
                    AppDatabase appDatabase=AppDatabase.getInstance(getApplicationContext());
                    final Dao dao= appDatabase.dao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            PEntity pEntity = dao.login(emailText,passwordText);
                            if(pEntity==null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(),"invalid credentials",Toast.LENGTH_SHORT).show();

                                    }
                                });
                            }else{
                                String email=pEntity.email;
                                Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                                intent.putExtra("email",email);

                                startActivity(intent);
                            }

                        }
                    }).start();
                }


            }
        });
    }

//    private void validate(String userEmail,String password){
//        if((userEmail.equals("has")) && (password.equals("has"))){
//            Intent intent =new Intent(LoginActivity.this, SignupActivity.class);
//            startActivity(intent);
//        }else{
//            Toast.makeText(LoginActivity.this,"Email Or Password Field is Empty",Toast.LENGTH_SHORT).show();
//        }
//    }
}