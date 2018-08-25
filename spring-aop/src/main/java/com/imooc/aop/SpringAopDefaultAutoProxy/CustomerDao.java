package com.imooc.aop.SpringAopDefaultAutoProxy;

public class CustomerDao {


    public void save() {
        System.out.println("保存1");
    };

    public void update() {
        System.out.println("更新1");
    };

    public void delete() {
        System.out.println("删除1");
    };

    public void find() {
        System.out.println("查找1");
    };

}
