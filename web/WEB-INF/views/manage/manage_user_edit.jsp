<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/include_edit_header.jsp"%>
<body>
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
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
                <div class="col-xs-12">

                    <!-- PAGE CONTENT BEGINS -->
                    <form:form id="updateForm" name="updateForm" modelAttribute="bean" action="${ctx}/account/do_update" method="post" class="form-horizontal">
                        <form:hidden path="id" />


                        <div class="form-group" >
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 用户名字： </label>
                            <div class="col-sm-9">
                                <form:input path="name" id="form-field-2"  placeholder="用户名字"  cssClass="col-xs-10 col-sm-5" />
                            </div>
                        </div>

                        <div class="space-4"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-3"> 电子邮件： </label>
                            <div class="col-sm-9">
                                <form:input path="email" id="form-field-3"  placeholder="电子邮件地址"  cssClass="col-xs-10 col-sm-5" />
                            </div>
                        </div>

                        <div class="space-4"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-5"> 手机号码： </label>
                            <div class="col-sm-9">
                                <form:input path="phoneNum" id="form-field-5"  placeholder="手机号码"  cssClass="col-xs-10 col-sm-5" />
                            </div>
                        </div>


                        <div class="space-4"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 登录帐号： </label>
                            <div class="col-sm-9">
                                <form:input path="loginName" id="form-field-1"  placeholder="登录帐号" readonly="true" cssClass="col-xs-10 col-sm-5" />
                            </div>
                        </div>

                        <div class="space-4"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-4">状态：</label>

                            <div class="col-sm-9">
                                <form:select path="status" id="form-field-4"  placeholder="用户状态"  cssClass="col-xs-10 col-sm-5">
                                    <form:option value="0">有效</form:option>
                                    <form:option value="1">无效</form:option>
                                </form:select>
                            </div>
                        </div>

                        <div class="space-4"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-6"> 注册时间： </label>
                            <div class="col-sm-9">
                                <form:input path="registerTime" id="form-field-6" readonly="true" placeholder="注册时间"  cssClass="col-xs-10 col-sm-5" />
                            </div>
                        </div>

                        <div class="space-4"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-4">用户权限：</label>

                            <div class="col-sm-9">
                                <div class="checkbox">
                                    <form:bscheckboxes path="roleList" items="${ roles }" itemLabel="name" itemValue="id" cssClass="ace" />
                                </div>
                            </div>
                        </div>

                        <div class="clearfix form-actions">
                            <div class="col-md-offset-3 col-md-9">
                                <button class="btn btn-info" type="submit">
                                    <i class="icon-ok bigger-110"></i>
                                    提交
                                </button>
                                &nbsp; &nbsp; &nbsp;
                                <button class="btn" type="reset">
                                    <i class="icon-undo bigger-110"></i>
                                    重置
                                </button>
                                &nbsp; &nbsp; &nbsp;
                                <button class="btn" type="button" onclick="history.back();">
                                    <i class="icon-backward bigger-110"></i>
                                    返回
                                </button>
                            </div>
                        </div>
                        </form:form>
                </div>
            </div><!-- /.row -->
        </div><!-- /.page-content -->
        <script>
            $(document).ready(function() {
                /***注册表单验证**/
                $("#updateForm").validate({
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
                        error.insertAfter(element);
                    }
                });
            });
            function formSubmit(){
                updateForm.submit();
            }
        </script>
</body>
</html>
