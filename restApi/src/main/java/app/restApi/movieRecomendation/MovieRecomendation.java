package app.restApi.movieRecomendation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/*
* Dataset = https://www.kaggle.com/shivamb/netflix-shows
*/

public class MovieRecomendation implements RecomendationInterface {
    private ArrayList<MovieData> dados;

    public ArrayList<MovieData> getDados() { return dados; }

    public MovieRecomendation(){
        dados = new ArrayList<>();
        carregarDados();
    }


    private void carregarDados(){
        try {
            String currentLine;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/Users/Marcos/IdeaProjects/restApi/src/main/java/netflix_titles_modified_2.csv"));

            bufferedReader.readLine(); // pulando primeira linha

            while( (currentLine = bufferedReader.readLine() ) != null){
//                System.out.println(currentLine + "\n");
                String[] splitedLine = currentLine.split(",");

                dados.add( new MovieData(splitedLine[2], splitedLine[3], splitedLine[6], splitedLine[8], splitedLine[10], splitedLine[11], splitedLine[12])); // x = passanger_count / y = trip_distance / val = fare_amount
//                System.out.println(splitedLine[0]);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }




    @Override
    public JSONArray buscarGenero(String genero){
        JSONArray jsonArray = new JSONArray();

        for(MovieData md: dados){
            if(md.gender.contains(genero)){

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("Title", md.title);
                jsonObject.put("Duration", md.duration);

                String newGender = md.gender.replace("|", ",");
                jsonObject.put("Gender", newGender);
                jsonObject.put("Type", md.type);
                jsonObject.put("ReleaseYear", md.releaseYear);
                jsonObject.put("Country", md.country);

                String newDescription = md.description.replace("|", ",");
                jsonObject.put("Description", newDescription);

                jsonArray.add(jsonObject);

            }

        }
        return jsonArray;
    }

    @Override
    public JSONArray buscarTitulo(String titulo){
        JSONArray jsonArray = new JSONArray();

        for(MovieData md: dados){
            if(md.title.contains(titulo)){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("Title", md.title);
                jsonObject.put("Duration", md.duration);

                String newGender = md.gender.replace("|", ",");
                jsonObject.put("Gender", newGender);
                jsonObject.put("Type", md.type);
                jsonObject.put("ReleaseYear", md.releaseYear);
                jsonObject.put("Country", md.country);

                String newDescription = md.description.replace("|", ",");
                jsonObject.put("Description", newDescription);

                jsonArray.add(jsonObject);
            }

        }
        return jsonArray;
    }


}
