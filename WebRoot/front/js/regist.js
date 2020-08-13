function isEmail(){
				var a=$("#txtEmail").val();
  				var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,4}$/;
				if(!myreg.test(a)){
					$("#emailInfo").html("<span class='error'>邮箱格式不正确</span>"); 
				}else{
					$("#emailInfo").html("<span style='color:green'>邮箱格式正确</span>");
				}
			};
			function checkNickName(){
				 var name=$("#txtNickName").val();
				 var length=0;
				 var charCode=0;
				 //遍历文本框的值拿到每一个字符
				 for(var i=0;i<name.length;i++){
				    //获取每一个字符的编码
					charCode=name.charCodeAt(i);
					//根据编码判断该字符是否是汉字
					if(charCode>=0&&charCode<=127){
					    length+=1;
					}else{
					    length+=2;
					}
				 }
				 if(length>=4&&length<=20){
				     $("#nameInfo").html("<span style='color:green'>昵称格式正确</span>"); 
				 }else{
				 	 $("#nameInfo").html("<span class='error'>昵称格式不正确</span>");
				 }
			}
			function checkPassword1(){
				var password=$("#txtPassword").val();
				if(password.length>=6 && password.length<=22){
					$("#passwordInfo").html("<span style='color:green'>密码格式正确</span>");
				}else{
				 	$("#passwordInfo").html("<span class='error'>密码格式不正确</span>");
				}
			}
			function checkPassword2(){
				var password=$("#txtPassword").val();
				var password2=$("#txtRepeatPass").val();
				if(password==password2 && password!=null &&password!=''){
					$("#password2Info").html("<span style='color:green'>两次密码一致</span>");
				}else{
					if(password==null || password==''){
						$("#password2Info").html("<span class='error'>密码格式不正确</span>");
					}else{
						$("#password2Info").html("<span class='error'>两次密码不一致</span>");
					}
				 	
				}
			}
			function checkCode(){
				var code=$("#txtVerifyCode").val();
				if(code==null || code==''){
					$("#codeInfo").html("<span class='error'>验证码不能为空</span>");
				}else{
					$("#codeInfo").html("");
				}
			}
			function checkForm(){
				isEmail();
				checkNickName();
				checkPassword1();
				checkPassword2();
				checkCode();
				var tags=$(".error");
				if(tags.length>0){
					return false;
				}else{
					return true;
				}
				
			}
			