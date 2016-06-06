<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="jm" uri="http://www.junmei.com/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <title></title>

    <link rel="stylesheet" href="${ctx}/static/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/css/google.fonts.css" />
    <style>
    html{overflow-x:hidden; overflow-y:auto;}
    </style>
    <!-- jquery scripts -->
    <script src='${ctx}/static/assets/js/jquery-1.10.2.min.js'></script>
    <script src="${ctx}/static/assets/js/bootstrap.min.js"></script>
    <script src="${ctx}/static/assets/js/typeahead-bs2.min.js"></script>



    <script language="JavaScript" src="${ctx}/static/tabletree/Core4j.js"></script>
    <link rel="StyleSheet" href="${ctx}/static/tabletree/tabletree4j.css" type="text/css" />
    <script language="JavaScript" src="${ctx}/static/tabletree/TableTree4j.js"></script>


    <style>

    </style>
</head>

<body>

<div class="breadcrumbs" id="breadcrumbs">
    <ul class="breadcrumb" style="padding: 7px;">
        <li>
            <i class="icon-home home-icon"></i>
            <a href="#">系统首页</a>
        </li>

        <li>
            <a href="#">系统管理</a>
        </li>
        <li class="active">模块结构</li>
    </ul><!-- .breadcrumb -->
</div>

<div class="page-content">
    <div class="row">
        <div class="col-xs-12" align="center">
            <div class="panel panel-warning" style="width: 95%">
                <div class="panel-heading" align="left">
                    <i class="glyphicon glyphicon-th-list"></i>
                    模块管理
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

                    <div id="worldcupgird" class="content" style="width:99%;"></div>
                    <hr>


                </div>
            </div>

        </div><!-- /.col -->
    </div><!-- /.row -->
</div><!-- /.page-content -->

</body>


<script type="text/javascript">

    jQuery(function($) {

        treeHeaders=[{
            columns:[{dataIndex:'name'},{dataIndex:'add_child'},{dataIndex:'modify'},{dataIndex:'del'}],
            dataObject:{name:'名称',  add_child:'创建模块' , modify:'修改' , del:'删除'}
        }];

        var fifaGirdTree=new Core4j.toolbox.TableTree4j({
            columns:[
                {isNodeClick:true,dataIndex:'name',width:'60%'},
                {width:'10%',canSort:false,renderFunction:createChildFunction},
                {width:'10%',canSort:false,renderFunction:modifyFunction},
                {width:'10%',canSort:false,renderFunction:deleteFunction}
            ],
            treeMode:'gird',
            renderTo:'worldcupgird',
            useLine:true,
            useIcon:true,
            id:'myworldcupgirdtree',
            useCookie:false,
            onExpandNodeEvents:[fifaExpandNodeEvent],
            headers:treeHeaders,
            //footers:jsonfooters,
            themeName:'default',
            selectMode:'single'
            //floatRight:true
        });

        $.ajax({
            type: 'POST',
            url:  'list.json/-1',
            async: false,
            success: function(nodes){
                fifaGirdTree.build(nodes,true);

            }
        });
       // $("#myworldcupgirdtree").removeClass("tabletree4j-gird");
        //$("#myworldcupgirdtree").addClass("table table-hover");

        function fifaExpandNodeEvent(node, tree){
            if (node.isLoad == false) {
                tree.startLoadingNode(node);
                $.ajax({
                    type: 'post',
                    url:  'getTechStatusNewsView.do?method=techStatusNewsTree&schame=model' ,
                    data: {rootId:node.id},
                    async: false,
                    success: function(nodes){
                        //var dataObj=jQuery.parseJSON( nodes );//转换为json对象
                        tree.loadingAddNodes(nodes, node.id);

                    }
                });
                tree.endLoadingNode(node);
            }
        }
//创建创建子状态/////////////////////////////////////
//infoObj {dataValue:,node:,tabletreeObj:,rowObj:,rowIndex:,container:,columnIndex:}
        function createChildFunction(infoObj){
            var value=infoObj.dataValue;
            var node=infoObj.node;
            var tree=infoObj.tabletreeObj;
            var aElobj=Core4j.Domhelper.createElement("a",{
                attributeNames:['href'],
                valueObject:{href:'#'}
            });
            Core4j.Domhelper.addEventToEl(aElobj,Core4j.Domhelper.ElEventType.CLICK,function(){
                openWindow('创建子状态' ,'toAddTechStatusNew.do?method=toAddTechStatusNew&schame=model&pid=' + node.id );
            });
            aElobj.innerHTML="创建部件";
            return aElobj;
        }
//修改操作/////////////////////////////////////
//infoObj {dataValue:,node:,tabletreeObj:,rowObj:,rowIndex:,container:,columnIndex:}
        function modifyFunction(infoObj){
            var value=infoObj.dataValue;
            var node=infoObj.node;
            var tree=infoObj.tabletreeObj;
            var aElobj=Core4j.Domhelper.createElement("a",{
                attributeNames:['href'],
                valueObject:{href:'#'}
            });
            Core4j.Domhelper.addEventToEl(aElobj,Core4j.Domhelper.ElEventType.CLICK,function(){
                //alert(tree.tableObject.getAttribute("class"));
                //alert("id is ["+value+"] node level is["+node.level+"] islastNode["+node.isLastNode+"]");

                openWindow('修改' ,'getTechStatusNew.do?method=toUpdateTechStatusNew&schame=model&id=' + node.id );
            });
            aElobj.innerHTML="修改";
            return aElobj;
        }
        //删除态/////////////////////////////////////才
        //infoObj {dataValue:,node:,tabletreeObj:,rowObj:,rowIndex:,container:,columnIndex:}
        function deleteFunction(infoObj){
            var value=infoObj.dataValue;
            var node=infoObj.node;
            var tree=infoObj.tabletreeObj;
            var aElobj=Core4j.Domhelper.createElement("a",{
                attributeNames:['href'],
                valueObject:{href:'#'}
            });
            Core4j.Domhelper.addEventToEl(aElobj,Core4j.Domhelper.ElEventType.CLICK,function(){

                if(node.childs!=null && node.childs.length>0){
                    alert('无法完成删除操作,[' + node.dataObject.name.replace(/&nbsp;/g ," ") + ']下存在子结点,请手动删除该结点下的所有子结点.' );
                }else{
                    if(!node.isLeaf && node.isLoad==false){
                        alert('无法完成删除操作,[' + node.dataObject.name.replace(/&nbsp;/g," ") + ']下存在子结点,请手动删除该结点下的所有子结点.' )
                    }else{
                        if(!confirm('您确定要删除[' +  node.dataObject.name.replace(/&nbsp;/g," ") +  ']该记录吗?')) return;
                        // 文档就绪
                        var data={id:node.id};
                        $.ajax({
                            type: 'post',
                            url:  'delTechStatusNew.do?method=delTechStatusNew&schame=model' ,
                            data:data,
                            async: false,
                            success: function(code){
                                tree.removeNode(node.id);
                            }
                        });
                    }

                }
            });
            aElobj.innerHTML="删除";
            return aElobj;
        }
    })
</script>
</html>
