<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  </head>
  <body>


        <button type="click" onclick = "get_user_id()">click me</button>

    <div class="opt1"></div>
    <div class="opt"></div>
    <div class="opt"></div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script>
    let i=1
    

function get_user_id(){
    // Using Fetch API
    $.ajax({
      type : 'GET',
      url : "servlet_5",
      dataType: "json",
      success : function(response)
      { 
    	  console.log(response.name)
    	  document.querySelector(".opt1").textContent=response.name
    	  
      },
      error : function(response)
      {
          console.log("Error"+response.message);
          console.log('Error');
      }
  });

   }

  



   get_user_id()
  
    </script>
  </body>
</html>