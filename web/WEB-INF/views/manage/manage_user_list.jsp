<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../include/include_list_header.jsp"%>
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
                    <table id="grid-table"></table>
                    <div id="grid-pager"></div>
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.page-content -->

</body>

<script>
    var $path_base = "/";//this will be used in gritter alerts containing images
    jQuery(function($) {
        var grid_selector = "#grid-table";
        var pager_selector = "#grid-pager";

        var url = "user_json";
        var colModel = [
            {name:'name',index:'name',label : "姓名", sortable : true, align : 'center'},
            {name:'loginName',index:'loginName',label:"登录帐号", sortable:true, align :'center'},
            {name:'email',index:'email',label:"电子邮件", sortable:true, align :'center'},
            {name:'status',index:'status',label:"状态", sortable:true, align :'center'},
            {name:'process',index:'process', fixed:true, sortable:false, resize:false,label : "操作" ,align:'center'}
        ]
        var caption = "系统用户表";
            <%@include file="../include/include_list_js1.jsp"%>
        });

        //enable search/filter toolbar
        //jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})

    <%@include file="../include/include_list_js.jsp"%>

    function viewStu(id){
    }
    function updateStu(id){
        window.location.href="${ctx}/sys/admin/user/update/" + id;
    }
    function deleteStu(id){
    }
</script>
</html>
