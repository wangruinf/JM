<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.LockedAccountException "%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", -10);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>俊美登录页面</title>
    <meta name="keywords" content="俊美" />
    <meta name="description" content="俊美" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" href="${ctx}/static/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/css/font-awesome.min.css" />

    <!--[if IE 7]>
    <link rel="stylesheet" href="${ctx}/static/assets/css/font-awesome-ie7.min.css" />
    <![endif]-->

    <!-- page specific plugin styles -->

    <!-- fonts -->

    <link rel="stylesheet" href="${ctx}/static/assets/css/google.fonts.css" />

    <!-- ace styles -->

    <link rel="stylesheet" href="${ctx}/static/assets/css/ace.min.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/css/ace-rtl.min.css" />

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${ctx}/static/assets/css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="${ctx}/static/assets/js/html5shiv.js"></script>
    <script src="${ctx}/static/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="login-layout">
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h1>
                            <i class="icon-leaf green"></i>
                            <span class="red">俊美</span>
                            <span class="white">应用平台</span>
                        </h1>
                        <h4 class="blue">&copy; 俊美</h4>
                    </div>

                    <div class="space-6"></div>

                    <div class="position-relative">
                        <div id="login-box" class="login-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header blue lighter bigger">
                                        <i class="icon-coffee green"></i>
                                        请输入您的帐户
                                    </h4>
                                    <div class="space-6"></div>

                                    <form action="${ctx}/login" method="post" id="loginForm">
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" name="username" class="form-control required" placeholder="帐号"/>
															<i class="icon-user"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" name="password" class="form-control required" placeholder="密码" />
															<i class="icon-lock"></i>
														</span>
                                            </label>

                                            <div class="space"></div>

                                            <div class="clearfix">
                                                <label class="inline">
                                                    <input type="checkbox" class="ace" />
                                                    <span class="lbl"> 记住我</span>
                                                </label>

                                                <button type="submit" class="width-35 pull-right btn btn-sm btn-primary" >
                                                    <i class="icon-key"></i>
                                                    登陆
                                                </button>
                                            </div>

                                            <div class="space-4"></div>
                                        </fieldset>
                                    </form>

                                    <div class="social-or-login center">
                                        <span class="bigger-110"></span>
                                    </div>


                                </div><!-- /widget-main -->

                                <div class="toolbar clearfix">
                                    <div>
                                        <a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
                                            <i class="icon-arrow-left"></i>
                                            我忘记了密码
                                        </a>
                                    </div>

                                    <div>
                                        <a href="#" onclick="show_box('signup-box'); return false;" class="user-signup-link">
                                            注册帐号
                                            <i class="icon-arrow-right"></i>
                                        </a>
                                    </div>
                                </div>
                            </div><!-- /widget-body -->
                        </div><!-- /login-box -->

                        <div id="forgot-box" class="forgot-box widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header red lighter bigger">
                                        <i class="icon-key"></i>
                                        取回密码
                                    </h4>

                                    <div class="space-6"></div>
                                    <p>
                                        请输入您要找回密码的Email
                                    </p>

                                    <form>
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" placeholder="Email" />
															<i class="icon-envelope"></i>
														</span>
                                            </label>

                                            <div class="clearfix">
                                                <button type="button" class="width-35 pull-right btn btn-sm btn-danger">
                                                    <i class="icon-lightbulb"></i>
                                                    发送
                                                </button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div><!-- /widget-main -->

                                <div class="toolbar center">
                                    <a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
                                        返回登陆
                                        <i class="icon-arrow-right"></i>
                                    </a>
                                </div>
                            </div><!-- /widget-body -->
                        </div><!-- /forgot-box -->

                        <div id="signup-box" class="signup-box widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header green lighter bigger">
                                        <i class="icon-group blue"></i>
                                        注册帐号
                                    </h4>

                                    <div class="space-6"></div>
                                    <p> 请输入详细的帐号信息: </p>

                                    <form action="${ctx}/register" METHOD="POST" id="registerForm">
                                        <fieldset>

                                            <label class="block clearfix form-group has-info">
														<span class="block input-icon input-icon-right">
															<input type="name" name="name" class="form-control" placeholder="用户姓名" />
															<i class="icon-user"></i>
														</span>
                                            </label>


                                            <label class="block clearfix form-group has-info">
														<span class="block input-icon input-icon-right">
															<input type="email" name="email" class="form-control" placeholder="电子邮件" />
															<i class="icon-envelope"></i>
														</span>
                                            </label>
                                            <label class="block clearfix form-group has-info">
														<span class="block input-icon input-icon-right">
															<input type="phoneNum" name="phoneNum" class="form-control" placeholder="手机号码" />
															<i class="icon-mobile-phone"></i>
														</span>
                                            </label>


                                            <label class="block clearfix form-group has-info">
														<span class="block input-icon input-icon-right">
															<input type="text" name="loginName" class="form-control" placeholder="帐号" />
															<i class="icon-key"></i>
														</span>
                                            </label>

                                            <label class="block clearfix form-group has-info">
														<span class="block input-icon input-icon-right">
															<input type="password" id="plainPassword" name="plainPassword" class="form-control " placeholder="密码" />
															<i class="icon-lock"></i>
														</span>
                                            </label>

                                            <label class="block clearfix form-group has-info">
														<span class="block input-icon input-icon-right">
															<input type="password" name="passwordconfirm" class="form-control" placeholder="确认密码" />
															<i class="icon-retweet"></i>
														</span>
                                            </label>

                                            <label class="block clearfix form-group has-info">
                                                <span class="block input-icon input-icon-right">
                                                    <input type="checkbox" class="ace" name="agree"/>
                                                    <span class="lbl">
															我接受本<a href="#">用户协议</a>
														</span>
                                                </span>
                                            </label>

                                            <div class="space-24"></div>

                                            <div class="clearfix">
                                                <button type="reset" class="width-30 pull-left btn btn-sm">
                                                    <i class="icon-refresh"></i>
                                                    重置
                                                </button>

                                                <button type="submit" class="width-65 pull-right btn btn-sm btn-success" >
                                                    注册
                                                    <i class="icon-arrow-right icon-on-right"></i>
                                                </button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div>

                                <div class="toolbar center">
                                    <a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
                                        <i class="icon-arrow-left"></i>
                                        返回登陆
                                    </a>
                                </div>
                            </div><!-- /widget-body -->
                        </div><!-- /signup-box -->
                    </div><!-- /position-relative -->
                </div>
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div>
</div><!-- /.main-container -->

