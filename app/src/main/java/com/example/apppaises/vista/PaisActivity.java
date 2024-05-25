package com.example.apppaises.vista;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.apppaises.Models.Pais;
import com.example.apppaises.R;

public class PaisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pais);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("var_pais")) {
            Pais pais = (Pais) intent.getSerializableExtra("var_pais");

            // Usar el objeto Pais como desees
            TextView textView = findViewById(R.id.txtPaisName);
            textView.setText(pais.getName());
        } else {
            // Manejar el caso en el que no se proporcionó el objeto Pais
        }
    }
}