/**
 * web socket
 */

function getId(id){
	return document.getElementById(id);
}


var data = {};//전송 데이터(JSON)

var ws ;
var mid = getId('mid'); //채팅 참겨 아이디
var btnLogin = getId('btnLogin'); //참여 버튼
var btnSend = getId('btnSend'); // 전송버튼
var talk = getId('talk'); //채팅 화면
var msg = getId('msg'); //전송 인풋란

	ws = new WebSocket("ws://" + location.host + "/chatt");

	ws.onmessage = function(msg){
		var data = JSON.parse(msg.data);
		var css;
		
		if(data.mid == mid.value){
			css = 'class=me';
		}else{
			css = 'class=other';
		}
		
		var item = `<div ${css} >
		              <span class = "chatinfo"><b>${data.mid}</b></span class = "chatinfo"> [ ${data.date} ]<br/>
                      <span>${data.msg}</span>
						</div>`;
					
		talk.innerHTML += item;
		talk.scrollTop=talk.scrollHeight;//스크롤바 하단으로 이동
		send(  "님 입장하셨습니다.");
		}
		

msg.onkeyup = function(ev){
	
	if(ev.keyCode == 13){
		send();
	}
}

btnSend.onclick = function(){
	send();
}

function send(){
	if(msg.value.trim() != ''){
		data.mid = getId('mid').value;
		data.msg = msg.value;
		data.date = new Date().toLocaleTimeString();
		var temp = JSON.stringify(data);
		ws.send(temp);
	}
	msg.value ='';

}
