/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-10-19 01:27:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class role_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <title>Insert title here</title>\r\n");
      out.write("    <!-- 导入jquery核心类库 -->\r\n");
      out.write("    <script type=\"text/javascript\"\r\n");
      out.write("            src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jquery-1.8.3.js\"></script>\r\n");
      out.write("    <!-- 导入easyui类库 -->\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("          href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/themes/default/easyui.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("          href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/themes/icon.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("          href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/ext/portal.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("          href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/default.css\">\r\n");
      out.write("    <script type=\"text/javascript\"\r\n");
      out.write("            src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\"\r\n");
      out.write("            src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/ext/jquery.portal.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\"\r\n");
      out.write("            src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/ext/jquery.cookie.js\"></script>\r\n");
      out.write("    <script\r\n");
      out.write("            src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/locale/easyui-lang-zh_CN.js\"\r\n");
      out.write("            type=\"text/javascript\"></script>\r\n");
      out.write("    <!-- 导入ztree类库 -->\r\n");
      out.write("    <link rel=\"stylesheet\"\r\n");
      out.write("          href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/ztree/zTreeStyle.css\"\r\n");
      out.write("          type=\"text/css\"/>\r\n");
      out.write("    <script\r\n");
      out.write("            src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/ztree/jquery.ztree.all-3.5.js\"\r\n");
      out.write("            type=\"text/javascript\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        $(function () {\r\n");
      out.write("            // 数据表格属性\r\n");
      out.write("            $(\"#grid\").datagrid({\r\n");
      out.write("                toolbar: [\r\n");
      out.write("                    {\r\n");
      out.write("                        id: 'add',\r\n");
      out.write("                        text: '添加角色',\r\n");
      out.write("                        iconCls: 'icon-add',\r\n");
      out.write("                        handler: function () {\r\n");
      out.write("                            location.href = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/role/pageAdd.action';\r\n");
      out.write("                        }\r\n");
      out.write("                    }, {\r\n");
      out.write("                        id: 'delete',\r\n");
      out.write("                        text: '删除角色',\r\n");
      out.write("                        iconCls: 'icon-remove',\r\n");
      out.write("                        handler: function () {\r\n");
      out.write("                            var rows = $(\"#grid\").datagrid(\"getSelections\");\r\n");
      out.write("                            if (rows.length == 0) {\r\n");
      out.write("                                $.messager.alert(\"提示信息\", \"请选择要删除的记录\", \"error\");\r\n");
      out.write("                            } else {\r\n");
      out.write("                                $.ajax({\r\n");
      out.write("                                    url:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/role/delete.action?roleId=\"+rows[0].id,\r\n");
      out.write("                                    type:\"get\",\r\n");
      out.write("                                    success:function (data) {\r\n");
      out.write("                                        if(data==\"true\"){\r\n");
      out.write("                                            window.location.reload();\r\n");
      out.write("                                        }\r\n");
      out.write("                                    }\r\n");
      out.write("                                })\r\n");
      out.write("                            }\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                ],\r\n");
      out.write("                url: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/role/pageQuery.action',\r\n");
      out.write("                pagination: true,\r\n");
      out.write("                pageList: [3, 5, 7],\r\n");
      out.write("                onDblClickRow: doDblClickRow,\r\n");
      out.write("                striped:true,\r\n");
      out.write("                singleSelect:true,\r\n");
      out.write("                columns: [[\r\n");
      out.write("                    {\r\n");
      out.write("                        field: 'id',\r\n");
      out.write("                        title: '编号',\r\n");
      out.write("                        width: 200\r\n");
      out.write("                    },\r\n");
      out.write("                    {\r\n");
      out.write("                        field: 'name',\r\n");
      out.write("                        title: '名称',\r\n");
      out.write("                        width: 200\r\n");
      out.write("                    },\r\n");
      out.write("                    {\r\n");
      out.write("                        field: 'description',\r\n");
      out.write("                        title: '描述',\r\n");
      out.write("                        width: 200\r\n");
      out.write("                    }\r\n");
      out.write("                ]]\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        function doDblClickRow(rowIndex, rowData) {\r\n");
      out.write("            $(\"#roleId\").val(rowData.id);\r\n");
      out.write("            let arr;\r\n");
      out.write("            var p = new Promise(function (resolve, reject) {\r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    url: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/function/queryFunctionByRole.action?id=' + rowData.id,\r\n");
      out.write("                    type: \"get\",\r\n");
      out.write("                    success: function (data) {\r\n");
      out.write("                        arr = data;\r\n");
      out.write("                        resolve(arr)\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            })\r\n");
      out.write("            p.then(function (res) {\r\n");
      out.write("                var setting = {\r\n");
      out.write("                    data: {\r\n");
      out.write("                        key: {\r\n");
      out.write("                            title: \"t\"\r\n");
      out.write("                        },\r\n");
      out.write("                        simpleData: {//使用简单json数据构造节点数据\r\n");
      out.write("                            enable: true,\r\n");
      out.write("                            // idKey: \"id\",\r\n");
      out.write("                            // pIdKey: \"pid\"\r\n");
      out.write("                        }\r\n");
      out.write("                    },\r\n");
      out.write("                    check: {//使用ztree勾选效果\r\n");
      out.write("                        enable: true\r\n");
      out.write("                    }\r\n");
      out.write("                };\r\n");
      out.write("                $\r\n");
      out.write("                    .ajax({\r\n");
      out.write("                        url: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/function/listajax.action',\r\n");
      out.write("                        type: 'POST',\r\n");
      out.write("                        dataType: 'json',\r\n");
      out.write("                        success: function (data) {\r\n");
      out.write("                            let tree = $.fn.zTree.init($(\"#functionTree\"), setting, data);\r\n");
      out.write("                            tree.expandAll(true)\r\n");
      out.write("                            $.each(res, function (index, val) {\r\n");
      out.write("                                let node = tree.getNodeByParam(\"id\", val);\r\n");
      out.write("                                tree.checkNode(node, true, false)\r\n");
      out.write("                            });\r\n");
      out.write("                        },\r\n");
      out.write("                        error: function (msg) {\r\n");
      out.write("                            alert('树加载异常!');\r\n");
      out.write("                        }\r\n");
      out.write("                    });\r\n");
      out.write("                // 点击保存\r\n");
      out.write("                $('#save').click(function () {\r\n");
      out.write("\r\n");
      out.write("                });\r\n");
      out.write("                // resolve(1);\r\n");
      out.write("            }).then(function (res) {\r\n");
      out.write("                $(\"#win\").window('open');\r\n");
      out.write("            })\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"easyui-layout\">\r\n");
      out.write("<div data-options=\"region:'center'\">\r\n");
      out.write("    <table id=\"grid\"></table>\r\n");
      out.write("    <div id=\"win\" class=\"easyui-window\" title=\"权限修改\" style=\"width:600px;height:400px;\"\r\n");
      out.write("         data-options=\"modal:true,closed:true,iconCls:'icon-save',collapsible:false,minimizable:false,maximizable:false,draggable:false,tools:'#tt'\">\r\n");
      out.write("        <form id=\"roleForm\" method=\"post\"\r\n");
      out.write("              action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/role/update.action\">\r\n");
      out.write("            <input type=\"hidden\" name=\"ids\">\r\n");
      out.write("            <input type=\"hidden\" name=\"roleId\" id=\"roleId\">\r\n");
      out.write("            <div class=\"easyui-panel\" style=\"padding:5px\">\r\n");
      out.write("                <ul id=\"functionTree\" class=\"ztree\"></ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"tt\">\r\n");
      out.write("    <a href=\"javascript:void(0)\" class=\"icon-add\" onclick=\"javascript:editRole()\"></a>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    function editRole() {\r\n");
      out.write("        var v = $(\"#roleForm\").form(\"validate\");\r\n");
      out.write("        if (v) {\r\n");
      out.write("            var treeObj = $.fn.zTree.getZTreeObj(\"functionTree\");//获得页面中的ztree对象\r\n");
      out.write("            var nodes = treeObj.getCheckedNodes(true);//在提交表单之前将选中的checkbox收集\r\n");
      out.write("            var array = new Array();\r\n");
      out.write("            for (var i = 0; i < nodes.length; i++) {\r\n");
      out.write("                var id = nodes[i].id;//权限id\r\n");
      out.write("                array.push(id);\r\n");
      out.write("            }\r\n");
      out.write("            var ids = array.join(\",\");//1,2,3,4,5\r\n");
      out.write("            $(\"input[name=ids]\").val(ids);\r\n");
      out.write("            //alert();\r\n");
      out.write("            // $(\"#roleForm\").submit();\r\n");
      out.write("            let roleId = $(\"#roleId\").val()\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/role/update.action\",\r\n");
      out.write("                type: 'post',\r\n");
      out.write("                data: {ids: ids, roleId: roleId},\r\n");
      out.write("                success: function (data) {\r\n");
      out.write("                    $.messager.alert(\"提示信息\", \"修改    成功\", \"info\");\r\n");
      out.write("                    $(\"#win\").window(\"close\");\r\n");
      out.write("                },\r\n");
      out.write("                error: function (data) {\r\n");
      out.write("                    console.log(data)\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}