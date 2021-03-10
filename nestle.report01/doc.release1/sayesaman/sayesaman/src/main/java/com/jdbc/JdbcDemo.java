package com.jdbc;

import com.jdbc.bo.impl.JdbcBoImpl;
import com.jdbc.model.AccYear;
import com.jdbc.model.Dc;
import com.jdbc.model.Personnel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ameysami
 * Date: 6/17/13
 * Time: 12:27 PM
 */
public class JdbcDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context-jdbc.xml");
        JdbcBoImpl bo = ctx.getBean("jdbcBoImpl", JdbcBoImpl.class);

        System.out.println("-------------------------------");
        List<Dc> l1 = new LinkedList<Dc>();
        l1 = bo.getDc();

        for (Dc data : l1)
            System.out.print(data.getName());

        System.out.println("-------------------------------");
        List<AccYear> l2 = new LinkedList<AccYear>();
        l2 = bo.getAccYear();

        for (AccYear data : l2)
            System.out.print(data.getName());

        System.out.println("-------------------------------");
        List<Personnel> l3 = new LinkedList<Personnel>();
        l3 = bo.getPersonnel("0","0","1","0");

        for (Personnel data : l3)
            System.out.print(data.getPersonnelName());

    }
}
