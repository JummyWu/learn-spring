package com.imooc.aop.aspectJXml;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void save() {
        System.out.println("save");
    }

    @Override
    public String find() {
        System.out.println("find");
        return "123123";
    }

    @Override
    public void detele() {
        System.out.println("detele");
//        int a = 1/0;
    }

    @Override
    public void update() {
        System.out.println("update");

    }

    @Override
    public void findAll() {
        System.out.println("findAll");
//        int a = 1/0;
    }
}
