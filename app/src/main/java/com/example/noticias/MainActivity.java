package com.example.noticias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mostrar Icono en el ActionBar
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Inicializar el Spinner
        spinner = findViewById(R.id.spinner);

        // Opciones del Spinner
        String[] opc = {"Selecciona una opción", "Noticias De Colombia", "Diarios del Mundo"};

        // Configurar el adaptador del Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opc);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void VerDiarios(View view) {
        // Obtener el valor seleccionado
        String seleccion = spinner.getSelectedItem().toString();

        // Verificar la selección y abrir la actividad correspondiente
        if (seleccion.equals("Noticias De Colombia")) {
            Intent i = new Intent(this, activity_NoticiasColombia.class);
            startActivity(i);
        } else if (seleccion.equals("Diarios del Mundo")) {
            Intent i = new Intent(this, activity_DiariosMundo.class);
            startActivity(i);
        } else {
            // Mostrar un mensaje si no se ha seleccionado una opción válida
            Toast.makeText(this, "Debes seleccionar una opción", Toast.LENGTH_SHORT).show();
        }
    }
}
