package com.wr.unit.admin.entity;

/**
 * Created by wangrui on 2015/4/23.
 */
public enum UserStatus{
    ENABLE((byte)0), DISABLE((byte)1);

    private UserStatus(byte value){
        this.value = value;
    }

    private byte value;

    public byte value(){
        return this.value;
    };


    @Override
    public String toString() {
        return "" + this.value;
    }
}
