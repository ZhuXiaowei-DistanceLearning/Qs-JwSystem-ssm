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
    <!-- 导入ztree类库 -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css"
          type="text/css"/>
    <script
            src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"
            type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            // 数据表格属性
            $("#grid").datagrid({
                toolbar: [
                    {
                        id: 'add',
                        text: '添加角色',
                        iconCls: 'icon-add',
                        handler: function () {
                            location.href = '${pageContext.request.contextPath}/role/pageAdd.action';
                        }
                    }, {
                        id: 'delete',
                        text: '删除角色',
                        iconCls: 'icon-remove',
                        handler: function () {
                            var rows = $("#grid").datagrid("getSelections");
                            if (rows.length == 0) {
                                $.messager.alert("提示信息", "请选择要删除的记录", "error");
                            } else {
                                $.ajax({
                                    url:"${pageContext.request.contextPath}/role/delete.action?roleId="+rows[0].id,
                                    type:"get",
                                    success:function (data) {
                                        if(data=="true"){
                                            window.location.reload();
                                        }
                                    }
                                })
                            }
                        }
                    }
                ],
                url: '${pageContext.request.contextPath}/role/pageQuery.action',
                pagination: true,
                pageList: [3, 5, 7],
                onDblClickRow: doDblClickRow,
                striped:true,
                singleSelect:true,
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
                    }
                ]]
            });
        });

        function doDblClickRow(rowIndex, rowData) {
            $("#roleId").val(rowData.id);
            let arr;
            var p = new Promise(function (resolve, reject) {
                $.ajax({
                    url: '${pageContext.request.contextPath}/function/queryFunctionByRole.action?id=' + rowData.id,
                    type: "get",
                    success: function (data) {
                        arr = data;
                        resolve(arr)
                    }
                });
            })
            p.then(function (res) {
                var setting = {
                    data: {
                        key: {
                            title: "t"
                        },
                        simpleData: {//使用简单json数据构造节点数据
                            enable: true,
                            // idKey: "id",
                            // pIdKey: "pid"
                        }
                    },
                    check: {//使用ztree勾选效果
                        enable: true
                    }
                };
                $
                    .ajax({
                        url: '${pageContext.request.contextPath}/function/listajax.action',
                        type: 'POST',
                        dataType: 'json',
                        success: function (data) {
                            let tree = $.fn.zTree.init($("#functionTree"), setting, data);
                            tree.expandAll(true)
                            $.each(res, function (index, val) {
                                let node = tree.getNodeByParam("id", val);
                                tree.checkNode(node, true, false)
                            });
                        },
                        error: function (msg) {
                            alert('树加载异常!');
                        }
                    });
                // 点击保存
                $('#save').click(function () {

                });
                // resolve(1);
            }).then(function (res) {
                $("#win").window('open');
            })
        }
    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'center'">
    <table id="grid"></table>
    <div id="win" class="easyui-window" title="权限修改" style="width:600px;height:400px;"
         data-options="modal:true,closed:true,iconCls:'icon-save',collapsible:false,minimizable:false,maximizable:false,draggable:false,tools:'#tt'">
        <form id="roleForm" method="post"
              action="${pageContext.request.contextPath }/role/update.action">
            <input type="hidden" name="ids">
            <input type="hidden" name="roleId" id="roleId">
            <div class="easyui-panel" style="padding:5px">
                <ul id="functionTree" class="ztree"></ul>
            </div>
        </form>
    </div>
</div>
<div id="tt">
    <a href="javascript:void(0)" class="icon-add" onclick="javascript:editRole()"></a>
</div>
</div>
<script type="text/javascript">
    function editRole() {
        var v = $("#roleForm").form("validate");
        if (v) {
            var treeObj = $.fn.zTree.getZTreeObj("functionTree");//获得页面中的ztree对象
            var nodes = treeObj.getCheckedNodes(true);//在提交表单之前将选中的checkbox收集
            var array = new Array();
            for (var i = 0; i < nodes.length; i++) {
                var id = nodes[i].id;//权限id
                array.push(id);
            }
            var ids = array.join(",");//1,2,3,4,5
            $("input[name=ids]").val(ids);
            //alert();
            // $("#roleForm").submit();
            let roleId = $("#roleId").val()
            $.ajax({
                url: "${pageContext.request.contextPath }/role/update.action",
                type: 'post',
                data: {ids: ids, roleId: roleId},
                success: function (data) {
                    $.messager.alert("提示信息", "修改    成功", "info");
                    $("#win").window("close");
                },
                error: function (data) {
                    console.log(data)
                }
            })
        }
    }
</script>
</body>
</html>