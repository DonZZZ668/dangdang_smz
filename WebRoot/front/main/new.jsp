<%@page contentType="text/html;charset=utf-8"%>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<c:forEach var="b" items="${requestScope.news}">
		<!--热销图书A开始-->
		<div class="second_d_wai">
			<div class="img">
				<a href="${pageContext.request.contextPath}/book/showDetail?book.id=${b.id}" target='_blank'>
					<img class="aaa" src="${pageContext.request.contextPath}/back/img/${b.cover}" border=0 /> 
				</a>
			</div>
			<div class="shuming">
				<a href="${pageContext.request.contextPath}/book/showDetail?book.id=${b.id}" target="_blank">${b.name }</a><a href="#" target="_blank"></a>
			</div>
			<div class="price">
				定价：￥${b.price }
			</div>
			<div class="price">
				当当价：￥${b.dprice }
			</div>
			<div class="price">
				销量：<font color="red">${b.sale }</font>
			</div>
		</div>
		<div class="book_c_xy_long"></div>
		<!--热销图书A结束-->
	</c:forEach>

</div>
<div class="clear"></div>