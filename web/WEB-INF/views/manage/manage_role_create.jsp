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
                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 名称： </label>
                    <div class="col-sm-9">
                        <form:input path="name" id="form-field-1"  placeholder="名称"  cssClass="col-xs-10 col-sm-5" />
                    </div>
                </div>

                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="form-field-2">许可：</label>

                    <div class="col-sm-9">
                        <div class="checkbox">
                            <form:bscheckboxes id="form-field-2" path="permissionList" items="${ permissions }" itemLabel="code" itemValue="code" cssClass="ace" />
                        </div>
                    </div>
                </div>

                <div class="col-md-offset-3 col-md-9">
                    <button class="btn btn-primary btn-sm" type="submit">
                        <i class="icon-ok"></i>
                        提交
                    </button>
                    &nbsp; &nbsp; &nbsp;
                    <button class="btn btn-default btn-sm" type="reset">
                        <i class="icon-undo"></i>重置
                    </button>
                    &nbsp; &nbsp; &nbsp;
                    <button class="btn btn-default btn-sm" type="button" onclick="history.back();">
                        <i class="icon-backward"></i>
                        返回
                    </button>
                </div>
            </form:form>
        </div>
    </div><!-- /.row -->
</div><!-- /.page-content -->
<script>
    $(document).ready(function() {

    });
    function formSubmit(){
        updateForm.submit();
    }
</script>
</body>
</html>
