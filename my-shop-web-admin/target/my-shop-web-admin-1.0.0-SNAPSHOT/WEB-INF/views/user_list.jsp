<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html>
<head>

    <title>我的商城 | 用户管理</title>
    <jsp:include page="../includes/header.jsp"/>

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
                用户管理
                <small>用户列表</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">用户管理</li>
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
                            <h3 class="box-title">用户列表</h3>


                            <div class="row" style="margin-top: 15px">
                                <div class="col-xs-12">
                                    <div class="row" style="padding-left: 15px;padding-top: 5px ">
                                        <a href="/user/form" type="button" class="btn  btn-success btn-sm"><font
                                                style="vertical-align: inherit;"><font style="vertical-align: inherit;"><i
                                                class="fa fa-plus"></i> 新增</font></font></a>&nbsp;&nbsp;&nbsp;
                                        <a onclick="APP.deleteMulti('/user/delete')" type="button"
                                           class="btn  btn-danger btn-sm"><font
                                                style="vertical-align: inherit;"><font style="vertical-align: inherit;"><i
                                                class="fa fa-trash-o"></i> 删除</font></font></a>

                                    </div>

                                </div>
                            </div>

                            <div class="row" style="margin-top: 15px">

                                <div class="row">
                                    <div class="col-xs-4">
                                        <div class="form-group">
                                            <label for="username" class="col-sm-2 control-label">姓名：</label>
                                            <div class="col-sm-8">
                                                <input id="username" class="form-control" placeholder="姓名"
                                                       name="username"/>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-xs-4">
                                        <div class="form-group">
                                            <label for="phone" class="col-sm-2 control-label">电话：</label>
                                            <div class="col-sm-8">
                                                <input id="phone" class="form-control" placeholder="电话" name="phone"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-4">
                                        <div class="form-group">
                                            <label for="email" class="col-sm-2 control-label">邮箱：</label>
                                            <div class="col-sm-8">
                                                <input id="email" class="form-control" placeholder="电子邮件" name="email"/>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <div class="row" style="padding-right: 20px">
                                    <div class="col-xs-12">
                                        <button type="button" onclick="search();" class="btn btn-info pull-right">搜索
                                        </button>
                                    </div>
                                </div>


                            </div>


                        </div>

                    </div>
                    <!-- /.box-header -->
                    <div class="box-body table-responsive ">
                        <table id="datatable" class="table table-hover">
                            <thead>

                            <tr>
                                <th><input type="checkbox" class="minimal master"/></th>
                                <th>ID</th>
                                <th>用户名</th>
                                <th>手机号</th>
                                <th>邮箱</th>
                                <th>更新时间</th>
                                <th>操作</th>
                            </tr>


                            </thead>
                            <tbody>
                            <%--                            <c:forEach items="${tbUsers}" var="tbUser">--%>
                            <%--                                <tr>--%>
                            <%--                                    <td><input id="${tbUser.id}" type="checkbox" class="minimal"/></td>--%>
                            <%--                                    <td>${tbUser.id}</td>--%>
                            <%--                                    <td>${tbUser.username}</td>--%>
                            <%--                                    <td>${tbUser.phone}</td>--%>
                            <%--                                    <td>${tbUser.emil}</td>--%>
                            <%--                                    <td><fmt:formatDate value="${tbUser.update}"--%>
                            <%--                                                        pattern="yyyy-MM-dd hh:mm:ss"/></td>--%>
                            <%--                                    <td>--%>
                            <%--                                        <a href="#" type="button" class="btn  btn-primary btn-sm"><font--%>
                            <%--                                                style="vertical-align: inherit;"><font--%>
                            <%--                                                style="vertical-align: inherit;"><i class="fa fa-search"></i>--%>
                            <%--                                            查看</font></font></a>--%>
                            <%--                                        <a href="#" type="button" class="btn  btn-info btn-sm"><font--%>
                            <%--                                                style="vertical-align: inherit;"><font--%>
                            <%--                                                style="vertical-align: inherit;"><i class="fa fa-edit"></i>--%>
                            <%--                                            编辑</font></font></a>--%>
                            <%--                                        <a href="#" type="button" class="btn  btn-danger btn-sm"><font--%>
                            <%--                                                style="vertical-align: inherit;"><font--%>
                            <%--                                                style="vertical-align: inherit;"><i class="fa fa-trash"></i>--%>
                            <%--                                            删除</font></font></a>--%>
                            <%--                                    </td>--%>
                            <%--                                </tr>--%>
                            <%--                            </c:forEach>--%>

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

//插入模态框
<sys:modal/>
<script>

    //使用DATaTable显示数据
    var _dataTable;
    $(function () {
        var _columns = [
            {
                "data": function (row, type, val, meta) {
                    return '<input id="' + row.id + '" type="checkbox" class="minimal"/>';
                }
            },
            {"data": "id"},
            {"data": "username"},
            {"data": "phone"},
            {"data": "email"},
            {
                "data": function (row, type, val, meta) {
                    return DateTime.format(row.update, "yyyy-MM-dd hh:mm:ss");
                }
            },
            {
                "data": function (row, type, val, meta) {
                    var detailURL = "/user/detail?id=" + row.id;
                    return '<button  type="button" class ="btn btn-sm btn-default" onclick="APP.showDetail(\'' + detailURL + '\')"><i class="fa fa-search"></i>查看</button>&nbsp;&nbsp;&nbsp' +
                        '<a href="/user/form?id=' + row.id + '" type="button" class ="btn btn-sm btn-primary"><i class="fa fa-edit"></i>编辑</a>&nbsp;&nbsp;&nbsp' +
                        '<a href="/user/deleteOne?id=' + row.id + '" type="button" class ="btn btn-sm btn-danger"><i class="fa fa-trash-o"></i>删除</a>&nbsp;&nbsp;&nbsp';
                }
            },
        ];
        //实现分页
        _dataTable = APP.initDataTables("/user/page", _columns);

    });

    /**
     * 实现搜索功能在DaTaTable中
     */
    function search() {
        var username = $("#username").val();
        var phone = $("#phone").val();
        var email = $("#email").val();
        var param = {
            "username": username,
            "phone": phone,
            "email": email
        };
        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    }
</script>


</body>


</html>