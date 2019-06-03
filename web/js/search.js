/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function createElement(libro){

    var titolo = $("<h2>").html(libro.titolo);

    return $("<div>").attr("class", "libri-div").append(titolo);
    
}

function stateSuccess(data){ //Ho ricevuto una risposta HTTP con stato positivo
    //Quindi data è la risposta (array di json) che ho costruito nel JSP

    var libriDiv = $("#div-libri");

    $(libriDiv).empty();

    for(var instance in data){
        $(libriDiv).append(createElement(data[instance]));
    }
    
}

function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function() { //Quando è pronto il DOM
    
    $("#search").keyup(function(event){ //Quando viene scritto qualcosa nella textbox
      
       $.ajax({
          url: "SearchAJAX", 
          data: {cmd: "search",
                 toSearch: event.target.value
          },
          dataType: 'json',
          success: function(data, state){stateSuccess(data);},
          error: function(data, state){stateFailure(data, state);}
       });
        
    });
    
});
