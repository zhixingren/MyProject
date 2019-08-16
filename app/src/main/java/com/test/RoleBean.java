package com.test;

import android.support.annotation.NonNull;

/**
 * Created by xingzhi on 2019/4/2.
 */
public class RoleBean implements Comparable<RoleBean> {

    private int index;
    private String roleName;
    private int icon;

    public RoleBean(int index, String roleName, int icon) {
        this.index = index;
        this.roleName = roleName;
        this.icon = icon;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public int compareTo(@NonNull RoleBean o) {
        return (this.index - o.index);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof RoleBean) {
            RoleBean roleBean = (RoleBean) object;
            return this.roleName.equals(roleBean.roleName);
        }
        return super.equals(object);
    }
}
