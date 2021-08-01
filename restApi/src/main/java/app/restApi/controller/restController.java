package app.restApi.controller;


import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import app.restApi.movieRecomendation.MovieRecomendation;


@RestController
public class restController {
    MovieRecomendation movieRecomendation;

    public restController() {
        this.movieRecomendation = new MovieRecomendation();
    }


    @GetMapping("pesquisaTitulo/{nomeFilme}") // mapeando o verbo http
    public JSONArray searchTitle(@PathVariable String nomeFilme){
        return movieRecomendation.buscarTitulo(nomeFilme);
    }


    @GetMapping("pesquisaGenero/{genero}")
    public JSONArray searchType(@PathVariable String genero){
        return movieRecomendation.buscarGenero(genero);
    }


}
