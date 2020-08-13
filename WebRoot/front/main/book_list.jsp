<%@page contentType="text/html;charset=utf-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath }/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/prototype-1.6.0.3.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/magnifier.js"></script>
		
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="${pageContext.request.contextPath }/front/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='${pageContext.request.contextPath }/book/main'>当当图书</a> &gt;&gt;
			<font style='color: #cc3300'><strong>${requestScope.category.name }</strong> </font>
			<c:if test="${sid!=null && sid!=''}">
				&gt;&gt;
				<font style='color: #cc3300'><strong>
					<c:forEach var="c2" items="${category.sons }">
						<c:if test="${c2.id==sid }">
							${c2.name }
						</c:if>
					</c:forEach>
				</strong> </font>
			</c:if>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
										
										<c:if test="${sid==null || sid==''}">
											<a href="${pageContext.request.contextPath }/book/second?fid=${fid}" style='color: #cc3300'><strong>&middot;全部&nbsp;</strong> </a>
										</c:if>
										<c:if test="${sid!=null && sid!=''}">
											<a href="${pageContext.request.contextPath }/book/second?fid=${fid}" >&middot;全部&nbsp;</a>
										</c:if>
									</div>
								</div>
							</li>
							<div class="clear"></div>
							
							<!--2级分类开始-->
							<c:forEach var="c2" items="${category.sons }">
								<li>
									<div>
										<div class=second_fenlei>
											&middot;
										</div>
										<div class=second_fenlei>
											<c:if test="${sid==c2.id }">
												<a href="${pageContext.request.contextPath }/book/second?fid=${c2.parentId}&sid=${c2.id}" style='color: #cc3300'><strong>${c2.name }&nbsp;</strong> </a>
											</c:if>
											<c:if test="${sid!=c2.id }">
												<a href="${pageContext.request.contextPath }/book/second?fid=${c2.parentId}&sid=${c2.id}" >${c2.name }&nbsp;</a>
											</c:if>
										</div>
									</div>
								</li>
								<div class="clear"></div>
							</c:forEach>
						    
							<!--2级分类结束-->
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							
							<div class='list_r_title_text3a'>
								<a name=link_page_next href="${pageContext.request.contextPath }/book/second?fid=${fid}&sid=${sid}&pageNum=1">
									<img src='${pageContext.request.contextPath }/front/images/page_up.gif' /> 
								</a>
							</div>
	
							<div class='list_r_title_text3a'>
								<a name=link_page_next href="${pageContext.request.contextPath }/book/second?fid=${fid}&sid=${sid}&pageNum=${pageNum-1}">
									<img src='${pageContext.request.contextPath }/front/images/page_up.gif' /> 
								</a>
							</div>
				
							<div class='list_r_title_text3b'>
								第${pageNum }页/共${count }页
							</div>
							
							<div class='list_r_title_text3a'>
								<a name=link_page_next href="${pageContext.request.contextPath }/book/second?fid=${fid}&sid=${sid}&pageNum=${pageNum+1}">
									<img src='${pageContext.request.contextPath }/front/images/page_down.gif' /> 
								</a>
							</div>
			
							<div class='list_r_title_text3a'>
								<a name=link_page_next href="${pageContext.request.contextPath }/book/second?fid=${fid}&sid=${sid}&pageNum=${count}">
									<img src='${pageContext.request.contextPath }/front/images/page_down.gif' /> 
								</a>
							</div>

							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						<c:forEach var="b" items="${requestScope.list }">
							<div class="list_r_line"></div>
							<div class="clear"></div>
								<div class="list_r_list">
									<span class="list_r_list_book">
										<a name="link_prd_img" href='${pageContext.request.contextPath}/book/showDetail?book.id=${b.id}'>
											<img class="aaa" src="${pageContext.request.contextPath}/back/img/${b.cover}" /> 
										</a>
									</span>
									<h2>
										<a name="link_prd_name" href='${pageContext.request.contextPath}/book/showDetail?book.id=${b.id}'>${b.name }</a>
									</h2>
									<h4 class="list_r_list_h4">
										作 者:
										<a href='#' name='作者'>${b.author }</a>
									</h4>
									<h4>
										出版社：
										<a href='#' name='出版社'>${b.press }</a>
									</h4>
									<h4>
										出版时间：<fmt:formatDate pattern="yyyy-MM-dd" value="${b.pressDate}"/>
									</h4>
									<h5>
										${b.contentAbstract }
									</h5>
									<div class="clear"></div>
									<h6>
										<span class="del">￥${b.price }</span>
										<span class="red">￥${b.dprice }</span>
										节省：￥${b.price-b.dprice }
									</h6>
									<span class="list_r_list_button"> 
									<a href="${pageContext.request.contextPath }/cart/addCart?id=${b.id}"> 
										<img src='${pageContext.request.contextPath }/front/images/buttom_goumai.gif' /> 
									</a>
									<span id="cartinfo"></span>
								</div>
							<div class="clear"></div>
						</c:forEach>

						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
