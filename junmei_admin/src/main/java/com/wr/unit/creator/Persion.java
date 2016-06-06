package com.wr.unit.creator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by wangrui on 2015/5/12.
 */
@Bean(pn = "com.wr.unit.creator.test")
//@Entity
@Table(name="t_person")
public class Persion implements Serializable{

    private Long id;
    private String name;
    private String address;
    private Integer age;
    private Date sr;
    private Date lastLogginginTime;
    private Byte status;
    //@Id
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="persion_seq")
   // @SequenceGenerator(name="persion_seq", sequenceName="persion_seq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column( nullable = false, length = 20, unique = true)
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column
    public Date getSr() {
        return sr;
    }

    public void setSr(Date sr) {
        this.sr = sr;
    }
    @Column
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
    @Column(length = 444)
    public Date getLastLogginginTime() {
        return lastLogginginTime;
    }

    public void setLastLogginginTime(Date lastLogginginTime) {
        this.lastLogginginTime = lastLogginginTime;
    }
}
