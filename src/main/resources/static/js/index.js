var page = 1;
var pageTotal = 4;
var box = new Vue({
    el: '#job-content',
    data: {
        jobs: [{}]
    },
    mounted: function () {
        this.$nextTick(function () {
            $.ajax({
                url: "http://127.0.0.1:8080/page/" + page,
                type: "post",
                dataType: "json",
//                    jsonp: "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)
//                    jsonpCallback:"flightHandler",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名，也可以写"?"，jQuery会自
                success: function (msg) {
                	
                    
                    for(i = 0;i<msg.posInfo.length;i++){
                    	 if(msg.posInfo[i] == " " || msg.posInfo[i] == null || typeof(msg.posInfo[i]) == "undefined")  
                         {  
                    		 msg.posInfo.splice(i,1);  
                                  i= i-1;  

                         }  
                    }
            box.jobs = msg.posInfo;
                    // pageTotal = msg.posInfo.pages;
                    console.log(box.jobs);
                    if (msg.user != null) {
                        headervue.type = 'user';
                        headervue.person.user = msg.user;
                    } else if (msg.hr != null) {
                        headervue.type = 'hr';
                        headervue.person.hr = msg.hr;
                    }


                },
                error: function (msg) {
                	console.log(msg);
                    window.location.href = "http://127.0.0.1:8080/user/login";
                }
            });

        });
    }
});

function nextPage() {
    page = page + 1;
    if (page <= pageTotal) {
        $.ajax({
            url: "http://127.0.0.1:8080/page/" + page,
            type: "post",
            dataType: "json",
            success: function (msg) {
                for (var i = 0; i < msg.posInfo.length; i++) {
                    box.jobs.push(msg.posInfo[i]);
                }
                // box.jobs.push(msg.posInfo);
            }, error: function () {
                $("#viewMoreButton").empty();
                $("#viewMoreButton").append("没有更多");
            }
        });
    } else {
        $("#viewMoreButton").empty();
        $("#viewMoreButton").append("没有更多");
        $("#viewMoreButton").addClass("disable");
    }
}