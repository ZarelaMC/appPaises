package com.example.apppaises.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.apppaises.Models.Pais;
import com.example.apppaises.R;

import java.util.List;

public class AdapterPais extends ArrayAdapter<Pais> {
    private Context context;
    private List<Pais> objects;
    private int resource;


    public AdapterPais(@NonNull Context context, int resource, @NonNull List<Pais> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(resource, parent, false);

        Pais objPaises = objects.get(position);

        //Relacionar los elementos de la interfaz con los de la Entidad

        TextView txtName = convertView.findViewById(R.id.txtPaisName);
        txtName.setText(objPaises.getName());

        TextView txtArea = convertView.findViewById(R.id.txtPaisArea);
        txtArea.setText(objPaises.getArea() + "");

        TextView txtPopulation = convertView.findViewById(R.id.txtPaisPopulation);
        txtPopulation.setText(objPaises.getPopulation());

        ImageView imgFoto = convertView.findViewById(R.id.idBanderaImage);
        Glide.with(context).load(objPaises.getFlags().getPng()).into(imgFoto);



        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent, false);
        }

        Pais objPaises = objects.get(position);

        //Relacionar los elementos de la interfaz con los de la Entidad
        TextView txtName = convertView.findViewById(R.id.txtPaisName);
        txtName.setText(objPaises.getName());

        TextView txtArea = convertView.findViewById(R.id.txtPaisArea);
        txtArea.setText(String.valueOf(objPaises.getArea()));

        TextView txtPopulation = convertView.findViewById(R.id.txtPaisPopulation);
        txtPopulation.setText(String.valueOf(objPaises.getPopulation()));

        ImageView imgFoto = convertView.findViewById(R.id.idBanderaImage);
        Glide.with(context).load(objPaises.getFlags().getPng()).into(imgFoto);

        return convertView;
    }
}
