package com.example.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TextActivity extends AppCompatActivity {

    // Declaración de las vistas
    EditText etName, etEmail;
    TextView tvResult, tvLabelName, tvLabelEmail;
    Button btnShowInput, btnGoToMainFromText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        // Inicialización de las vistas (encontrarlas por su ID en el layout XML)
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        tvResult = findViewById(R.id.tvResult);
        tvLabelName = findViewById(R.id.tvLabelName);
        tvLabelEmail = findViewById(R.id.tvLabelEmail);
        btnShowInput = findViewById(R.id.btnShowInput);
        btnGoToMainFromText = findViewById(R.id.btnGoToMainFromText);

        // Configurar el listener para el botón "Mostrar Texto Ingresado"
        btnShowInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto ingresado en los EditText
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();

                // Verificar que los campos no estén vacíos
                if (name.isEmpty() || email.isEmpty()) {
                    // Mostrar un mensaje Toast si algún campo está vacío
                    Toast.makeText(TextActivity.this, "Por favor, ingresa nombre y email", Toast.LENGTH_SHORT).show();
                } else {
                    // Formar el texto de resultado
                    String resultText = "Nombre: " + name + "\nEmail: " + email;
                    // Mostrar el texto en el TextView tvResult
                    tvResult.setText(resultText);
                }
            }
        });

        // Configurar el listener para el botón "Volver al Menú Principal"
        btnGoToMainFromText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para volver a MainActivity
                // Intent.FLAG_ACTIVITY_CLEAR_TOP y Intent.FLAG_ACTIVITY_SINGLE_TOP se usan a menudo
                // para asegurar que no se creen múltiples instancias de MainActivity si ya existe una.
                Intent intent = new Intent(TextActivity.this, MainActivity.class);
                // Estas flags ayudan a manejar la pila de actividades.
                // FLAG_ACTIVITY_CLEAR_TOP: Si la actividad a iniciar ya está en la pila, todas las actividades por encima de ella se cierran.
                // FLAG_ACTIVITY_SINGLE_TOP: Si la actividad a iniciar ya está en la cima de la pila, no se crea una nueva instancia.
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent); // Iniciar MainActivity
                finish(); // Opcional: cierra la actividad actual (TextActivity) para que no quede en la pila.
            }
        });
    }
}
