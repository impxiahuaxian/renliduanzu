var wait = 60;
var show_flag = 0;



function phone_varify_send() {
    var mobile = document.getElementById("tel");
    var pass=document.getElementById("password").value;
    var tel = document.getElementById("tel").value;;
    console.log(pass);
    console.log(tel);
    re = /^(((13[0-9]{1})|(15[0-9]{1})|(1[0-9]{2}))+\d{8})$/;
    if (re.test(tel)) {
        $.ajax({
            url: "http://127.0.0.1:8080/hr/register/second",
            type: "post",
            data:{
            	hrMobile:tel,
            	hrPassword: pass
            },
            dataType: "json",
            success: function (msg) {
            	 console.log(msg);
            	if(msg == 1){
            		
            		 swal("Yes!", "恭喜你，成功", "success")
            		window.location.href="/hr/hr_login"
            	} else {
            		swal("哦哦....", "请输入正确的手机号哦!!!", "error");
            	}
               
            }
        });

    } else {
        swal("哦哦....", "请输入正确的手机号哦!!!", "error");
    }
}


function showPass() {
    console.log("change showing~");
    var pass_notshow = document.getElementById("password");
    if (show_flag == 0) {
        pass_notshow.type = 'text';
        show_flag = 1;
        document.getElementById("show_pass").src = "../sign_up/img/openeye.jpg";
    }
    else {
        pass_notshow.type = 'password';
        show_flag = 0;
        document.getElementById("show_pass").src = "../sign_up/img/closeeye.jpg";
    }
}


// window.onload=function(){
// 	//
// 	var name=document.getElementById("name").value;
// 	var pass=document.getElementById("password").value;
// 	var login=document.getElementById("submit");
// 	login.onclick=function(){
//
// 	}
// 	var xmlhttp;
// 	function regUser(path){
// 		if(window.XMLHttpRequest){
//
// 			xmlhttp=new XMLHttpRequest();
// 		}else if(window.ActiveXObject()){
//
// 			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
// 		}
//
// 		xmlhttp.open("POST",path,true);
//
// 		xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
//
// 		xmlhttp.send("id="+name.value+"&psw="+pass.value);
//
// 		xmlhttp.onreadystatechange=httpBack;
// 	}
// 	function httpBack(){
//
// 		if(xmlhttp.readyState==4){
//
// 			if(xmlhttp.status==200){
// 				var result=xmlhttp.responseText;
// 				console.log(result);
// 				if(result=="1"){
//
// 					swal("注册成功!", "恭喜你注册成功!!!", "success")
// 					//以键值对形式存储时的键
// 					var strKey="username";
// 					var storage=window.localStorage;
// 					if(storage){
// 						//本地存储，存储键值对
// 						storage.setItem(strKey, name.value);
// 					}else{
// 						//cookie键值对存储
// 						Cookie.write(strKey, name.value);
// 					}
// 					var path="http://localhost:8080/main";
// 					window.location.assign(path);
// 				}else if(result=="0"){
//
// 					swal("警告...", "注册失败，账号已存在", "error");
// 				}
// 			}
// 		}
// 	}
// }