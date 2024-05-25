package com.example.apppaises.service;

import com.example.apppaises.Models.Pais;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicePais {
    @GET("v2/all")
    public abstract Call<List<Pais>> listaPaises();
}
