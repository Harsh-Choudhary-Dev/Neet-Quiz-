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
    body{
background: #843D3B;
background: linear-gradient(135deg, #843D3B, #010DCE);
font-family: 'Noto Sans', sans-serif;
font-family: 'Patua One', serif;
font-size: 4vh;
    }
    .container{
        background-color: rgb(27, 145, 248);
        width: 75vh;
        border-radius: 7vh;
        box-shadow: 10px 10px;
    }



    .card{
background: #4953D6;
background: linear-gradient(135deg, #4953D6, #BEFFB7);
width: 45vh;
height: 25vh;
margin: auto;
    }
  </style>
  <body>
    <div class="container text-center">
        <div class="d-flex flex-column  mb-3">
        <div class="p-2">
            <img src="/result-concept-illustration-idea-growth-analysis-success_277904-4062.jpg" class="img-fluid" alt="...">
        </div>
        <div class="box-container">
        <div class="p-2">
            <div class="card">
                <div class="card-body">
                    <p>Your Correct Answere</p>
                    <p class="correct-box"><%= (String)session.getAttribute("correct") %></p>
                </div>
              </div>
        </div>
        <div class="p-2">
            <div class="card">
                <div class="card-body">
                  <p>Your Wrong Answere</p>
                  <p class="wrong-box"><%= (String)session.getAttribute("wrong") %></p>
                </div>
              </div>
        </div>
        <div class="p-2">
            <div class="card">
                <div class="card-body">
                  <p> Total Questions</p>
                  <p class="total-box"><%= (String)session.getAttribute("wrong") %></p>
                </div>
              </div>
        </div>
    </div>
        <!-- <div class="p-2"></div> -->
      </div>
    </div> 

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>