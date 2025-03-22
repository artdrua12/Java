// alfa = ((2-n)/n)*180


window.onload = function()  {
 
  var canvas = document.getElementById("tshirtCanvas");
  var context = canvas.getContext("2d");

   context.translate(100,250);
   moreNLine(context,7,100,10);

  
}

function moreNLine(context,n,len,a) { 

let angleFig = ((2-n)/n)*180; // подсчет градуса для n угольника
let cornerNLine = 180-angleFig; // подсчета градуса для поворота оси	для n угольника
let cornermoreNLine; //
let deg = Math.PI / 180; // for convert to radian
let b; // сторона для определения новой длинны

for (var i=0; i<20; i++)  {
NLine();
b = len - a;
len = Math.sqrt((Math.pow(a,2)+Math.pow(b,2) - 2*a*b*Math.cos(angleFig*deg)));
cornermoreNLine = degreeDiscovery();
context.translate(a,0); // begin point for new figure
context.rotate(cornermoreNLine*deg);
}

function degreeDiscovery(){
		cos = (Math.pow(len,2)+Math.pow(b,2)-Math.pow(a,2))/2*len*b;
		sin = (Math.sin(cornerNLine*deg)*a)/len; //  считаем синус путем достроение до прямоугольноготреугольника

          var degree = Math.round(Math.asin(sin) * (180/Math.PI));
          if(cos<0){
          addDegree = 90 - Math.round(Math.asin(sin) * (180/Math.PI));
          degree = 90 + addDegree;
                }
          if(degree < 0){
          degree = 360 + degree;
                }
          return degree;
      }

function NLine() { // drow n-angleFigure

	function Line() { // функция рисующая линию от начала координат 
           context.beginPath();
           context.lineWidth = 3; 
           context.strokeStyle = "red";
           context.moveTo(0, 0);
           context.lineTo(len,0);
           context.stroke();
       }

     for (let i = 0; i < n; i++) {
       	Line();
		context.translate(len,0);
		context.rotate(cornerNLine*deg);
     }
  }

}

/*




var deg = Math.PI / 180;
let corner;
var a = 50;
var b = 300-a;

 window.onload = function()  {
 
  var canvas = document.getElementById("tshirtCanvas");
 	var context = canvas.getContext("2d");
  context.strokeStyle = "red";
  context.lineWidth = 3;
  context.strokeRect(100,100,300,300);

  context.translate(100+a,400); // begin point
  context.save();
  square(context,a,b);
  context.restore();

while (b>a) {
  context.rotate(-corner*deg);
  context.translate(a,0);
  context.save();
  square(context,a,b);
  context.restore();
}
  
alert(parseFloat(Math.sin(30*deg)).toFixed(1));
}

     
 function square(context){
 
    function Line() { // функция рисующая линию от начала координат длиной segment
           context.beginPath();
           context.lineWidth = 3; //
           context.strokeStyle = "red";
           context.moveTo(0, 0);
           context.lineTo(b,-a);
           context.stroke();
           context.translate(b,-a);
      }

    function degreeDiscovery(){
          var c = Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
          var sin = a/c;
          var cos = b/c; 
          b=c-a;
          var degree = Math.round(Math.asin(sin) * (180/Math.PI));
          if(cos<0){
          addDegree = 90 - Math.round(Math.asin(sin) * (180/Math.PI));
          degree = 90 + addDegree;
                }
          if(degree < 0){
          degree = 360 + degree;
                }
          return degree;
      }

  for (var i = 0; i < 4; i++) {
  Line();
  context.rotate(-90*deg);
  }
  corner = degreeDiscovery();
 } */