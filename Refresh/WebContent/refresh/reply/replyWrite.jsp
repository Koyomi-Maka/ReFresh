<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>댓글</title>
  <script type="text/javascript" src="/Refresh/refresh/js/jquery3.js"></script>
  <style type="text/css">
     .reply{
        border: 1px solid pink ;
      
     }
  </style>
  <script type="text/javascript" src="/Refresh/refresh/js/ajax2.js"></script>
  <script type="text/javascript">
    //댓글 목록 작업: loadReplyList, loadReplyResult
    function loadReplyList(){
      new ajax.xhr.Request('/Refresh/refresh/reply.do?action=list', null,loadReplyResult,'GET');	
    }//loadReplyList
    
    function loadReplyResult(xhr){
      if(xhr.readyState==4 && xhr.status==200){
    	 // alert('남의 다리?'+ xhr.responseText);
    	  //alert('정말?'+xhr.responseText);
    	 var list = eval(xhr.responseText);
    	 var replyList = document.getElementById('replyList');
    	 
    	 
    	 //메모리로 부터 이전에 출력된 리스트 삭제
   
    	 replyList.innerHTML='';
    	 
    	 for(var i=0; i<list.length; i++){//새로 얻어 온 리스트 출력
    		replyList.appendChild(makeReplyView(list[i]));
    	 }
      }	
    }//loadReplyResult
    
    function makeReplyView(reply){//list에 출력될 div엘리먼트 생성
    	
       //reply: {no:1,name:'홍길동',content:'Ajax재밌어요!!'}
       var replyDiv = document.createElement('div');//<div></div>
           replyDiv.className='reply';//<div class='reply'></div>
           replyDiv.setAttribute("id", 'r'+reply.rnum);//<div class='reply' id="r1"></div>
           replyDiv.reply = reply;//<div>엘리먼트에 reply JSON객체저장!!                       
                                  
       var htmlTxt = '<strong>'+reply.rname+'</strong><br>'+reply.rcontent+
      '<br><br>'+reply.rdate+'\t<input type="button" id="del" value="삭제" onclick="deleteReply('+reply.rnum+')">';
       replyDiv.innerHTML=htmlTxt;
       return replyDiv;
    }//makeReplyView
    
  //댓글 삭제작업
  
  
  
    function deleteReply(rnum){
        if (!confirm("삭제하시겠습니까?")) {
            return;
        }
        $.ajax({
            url: "/Refresh/refresh/reply.do?action=delete",
            type:"post", 
            data: {"rnum": rnum},
            success: function(result){
                if (result.indexOf("OK")>-1){//=="OK") {
                    $("#r"+rnum).remove();
                    alert("삭제되었습니다.");
                    
                    //loadReplyList();
                } else{
                    alert("삭제 실패.");
                }
            }
        })
    }

    function nullCheck3(){// 널값
        var idmail = document.getElementById("idmail").value;
        var ipass = document.getElementById("ipass").value;
        if(idmail==null||idmail==''||ipass==null||ipass==''){
  			alert('아이디 또는 비밀번호를 입력해주세요');
  			return true;
  		}
        return false;
    }
  
    //댓글 등록작업: addReply, addResult
    function addReply(page){//등록 요청
        var flag=false;
    	
    	if(page=='replyview.do')
    	    flag=nullCheck3();
    	
    if(!flag){
       var rname = document.addForm.rname.value;
       var rcontent = document.addForm.rcontent.value;
       
       
       var params='rname='+rname+'&rcontent='+rcontent;
       new ajax.xhr.Request('/Refresh/refreshs/reply.do?action=insert',params,addResult,'POST');
    }
    }//addReply
    
    function addResult(xhr){//콜백
       if(xhr.readyState==4){
    	  if(xhr.status==200){
    		  alert(xhr.responseText);//등록성공!!
    		  
    		  loadReplyList();//리스트 갱신
    		  
    		  document.addForm.rname.value='';
    		  document.addForm.rcontent.value='';
              document.addForm.rname.focus();   		  
    	  }else{
    		  alert('서버에러: '+ xhr.status);
    	  }
       }//if	
    }//addResult
    
  
    
    window.onload=function(){
    	loadReplyList();
    }
  </script>
</head> 
<!-- reply.html -->
<body>
  <!-- 댓글 목록 출력(DB에 저장된 값을 화면에 출력) -->
    <div id="replyList"></div>
    
  <!-- 댓글 입력폼 -->
    <div id="replyAdd" >
     <form name="addForm">
     <br>
         <input type="text" name="rname" size="10" placeholder="이름"><br>
         <textarea rows="2" cols="50" name="rcontent" placeholder="여러분의 소중한 댓글을 달아주세요"></textarea>
           <input type="button" value="등록" onclick="addReply()">
     </form>       
    </div>
</body>
</html>