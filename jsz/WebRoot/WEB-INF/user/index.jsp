<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>

	<link rel="stylesheet" type="text/css" href="css/comm.css" />
	<link rel="stylesheet" type="text/css" href="css/index.css" />

  </head>
  
  <body>
    
	<div class="top">
		<img src="images/top.gif" />
	
	</div>
	
	<!-- 中左部分div -->
	<div class="user_mid_left">
		<!-- 广告信息头 -->
		<div class="ad_info_title">
			<span>
				<img src="images/landian.gif"/>&nbsp;
				<font class="font_style1">推荐企业广告信息</font>
			</span>
		</div>
		
		<!-- 广告信息列表 -->
		<div class="ad_info_list">
			<ul>
				<li><a href="#">- 重庆明天会更好。。。。。</a></li>
				<li><a href="#">- 重庆明天会更好。。。。。</a></li>
				<li><a href="#">- 重庆明天会更好。。。。。</a></li>
				<li><a href="#">- 重庆明天会更好。。。。。</a></li>
				<li><a href="#">- 重庆明天会更好。。。。。</a></li>
				<li><a href="#">- 重庆明天会更好。。。。。</a></li>
				<li><a href="#">- 重庆明天会更好。。。。。</a></li>
				<li><a href="#">- 重庆明天会更好。。。。。</a></li>
				<li><a href="#">- 重庆明天会更好。。。。。</a></li>
			</ul>
		</div>
		
		<!-- 快速信息检索头 -->
		<div class="ad_info_search">
			<span>
				<img src="images/landian.gif"/>&nbsp;
				<font class="font_style1">信息快速检索</font>
			</span>
		</div>
		
		<!-- 信息检索表单 -->
		<div class="info_search">
			<table>
				<tr><td>关键字</td><td><input type="text" name="keyword" /></td></tr>
				<tr><td>条件</td>
				<td>
					<select name="infoType">
						<option value="qiuzhi">求职信息</option>					
						<option value="zhaopin">招聘信息</option>					
						<option value="jiajiao">家教信息</option>					
						<option value="qita">其它信息</option>					
					</select>
				</td></tr>
				<tr><td></td><td><input type="image" src="images/btn1.gif" /></td></tr>
			</table>
		</div>
		
		<!-- 联系我们头 -->
		<div class="contact_us">
			<span>
				<img src="images/landian.gif"/>&nbsp;
				<font class="font_style1">联系我们</font>
			</span>
		</div>
		
		<!-- 联系信息 -->
		<div class="contact_info">
			<span>
				<font class="font_style2">及时雨供求信息网</font><br />
				<hr class="underline_style1"/>
				联系地址： 合肥市 ** 街 *号<br />
				联系电话：１２９３２０９０２０<br />
				邮编号码：３９２９０９<br />
			</span>
		</div>
	</div>
	
	<!-- 中右部分 -->
	<div class="user_mid_right">
		<div class="pay_title">
			
		</div>
		
		<div class="pay_info_con">
			<table>
				<tr><td><font class="font_style2">【求职信息】</font><font class="font_style3">  我是一个求职人</font><font class="font_style4">  2012-10-10 12:12:21</font></td></tr>
				<tr><td style="text-indent:2em;"><font class="font_style5">hello</font></td></tr>
				<tr><td><font class="font_style3">联系人：111   联系电话： 111</font></td></tr>
				<tr><td><hr /></td></tr>
			</table>
		</div>
		
		<!-- 放入首页的广告 -->
		<div class="ad_con">
			<img src="images/guanggao.gif" />
		</div>
		
		<!-- 免费信息图片 -->
		<div class="free_title">
		</div>		
		
		<!-- 免费信息 -->
		<div class="free_info_con">
			<table>
				<tr><td><font class="font_style2">【求职信息】</font><font class="font_style3">  我是一个求职人</font><font class="font_style4">  2012-10-10 12:12:21</font></td></tr>
				<tr><td style="text-indent:2em;"><font class="font_style5">hello</font></td></tr>
				<tr><td><font class="font_style3">联系人：111   联系电话： 111</font></td></tr>
				<tr><td><hr /></td></tr>
			</table>
			<table>
				<tr><td><font class="font_style2">【求职信息】</font><font class="font_style3">  我是一个求职人</font><font class="font_style4">  2012-10-10 12:12:21</font></td></tr>
				<tr><td style="text-indent:2em;"><font class="font_style5">hello</font></td></tr>
				<tr><td><font class="font_style3">联系人：111   联系电话： 111</font></td></tr>
				<tr><td><hr /></td></tr>
			</table>
			<table>
				<tr><td><font class="font_style2">【求职信息】</font><font class="font_style3">  我是一个求职人</font><font class="font_style4">  2012-10-10 12:12:21</font></td></tr>
				<tr><td style="text-indent:2em;"><font class="font_style5">hello</font></td></tr>
				<tr><td><font class="font_style3">联系人：111   联系电话： 111</font></td></tr>
				<tr><td><hr /></td></tr>
			</table>
			
			<span class="pagenavi">共有  3 条    每页显示  4 条    第  1 页/共  1 页</span>
		</div>
		
	</div>
	
	<!-- 首页的底部 -->
	<div class="user_bottom">
		<span><font class="font_style6">就就读供求信息网  www.justtest.com 版权所有  联系电话：8329832039</font></span>
	</div>

  </body>
</html>
