var href = window.location.href;

var box = new Vue({
    el: '#position_content',
    data: {
        position: [{}],
        department: [{}],
        company: [{}],
        category: [{}],
        reviews: [{}],
        resume: [{}],
        positionEntitiess: [{}]
    },
    created: function () {
        this.$nextTick(function () {
            $.ajax({
                url: href + "/1",
                type: "post",
                dataType: "json",
                success: function (msg) {
                	
                    box.position = msg.user;
                    box.resume = msg.resume;
                    box.category = msg.category;
                    
                    console.log(msg);

                    box.reviews.pop();
                    $(msg.comList.list).each(function (key, val) {
                        box.reviews.push({
                            userName: val.hrName,
                            reviewDetail: val.usercontent,
                            fenshu: val.fenshu
                        });
                    });
                  
                    box.positionEntitiess.pop();
                    $(msg.positionEntities).each(function (key, val) {
                        box.positionEntitiess.push({
                        	title: val.title,
                        	workCity: val.workCity,
                        	positionId: val.positionId,
                        	salaryDown: val.salaryDown,
                        	salaryUp: val.salaryUp,
                        	quantity: val.quantity
                        });
                    });
                  
                    if (msg.hr != null) {
                        header.type = 'hr';
                        header.person.hr = msg.hr;
                    }
                },
                error: function (msg) {
                    console.log(msg);
                }
            });
        });
    }

});

function posDetermine(obj) {
	var id;
	var str_1;
	var workid;
	function getRowObj(obj)
	{
	   var i = 0;
	   while(obj.tagName.toLowerCase() != "tr"){
	    obj = obj.parentNode;
	    if(obj.tagName.toLowerCase() == "table")
	  return null;
	   }
	   return obj;
	}

	var trObj = getRowObj(obj);
	   var trArr = trObj.parentNode.children;
	var trNo;
	 for( trNo= 0; trNo < trArr.length; trNo++){
	  if(trObj == trObj.parentNode.children[trNo]){
	    console.log(trNo+1);
	var x=document.getElementById('test').rows[trNo].cells;

	str_1 = x[6].innerHTML;
	id = str_1.replace(/\s*/g,"");
	str_1 = x[5].innerHTML;
	workid = str_1.replace(/\s*/g,"");
	console.log(id)
		console.log(workid)
	  }
	 }
    $.ajax({
        type:"post",
        url: "http://127.0.0.1:8080/hr/Determine",
        data: {
        	userid: id,
        	workid: workid
        },
        	dataType:"json",
        success: function(msg){
           if(msg == false){
        	   alert("失败")
           }else{
        	   alert("成功")
        	   console.log(msg)
           }
          
            
        },
        error: function(msg){
            console.log(msg);
        }
    });
	
	
	closeDialog();
}
//
//var favorFlag;
//$(document).ready(function () {
//    $.ajax({
//        url: "http://127.0.0.1:8080/hr/favorOrNot/" + posId,
//        type: "get",
//        dataType: "json",
//        success: function (msg) {
//            if (msg == "0") {
//                $("#favor_tag").css("background-color", "#3992d6").css("border", "1px solid #3992d6").text("收藏");
//                favorFlag = 0;
//            } else {
//                $("#favor_tag").css("background-color", "#707070").css("border", "1px solid #707070").text("取消收藏");
//                favorFlag = 1;
//            }
//        },
//        error: function (msg) {
//            console.log(msg);
//        }
//    });
//
//});
//
//var index = href.lastIndexOf("\/");
//var posId = href.substr(index + 1, href.length);
//// document.getElementById("apply_tag").setAttribute("href","http://localhost:8080/user/apply/"+posId);
//$("#apply_tag").attr("href", "http://127.0.0.1:8080/user/apply/" + posId);
//$("#favor_tag").click(function () {
//    if (favorFlag == 0) {
//        $.ajax({
//            url: "http://127.0.0.1:8080/user/favor/" + posId,
//            type: "get",
//            dataType: "text",
//            success: function (msg) {
//                if (msg == "success") {
//                    $("#favor_tag").css("background-color", "#707070").css("border", "1px solid #707070").text("取消收藏");
//                    favorFlag = 1;
//                } else {
//                    console.log(msg);
//                }
//            },
//            error: function (msg) {
//                console.log(msg);
//            }
//        });
//        window.location.reload();
//    } else {
//        $.ajax({
//            url: "http://127.0.0.1:8080/user/disfavor/" + posId,
//            type: "get",
//            dataType: "text",
//            success: function (msg) {
//                if (msg == "success") {
//                    $("#favor_tag").css("background-color", "#3992d6").css("border", "1px solid #3992d6").text("收藏");
//                    favorFlag = 0;
//                } else {
//                    console.log(msg)
//                }
//            },
//            error: function (msg) {
//                console.log(msg);
//            }
//        });
//
//    }
//});

//隐藏表单项提交
//$("#posId").val(posId);


/**
 * 评论ajax表单提交
 */
// function comPublish() {
//
//     var type = $("#comment_star").val();
//     type = type > 0 ? type : 1;
//     var content = layedit.getText(index);
//     var input = {
//         posId: posId,
//         type: type,
//         content: content
//     }
//
//     alert(JSON.stringify(input));
//
//     $.ajax({
//         type: "post",
//         url: "http://localhost:8080/user/comment",
//         data: input,
//         dataType: "text",
//         success: function (msg) {
//             console.log(msg);
//         },
//         error: function (msg) {
//             console.log(msg);
//         }
//     });
//
//     window.location.href(href);
// }


