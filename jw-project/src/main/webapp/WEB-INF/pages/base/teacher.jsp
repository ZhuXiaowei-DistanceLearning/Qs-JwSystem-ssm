<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/ztree/jquery-1.8.3.js"></script>
<!-- 导入easyui类库 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/default.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
<script
	src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function doAdd() {
		location.href = "${pageContext.request.contextPath}/teacher/userinfo.action";
	}

	function doView() {
	}

	function doDelete() {

	}

	function doRestore() {
		alert("将取派员还原...");
	}
	//工具栏
	var toolbar = [ {
		id : 'button-add',
		text : '添加教师',
		iconCls : 'icon-add',
		handler : doAdd
	}];
	// 定义列
	var columns = [ [ {
		field : 'tid',
		title : '教师编号',
		width : 100,
		rowspan : 2,
		checkbox : true,
	}, {
		field : 'tname',
		title : '姓名',
		width : 100,
		rowspan : 2,
		align : 'center'
	}, {
		field : 'tsex',
		title : '性别',
		width : 100,
		rowspan : 2,
		align : 'center'
	}, {
		field : 'tage',
		title : '年龄',
		width : 100,
		rowspan : 2,
		align : 'center'
	}, {
		field : 'status',
		title : '是否在职',
		width : 100,
		rowspan : 2,
		align : 'center',
		formatter : function(data, row, index) {
			if (data == "0") {
				return "在职"
			} else {
				return "已退休";
			}
		}
	}, {
		field : 'password',
		title : '密码',
		width : 100,
		rowspan : 2,
		align : 'center'
	}, {
		field : 'formatDate',
		title : '入职日期',
		width : 100,
		rowspan : 2,
		align : 'center'
	}, {
		title : '其他信息',
		colspan : 2
	}, {
		field : 'qx',
		title : '权限',
		width : 170,
		rowspan : 2,
		align : 'center'
	} ], [ {
		field : 'collegeName',
		title : '单位',
		width : 110,
		rowspan : 2,
		align : 'center',
		formatter : function(data, row, index) {
			return row.college.name;
		}
	}, {
		field : 'salary',
		title : '工资',
		width : 80,
		rowspan : 2,
		align : 'center'
	} ] ];

	$(function() {
		// 先将body隐藏，再显示，不会出现页面刷新效果
		$("body").css({
			visibility : "visible"
		});

		// 取派员信息表格
		$('#grid')
				.datagrid(
						{
							iconCls : 'icon-forward',
							fit : true,
							border : false,
							rownumbers : true,
							striped : true,
							singleSelect : true,
							pageList : [ 30, 50, 100 ],
							pagination : true,
							toolbar : toolbar,
							url : "${pageContext.request.contextPath}/teacher/pageQuery.action",
							idField : 'id',
							columns : columns,
							onDblClickRow : doDblClickRow
						});

		// 添加取派员窗口
		$('#importStudent').window({
			title : '添加专业',
			width : 400,
			modal : true,
			shadow : true,
			closed : true,
			height : 400,
			resizable : false
		});

		$('#editStaffWindow').window({
			title : '修改学生',
			width : 400,
			modal : true,
			shadow : true,
			closed : true,
			height : 400,
			resizable : false
		});

	});

	function doDblClickRow(rowIndex, rowData) {
		$("#importStudent").window("open");
		$("#editSpecialtyForm").form("load", rowData);
	}
</script>
</head>
<body class="easyui-layout" style="visibility: hidden;">
	<div region="center" border="false">
		<table id="grid"></table>
	</div>

	<div class="easyui-window" title="导入学生数据" id="importStudent"
		collapsible="false" minimizable="false" maximizable="false"
		style="top: 20px; left: 200px">
		<div region="north" style="height: 31px; overflow: hidden;"
			split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-redo" href="#" class="easyui-linkbutton"
					plain="true">导入</a>
				<script type="text/javascript">
					$("#save").click(function() {
						var r = $("#addClassesForm").form("validate");
						if (r) {
							$("#addClassesForm").submit();
						}
					});
				</script>
			</div>
		</div>

		<div region="center" style="overflow: auto; padding: 5px;"
			border="false">
			<form id="addClassesForm" action="classesAction_add.action"
				method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">专业信息</td>
					</tr>
					<tr>
						<td>课程名称</td>
						<td><input type="text" name="classname"
							class="easyui-validatebox" required="true" /></td>
					</tr>
					<tr>
						<td>选择专业</td>
						<td><input class="easyui-combobox" required="true"
							name="specialty.id"
							data-options="valueField:'id',textField:'name',url:'${pageContext.request.contextPath}/specialtyAction_listajax.action'" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<!-- 修改专业信息 -->
	<div class="easyui-window" title="对学院进行添加或者修改" id="editStaffWindow"
		collapsible="false" minimizable="false" maximizable="false"
		style="top: 20px; left: 200px">
		<div region="north" style="height: 31px; overflow: hidden;"
			split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="editSave" icon="icon-save" href="#" class="easyui-linkbutton"
					plain="true">保存</a>
				<script type="text/javascript">
					$("#editSave").click(function() {
						var r = $("#editSpecialtyForm").form("validate");
						if (r) {
							$("#editSpecialtyForm").submit();
						}
					});
				</script>
			</div>
		</div>

		<div region="center" style="overflow: auto; padding: 5px;"
			border="false">
			<form id="editSpecialtyForm"
				action="specialtyAction_updateSpecialty.action" method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">学院信息</td>
					</tr>
					<input type="hidden" name="id" />
					<input type="hidden" name="status" />
					<tr>
						<td>专业名称</td>
						<td><input type="text" name="name" class="easyui-validatebox"
							required="true" /></td>
					</tr>
					<tr>
						<td>选择学院</td>
						<td><input class="easyui-combobox" required="true"
							name="college.id"
							data-options="valueField:'id',textField:'name',url:'${pageContext.request.contextPath}/collegeAction_listajax.action'" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>
</html>
