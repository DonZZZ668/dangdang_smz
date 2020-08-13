<%@page contentType="text/html;charset=utf-8"%>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
		<!--1级分类开始-->
			<c:forEach var="c" items="${requestScope.clist }">
				<div class="bg_old" onmouseover="this.className = 'bg_white';"
					onmouseout="this.className = 'bg_old';">
					<h3>
						[<a href='${pageContext.request.contextPath }/book/second?fid=${c.id}&pageNum=1'>${c.name }</a>]
					</h3>
					<ul class="ul_left_list">
							<c:forEach var="c2" items="${c.sons }">
							<!--2级分类开始-->
								<li>
									<a href='${pageContext.request.contextPath }/book/second?fid=${c.id}&sid=${c2.id}&pageNum=1'>${c2.name }</a>
								</li>
							<!--2级分类结束-->
							</c:forEach>
					</ul>
					<div class="empty_left">
					</div>
				</div>
		<!--1级分类结束-->
			</c:forEach>



		
	</div>
</div>
