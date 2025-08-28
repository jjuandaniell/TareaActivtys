package com.example.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class ButtonActivity extends AppCompatActivity {

    // Declaración de las vistas
    Button btnSimple, btnStyled, btnGoToMainFromButton;
    ImageButton btnImage;
    MaterialButton btnMaterial;
    TextView tvButtonFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        // Inicialización de las vistas
        btnSimple = findViewById(R.id.btnSimple);
        btnImage = findViewById(R.id.btnImage);
        btnStyled = findViewById(R.id.btnStyled);
        btnMaterial = findViewById(R.id.btnMaterial);
        tvButtonFeedback = findViewById(R.id.tvButtonFeedback);
        btnGoToMainFromButton = findViewById(R.id.btnGoToMainFromButton);

        // Listener para el botón simple
        btnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar un mensaje Toast y actualizar el TextView
                Toast.makeText(ButtonActivity.this, "Botón Simple presionado", Toast.LENGTH_SHORT).show();
                tvButtonFeedback.setText("Presionado: Botón Simple");
            }
        });

        // Listener para el ImageButton
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar un mensaje Toast y actualizar el TextView
                Toast.makeText(ButtonActivity.this, "ImageButton presionado", Toast.LENGTH_SHORT).show();
                tvButtonFeedback.setText("Presionado: ImageButton");
            }
        });

        // Listener para el botón con estilo
        btnStyled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar un mensaje Toast y actualizar el TextView
                Toast.makeText(ButtonActivity.this, "Botón con Estilo presionado", Toast.LENGTH_SHORT).show();
                tvButtonFeedback.setText("Presionado: Botón con Estilo");
            }
        });

        // Listener para el MaterialButton
        btnMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar un mensaje Toast y actualizar el TextView
                Toast.makeText(ButtonActivity.this, "MaterialButton presionado", Toast.LENGTH_SHORT).show();
                tvButtonFeedback.setText("Presionado: MaterialButton");
            }
        });

        // Listener para el botón de volver al menú principal
        btnGoToMainFromButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para volver a MainActivity
                Intent intent = new Intent(ButtonActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish(); // Cierra ButtonActivity
            }
        });
    }
}
