var form =new Vue({
    el:'#loginForm',
    data:{
        url:'/hr/login',
        form:{
            userName: '',
            userPass: ''
        }
    },
    methods:{
        login : function () {
        	console.log(this.url)
        	
            this.$http.post(this.url, this.form,{emulateJSON:true}).then((message) => {
            	console.log(message)
            	setTimeout(function(){
                    self.location='/hr/index';
                },1000);
                
            }).
            catch((message) => {
                alert("账号或密码错误!!");
            });
        }
    }
});