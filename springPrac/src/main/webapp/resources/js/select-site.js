/**
 * 
 */
var campName;
var imgs;
var campZone;
var maxPeople;
var category;
var campPrice;
var bbqPrice;
var peopleNum;
var sort_idx;

$(document).ready(function(){
	//avgStar Booking.jsp에 평점 띄우기 위해 localStorage로 넘김
	avgStar = $('#avgStar').val();
	//console.log(" avgStar : "+avgStar+", type of : "+typeof avgStar);
	if(avgStar===""){
		avgStar="0.0";
	}
	localStorage.setItem("avgStar",avgStar);
})

function selectSite(index){
	//예약 버튼 활성화
	//document.getElementById('booking-event').style.pointerEvents = 'auto'; 
	$('#booking-event').empty();
	$('#booking-event').append("예약하기");
	
	peopleNum = Number(document.getElementById("peopleNum").value);
	console.log(check_booking_available);
	if(peopleNum>=1 && check_booking_available){
		document.getElementById('booking-event').style.pointerEvents = 'auto'; 
	}else{
//		alert("인원수를 10명 이상으로 설정해주세요.")
		document.getElementById('booking-event').style.pointerEvents = 'none';
	}
	
	

	// == $('#booking-event').text("예약하기");
	imgs = document.getElementById('img'+index).getAttribute('src');
	campName = document.getElementById('campName').value;
	campZone =  document.getElementById('campZone'+index).innerHTML;
	maxPeople = document.getElementById('maxPeople'+index).innerHTML;
	category = document.getElementById('category'+index).value;
	campPrice = document.getElementById('price'+index).innerHTML;
	//bbqPrice = document.getElementById('bbqPrice').value;
	bbqPrice = bbq_fee.format();
	sort_idx = document.getElementById('sort_idx'+index).value;
	
	var imgs_html = "";
	imgs_html += "<img id='imgTest' src="+imgs+" alt='blog image'>";

	//document.getElementsByClassName("calender-customize")[0].value = "2/2/2020";
	//$('.calender-customize').val("2/2/2020");
	//var length = document.getElementsByClassName("calender-customize").length;
	//for(var i=0; i<length; i++){
	//	document.getElementsByClassName("calender-customize")[i].value = "2/2/2020";
	//}
	
	var imgs_html = "";
	imgs_html += "<img src="+imgs+" alt='blog image'>";
	$("#selectedImg").html(imgs_html);
	
	var selectedBody_html = "";
	selectedBody_html += "<h4 class='recent__link'>"
		+ campName+"("+category+") : "
    	+ "<br/><em>"+campZone+"</em></h4>"
    	+ "<p class='recent__meta'><span class='color-text font-weight-bold'>"+campPrice+"</span>"
    	+	"<br>최대인원 - "+maxPeople+"</p>";
	var checkBox_html = "";
	checkBox_html += "<div class='custom-checkbox'>"
		+ "<input type='checkbox' id='chb' class='check-bbq' value='"+bbqPrice+"'>"
		+ "<label for='chb' style='color:#eb7a97;text-decoration: underline; text-underline-position:under;text-decoration-color:red;'>바베큐 : "+bbqPrice+"<span>+</span></label>"
		+ "</div>";
		
		// peopleNum class 의 속성인 max 를 maxPeople 값으로 변경
		document.getElementById("peopleNum").setAttribute("max", maxPeople);
		//peopleNum class 의 value 값이 maxPeople보다 큰 경우 maxPoeple값으로 설정(ex 예약시 선택한 인원수가 6인데 선택한 캠핑장의 수용 가능 인원수가 4라면 6->4로 설정됨)
		if(peopleNum>Number(maxPeople)){
			document.getElementById("peopleNum").value = Number(maxPeople);
		}
		$("#selectedBody").html(selectedBody_html);
		$(".customize-checkbox").html(checkBox_html);
	
	//document.getElementsByClassName('peopleNum').setAttribute('max', maxPeople);
		
	window.location.href="#focusHere";
}

/*$('.card-body').on('click', function(event) {
    alert('You clicked the Bootstrap Card');
});*/