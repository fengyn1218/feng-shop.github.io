<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

    <title>我的商城 | 用户详情</title>
    <jsp:include page="../includes/header.jsp"/>

</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="box-body " >
    <div class="form-group">
        <table id="datatable" class="table ">
          <tbody>
          <tr>
              <td>邮箱: </td>
              <td>${tbUser.email}</td>
          </tr>
          <tr>
              <td>姓名: </td>
              <td>${tbUser.username}</td>
          </tr>
          <tr>
              <td>手机: </td>
              <td>${tbUser.phone}</td>
          </tr>
          <tr>
              <td>创建时间: </td>
              <td><fmt:formatDate value="${tbUser.created}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
          </tr>
          <tr>
              <td>更新时间: </td>
              <td><fmt:formatDate value="${tbUser.update}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
          </tr>
          </tbody>
        </table>
    </div>


</div>
<jsp:include page="../includes/footer.jsp"/>


</body>


</html>