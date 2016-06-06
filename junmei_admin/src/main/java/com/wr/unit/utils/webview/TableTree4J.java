package com.wr.unit.utils.webview;

/**
 * Created by wangrui on 2015/7/1.
 *
 */
public interface TableTree4J<V> {

    String getId();
    String getPid();

    public void addAttr( String key, Object obj );
    public Object removeAttr(String key);
    public Object getAttr( String key);
    public Integer getOrder();
}
