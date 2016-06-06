<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>

    <link rel="stylesheet" href="${ctx}/static/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/css/font-awesome.min.css" />
    <!-- page specific plugin styles -->

    <link rel="stylesheet" href="${ctx}/static/assets/css/google.fonts.css" />

    <link rel="stylesheet" href="${ctx}/static/assets/css/jquery-ui-1.10.3.full.min.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/css/datepicker.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/css/ui.jqgrid.css" />


    <link rel="stylesheet" href="${ctx}/static/assets/css/ace.min.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/css/ace-skins.min.css" />

    <!-- jquery scripts -->
    <script src='${ctx}/static/assets/js/jquery-1.10.2.min.js'></script>

    <script src="${ctx}/static/assets/js/ace-extra.min.js"></script>
    <script src="${ctx}/static/assets/js/bootstrap.min.js"></script>
    <script src="${ctx}/static/assets/js/typeahead-bs2.min.js"></script>


    <!-- page specific plugin scripts -->

    <script src="${ctx}/static/assets/js/date-time/bootstrap-datepicker.min.js"></script>
    <script src="${ctx}/static/assets/js/jqGrid/jquery.jqGrid.min.js"></script>
    <script src="${ctx}/static/assets/js/jqGrid/i18n/grid.locale-en.js"></script>

    <!-- ace styles -->
    <script src="${ctx}/static/assets/js/ace-elements.min.js"></script>
    <script src="${ctx}/static/assets/js/ace.min.js"></script>
</head>
