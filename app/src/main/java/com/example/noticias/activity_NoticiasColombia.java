package com.example.noticias;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Objects;

public class activity_NoticiasColombia extends AppCompatActivity {

    private ListView listViewNoticiasColombia; // Ajustado para seguir el estilo camelCase

    // Datos de noticieros
    private String[] noticierosColombia = {"El Espectador", "El Tiempo", "El Colombiano", "Debate", "Record"};
    private String[] urlnoticieros = {"https://www.elespectador.com/", "https://www.eltiempo.com/", "https://www.elcolombiano.com/", "https://www.debate.com.mx/", "https://www.record.com.mx/"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__noticiasColombia); // Asegúrate de que el nombre coincide con tu layout XML

        // Mostrar Icono en el ActionBar
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Inicializar ListView
        listViewNoticiasColombia = findViewById(R.id.listView_NoticiasColombia);

        // Crear adaptador usando un layout estándar
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, noticierosColombia);
        listViewNoticiasColombia.setAdapter(adapter);

        // Agregar evento clic al ListView
        listViewNoticiasColombia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String url = urlnoticieros[i];
                navegar(url);
            }
        });
    }

    // Método para finalizar la actividad
    public void volver(View view) { // Ajustado a camelCase
        finish();
    }

    // Navegar a otra actividad con la URL seleccionada
    private void navegar(String url) {
        Intent i = new Intent(this, activity_NavegadorDiarios.class);
        i.putExtra("url", url);
        startActivity(i);
    }

    // Inicializar el menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_overflow, menu);
        return true;
    }

    // Manejar selección de opción del menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.opc_acercade) {
            Intent i = new Intent(this, activity_AcercaDe.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    public void Volver(View view) {
    }
    }
