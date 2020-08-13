			function selectAddress(id){
				if(id==0){
					
					window.location.href="${pageContext.request.contextPath }/address/selectAddresses?addressId=0";
					
				}else{
					
					window.location.href="${pageContext.request.contextPath }/address/selectAddresses?addressId="+id;
					
				}
			}
			function addNew(id){
				if(id==0){
					window.location.href="${pageContext.request.contextPath }/address/selectAddresses?addressId=0";
				}
			}
			function checkName(){
				var name=$("#receiveName").val();
				if(name==null || ""==name){
					$("#dname").html("<span class='error'>收件人姓名不能为空</span>");
				}else{
					$("#dname").html("");
				}
			}
			function checkAddress(){
				var address=$("#fullAddress").val();
				if(address==null || ""==address){
					$("#daddress").html("<span class='error'>收件人详细地址不能为空</span>");
				}else{
					$("#daddress").html("");
				}
			}
			function checkCode(){
				var code=$("#postalCode").val();
				if(code==null || ""==code){
					$("#dcode").html("<span class='error'>邮政编码不能为空</span>");
				}else{
					$("#dcode").html("");
				}
			}
			function checkPhone(){
				var phone=$("#phone").val();
				if(phone==null || ""==phone){
					$("#dphone").html("<span class='error'>电话不能为空</span>");
				}else{
					$("#dphone").html("");
				}
			}
			function checkForm(){
				checkName();
				checkAddress();
				checkCode();
				checkPhone();
				var tags=$(".error");
				if(tags.length>0){
					return false;
				}else{
					return true;
				}
			}