package com.example.trabajocochesapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CochesAdapter extends BaseAdapter {

    private final Context context;
    private final List<Coches> cochesList;

    public CochesAdapter(Context context, List<Coches> cochesList) {
        this.context = context;
        this.cochesList = cochesList;
    }

    @Override
    public int getCount() {
        return cochesList.size();
    }

    @Override
    public Object getItem(int i) {
        return cochesList.get(i);
    }

    @Override
    public long getItemId(int posicio) {
        return posicio;
    }

    @Override
    public View getView(int posicio, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.coches_rows, parent, false);

        }
        Coches coche = cochesList.get(posicio);

        TextView marca = convertView.findViewById(R.id.marca);
        marca.setText(coche.getMarca());
        ImageView imagen = convertView.findViewById(R.id.imagen);

       Glide.with(context)
               .load(coche.getImagen())
               .into(imagen);
        return convertView;
    }


}
