package com.example.apppaises;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.apppaises.Models.Pais;
import com.example.apppaises.adapter.AdapterPais;
import com.example.apppaises.service.ServicePais;
import com.example.apppaises.util.ConnectionRest;
import com.example.apppaises.vista.PaisActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //Declarar variables
    Spinner spnPais;

    /*
    *     ArrayList<String> lstPaises = new ArrayList<>();
    ArrayAdapter<String> adaptadorPais;*/

    ServicePais servicePais;

    ArrayList<Pais> listaPaises = new ArrayList<Pais>();
    AdapterPais paisAdapter;

    private List<Pais> listaTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //Inicializar variables del Spinner
        /*adaptadorPais = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, lstPaises);
        spnPais = findViewById(R.id.spnPaises);
        spnPais.setAdapter(adaptadorPais);*/

        spnPais = findViewById(R.id.spnPaises);
        paisAdapter = new AdapterPais(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaPaises);
        spnPais.setAdapter(paisAdapter);



        //Inicializar los Service para acceder a la conexión -- .class indica que se está pasando un objeto de servicio que contiene los endPoints
        servicePais = ConnectionRest.getConnection().create(ServicePais.class);

        //Llamar método para llenar Spinner al ejecutarse la app
        cargaPaises();


        //Evento
        spnPais.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Pais obj = listaPaises.get(position);
                Intent intent = new Intent(MainActivity.this, PaisActivity.class);
                intent.putExtra("var_pais", obj);
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    void cargaPaises(){
        Call<List<Pais>> call = servicePais.listaPaises();
        call.enqueue(new Callback<List<Pais>>() {
            @Override
            public void onResponse(Call<List<Pais>> call, Response<List<Pais>> response) {
                if (response.isSuccessful()){
                    //Atrapar el cuerpo de la respuesta (datos)
                    listaTotal = response.body();

                    //para dar formato al dato mostrado
                    for(Pais obj: listaTotal){
                        listaTotal.add();
                    }
                    paisAdapter.notifyDataSetChanged(); //refrescar el ArrayAdapter para que muestre los datos traídos
                }
            }

            @Override
            public void onFailure(Call<List<Pais>> call, Throwable t) {

            }
        });
    }
}