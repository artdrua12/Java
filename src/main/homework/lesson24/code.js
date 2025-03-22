 
  window.onload = function() {
  var canvas = document.getElementById("tshirtCanvas");
 	var sky = canvas.getContext("2d");
  snowflake(sky,120,100,350);
 }

function KochLine(sky,segment,corner) {

var deg = Math.PI / 180; // глобальная переменная для перевода в радианы

   sky.save(); // запоминаем  начальну позицию оси координат        
   Line(segment,2*segment,"#dee3e6")// для удаления линии посередине
   sky.restore(); // возвращаемся к начальной позиции оси координат

       function Line(moveToX,lineToX,color) { // функция рисующая линию от начала координат длиной segment
           sky.beginPath();
           sky.lineWidth = 3; //
           sky.strokeStyle = color;
           sky.moveTo(moveToX, 0);
           sky.lineTo(lineToX, 0);
           sky.stroke();
        }

      function lineTurn(degree) { // функция отвечающая за повороты
           Line(0,segment,"#14acac"); // рисуем отрезок
           sky.translate(segment,0); // устанавливаем начало координат в конец отрезка
           sky.rotate(degree*deg) // поворачиваем начало координат
       } 
  
   sky.save();
   lineTurn(60);lineTurn(-120);
   lineTurn(60);lineTurn(0);
   sky.restore(); // возвращаемся к начальной позиции оси координат

   sky.translate(3*segment,0); // устанавливаем начало координат в конец отрезка
   sky.rotate(corner*deg) // поворачиваем начало координат
}


function snowflake (sky,segment,x0,y0) {
 	
 	 sky.translate(x0,y0); // устанавливаем начало координат в начало отрезка
      
    //  for (var i = 0; i < 3; i++) {
    //   KochLine(sky,segment,-120);
    //   }

    //    for (var i = 0; i < 6; i++) { 
                
    //     KochLine(sky,segment/3,60);
    //     KochLine(sky,segment/3,-120);          

    //     }

        for (var i = 0; i < 6; i++) {
          KochLine(sky,segment/9,60);
          KochLine(sky,segment/9,-120);    
          KochLine(sky,segment/9,60);
          KochLine(sky,segment/9, 60);
          KochLine(sky,segment/9,60);    
          KochLine(sky,segment/9,-120)
          KochLine(sky,segment/9,60);   
          KochLine(sky,segment/9,-120)
          
        }                
          
}


      