function getQueryVariable(variable)
{
       var query = window.location.search.substring(1);
       var vars = query.split("&");
       for (var i=0;i<vars.length;i++) {
               var pair = vars[i].split("=");
               if(pair[0] == variable){return pair[1];}
       }
       return(false);
}

function createxmlreuqest() {
    try {
        return new XMLHttpRequest();
    } catch (e) {
        try {
            return new ActiveXObjecct("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                return new ActiveXObject("Micrsoft.XML");
            } catch (e) {
                throw (e);
            }
        }
    }
}
var uname=document.getElementById("showname");
var xhr = createxmlreuqest();
xhr.open("post","../getuser.action",true);
xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
xhr.send(null);
xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
        var obj = xhr.responseText;
        try{
        	  var json = JSON.parse(obj);
              if(json.flag){
              	uname.innerHTML=json.obj.hrName;
              }
        }catch(e){
        	alert("请先登录");
        	 window.location.href='/hr/hr_login';
        }
     
    }
};

var btn = document.getElementById("next");
btn.onclick=function () {
	var thname = document.getElementById("thname");
	var paper = new Object();
	paper.resumeId = getQueryVariable("id");
	paper.hrid = getQueryVariable("workid");
	paper.name = thname.value;
	var data = JSON.stringify(paper);
	if(thname.value!=""){
		 var xhr2 =new  createxmlreuqest();
		    xhr2.open("post","../addpaper.action",true);
		    xhr2.setRequestHeader("content-type", "application/json");
		    console.log(data);
		    xhr2.send(data);
		 
		    xhr2.onreadystatechange = function() {
		        if (xhr2.readyState == 4 && xhr2.status == 200) {
		            var obj = xhr2.responseText;
		            var json = JSON.parse(obj);
		            if(json.flag){
		               window.location.href="/addproblem?id="+getQueryVariable("id")+"&workid="+getQueryVariable("workid");;
		            }else{
		                alert("添加失败，请重试！")
		            }

		        }
		    };	
	}else{
		alert("不能为空哦");
	}
}
