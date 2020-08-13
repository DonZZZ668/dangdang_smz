<%@page contentType="text/html;charset=utf-8"%>
	<h2 class="t_xsrm">
		新书热卖榜
	</h2>
	<div id="NewProduct_1_o_t" onmouseover="">
	<ul>
		<c:forEach var="b" items="${requestScope.newAndHot }">
			<li>&nbsp;&nbsp;&nbsp;
				<a  target='_blank' href="${pageContext.request.contextPath}/book/showDetail?book.id=${b.id}">
					${b.name }
				</a>
			</li>
		</c:forEach>
	</ul>
	<h3 class="second">
		<span class="dot_r"> </span><a href="#" target="_blank">更多&gt;&gt;</a>
	</h3>
</div>