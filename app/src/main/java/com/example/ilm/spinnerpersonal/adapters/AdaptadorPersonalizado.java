package com.example.ilm.spinnerpersonal.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilm.spinnerpersonal.R;
import com.example.ilm.spinnerpersonal.datamodel.Ciudad;

import java.util.Comparator;

/**
 * Adaptador de lista personalizado
 * @author Rafa
 * @version 1.0
 */
public class AdaptadorPersonalizado extends ArrayAdapter<Ciudad> implements Comparator<Ciudad> {
    private Ciudad[] ciudades;
    private Activity activity;

    /**
     * Constructor personalizado, inicializa las propiedades principales de la clase
     * @param ctx Contexto de ejecución
     * @param txtViewResourceId Identificador del recurso que representa al componente de lista
     * @param objects Array con los datos de la lista
     */
    public AdaptadorPersonalizado(Context ctx, int txtViewResourceId, Ciudad[] objects){
        super(ctx, txtViewResourceId, objects);
        ciudades = objects;
        activity = (Activity)ctx;
    }
    /**
     * Método callback que es invocado cuando se despliegan los elementos la lista
     * @param position Posición del elemento de la lista
     * @param cnvtView Widget para el elemento de la lista
     * @param prnt Contenededor del widget que define el elemento de la lista
     * @return View Widget creado para utilizar como elemento de lista
     */
    @Override
    public View getDropDownView(int position, View cnvtView, ViewGroup prnt){
        return crearFilaPersonalizada(position, cnvtView, prnt);
    }
    /**
     * Método callback que es invocado cuando se construyen los elementos la lista
     * @param pos Posición del elemento de la lista
     * @param cnvtView Widget para el elemento de la lista
     * @param prnt Contenededor del widget que define el elemento de la lista
     * @return View Widget creado para utilizar como elemento de lista
     */
    @Override
    public View getView(int pos, View cnvtView, ViewGroup prnt){
        return crearFilaPersonalizada(pos, cnvtView, prnt);
    }

    /**
     * Método de soporte para el método-callback getView, se encarga de construir el widget que corma
     * el elemento de lista
     * @param position Posición del elemento de lista
     * @param convertView Widget para elemento de lista
     * @param parent Contenedor del elemento de lista
     * @return View Widget que representa al elemento de la lista
     */
    public View crearFilaPersonalizada(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = activity.getLayoutInflater();
        View miFila = inflater.inflate(R.layout.lineaspiner, parent, false);

        TextView nombre = (TextView) miFila.findViewById(R.id.nombre);
        nombre.setText(ciudades[position].getNombre());

        TextView descripcion = (TextView) miFila.findViewById(R.id.descripcion);
        descripcion.setText(ciudades[position].getDescripcion());

        TextView habitantes = (TextView) miFila.findViewById(R.id.habitantes);
        habitantes.setText(String.valueOf(ciudades[position].getHabitantes()));

        ImageView imagen = (ImageView) miFila.findViewById(R.id.imagenCiudad);
        imagen.setImageResource(ciudades[position].getImagen());
        return miFila;

    }
    /**
     * Método para personalizar cómo se comparan los elementos de la clase Ciudad
     * @param ciudad Origen de la comparación
     * @param t1 Destino de la comparación
     * @return int Valor resultado de la comparación: 0 si son iguales, 1 si la ciudad origen tiene
     * mas habitantes que la ciudad destino, y -1 para el resto de casos.
     */
    @Override
    public int compare(Ciudad ciudad, Ciudad t1) {
        if(ciudad.getHabitantes()>t1.getHabitantes())
            return 1;
        else if (ciudad.getHabitantes()<t1.getHabitantes())
            return -1;

        return 0;
    }
}
