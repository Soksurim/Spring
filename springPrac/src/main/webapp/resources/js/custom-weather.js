/*
	$.getJSON('파일경로',function(data){
		//data로 할일...
	});
*/


$.getJSON('https://api.openweathermap.org/data/2.5/forecast?id=1835848&APPID=c7b2a7dae0cdb05aaa0d01e3f0338ef4&units=metric',
	function(data){
	console.log(data);
	
	var date = new Array();
	var icon = new Array();
	var j=0;
	for(var i=0;i<=data.list.length;i++){
		//"2020-08-16 18:00:00"->"8/16"
		temp = data.list[i].dt_txt;
		month = temp.substring(5,7);
		day = temp.substring(8,10);
		hour = temp.substring(11,13);//"2020-08-16 18:00:00"->"18"
		dateTemp = month.concat("/", day);
		//"04n"->"04d"(밤->하루)
				
  		temp2 = data.list[i].weather[0].icon;
		tempIcon = temp2.substring(0,2);
	
		if(hour>=12){
			date[j]=dateTemp;
			$("#date"+j).append(date[j]);//날짜 
			$("#hour"+j).prepend(hour);//시간
			if(hour>=21){//오후 9시 이후일 때 night아이콘 셋팅
				icon[j] = tempIcon.concat("n");
				$("#cicon"+j).append("<img src='http://openweathermap.org/img/wn/"+icon[j]+"@2x.png'/>");//아이콘
			}
			else{//아니면 day아이콘 셋팅
				icon[j] = tempIcon.concat("d");
				$("#cicon"+j).append("<img src='http://openweathermap.org/img/wn/"+icon[j]+"@2x.png'/>");//아이콘
			}
			$("#ctemp"+j).prepend(data.list[i].main.temp);//현재온도
			$("#pop"+j).prepend(Math.round(data.list[i].pop*100));//강수확률
			j++
		}
	}
		
});	

