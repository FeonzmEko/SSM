package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.dao.BookDao;
import com.itheima.dao.impl.BookDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForAnnotation {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        BookDaoImpl bookDao1 = (BookDaoImpl) ctx.getBean(BookDao.class);
        BookDao bookDao2 = (BookDaoImpl) ctx.getBean(BookDao.class);
        System.out.println(bookDao1.name);
        System.out.println(bookDao2);
    }
}