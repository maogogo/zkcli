package com.maogogo.zkcli.model;

import java.util.List;

/**
 * Created by Toan on 2017/1/1.
 */
public class ZKBean {

    private String id;
    private String text;
    private String icon;    //jstree-file
    private Object children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Object getChildren() {
        return children;
    }

    public void setChildren(Object children) {
        this.children = children;
    }
}
