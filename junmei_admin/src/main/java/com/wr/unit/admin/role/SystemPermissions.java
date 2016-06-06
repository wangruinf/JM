package com.wr.unit.admin.role;

import com.wr.unit.utils.webview.TableTree4J;

/**
 * Created by wangrui on 2015/6/15.

public class SystemPermissions{

    public static final String USER_LIST = "SYS:ADMIN:USER:LIST";
    public static final String USER_EDIT = "SYS:ADMIN:USER:EDIT";
    public static final String USER_DEL = "SYS:ADMIN:USER:DEL";

    public static TableTree4J<TreeNode> TREE_ROOT = new TreeNode<PermissionDef>("1", "权限许可", null);

    static {

        TableTree4J<TreeNode> houtai =     new TreeNode<PermissionDef>("2", "后台管理", TREE_ROOT.getTreeNode());
        TableTree4J<TreeNode> userAdmin =  new TreeNode<PermissionDef>("3", "用户管理", houtai.getTreeNode());
        TableTree4J<TreeNode> groupAdmin = new TreeNode<PermissionDef>("4", "组管理",  houtai.getTreeNode());
        TableTree4J<TreeNode> roleAdmin =  new TreeNode<PermissionDef>("5", "权限管理", houtai.getTreeNode());




        userAdmin.getData().add( new PermissionDef( "用户列表", USER_LIST,   "/account/users") );
        userAdmin.getData().add( new PermissionDef( "用户更改", USER_EDIT,   "/account/users") );
        userAdmin.getData().add(new PermissionDef("用户删除", USER_DEL, "/account/users"));
    }
    public static void  main(String[]argv){
        TREE_ROOT.print();
    }

    public static TreeNode<PermissionDef> get(){
        return TREE_ROOT;
    }
}
 */