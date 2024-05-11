let wrong_answere_count = sessionStorage.getItem("wrong_answere_count");
      let correct_answere_count = sessionStorage.getItem("correct_answere_count");
      document.querySelector(".correct-ques-count").textContent=correct_answere_count
      document.querySelector(".wrong-ques-count").textContent=wrong_answere_count
      document.querySelector(".total-ques-count").textContent=parseInt(wrong_answere_count)+parseInt(correct_answere_count)
const table_body = document.querySelector(".questions-container")
console.log(table_body)


$.ajax({
  type: 'GET',
  url: "servlet_5",
  data: { status:"history" },
  dataType: "json",
  cache: false,
  success: function () {},
  error: function (response) {
    console.log("Error " + response.message);
    console.log('Error');
  }
});


let ques_count
    function get_wrong_questions(){
        console.log("hello from ajax"+ques_count)
    let i = 0
          
          $.ajax({
            type: 'GET',
            url: "servlet_5",
            data: {status:"ques" },
            dataType: "json",
            cache: false,
            success: function (data) {
            
              console.log(data)
              data.data.forEach((d)=>{
                let options = d.options
                table_body.innerHTML += `<div class="ques-box" style="background-color: ${get_colors(i+=1)};">
              <div class="p-2">${d.question}</div>
              <div class="p-2">${options[0]}</div>
              <div class="p-2">${options[1]}</div>
              <div class="p-2">${options[2]}</div>
              <div class="p-2">${options[3]}</div>
              <div class="p-2">${d.answere}</div>
              </div>`
              })
              
             
            },
            error: function (response) {
              console.log("Error " + response.message);
              console.log('Error');
            }
          });
        
        }

        function capitalize(s)
{
    return s[0].toUpperCase() + s.slice(1);
}
        function get_user_info(){
          $.ajax({
            type: 'GET',
            url: "servlet_5",
            data: { status:"user_info" },
            dataType: "json",
            cache: false,
            success: function (data) {
              console.log(data)
              document.querySelector("h1").textContent = "Hello "+capitalize(data.name)
              document.querySelector(".user_id").textContent = "user-id "+data.user_id
             
            },
            error: function (response) {
              console.log("Error " + response.message);
              console.log('Error');
            }
          });
        }



        get_user_info()
        
       

        function get_colors(i){
          if(i%2===0){
            console.log(i);
            return "#f5db93"
          }
          else{return "#ebdbb0"}
        }

        function myFunction(x) {
          if (x.matches) { // If media query matches
            
            document.querySelectorAll(".main").forEach((cont)=>{
              cont.classList.remove("container")
            })
          } else {
        
            document.querySelectorAll(".main").forEach((cont)=>{
              cont.classList.add("container")
            })
          }
        }
        
        // Create a MediaQueryList object
        var x = window.matchMedia("(max-width: 700px)")
        
        // Call listener function at run time
        myFunction(x);
        
        // Attach listener function on state changes
        x.addEventListener("change", function() {
          myFunction(x);
        });

        get_wrong_questions()

        
  const ctx1 = document.querySelector('.myChart1');

  
function get_chart_data(){
  let label = []
  let values = []
  $.ajax({
    type: 'GET',
    url: "servlet_5",
    data: { status:"chart_question_composition" },
    dataType: "json",
    cache: false,
    success: function (data) {
      console.log(data)
      for(const key in data){
        label.push(key)
        values.push(data[key])
      }

      new Chart(ctx1, {
        type: 'bar',
        data: {
          labels:label,
          datasets: [{
            label: 'Paper Composition',
            data:values,
            borderWidth: 1
          }]
        },
        options: {
          scales: {
            y: {
              beginAtZero: true
            }
          }
        }
      });
     
    },
    error: function (response) {
      console.log("Error " + response.message);
      console.log('Error');
    }
  });
}






var data = {
  series: [5, 3, 4]
};

var sum = function(a, b) { return a + b };

new Chartist.Pie('.ct-chart', data, {
  labelInterpolationFnc: function(value) {
    return Math.round(value / data.series.reduce(sum) * 100) + '%';
  }
});


  get_chart_data()