<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springside.org.cn/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8" />
    <title>用户管理</title>

    <link rel="stylesheet" href="${ctx}/static/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/css/font-awesome.min.css" />
    <!-- page specific plugin styles -->

    <link rel="stylesheet" href="${ctx}/static/assets/css/google.fonts.css" />

    <link rel="stylesheet" href="${ctx}/static/assets/css/jquery-ui-1.10.3.custom.min.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/css/ace.min.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/css/ace-skins.min.css" />
    <script src="${ctx}/static/assets/js/jquery-1.10.2.min.js"></script>
    <script src="${ctx}/static/assets/js/chosen.jquery.min.js"></script>

    <script src="${ctx}/static/assets/js/jquery-validation/jquery.validate.min.js" type="text/javascript"></script>
    <script src="${ctx}/static/assets/js/jquery-validation/messages_bs_zh.js" type="text/javascript"></script>
    <link ref="${ctx}/static/assets/js/jquery-validation/validate.css" type="text/css" rel="stylesheet" />

</head>