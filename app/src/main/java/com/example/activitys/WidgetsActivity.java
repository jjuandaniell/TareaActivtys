package com.example.activitys;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class WidgetsActivity extends AppCompatActivity {

    // Declaración de vistas
    CheckBox cbEmailNotifications, cbPushNotifications;
    Switch swDarkMode;
    RadioGroup rgGender;
    RadioButton rbMale, rbFemale, rbOther, rbSelectedGender;
    Button btnShowWidgetStates, btnGoToMainFromWidgets;
    TextView tvWidgetStates;
    ScrollView widgetsRootLayout; // Referencia al layout raíz

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);

        // Inicialización de vistas
        widgetsRootLayout = findViewById(R.id.widgetsRootLayout); // Inicializar el layout raíz
        cbEmailNotifications = findViewById(R.id.cbEmailNotifications);
        cbPushNotifications = findViewById(R.id.cbPushNotifications);
        swDarkMode = findViewById(R.id.swDarkMode);
        rgGender = findViewById(R.id.rgGender);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        rbOther = findViewById(R.id.rbOther);
        btnShowWidgetStates = findViewById(R.id.btnShowWidgetStates);
        tvWidgetStates = findViewById(R.id.tvWidgetStates);
        btnGoToMainFromWidgets = findViewById(R.id.btnGoToMainFromWidgets);

        // Marcar un CheckBox por defecto desde código
        cbEmailNotifications.setChecked(true);

        // Listener para el Switch de Modo Oscuro
        swDarkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // El Switch está activado (Modo Oscuro)
                    widgetsRootLayout.setBackgroundColor(ContextCompat.getColor(WidgetsActivity.this, R.color.dark_gray));
                    Toast.makeText(WidgetsActivity.this, "Modo Oscuro Activado", Toast.LENGTH_SHORT).show();
                } else {
                    // El Switch está desactivado (Modo Claro)
                    widgetsRootLayout.setBackgroundColor(Color.WHITE); // O tu color por defecto para el modo claro
                    Toast.makeText(WidgetsActivity.this, "Modo Oscuro Desactivado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Listener para el botón "Mostrar Estados de Widgets"
        btnShowWidgetStates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder states = new StringBuilder();

                // Leer estado de CheckBox
                states.append("Notificaciones por Email: ").append(cbEmailNotifications.isChecked() ? "Activado" : "Desactivado").append("\n");
                states.append("Notificaciones Push: ").append(cbPushNotifications.isChecked() ? "Activado" : "Desactivado").append("\n");

                // Leer estado del Switch
                states.append("Modo Oscuro: ").append(swDarkMode.isChecked() ? "Activado" : "Desactivado").append("\n");

                // Leer estado del RadioGroup
                int selectedGenderId = rgGender.getCheckedRadioButtonId();
                if (selectedGenderId != -1) {
                    rbSelectedGender = findViewById(selectedGenderId);
                    states.append("Género Seleccionado: ").append(rbSelectedGender.getText()).append("\n");
                } else {
                    states.append("Género Seleccionado: Ninguno\n");
                }

                // Mostrar los estados en el TextView
                tvWidgetStates.setText(states.toString());

                Toast.makeText(WidgetsActivity.this, "Estados actualizados en el TextView", Toast.LENGTH_LONG).show();
            }
        });

        // Listener para el botón de volver al menú principal
        btnGoToMainFromWidgets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WidgetsActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish(); // Cierra WidgetsActivity
            }
        });
    }
}
