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
        $(function () {
            $("#grid").datagrid({
                toolbar: [
                    {
                        id: 'add',
                        text: '添加权限',
                        iconCls: 'icon-add',
                        handler: function () {
                            location.href = '${pageContext.request.contextPath}/function/function_add.action';
                        }
                    }
                ],
                url: '${pageContext.request.contextPath}/function/pageQuery.action',
                pagination: true,
                pageList: [10, 20, 30],
                fit: true,
                border: false,
                rownumbers: true,
                striped: true,
                onDblClickRow: doDblClickRow,
                columns: [[
                    {
                        field: 'id',
                        title: '编号',
                        width: 200
                    },
                    {
                        field: 'name',
                        title: '名称',
                        width: 200
                    },
                    {
                        field: 'description',
                        title: '描述',
                        width: 200
                    },
                    {
                        field: 'generatemenu',
                        title: '是否生成菜单',
                        width: 200
                    },
                    {
                        field: 'zindex',
                        title: '优先级',
                        width: 200
                    },
                    {
                        field: 'page',
                        title: '路径',
                        width: 200
                    }
                ]]
            });
            $('#addStaffWindow').window({
                title: '添加专业',
                width: 400,
                modal: true,
                shadow: true,
                closed: true,
                height: 400,
                resizable: false
            });
        });

        function doDblClickRow(rowIndex, rowData) {
            $("#addStaffWindow").window("open");
            console.log(rowData)
            $("#addSpecialtyForm").form("load", rowData);
        }

    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'center'">
    <table id="grid"></table>
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
                        <td>名称</td>
                        <td><input type="text" name="name" class="easyui-validatebox"
                                   required="true"/></td>
                    </tr>
                    <tr>
                        <td>描述</td>
                        <td><input type="text" name="description" class="easyui-validatebox"/></td>
                    </tr>
                    <tr>
                        <td>是否生成菜单</td>
                        <td><input type="text" name="generatemenu" class="easyui-validatebox"
                                   required="true"/></td>
                    </tr>
                    <tr>
                        <td>优先级</td>
                        <td><input type="text" name="zindex" class="easyui-validatebox"
                                   required="true"/></td>
                    </tr>
                    <tr>
                        <td>路径</td>
                        <td><input type="text" name="page" class="easyui-validatebox"/></td>
                    </tr>
                    <tr>
                        <td>父级菜单</td>
                        <td><input type="text" name="name" class="easyui-validatebox"
                                   required="true"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

</body>
</html>