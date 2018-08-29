package com.wzc.hello;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.SessionFactoryServiceInitiator;
import org.hibernate.service.spi.SessionFactoryServiceRegistryBuilder;
import org.junit.Test;

public class HibernateTest {

	@Test
	public void test() {

        //1������һ��sessionFactory����
        SessionFactory sessionFactory = null;

        //1)������Configuration  ���󣻶�ӦHibernate �Ļ���������Ϣ�Ͷ����ϵӳ����Ϣ
        Configuration configuration = new Configuration().configure();

        //4.0֮ǰ��������
        sessionFactory = configuration.buildSessionFactory();
        
        /**
         * ���������@�Ӵ���sessionFactory�д��� ��֪��Ϊʲô
         */

        //2)������һ��ServiceRegister  ����hibernate 4.x  ����ӵĶ���
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
//        		applySettings(configuration.getProperties()).build();
//        
//        
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);


        //2������һ��session����
        Session session = sessionFactory.openSession();

        //3����������
        //���в�����Ӧ���������½��У����������ݿ��в���ִ��
        Transaction transaction = session.beginTransaction();

        //4��ִ�б������

        /**
         * ���ǲ������
         */
        News news = new News("Java", "WZC", new Date());
        session.save(news);
        
        /**
         * ���ǻ�ȡ����,����Hibernate�ײ��õķ�����ƣ�����News����Ҫ�пղι���
         */
        News news2 = (News)session.get(News.class, 1);
        System.out.println(news2.getAuthor());
    

        //5���ύ����
        //���Ҫʹ������Ч�������Ҫ�ύ����
        transaction.commit();


        //6���ر�session
        session.close();

        //7���ر�SessionFactory ����

        sessionFactory.close();

	}

}
