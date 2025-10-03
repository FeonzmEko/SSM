package com.itheima;

import com.itheima.config.SpringConfigure;
import com.itheima.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfigure.class);
        BookDao bookDao = ctx.getBean(BookDao.class);

        int select = bookDao.select();
        //System.out.println(bookDao.getClass());
        System.out.println(select);
    }
}
