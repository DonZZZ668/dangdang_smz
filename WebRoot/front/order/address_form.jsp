<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="${pageContext.request.contextPath }/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
			.error{ color:red }
		</style>
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/address_form.js"></script>
		
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
		</div>
		<div class="fill_message">
			<p>
				选择地址：
				<select id="address" onchange="selectAddress(this.value)">
					<option value="0" >
						填写新地址
					</option>
					<c:forEach var="a" items="${requestScope.alist }">
						<option value="${a.id }" <c:if test="${addressId==a.id }">selected="selected"</c:if>>
							${a.local }
						</option>
					</c:forEach>
					
				</select>
			</p>
			<form name="ctl00" method="get" action="${pageContext.request.contextPath}/order/addOrder" id="f" onsubmit="return checkForm()">
				<input type="hidden" name="address.id" id="addressId" value="${address.id }"/>
				<input type="hidden" name="address.userId" id="userId" value="${address.userId }"/>
				<input type="hidden" name="address.createDate" id="createDate" value="<fmt:formatDate value='${address.createDate }' pattern='yyyy-MM-dd'/>"/>
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名:
						</td>
						<td>
							<input type="text" class="text_input" name="address.name" id="receiveName" value="${requestScope.address.name }" onblur="checkName()"/>
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名<div id="dname"></div>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址:
						</td>
						<td>
							<input type="text" name="address.local" class="text_input" id="fullAddress" value="${requestScope.address.local }" onblur="checkAddress()"/>
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址<div id="daddress"></div>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码:
						</td>
						<td>
							<input type="text" class="text_input" name="address.zipCode" id="postalCode" value="${requestScope.address.zipCode }" onblur="checkCode()"/>
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码<div id="dcode"></div>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话:
						</td>
						<td>
							<input type="text" class="text_input" name="address.phone" id="phone" value="${requestScope.address.phone }" onblur="checkPhone()"/>
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话<div id="dphone"></div>
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">
					<a href="order_info.jsp">
						<input id="btnClientRegister" class="button_1" name="submit" type="submit" value="取消" />
					</a>			
				<input id="btnClientRegister" class="button_1" name="submit" type="submit" value="下一步" />
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

