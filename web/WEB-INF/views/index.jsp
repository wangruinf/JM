<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.LockedAccountException "%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <title>俊美</title>
    <meta name="keywords" content="俊美" />
    <meta name="description" content="俊美" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- basic styles -->
    <link rel="stylesheet"  href="${ctx}/static/assets/css/bootstrap.min.css" />
    <link rel="stylesheet"  href="${ctx}/static/assets/css/font-awesome.min.css" />
    <!--[if IE 7]>
    <link rel="stylesheet" href="${ctx}/static/assets/css/font-awesome-ie7.min.css" />
    <![endif]-->
    <!-- page specific plugin styles -->
    <!-- fonts -->
    <link rel="stylesheet" href="${ctx}/static/assets/css/google.fonts.css" />
    <!-- ace styles -->
    <link rel="stylesheet" href="${ctx}/static/assets/css/ace.min.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/css/ace-skins.min.css" />
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${ctx}/static/assets/css/ace-ie.min.css" />
    <![endif]-->
    <!-- inline styles related to this page -->
    <!-- ace settings handler -->
    <script src="${ctx}/static/assets/js/ace-extra.min.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="${ctx}/static/assets/js/html5shiv.js"></script>
    <script src="${ctx}/static/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {}

        function logout(){
            if( confirm("您确定要退出吗？")){
                window.location.href="/logout";
            }
        }
    </script>
    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    俊美后台管理系统
                </small>
            </a>

            <!-- /.brand -->
        </div>

        <!-- /.navbar-header -->
        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <!--img class="nav-user-photo" src="assets/avatars/user.jpg" alt="Jason's Photo" /-->
                            <span class="user-info">
									<small>欢迎光临,</small>
									xxx
								</span>
                        <i class="icon-caret-down"></i>
                    </a>
                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="#">
                                <i class="icon-cog"></i> 设置
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="icon-user"></i> 个人资料
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="logout" ><i class="icon-off"></i> 退出</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- /.ace-nav -->
        </div>
        <!-- /.navbar-header -->
    </div>
    <!-- /.container -->
