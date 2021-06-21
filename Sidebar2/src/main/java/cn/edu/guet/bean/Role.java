package cn.edu.guet.bean;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private String roleId;
    private String roleName;
    private List<Tree> treeList=new ArrayList<Tree>();

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Tree> getTreeList() {
        return treeList;
    }

    public void setTreeList(List<Tree> treeList) {
        this.treeList = treeList;
    }
}
