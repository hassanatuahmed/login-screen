package com.example.dashboard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dashboard.db.AppDatabase;
import com.example.dashboard.db.Dao;
import com.example.dashboard.db.ImageEntity;
import com.example.dashboard.db.PEntity;

public class HomeActivity extends AppCompatActivity {
    public static final int CAMERA_ACTION_CODE =1;
    private TextView Email;
    private ImageView Photo;
    private Button TakePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Email=(TextView) findViewById(R.id.emailText);
        Photo=(ImageView) findViewById(R.id.imageView);
        TakePhoto=(Button) findViewById(R.id.btnTakePhoto);


        String emailFromIntent=getIntent().getStringExtra("email");
        Email.setText(emailFromIntent);

        TakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivityForResult(intent,CAMERA_ACTION_CODE);
                }else{
                    Toast.makeText(HomeActivity.this,"Is does not support this feature",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAMERA_ACTION_CODE && resultCode==RESULT_OK && data!=null){
            Bundle bundle=data.getExtras();
            Bitmap finalPhoto= (Bitmap) bundle.get("data");
            Photo.setImageBitmap(finalPhoto);
           //saveImage(finalPhoto);




        }
    }

//    public void saveImage(Bitmap image) {
//        AppDatabase db = AppDatabase.getInstance(this.getApplicationContext());
//        ImageEntity imageEntity = new ImageEntity();
//        imageEntity.captureImage=image;
//
//
//        db.dao().insertImage(imageEntity);
//
//
//    }
}