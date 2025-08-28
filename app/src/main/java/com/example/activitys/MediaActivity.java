package com.example.activitys;

import android.content.Intent;
// import android.net.Uri; // Eliminado
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
// import android.widget.MediaController; // Eliminado
import android.widget.Toast;
// import android.widget.VideoView; // Eliminado

import androidx.appcompat.app.AppCompatActivity;

public class MediaActivity extends AppCompatActivity {

    // Declaración de vistas
    ImageView ivDisplayImage;
    Button btnChangeImage1, btnChangeImage2, btnGoToMainFromMedia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        // Inicialización de vistas
        ivDisplayImage = findViewById(R.id.ivDisplayImage);
        btnChangeImage1 = findViewById(R.id.btnChangeImage1);
        btnChangeImage2 = findViewById(R.id.btnChangeImage2);
        btnGoToMainFromMedia = findViewById(R.id.btnGoToMainFromMedia);

        // Listener para cambiar a la primera imagen (icono de Android por defecto)
        btnChangeImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivDisplayImage.setImageResource(R.mipmap.ic_launcher);
                Toast.makeText(MediaActivity.this, "Mostrando Icono Android", Toast.LENGTH_SHORT).show();
            }
        });

        // Listener para cambiar a la segunda imagen (un icono de sistema)
        btnChangeImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ivDisplayImage.setImageResource(android.R.drawable.ic_dialog_info);
                Toast.makeText(MediaActivity.this, "Mostrando Icono de Información", Toast.LENGTH_SHORT).show();
            }
        });


        btnGoToMainFromMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish(); // Cierra MediaActivity
            }
        });
    }

}
