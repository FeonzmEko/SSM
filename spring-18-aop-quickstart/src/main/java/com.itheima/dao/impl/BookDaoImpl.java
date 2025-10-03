package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.stereotype.Repository;


@Repository
public class BookDaoImpl implements BookDao {
    public void save(){
        System.out.println(System.currentTimeMillis());
        System.out.println("book is saving...");
    }

    public void update(){
        System.out.println("book is updating...");
    }

    @Override
    public int select() {
        System.out.println("book is selecting...");
        return 100;
    }
}
