package com.imooc.aop.aspectJ;

public class ProductDao {

    public void save(){
        System.out.println("保存商品");
    }
    public void find(){
        System.out.println("查找商品");
//        int a = 1/0;
    }
    public void detele(){
        System.out.println("删除商品");
    }
    public String update(){
        System.out.println("更新商品");
        return "123123";
    }

    public void findAll(){
        System.out.println("查找所有");
//        int a = 1/0;
    }

}
