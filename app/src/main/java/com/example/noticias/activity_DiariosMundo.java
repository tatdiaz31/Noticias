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

public class activity_DiariosMundo extends AppCompatActivity {

    private ListView listView_DiariosMundo;

    private String noticierosMundo[] = {"New York Times", "USA Today", "BBC"};
    private String urlnoticieros[] = {"https://www.nytimes.com/es/", "https://www.usatoday.com/",
            "https://www.bbc.com/mundo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__diarios_mundo);

        // Mostrar Icono en el ActionBar
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        listView_DiariosMundo = findViewById(R.id.listview_DiariosMundo);

        // Configurar el adaptador del ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, noticierosMundo);
        listView_DiariosMundo.setAdapter(adapter);

        // Agregar el evento Clic al ListView
        listView_DiariosMundo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String url = urlnoticieros[i];
                navegar(url);
            }
        });
    }

    public void Volver(View view) {
        finish();
    }

    private void navegar(String url) {
        Intent i = new Intent(this, activity_NavegadorDiarios.class);
        i.putExtra("url", url);
        startActivity(i);
    }

    // Inicializar el Menu OverFlow
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_overflow, menu);
        return true;
    }

    // Selección de una opción de Menú
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.opc_acercade) {
            Intent i = new Intent(this, activity_AcercaDe.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
