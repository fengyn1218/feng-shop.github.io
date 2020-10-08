<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

    <title>我的商城 | 内容详情</title>
    <jsp:include page="../includes/header.jsp"/>

</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="box-body " >
    <div class="form-group">
        <table id="datatable" class="table ">
            <tbody>
            <tr>
                <td>内容类目ID: </td>
                <td>${tbContent.tbContentCategory.id}</td>
            </tr>
            <tr>
                <td>标题: </td>
                <td>${tbContent.title}</td>
            </tr>
            <tr>
                <td>子标题: </td>
                <td>${tbContent.subTitle}</td>
            </tr>
            <tr>
                <td>创建时间: </td>
                <td><fmt:formatDate value="${tbContent.created}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
            <tr>
                <td>更新时间: </td>
                <td><fmt:formatDate value="${tbContent.update}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
            <tr>
                <td>详情: </td>
                <td>${tbContent.content}</td>
            </tr>
            </tbody>
        </table>
    </div>


</div>
<jsp:include page="../includes/footer.jsp"/>


</body>


</html>