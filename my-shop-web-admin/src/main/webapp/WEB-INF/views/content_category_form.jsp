<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html>
<head>

    <title>我的商城 | 内容管理</title>
    <jsp:include page="../includes/header.jsp"/>
    <link rel="stylesheet" href="/static/assets/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.min.css"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>
    <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="../includes/menu.jsp"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                内容管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>


        <!-- Main content -->
        <section class="content">
            <div class="row">

                <div style="padding-left: 120px" class="col-xs-8">
                    <c:if test="${baseResult!=null}">
                        <div class="alert alert-${baseResult.status==200?"success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true"><font
                                    style="vertical-align: inherit;"><font
                                    style="vertical-align: inherit;">×</font></font>
                            </button>
                            <h4><font style="vertical-align: inherit;"><font
                                    style="vertical-align: inherit;"> </font></font></h4><font
                                style="vertical-align: inherit;"><font style="vertical-align: inherit;">
                        </font><font style="vertical-align: inherit;"></font><font
                                style="vertical-align: inherit;">${baseResult.message}
                        </font></font></div>
                    </c:if>

                    <!-- Horizontal Form -->
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title"> ${tbContentCategory.id==null?"新增":"编辑"}分类</h3>
                        </div>
                        <!-- /.box-header -->
                        <form:form id="inputForm" cssClass="form-horizontal" method="post" action="/content/category/save"
                                   modelAttribute="tbContentCategory">
                            <form:hidden path="id"/>
                            <div class="box-body">
                                <div class="form-group">
                                    <label  class="col-sm-2 control-label ">父级类目</label>

                                    <div class="col-sm-10">
                                        <form:hidden id="parentId" path="parent.id"/>

                                        <input id="categoryName" class="form-control required " placeholder="请选择"
                                               readonly="true" data-toggle="modal"
                                               data-target="#modal-default" value="${tbContentCategory.parent.name}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="name" class="col-sm-2 control-label">分类名称</label>

                                    <div class="col-sm-10">
                                        <form:input path="name" cssClass="form-control required"
                                                    placeholder="分类名称"/>

                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="sortOrder" class="col-sm-2 control-label">分类排序</label>

                                    <div class="col-sm-10">
                                        <form:input path="sortOrder" cssClass="form-control required"
                                                    placeholder="分类排序"/>

                                    </div>
                                </div>


                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                                <button type="submit" class="btn btn-info pull-right">提交</button>
                            </div>
                            <!-- /.box-footer -->
                        </form:form>


                    </div>
                </div>
            </div>

        </section>

    </div>
    <jsp:include page="../includes/banquan.jsp"/>


</div>
<jsp:include page="../includes/footer.jsp"/>
<%--自定义模态框--%>
<sys:modal title="请选择：" msg="<ul id='myTree' class='ztree'></ul>"/>
<script src="/static/assets/plugins/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script>
    $(function () {
        APP.initZTree("/content/category/tree/data", ["id"], function (nodes) {
            var node = nodes[0];
            $("#parentId").val(node.id);
            $("#categoryName").val(node.name);
            $("#modal-default").modal("hide");
        })
    });
</script>
</body>


</html>