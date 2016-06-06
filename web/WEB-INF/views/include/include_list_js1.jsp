<%@ page contentType="text/html;charset=UTF-8" %>
jQuery(grid_selector).jqGrid({
url: url,  // 提交的action地址
rownumbers : true, // 是否显示前面的行号
datatype : "json", // 返回的数据类型
mtype: "post",      // 提交方式
height: 358,
colModel:colModel,

viewrecords : true,
sortname : "id",

rowNum:10,
rowList:[10,20,30],
prmNames : {
search : "search"
},
jsonReader : {
root : "rows", // 服务端保存数据的集合
records : "record", // 可以不要,因为我的服务端是record,不是默认的,才加上的
repeatitems : false
// 其它的全部默认就行
},
pager : pager_selector,
caption : caption ,
hidegrid : false,
loadComplete : function() {
var table = this;
setTimeout(function(){
styleCheckbox(table);
updateActionIcons(table);
updatePagerIcons(table);
enableTooltips(table);
}, 0);
},
gridComplete : function() {
var ids = jQuery(grid_selector).jqGrid('getDataIDs');
for ( var i = 0; i < ids.length; i++) {
var cl = ids[i];

var start = '<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">'
var update = '<a class="blue" href="javascript:viewStu(' + cl + ')"><i class="icon-zoom-in bigger-130"></i></a>&nbsp;';
var del = '<a class="green" href="javascript:updateStu(' + cl + ')"><i class="icon-pencil bigger-130"></i></a>&nbsp;';
var view = '<a class="red" href="javascript:deleteStu(' + cl + ')"><i class="icon-trash bigger-130"></i></a>';
var end = '</div>';
jQuery(grid_selector).jqGrid('setRowData', ids[i], {  process :start + update + del + view +end });
}

},

editurl: $path_base+"/dummy.html",//nothing is saved
autowidth: true