</div>
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {}
    </script>
    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>
        <div class="sidebar" id="sidebar">
            <script type="text/javascript">
                try {
                    ace.settings.check('sidebar', 'fixed')
                } catch (e) {}
            </script>
            <div class="sidebar-shortcuts" id="sidebar-shortcuts">
                <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                    <button class="btn btn-success">
                        <i class="icon-signal"></i>
                    </button>
                    <button class="btn btn-info">
                        <i class="icon-pencil"></i>
                    </button>
                    <button class="btn btn-warning">
                        <i class="icon-group"></i>
                    </button>
                    <button class="btn btn-danger">
                        <i class="icon-cogs"></i>
                    </button>
                </div>
                <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                    <span class="btn btn-success"></span>
                    <span class="btn btn-info"></span>
                    <span class="btn btn-warning"></span>
                    <span class="btn btn-danger"></span>
                </div>
            </div>
            <!-- #sidebar-shortcuts -->
            <ul class="nav nav-list">
                <li class="active">
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-list"></i>
                        <span class="menu-text"> 系统管理 </span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li>
                            <a href="sys/admin/users" target="mainContent">
                                <i class="icon-double-angle-right"></i> 用户管理
                            </a>
                        </li>
                        <li>
                            <a href="account/groups" target="mainContent">
                                <i class="icon-double-angle-right"></i> 组管理
                            </a>
                        </li>
                        <li>
                            <a href="sys/admin/roles" target="mainContent">
                                <i class="icon-double-angle-right"></i> 权限管理
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="typography.html">
                        <i class="icon-text-width"></i>
                        <span class="menu-text"> 文字排版 </span>
                    </a>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-desktop"></i>
                        <span class="menu-text"> UI 组件 </span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li>
                            <a href="elements.html">
                                <i class="icon-double-angle-right"></i> 组件
                            </a>
                        </li>
                        <li>
                            <a href="buttons.html">
                                <i class="icon-double-angle-right"></i> 按钮 &amp; 图表
                            </a>
                        </li>
                        <li>
                            <a href="treeview.html">
                                <i class="icon-double-angle-right"></i> 树菜单
                            </a>
                        </li>
                        <li>
                            <a href="jquery-ui.html">
                                <i class="icon-double-angle-right"></i> jQuery UI
                            </a>
                        </li>
                        <li>
                            <a href="nestable-list.html">
                                <i class="icon-double-angle-right"></i> 可拖拽列表
                            </a>
                        </li>
                        <li>
                            <a href="#" class="dropdown-toggle">
                                <i class="icon-double-angle-right"></i> 三级菜单
                                <b class="arrow icon-angle-down"></b>
                            </a>
                            <ul class="submenu">
                                <li>
                                    <a href="#">
                                        <i class="icon-leaf"></i> 第一级
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="dropdown-toggle">
                                        <i class="icon-pencil"></i> 第四级
                                        <b class="arrow icon-angle-down"></b>
                                    </a>
                                    <ul class="submenu">
                                        <li>
                                            <a href="#">
                                                <i class="icon-plus"></i> 添加产品
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <i class="icon-eye-open"></i> 查看商品
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-list"></i>
                        <span class="menu-text"> 表格 </span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li>
                            <a href="tables.html">
                                <i class="icon-double-angle-right"></i> 简单 &amp; 动态
                            </a>
                        </li>
                        <li>
                            <a href="jqgrid.html">
                                <i class="icon-double-angle-right"></i> jqGrid plugin
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-edit"></i>
                        <span class="menu-text"> 表单 </span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li>
                            <a href="form-elements.html">
                                <i class="icon-double-angle-right"></i> 表单组件
                            </a>
                        </li>
                        <li>
                            <a href="form-wizard.html">
                                <i class="icon-double-angle-right"></i> 向导提示 &amp; 验证
                            </a>
                        </li>
                        <li>
                            <a href="wysiwyg.html">
                                <i class="icon-double-angle-right"></i> 编辑器
                            </a>
                        </li>
                        <li>
                            <a href="dropzone.html">
                                <i class="icon-double-angle-right"></i> 文件上传
                            </a>
                        </li>
                    </ul>
                </li>

            </ul>
            <!-- /.nav-list -->
            <div class="sidebar-collapse" id="sidebar-collapse">
                <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
            </div>
            <script type="text/javascript">
                try {
                    ace.settings.check('sidebar', 'collapsed')
                } catch (e) {}
            </script>
        </div>

        <!--  content  -->
        <div id="main_content" class="main-content">
        <iframe id="mainContent" name="mainContent" src="" frameborder="0"  width="100%" height="580"></iframe>
        </div>

        <!-- /.main-content -->
        <div class="ace-settings-container" id="ace-settings-container">
            <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
                <i class="icon-cog bigger-150"></i>
            </div>
            <div class="ace-settings-box" id="ace-settings-box">
                <div>
                    <div class="pull-left">
                        <select id="skin-colorpicker" class="hide">
                            <option data-skin="default" value="#438EB9">#438EB9</option>
                            <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                            <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                            <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
                        </select>
                    </div>
                    <span>&nbsp; 选择皮肤</span>
                </div>
                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
                    <label class="lbl" for="ace-settings-navbar"> 固定导航条</label>
                </div>
                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
                    <label class="lbl" for="ace-settings-sidebar"> 固定滑动条</label>
                </div>
                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
                    <label class="lbl" for="ace-settings-breadcrumbs">固定面包屑</label>
                </div>
                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
                    <label class="lbl" for="ace-settings-rtl">切换到左边</label>
                </div>
                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
                    <label class="lbl" for="ace-settings-add-container">
                        切换窄屏
                        <b></b>
                    </label>
                </div>
            </div>
        </div>
        <!-- /#ace-settings-container -->
    </div>
    <!-- /.main-container-inner -->
    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
</div>
<!-- /.main-container -->
<!-- basic scripts -->
<!--[if !IE]>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
-->
<!-- <![endif]-->
<!--[if IE]><![endif]-->
<script src="${ctx}/static/jquery-1.11.2.min.js"></script>
<!--[if !IE]>

    <script type="text/javascript">
        window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
    </script>
-->
<!-- <![endif]-->
<!--[if IE]><![endif]-->
<script type="text/javascript">
    window.jQuery || document.write("<script src='${ctx}/static/assets/js/jquery-1.11.2.min.js'>" + "<" + "script>");
</script>
<script type="text/javascript">
    if ("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>" + "<" + "script>");
</script>
<script src="${ctx}/static/assets/js/bootstrap.min.js"></script>
<script src="${ctx}/static/assets/js/typeahead-bs2.min.js"></script>
<!-- page specific plugin scripts -->
<!--[if lte IE 8]>
<script src="${ctx}/static/assets/js/excanvas.min.js"></script>
<![endif]-->
<script src="${ctx}/static/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="${ctx}/static/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="${ctx}/static/assets/js/jquery.slimscroll.min.js"></script>
<script src="${ctx}/static/assets/js/jquery.easy-pie-chart.min.js"></script>
<script src="${ctx}/static/assets/js/jquery.sparkline.min.js"></script>
<script src="${ctx}/static/assets/js/flot/jquery.flot.min.js"></script>
<script src="${ctx}/static/assets/js/flot/jquery.flot.pie.min.js"></script>
<script src="${ctx}/static/assets/js/flot/jquery.flot.resize.min.js"></script>
<!-- ace scripts -->
<script src="${ctx}/static/assets/js/ace-elements.min.js"></script>
<script src="${ctx}/static/assets/js/ace.min.js"></script>
<!-- inline scripts related to this page -->
<script type="text/javascript">

    jQuery(function($) {
    })



</script>
</body>

</html>
