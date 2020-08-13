//图片放大镜
$(function(){
				$(".aaa").mouseover(function(e){
					var width=this.width*2;
					var height=this.height*2;
					var x=e.pageX;
					var y=e.pageY;
					var div=$("<div id='bigDiv'/>").css({
														"position":"absolute",
														"display":"none",
														"width":width,
														"height":height,
														"left":x,
														"top":y,
														"border":"2px solid red"
													});
					var img=$("<img/>").css({
												"width":width,
												"height":height
											}).attr({
												"src":this.src
											})
					div.append(img);
					$("body").append(div);
					div.show(500);
				}).mousemove(function(e){
					var x=e.pageX;
					var y=e.pageY;
					$("#bigDiv").css({
										"left":x+10,
										"top":y+10
									})
				}).mouseout(function(e){
						$("#bigDiv").remove();
				})
			})