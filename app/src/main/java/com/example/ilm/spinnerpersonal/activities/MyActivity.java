package com.example.ilm.spinnerpersonal.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ilm.spinnerpersonal.adapters.AdaptadorPersonalizado;
import com.example.ilm.spinnerpersonal.datamodel.Ciudad;
import com.example.ilm.spinnerpersonal.R;


public class MyActivity extends Activity implements Spinner.OnItemSelectedListener{
    //ciudades de prueba
    Ciudad[] ciudades = { new Ciudad("Toledo", "La ciudad Imperial",240000, R.drawable.toledo),
            new Ciudad("Ciudad Real", "Qué gran ciudad",134000,R.drawable.ciudadreal),
            new Ciudad("Albacete","Ciudad gastronómica",156000,R.drawable.albacete),
            new Ciudad("Cuenca", "Ciudad encantada",210000,R.drawable.cuenca),
            new Ciudad("Guadalajara", "Ciudad colgante",104000,R.drawable.guadalajara) };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        //referencia al spinner
        Spinner selectorCiudades = (Spinner) findViewById(R.id.spinner);
        //inicialización del adaptador especializado
        AdaptadorPersonalizado a=new AdaptadorPersonalizado(this, R.layout.lineaspiner, ciudades);
        selectorCiudades.setAdapter(a);
        //evento de elemento de lista
        selectorCiudades.setOnItemSelectedListener(this);
    }
    /**
     * Método de evento para escuchar el touch en cada elemento de la lista
     * @param parent Adapdatador de vistas para los elementos de la listas
     * @param view Elemento de la lista que recibe el evento
     * @param position Posición del elemento que recibe el evento en la lista
     * @param id Identificador del elemento de lista
     */
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        TextView c=(TextView)view.findViewById(R.id.nombre);
        TextView seleccion=(TextView)findViewById(R.id.ciudadSeleccionada);

        seleccion.setText(c.getText());
    }
    /**
     * Método de evento para escuchar cuando no se selecciona nada en la lista
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent){
        TextView seleccion=(TextView)findViewById(R.id.ciudadSeleccionada);
        seleccion.setText("nada seleccionado!");
    }
    /**
     * Método callback para la creación del menú de la app
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }
    /**
     * Método callback para interacción con los elementos del menú de la app
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
