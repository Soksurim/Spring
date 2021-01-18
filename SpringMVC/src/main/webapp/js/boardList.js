//목록
$(document).ready(function(){
	$.ajax({
		type: 'post',
		url: '/spring/board/getBoardList',
		data: {'pg': $('#pg').val()},
		dataType: 'json',
		success: function(data){
			console.log(JSON.stringify(data));
			
			$.each(data.list, function(index, items){
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.seq
				})).append($('<td/>',{
					
					}).append($('<a/>',{
						href: '#',
						text: items.subject,
						id: 'subjectA',
						class: items.seq+''
					}))
				
				).append($('<td/>',{
					align: 'center',
					text: items.id
				})).append($('<td/>',{
					align: 'center',
					text: items.hit
				})).append($('<td/>',{
					align: 'center',
					text: items.logtime
				})).appendTo($('#boardListTable'));                   
			
				//로그인 여부
				//각각 다른 이름의 class 속성을 지정하면 이벤트가 따로 불러진다
				/*$('.'+items.seq).click(function(){
					//alert($(this).prop('tagName'));
					
					if(data.memId == null){
						alert('먼저 로그인하세요');
					}else{
						//alert($(this).parent().prev().text());
						let seq = $(this).parent().prev().text();
					}
				});*/
				
			});//each
			
			//로그인 여부
			// a태그에 이벤트를 걸면 왼쪽메뉴에서도 이벤트가 걸려서 왼쪽메뉴를 클릭하면 "먼저 로그인하세요"가 뜬다
			//$('a').click(function(){
			
			//비동적 처리 - 목록 5줄이 id가 모두 'subjectA'라서 첫번째줄에만 이벤트가 걸린다
			//$('#subjectA').click(function(){
			
			//동적 처리 - 조상.on(이벤트, 자식, 함수(){});
			$('#boardListTable').on('click', '#subjectA', function(){
				//alert($(this).prop('tagName'));
				
				if(data.memId == null){
					alert('먼저 로그인하세요');
				}else{
					//alert($(this).parent().prev().text());
					let seq = $(this).parent().prev().text();
					let pg = data.pg;
					location.href = '/spring/board/boardView?seq='+seq+"&pg="+pg;
				}
			});
			//----------------
			
			//페이징 처리
			$('#boardPagingDiv').html(data.boardPaging.pagingHTML);
		},
		error: function(err){
			console.log(err);
		}
	});
});