<!-- basic scripts -->



<script src="${ctx}/static/assets/js/jquery-1.10.2.min.js"></script>

<script src="${ctx}/static/assets/js/jquery-validation/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/static/assets/js/jquery-validation/messages_bs_zh.js" type="text/javascript"></script>
<link ref="${ctx}/static/assets/js/jquery-validation/validate.css" type="text/css" rel="stylesheet" />



<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='${ctx}/static/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>

<!-- inline scripts related to this page -->

<script type="text/javascript">
    function show_box(id) {
        jQuery('.widget-box.visible').removeClass('visible');
        jQuery('#'+id).addClass('visible');
    }
    /**debug
    $.validator.setDefaults({
        submitHandler: function() {
            alert("已提交！（点击取消按钮跳过验证）");
        }
    });**/
    $(document).ready(function() {

        /* 登陆表单验证 */
        $("#loginForm").validate();

        /***注册表单验证**/
        $("#registerForm").validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
                name:{
                    required: true,
                    rangelength:[2,16]
                },
                email: {
                    required: true,
                    email:true,
                    maxlength:[128]
                },
                phoneNum : {
                    required: true,
                    digits : true,
                    rangelength:[11,11]
                },
                loginName:{
                    required: true,
                    rangelength:[5,10],
                    remote: "${ctx}/checkLoginName"
                },
                plainPassword :{
                    required: true,
                    rangelength:[5,10]
                },
                passwordconfirm :{
                    required: true,
                    rangelength:[5,10],
                    equalTo: "#plainPassword"
                },
                agree: 'required'
            },
            messages : {
                agree:"请接受我们的协议",
                loginName: {
                    remote: "用户登录名已存在"
                }
            },
            highlight: function (e) {
                $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
            },

            success: function (e) {
                $(e).closest('.form-group').removeClass('has-error').addClass('has-info');
                $(e).remove();
            },
            errorPlacement: function (error, element) {
                 error.insertAfter(element.parent());
            }
        });
    });


</script>

</body>
</html>
