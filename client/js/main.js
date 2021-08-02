function search(){

    $("#movies").empty();       

    insertFirstRow();

    if(document.getElementById("searchType").value == 1){
        getApi("pesquisaTitulo");
    }
    else if(document.getElementById("searchType").value == 2){
        getApi("pesquisaGenero");
    }
}




function insertFirstRow(){
    var table  = document.getElementById("movies");
    var row = table.insertRow();
    var cell = row.insertCell();
   
    cell.innerHTML = "TITLE";
    cell = row.insertCell();

    cell.innerHTML = "DURATION";
    cell = row.insertCell();

    cell.innerHTML = "GENDER";
    cell = row.insertCell();

    cell.innerHTML = "TYPE";
    cell = row.insertCell();

    cell.innerHTML = "RELEASE YEAR";
    cell = row.insertCell();

    cell.innerHTML = "COUNTRY";
    cell = row.insertCell();

    cell.innerHTML = "DESCRIPTION";
    cell = row.insertCell();

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
   
    let key = document.getElementById("search").value;
    let url = "http://localhost:8080/" + searchType + "/" + key;


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
