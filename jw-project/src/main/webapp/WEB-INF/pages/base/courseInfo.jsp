<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
            //alert("增加...");
            $("#saveCourse").window("open");
        }

        function doView() {
            alert("查看...");
        }

        function doDelete() {

        }

        function doRestore() {
            alert("将取派员还原...");
        }

        //工具栏
        var toolbar = [{
            id: 'button-add',
            text: '添加课程',
            iconCls: 'icon-add',
            handler: doAdd
        }];
        // 定义列
        var columns = [[{
            field: 'id',
            title: '课程编号',
            width: 200,
            checkbox: true,
        }, {
            field: 'name',
            title: '课程名称',
            width: 200,
            align: 'center'
        }, {
            field: 'classroom',
            title: '上课教室',
            width: 200,
            align: 'center'
        }, {
            field: 'collegeName',
            title: '开课学院',
            width: 200,
            align: 'center',
            formatter: function (data, row, index) {
                return row.college.name;
            }
        }, {
            field: 'tname',
            title: '上课教师',
            width: 200,
            align: 'center',
            formatter: function (data, row, index) {
                return row.teacher.tname;
            }
        }, {
            field: 'people',
            title: '已选人数',
            width: 200,
            align: 'center'
        }, {
            field: 'totalpeople',
            title: '课程人数',
            width: 200,
            align: 'center'
        }, {
            field: 'credit',
            title: '学分',
            width: 150,
            align: 'center'
        }, {
            field: 'totalTime',
            title: '总学时',
            width: 150,
            align: 'center'
        }, {
            field: 'examway',
            title: '考核方式',
            width: 150,
            align: 'center',
            formatter: function (data, row, index) {
                return row.examway.name;
            }
        }, {
            field: 'csName',
            title: '课程属性',
            width: 150,
            align: 'center',
            formatter: function (data, row, index) {
                return row.cstatus.name;
            }
        }, {
            field: 'nature_name',
            title: '课程性质',
            width: 150,
            align: 'center',
            formatter: function (data, row, index) {
                return row.nature.name;
            }
        }]];

        $(function () {
            // 先将body隐藏，再显示，不会出现页面刷新效果
            $("body").css({
                visibility: "visible"
            });

            // 取派员信息表格
            $('#grid').datagrid({
                iconCls: 'icon-forward',
                fit: true,
                border: false,
                rownumbers: true,
                striped: true,
                singleSelect: true,
                pageList: [30, 50, 100],
                pagination: true,
                toolbar: toolbar,
                url: "${pageContext.request.contextPath}/course/pageQuery.action",
                idField: 'id',
                columns: columns,
                onDblClickRow: doDblClickRow
            });

            // 添加取派员窗口
            $('#saveCourse').window({
                title: '添加课程',
                width: 800,
                modal: true,
                shadow: true,
                closed: true,
                height: 600,
                resizable: false
            });

            $('#editStaffWindow').window({
                title: '修改学生',
                width: 400,
                modal: true,
                shadow: true,
                closed: true,
                height: 400,
                resizable: false
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

<div class="easyui-window" title="导入课程数据" id="saveCourse"
     collapsible="false" minimizable="false" maximizable="false"
     style="top: 20px; left: 200px">
    <div region="north" style="height: 31px; overflow: hidden;"
         split="false" border="false">
        <div class="datagrid-toolbar">
            <a id="save" icon="icon-save" href="#" class="easyui-linkbutton"
               plain="true">保存</a>
            <script type="text/javascript">
                $("#save").click(function () {
                    var r = $("#addCourseForm").form("validate");
                    if (r) {
                        $("#addCourseForm").submit();
                    }
                });
            </script>
        </div>
    </div>

    <div region="center" style="overflow: auto; padding: 5px;"
         border="false">
        <form id="addCourseForm" action="${pageContext.request.contextPath }/course/add.action"
              method="post">
            <table class="table-edit" width="80%" align="center">
                <tr class="title">
                    <td colspan="2">课程信息</td>
                </tr>
                <tr>
                    <td>课程名称</td>
                    <td><input type="text" name="name" class="easyui-validatebox"
                               required="true"/></td>
                </tr>
                <tr>
                    <td>学分</td>
                    <td><input type="text" name="credit"
                               class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td>总学时</td>
                    <td><input type="text" name="totalTime"
                               class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td>上课教室</td>
                    <td><input type="text" name="classroom"
                               class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td>上课人数</td>
                    <td><input type="text" name="totalpeople"
                               class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td>上课时间</td>
                    <td><input class="easyui-combobox" required="true"
                               name="sectionId"
                               data-options="valueField:'id',textField:'sectionTime',url:'${pageContext.request.contextPath}/section/listajax.action'"/>
                    </td>
                </tr>
                <tr>
                    <td>上课学期</td>
                    <td><input class="easyui-combobox" required="true"
                               name="teamId"
                               data-options="valueField:'id',textField:'name',url:'${pageContext.request.contextPath}/team/listajax.action'"/>
                    </td>
                </tr>
                <tr>
                    <td>上课周数</td>
                    <td><input class="easyui-combobox" required="true"
                               name="weekId"
                               data-options="valueField:'id',textField:'time',url:'${pageContext.request.contextPath}/week/listajax.action'"/>
                    </td>
                </tr>
                <tr>
                    <td>开课学院</td>
                    <td><input class="easyui-combobox" required="true"
                               name="collegeId"
                               data-options="onSelect:ajaxUnion,valueField:'id',textField:'name',url:'${pageContext.request.contextPath}/college/listajax.action'"/>
                    </td>
                </tr>
                <tr>
                    <td>上课教师</td>
                    <td><input class="easyui-combobox" required="true"
                               name="teacherId" id="teacherInfo"
                               data-options="valueField:'tid',textField:'tname',url:'${pageContext.request.contextPath}/teacher/teacherByCollege.action'"/>
                    </td>
                </tr>
                <tr>
                    <td>考核方式</td>
                    <td><input class="easyui-combobox" required="true"
                               name="wayId"
                               data-options="valueField:'id',textField:'name',url:'${pageContext.request.contextPath}/way/listajax.action'"/>
                    </td>
                </tr>
                <tr>
                    <td>课程属性</td>
                    <td><input class="easyui-combobox" required="true"
                               name="cstatusId"
                               data-options="valueField:'id',textField:'name',url:'${pageContext.request.contextPath}/cstatus/listajax.action'"/>
                    </td>
                </tr>
                <tr>
                    <td>课程性质</td>
                    <td><input class="easyui-combobox" required="true"
                               name="natureId"
                               data-options="valueField:'id',textField:'name',url:'${pageContext.request.contextPath}/nature/listajax.action'"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<script type="text/javascript">
    function ajaxUnion(recode) {
        $("#teacherInfo ").combobox('reload','${pageContext.request.contextPath}/teacher/teacherByCollege.action?id='+recode.id);
    }
</script>
</body>
</html>
