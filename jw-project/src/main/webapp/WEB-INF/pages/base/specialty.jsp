<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <!-- 导入jquery核心类库 -->
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/jquery-1.8.3.js"></script>
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
            $('#addStaffWindow').window("open");
        }

        function doView() {
            alert("查看...");
        }

        function doDelete() {
            var rows = $("#grid").datagrid("getSelections");
            if (rows.length == 0) {
                $.messager.alert("提示信息", "请选择要删除的记录", "error");
            } else {
                var array = new Array();
                for (var i = 0; i < rows.length; i++) {
                    var id = rows[i].id;
                    array.push(id);
                }
                var ids = array.join(",");
                let url = '${pageContext.request.contextPath}/specialty/delete.action?ids=' + ids;
                $.ajax({
                    url: url,
                    type: 'get',
                    success: function (data) {
                        if (data = 200) {
                            window.location.reload();
                            $.messager.alert("提示信息", "作废成功", "info");
                        } else {
                            $.messager.alert("提示信息", "作废失败", "info");
                        }
                    }
                })
            }
        }

        function doRedo() {
            var rows = $("#grid").datagrid("getSelections");
            if (rows.length == 0) {
                $.messager.alert("提示信息", "请选择要恢复的记录", "error");
            } else {
                let ids = rows[0].id;
                let url = "${pageContext.request.contextPath}/specialty/redoSpecialty.action";
                $.ajax({
                    url: url,
                    type: 'post',
                    data: {
                        id: ids
                    },
                    success: function (data) {
                        if (data = 200) {
                            window.location.reload();
                            $.messager.alert("提示信息", "恢复成功", "info");
                        } else {
                            $.messager.alert("提示信息", "恢复失败", "info");
                        }
                    }
                })
            }
        }

        //工具栏
        var toolbar = [{
            id: 'button-add',
            text: '增加',
            iconCls: 'icon-add',
            handler: doAdd
        },
            {
                id: 'button-remove',
                text: '作废',
                iconCls: 'icon-remove',
                handler: doDelete
            },
            {
                id: 'button-redo',
                text: '恢复',
                iconCls: 'icon-redo',
                handler: doRedo
            }];
        // 定义列
        var columns = [[{
            field: 'id',
            title: '专业编号',
            width: 200,
            checkbox: true,
        }, {
            field: 'collegeName',
            title: '学院名称',
            width: 200,
            align: 'center',
            formatter: function (data, row, index) {
                return row.college.name;
            }
        }, {
            field: 'name',
            title: '专业名称',
            width: 200,
            align: 'center'
        }, {
            field: 'status',
            title: '是否可用',
            width: 200,
            align: 'center',
            formatter: function (data, row, index) {
                if (data == "0") {
                    return "正常使用"
                } else {
                    return "已作废";
                }
            }
        }]];

        $(function () {
            // 先将body隐藏，再显示，不会出现页面刷新效果
            $("body").css({
                visibility: "visible"
            });

            // 取派员信息表格
            $('#grid')
                .datagrid(
                    {
                        iconCls: 'icon-forward',
                        fit: true,
                        border: false,
                        rownumbers: true,
                        striped: true,
                        pageList: [30, 50, 100],
                        pagination: true,
                        toolbar: toolbar,
                        url: "${pageContext.request.contextPath}/specialty/pageQuery.action",
                        idField: 'id',
                        columns: columns,
                        singleSelect:true,
                        onDblClickRow: doDblClickRow
                    });

            // 添加取派员窗口
            $('#addStaffWindow').window({
                title: '添加专业',
                width: 400,
                modal: true,
                shadow: true,
                closed: true,
                height: 400,
                resizable: false
            });

            $('#editStaffWindow').window({
                title: '修改专业',
                width: 400,
                modal: true,
                shadow: true,
                closed: true,
                height: 400,
                resizable: false
            });

        });

        function doDblClickRow(rowIndex, rowData) {
            $("#editStaffWindow").window("open");
            $("#editSpecialtyForm").form("load", rowData);
        }
    </script>
</head>
<body class="easyui-layout" style="visibility: hidden;">
<div region="center" border="false">
    <table id="grid"></table>
</div>

<div class="easyui-window" title="对学院进行添加或者修改" id="addStaffWindow"
     collapsible="false" minimizable="false" maximizable="false"
     style="top: 20px; left: 200px">
    <div region="north" style="height: 31px; overflow: hidden;"
         split="false" border="false">
        <div class="datagrid-toolbar">
            <a id="save" icon="icon-save" href="#" class="easyui-linkbutton"
               plain="true">保存</a>
            <script type="text/javascript">
                $("#save").click(function () {
                    var r = $("#addSpecialtyForm").form("validate");
                    if (r) {
                        $("#addSpecialtyForm").submit();
                    }
                });
            </script>
        </div>
    </div>

    <div region="center" style="overflow: auto; padding: 5px;"
         border="false">
        <form id="addSpecialtyForm" action="${pageContext.request.contextPath}/specialty/addSpecialty.action"
              method="post">
            <table class="table-edit" width="80%" align="center">
                <tr class="title">
                    <td colspan="2">专业信息</td>
                </tr>
                <tr>
                    <td>专业名称</td>
                    <td><input type="text" name="name" class="easyui-validatebox"
                               required="true"/></td>
                </tr>
                <tr>
                    <td>选择学院</td>
                    <td><input class="easyui-combobox" required="true"
                               name="collegeId"
                               data-options="valueField:'id',textField:'name',url:'${pageContext.request.contextPath}/college/listajax.action'"/>
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
                $("#editSave").click(function () {
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
        <form id="editSpecialtyForm" action="${pageContext.request.contextPath}/specialty/updateSpecialty.action"
              method="post">
            <table class="table-edit" width="80%" align="center">
                <tr class="title">
                    <td colspan="2">学院信息</td>
                </tr>
                <input type="hidden" name="id"/>
                <input type="hidden" name="status"/>
                <tr>
                    <td>专业名称</td>
                    <td><input type="text" name="name" class="easyui-validatebox"
                               required="true"/></td>
                </tr>
                <tr>
                    <td>选择学院</td>
                    <td><input class="easyui-combobox" required="true"
                               name="collegeId"
                               data-options="valueField:'id',textField:'name',url:'${pageContext.request.contextPath}/college/listajax.action'"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

</body>
</html>
