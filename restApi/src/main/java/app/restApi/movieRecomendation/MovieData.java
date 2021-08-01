package app.restApi.movieRecomendation;

/*
    *   type = [2]
    *   title = [3]
    *   country = [6]
    *   releaseYear = [8]
    *   duration = [10]
    *   gender = [11]
    *   description = [12]
    *
    * */
public class MovieData {
    String type, title, country, releaseYear, duration, gender, description;

    public MovieData(String type, String title, String country, String releaseYear, String duration, String gender, String description) {
        this.type = type;
        this.title = title;
        this.country = country;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.gender = gender;
        this.description = description;
    }


    @Override
    public String toString() {
       return type + "--" + title + "--" + country + "--" + releaseYear + "--" + duration + "--" + gender + "--" + description + "\n";
    }
}
