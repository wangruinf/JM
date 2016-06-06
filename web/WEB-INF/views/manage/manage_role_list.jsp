<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="jm" uri="http://www.junmei.com/tags" %>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>

    <link rel="stylesheet" href="${ctx}/static/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/css/google.fonts.css" />
<style>
    .center{
        text-align: center!important;
    }
    .bigger-180 {
        font-size: 180%
    }
    html{overflow-x:hidden; overflow-y:auto;}
    </style>
    <!-- jquery scripts -->
    <script src='${ctx}/static/assets/js/jquery-1.10.2.min.js'></script>
    <script src="${ctx}/static/assets/js/bootstrap.min.js"></script>
    <script src="${ctx}/static/assets/js/typeahead-bs2.min.js"></script>
</head>

<body>

<div class="breadcrumbs" id="breadcrumbs">
    <ul class="breadcrumb" style="padding: 7px;">
        <li>
            <i class="icon-home home-icon"></i>
            <a href="#">系统首页</a>
        </li>

        <li>
            <a href="#">用户管理</a>
        </li>
        <li class="active">用户列表</li>
    </ul><!-- .breadcrumb -->
</div>

<div class="page-content">
    <div class="row">
        <div class="col-xs-12" align="center">
            <div class="panel panel-warning" style="width: 95%">
                <div class="panel-heading" align="left">
                    <i class="glyphicon glyphicon-th-list"></i>
                    权限管理
                </div>

                <div class="panel-body">
                    <div align="left" class="col-xs-12">
                        <form class="form-inline" style="margin: 0px;display: inline;" >
                            <div align="form-group">
                                <label for="search_name"></label>
                                <input id="search_name" class="form-control" placeholder="权限" name="search_name" style="width: auto;"/>
                                <button class="btn btn-default navbar-btn" onclick="formSubmit(this.form, '')"><i class="glyphicon glyphicon-search"></i></button>
                                <button class="btn btn-default" title="创建" onclick="formSubmit(this.form,'${ctx}/sys/admin/role/create')"><i class="glyphicon glyphicon-plus"></i></button>
                            </div>
                        </form>
                        <hr style="margin: 0px;">
                    </div>

                    <!--table-bordered table-striped table-hover-->
                    <table id="sample-table-1" class="table table-hover" width="98%" >
                        <thead>
                        <tr>
                            <th width="5%" class="center">序号</th>
                            <th width="20%">权限</th>
                            <th width="55%">许可</th>
                            <th width="20%">操作</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="bean" varStatus="index" items="${ page.content}">
                            <tr>
                                <td class="center">${page.size * page.number + index.count}</td>
                                <td >${bean.name}</td>
                                <td>${bean.permissions}</td>

                                <td>
                                    <div class="visible-md visible-lg hidden-sm hidden-xs ">

                                        <button class="btn btn-xs btn-info" onclick="go('role/update/${bean.id}')">
                                            <i class="icon-edit bigger-180"></i>
                                        </button>&nbsp;

                                        <button class="btn btn-xs btn-danger">
                                            <i class="icon-trash bigger-180"></i>
                                        </button>&nbsp;

                                    </div>

                                    <div class="visible-xs visible-sm hidden-md hidden-lg">
                                        <div class="inline position-relative">
                                            <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown">
                                                <i class="icon-cog icon-only bigger-110"></i>
                                            </button>

                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">

                                                <li>
                                                    <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
																				<span class="green">
																					<i class="icon-edit bigger-120"></i>
																				</span>
                                                    </a>
                                                </li>

                                                <li>
                                                    <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
																				<span class="red">
																					<i class="icon-trash bigger-120"></i>
																				</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <hr>
                    <div class="col-xs-12" align="right">
                            <jm:page formName="page" action="roles">
                            </jm:page>
                    </div>

                </div>
            </div>




        </div><!-- /.col -->
    </div><!-- /.row -->
</div><!-- /.page-content -->

</body>
<script type="text/javascript">

    function formSubmit(form, actionUrl){
        form.action = actionUrl;
        form.submit();
    }

    function go( url ){
        window.location.href=url;
    }
    jQuery(function($) {




        $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
        function tooltip_placement(context, source) {

            var $source = $(source);
            var $parent = $source.closest('table')
            var off1 = $parent.offset();
            var w1 = $parent.width();

            var off2 = $source.offset();
            var w2 = $source.width();

            if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
            return 'left';
        }
    })
</script>
</html>
