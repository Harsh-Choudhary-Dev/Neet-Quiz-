<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@200&family=Patua+One&display=swap" rel="stylesheet">
  </head>
  <style>

.btn-primary{
background: #0135E6;
background: linear-gradient(225deg, #0135E6, #6449ec);
width: 22vh;
border-radius: 2vh;
font-size: 3vh ;
}

.btn-primary:hover{
  box-shadow:7px 5px  #6785e8;
  background: linear-gradient(225deg,#6449ec, #0135E6 );
}

    .center{
      display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  font-family: 'Noto Sans', sans-serif;
font-family: 'Patua One', serif;
color: rgb(3, 3, 56);

  width: 110vh;
 /* background-color: rgba(38, 47, 222, 0.5); */
  max-width: 100%;       
    }
.white-box{
  background-color:  rgba(109, 115, 242, 0.5);
  border-radius: 12vh;
  
}

body{
  background: url("Untitled design.png") no-repeat fixed center;
}

.white-box:hover{
  /*background-color: rgb(239, 229, 215);*/
  border-color: rgb(12, 40, 222);
  border-style: solid;
  border-width: 0.5vh;
  

}

.bg-color{
  width: 100vh;
  height: 100vh;
}

.main-container{
  background-color: rgb(103, 103, 178);
  border-radius: 13vh;
  box-shadow: 10px 10px;
  
}

  </style>
  <body>
  

    
    <div class="container center main-container">
      <div class="d-flex flex-column mb-3 text-center ">
        <div class="p-2">
          You can center a div horizontally and vertically with Flex box, with just 4 lines of code.
        </div>
        <form action="servlet_2" method="get">
        <div class="p-2 fs-4 text-center question-container">
           <%= request.getAttribute("question")%>
        </div>
        <div class="option-container text-start">
        <div class="p-2 white-box my-2">
          <div class="form-check">
            <input class="form-check-input" type="radio" value='<%=  request.getAttribute("opt1")%>' name="flexRadioDefault" id="flexRadioDefault1">
            <label class="form-check-label" for="flexRadioDefault1">
               <%=  request.getAttribute("opt1")%>
            </label>
          </div>
          
        </div>
        <div class="p-2 white-box my-2">
          <div class="form-check">
            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" value='<%=  request.getAttribute("opt2")%>'>
            <label class="form-check-label" for="flexRadioDefault2">
             <%=  request.getAttribute("opt2")%>
            </label>
          </div>
        </div>
        <div class="p-2 white-box my-2">
          <div class="form-check">
            <input class="form-check-input" value='<%=  request.getAttribute("opt3")%>' type="radio" name="flexRadioDefault" id="flexRadioDefault3" >
            <label class="form-check-label" for="flexRadioDefault3">
               <%=  request.getAttribute("opt3")%>
            </label>
          </div>
        </div>
        <div class="p-2 white-box my-2">
          <div class="form-check">
            <input class="form-check-input" value='<%=  request.getAttribute("opt4")%>' type="radio" name="flexRadioDefault" id="flexRadioDefault4" >
            <label class="form-check-label" for="flexRadioDefault4">
              <%=  request.getAttribute("opt4")%>
            </label>
          </div>
        </div>
        <div class="p-2 text-center">
          
          <button type="submit" class="btn btn-primary">Next</button>
        </form>
        </div>
        <!-- <div class="p-2">Flex item 3</div> -->
      </div>
    </div>
  </div>
  
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script>


      function myFunction(x) {
        if (x.matches) { 
          document.querySelector(".question-container").classList.remove("text-center")
          document.querySelector(".question-container").classList.add("text-start")

          
          document.querySelector(".main-container").classList.remove("container")
          document.querySelector(".main-container").style.borderRadius = "2vh"
          document.querySelector(".main-container").style.height = "fit-content"
        } else {
          document.querySelector(".question-container").classList.add("text-center")
          document.querySelector(".question-container").classList.remove("text-start")
          document.querySelector(".main-container").classList.add("container")
          document.querySelector(".main-container").style.borderRadius = "12vh"
          document.querySelector(".main-container").style.height = "95vh"
        }
      }
      
      // Create a MediaQueryList object
      var x = window.matchMedia("(max-width: 500px)")
      
      // Call listener function at run time
      myFunction(x);
      
      // Attach listener function on state changes
      x.addEventListener("change", function() {
        myFunction(x);
      });

let i=1;
console.log(i++)



    </script>
  </body>
</html>