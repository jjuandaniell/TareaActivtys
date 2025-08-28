package com.example.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnGoToText, btnGoToButton, btnGoToWidgets, btnGoToMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ajustar el padding para las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar botones
        btnGoToText = findViewById(R.id.btnGoToText);
        btnGoToButton = findViewById(R.id.btnGoToButton);
        btnGoToWidgets = findViewById(R.id.btnGoToWidgets);
        btnGoToMedia = findViewById(R.id.btnGoToMedia);


        btnGoToText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crea un Intent para ir a TextActivity.
                Intent intent = new Intent(MainActivity.this, TextActivity.class);
                startActivity(intent); // Inicia la actividad especificada por el Intent.
            }
        });

        btnGoToButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crea un Intent para ir a ButtonActivity.
                Intent intent = new Intent(MainActivity.this, ButtonActivity.class);
                startActivity(intent);
            }
        });

        btnGoToWidgets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crea un Intent para ir a WidgetsActivity.
                Intent intent = new Intent(MainActivity.this, WidgetsActivity.class);
                startActivity(intent);
            }
        });

        btnGoToMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crea un Intent para ir a MediaActivity.
                Intent intent = new Intent(MainActivity.this, MediaActivity.class);
                startActivity(intent);
            }
        });
    }
}
