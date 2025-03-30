package com.wissemnouiri.tp23;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int IMAGE_CAPTURE = 1;

    ImageButton loadBtn;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        loadBtn = findViewById(R.id.loadBtn);
        imageView= findViewById(R.id.imageView);

        loadBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, IMAGE_CAPTURE);
            }
        });


    }

   @Override

    protected void onActivityResult(int requestCode, int resultCode , @Nullable Intent data){
        super.onActivityResult(requestCode , resultCode , data);
        if(requestCode == IMAGE_CAPTURE){
            Bundle content = data.getExtras();
            Bitmap bmp =(Bitmap) content.get("extra");
            imageView.setImageBitmap(bmp);
        }
   }


}