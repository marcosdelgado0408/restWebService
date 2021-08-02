function search(){
    if(document.getElementById("searchType").value == 1){
        getApi("pesquisaTitulo");
    }
    else if(document.getElementById("searchType").value == 2){
        genderSearch("pesquisaGenero");
    }
}



function createRow(movie){

    row = document.createElement("tr");
    
    
    title = document.createElement("td");
    duration = document.createElement("td");
    gender = document.createElement("td");
    type = document.createElement("td");
    releaseYear = document.createElement("td");
    country = document.createElement("td");
    description = document.createElement("td");


    title.innerHTML = movie.Title;
    duration.innerHTML = movie.Duration;
    gender.innerHTML = movie.Gender;
    type.innerHTML = movie.Type;
    releaseYear.innerHTML = movie.ReleaseYear;
    country.innerHTML = movie.Country;
    description.innerHTML = movie.Description;

    row.appendChild(title);
    row.appendChild(duration);
    row.appendChild(gender);
    row.appendChild(type);
    row.appendChild(releaseYear);
    row.appendChild(country);
    row.appendChild(description);


    return row; 
}


function getApi(searchType){
   
    let title = document.getElementById("search").value;
    let url = "http://localhost:8080/" + searchType + "/" + title;


    let request = new XMLHttpRequest();
    request.open("GET", url , false);
    request.send();

    movies = JSON.parse(request.responseText);

    let table = document.getElementById("movies");

    // criando uma linha para cada atributo do filme
    movies.forEach(element => {
        let row = createRow(element);
        table.appendChild(row);
    });

}
