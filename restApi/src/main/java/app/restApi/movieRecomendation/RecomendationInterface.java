package app.restApi.movieRecomendation;

import org.json.simple.JSONArray;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RecomendationInterface{
    JSONArray buscarGenero(String genero);
    JSONArray buscarTitulo(String genero);

}
