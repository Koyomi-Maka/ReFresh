
//reply.js

function loadReplyList(){
      new ajax.xhr.Request('/Refresh/reply.do?action=list', null,loadReplyResult,'GET');	
    }//loadReplyList
    
    function loadReplyResult(xhr){
      if(xhr.readyState==4 && xhr.status==200){
    	
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
            url: "/Refresh/reply.do?action=delete",
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

  
  
    //댓글 등록작업: addReply, addResult
    function addReply(){//등록 요청
       var rname = document.addForm.rname.value;
       var rcontent = document.addForm.rcontent.value;
       
       
       var params='rname='+rname+'&rcontent='+rcontent;
       new ajax.xhr.Request('/Refresh/reply.do?action=insert',params,addResult,'POST');
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