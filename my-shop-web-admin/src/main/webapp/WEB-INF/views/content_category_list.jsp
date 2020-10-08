<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html>
<head>

    <title>我的商城 | 内容管理</title>
    <jsp:include page="../includes/header.jsp"/>
    <link rel="stylesheet" href="/static/assets/plugins/treeTable/themes/vsStyle/treeTable.min.css"/>
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
                <small>用户列表</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">内容管理</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- /.row -->
            <div class="row">
                <div class="col-xs-12">
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

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">分类列表</h3>


                            <div class="row" style="margin-top: 15px">
                                <div class="col-xs-12">
                                    <div class="row" style="padding-left: 15px;padding-top: 5px ">
                                        <a href="/content/category/form" type="button"
                                           class="btn  btn-success btn-sm"><font
                                                style="vertical-align: inherit;"><font style="vertical-align: inherit;"><i
                                                class="fa fa-plus"></i> 新增</font></font></a>&nbsp;&nbsp;&nbsp;
                                        <a type="button"
                                           class="btn  btn-danger btn-sm"><font
                                                style="vertical-align: inherit;"><font style="vertical-align: inherit;"><i
                                                class="fa fa-trash-o"></i> 删除</font></font></a>

                                    </div>

                                </div>
                            </div>


                        </div>

                    </div>
                    <!-- /.box-header -->
                    <div class="box-body table-responsive ">
                        <table id="treeTable" class="table table-hover">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>名称</th>
                                <th>排序</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${tbContentCategories}" var="tbContentCategory">
                                <tr id="${tbContentCategory.id}" pId="${tbContentCategory.parent.id}">
                                    <td>${tbContentCategory.id}</td>
                                    <td>${tbContentCategory.name}</td>
                                    <td>${tbContentCategory.sortOrder}</td>
                                    <td>
                                        <a href="/content/category/form?id=${tbContentCategory.id}" type="button"
                                           class="btn btn-sm btn-primary"><i
                                                class="fa fa-edit"></i>编辑</a>&nbsp;&nbsp;&nbsp;
                                        <a href="/content/category/deleteOne?id=${tbContentCategory.id}" type="button"
                                           class="btn btn-sm btn-danger"><i
                                                class="fa fa-trash-o"></i>删除</a>&nbsp;&nbsp;&nbsp;
                                        <a href="/content/category/form?parent.id=${tbContentCategory.id}&parent.name=${tbContentCategory.name}"
                                           type="button" class="btn btn-sm btn-default"><i
                                                class="fa fa-plus"></i>新增下级菜单</a>&nbsp;&nbsp;&nbsp;
                                    </td>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
        </section>
    </div>
    <jsp:include page="../includes/banquan.jsp"/>

</div>

<jsp:include page="../includes/footer.jsp"/>
<script src="/static/assets/plugins/treeTable/jquery.treeTable.min.js"></script>

<%--插入模态框--%>
<sys:modal/>

<script>
    $(function () {
        $('#treeTable').treeTable({
            column: 1,
            expandLevel: 2
        });
    });
</script>

</body>


</html>