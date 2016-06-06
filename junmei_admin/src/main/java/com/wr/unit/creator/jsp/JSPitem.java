package com.wr.unit.creator.jsp;

/**
 * Created by wangrui on 2015/5/13.
 */
public class JSPitem implements Comparable{

    private String name;
    private String title;
    private Integer order;

    public JSPitem(String name,String title, Integer order) {
        this.title = title;
        this.order = order;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JSPitem jsPitem = (JSPitem) o;

        if (!order.equals(jsPitem.order)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return order.hashCode();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public int compareTo(Object o) {
        JSPitem jsPitem = (JSPitem) o;
        return this.getOrder().compareTo(jsPitem.getOrder());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
