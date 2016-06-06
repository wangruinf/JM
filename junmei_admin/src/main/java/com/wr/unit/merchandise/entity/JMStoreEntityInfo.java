package com.wr.unit.merchandise.entity;

import com.wr.unit.admin.entity.IdEntity;
import com.wr.unit.admin.entity.Team;
import com.wr.unit.admin.entity.User;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * Created by wangrui on 2015/6/2.
 * 实体店信息
 * 个体工商户
 */

@Entity
public class JMStoreEntityInfo extends IdEntity {

    private String name;                     //店名
    private String operator;                // 经营者名字
    private String constitute ;              // 经营组成
    private String address;                 // 实体店地址 ， 场所
    private String scopeOfBusiness;       // 经营范围 ，及形式

    private String registeredNum;               //工商注册号；
    private String num;                          // 工商编号

    private String phoneNumber;                 // 联系电话
    private String operatorPhoneNumber;        //经营者手机号
    private String operatorId;                  //经营者身份证号
    private Byte status;                        // 0 未提交 1 提交 2 是审核通过

    private JMStoreSet jmStoreSet;              // 网店

    @Column(length = 64, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(length = 16, nullable = false)
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
    @Column(length = 64, nullable = false)
    public String getConstitute() {
        return constitute;
    }

    public void setConstitute(String constitute) {
        this.constitute = constitute;
    }
    @Column(length = 128, nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Column(length = 255)
    public String getScopeOfBusiness() {
        return scopeOfBusiness;
    }

    public void setScopeOfBusiness(String scopeOfBusiness) {
        this.scopeOfBusiness = scopeOfBusiness;
    }
    @Column(length = 32, nullable = false)
    public String getRegisteredNum() {
        return registeredNum;
    }

    public void setRegisteredNum(String registeredNum) {
        this.registeredNum = registeredNum;
    }
    @Column(length = 32, nullable = false)
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
    @Column(length = 16, nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Column(length = 16, nullable = false)
    public String getOperatorPhoneNumber() {
        return operatorPhoneNumber;
    }

    public void setOperatorPhoneNumber(String operatorPhoneNumber) {
        this.operatorPhoneNumber = operatorPhoneNumber;
    }
    @Column(length = 18, nullable = false)
    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @NotNull
    @OneToOne
    @JoinColumn(name = "store_id")
    public JMStoreSet getJmStoreSet() {
        return jmStoreSet;
    }

    public void setJmStoreSet(JMStoreSet jmStoreSet) {
        this.jmStoreSet = jmStoreSet;
    }
}
