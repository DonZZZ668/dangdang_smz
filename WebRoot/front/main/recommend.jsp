<%@page contentType="text/html;charset=utf-8"%>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<c:forEach var="b" items="${requestScope.recommends }">
	 		<div class=second_c_02_b1>
				<div class=second_c_02_b1_1>
					<a href='${pageContext.request.contextPath}/book/showDetail?book.id=${b.id}' target='_blank'>
						<img class="aaa" src="${pageContext.request.contextPath}/back/img/${b.cover}" width=70 border=0 /> 
					</a>
				</div>
				<div class=second_c_02_b1_2>
					<h3>
						<a href='${pageContext.request.contextPath}/book/showDetail?book.id=${b.id}' target='_blank' title='书名'>${b.name }</a>
					</h3>
					<h4>
						作者：${b.author } 著
						<br />
						出版社：${b.press }&nbsp;&nbsp;&nbsp;&nbsp;
						出版时间：<fmt:formatDate pattern="yyyy-MM-dd" value="${b.pressDate}"/>
					</h4>
					<h5>
						${b.contentAbstract }
					</h5>
					<h6>
						定价：￥${b.price }&nbsp;&nbsp;
						当当价：￥${b.dprice }
						销量：<font color="red">${b.sale }</font>
					</h6>
					<div class=line_xx></div>
				</div>
			</div>
		</c:forEach>

	</div>
</div>
