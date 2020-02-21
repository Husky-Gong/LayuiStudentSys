<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student update</title>
<link rel="stylesheet" href="resources/layui/css/layui.css"/>
</head>
<body>
	<div style="width:650px;margin: auto;margin-top: 50px;">
	<!-- use form in Layui -->
	<form class="layui-form layui-form-pane" lay-filter="formFilter">
	
	
		<!-- student number and student name -->
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">Number:</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" name="stNo" placeholder="your student number" lay-verify="required|number" lay-reqText="Invalid student number" />
				</div>
			</div>
			
			<div class="layui-inline">
				<label class="layui-form-label">Name:</label>
					<div class="layui-input-inline">
						<input type="text" class="layui-input" name="name" placeholder="Your name" lay-verify="required" lay-reqText="Invalid Name!"/>
					</div>
			</div>
		</div>
		
		
		<!-- student age and student sex -->
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">Age:</label>
					<div class="layui-input-inline">
						<input type="text" class="layui-input" name="age" placeholder=" your age" lay-verify="required|number" lay-reqText="Invalid Age!"/>
					</div>
			</div>
			
			<div class="layui-inline">
				<label class="layui-form-label">Sex:</label>
					<div class="layui-input-inline">
						<input type="radio" name="sex" value="male" title="M" checked/>
						<input type="radio" name="sex" value="female" title="F" />
					</div>
			</div>
		</div>
		
		
		<!-- student cell phone number and city -->
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">Tel:</label>
					<div class="layui-input-inline">
						<input type="text" class="layui-input" name="phone" placeholder="phone number" lay-verify="phone" lay-reqText="Invalid phone number!"/>
					</div>
			</div>
			
			<div class="layui-inline">
				<label class="layui-form-label">add:</label>
					<div  class="layui-input-inline">
						<select name="city" lay-verify="required" lay-reqText="Invalid city!">
							<option value="">City:</option>
							<option value="Boston">Boston</option>
							<option value="Cambridge">Cambridge</option>
							<option value="Miami">Miami</option>
							<option value="Seattle">Seattle</option>
							<option value="Roxbory">Roxbory</option>
						</select>
					</div>
			</div>
		</div>
		
		
		<!-- Student self-introduction -->
		<div class="layui-form-item">
			<label class="layui-form-label">Self-intro:</label>
			<div class="layui-input-inline">
				<textarea name = "info" class="layui-textarea" style="width:510px"></textarea>
			</div>
		</div>
		
		
		<!-- Reset and submit button -->
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button type="reset" class="layui-btn layui-btn-normal">Reset</button>
				<button type="submit" class="layui-btn" lay-submit lay-filter="subBtnFilter">Submit</button>
			</div>
		</div>
	</form>
	</div>
	
	<script type="text/javascript" src="resources/layui/layui.js"></script>
	<script type="text/javascript">
		layui.use(['form','jquery','layer'],function(){
			var form = layui.form;
			var $ = layui.jquery;
			
		})
	</script>
	
</body>
</html>