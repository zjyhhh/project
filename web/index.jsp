<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>教师工号输入</title>
	<link rel="stylesheet" href="TeacherSum/css/TeacherNumber.css">
</head>
<body>
<div class="main">
	<div class="left">
		<img src="TeacherSum/img/loginLogo.png" alt="bg" class="login_logo">
	</div>
	<div class="right">
		<h2 class="header">教师教学工作量统计系统</h2>
		<div class="input_number">
			<span>账号：</span>
			<input type="text" id="TeacherNumber" value="" placeholder="请输入工号">
		</div>
		<button id="Go">Go</button>
	</div>
</div>
<div class="footer">
	Copyright &copy;2019 ForNa Work Team All Rights Reserved
</div>
<script type="text/javascript" src="TeacherSum/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="TeacherSum/js/TeacherNumber.js"></script>
</body>
</html>