package com.customers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import com.customers.beanclasses.Customer;
import com.customers.common.HibernateInit;

public class FetchCustomers {

    public List<Customer> getCustomers(Integer... id) {
        String hql;
        HibernateInit hibernateInstance = new HibernateInit();
        Session sessionInstance = hibernateInstance.init();
        if (id.length == 0) {
            hql = "from Customer";
        } else {
            hql = "from Customer where id = " + id[0];

        }

        Query query = sessionInstance.createQuery(hql);
        List<Customer> customerList = query.getResultList();
        sessionInstance.close();
        return customerList;

    }

    public void insertCustomers(String name, long age, double rating) {
        try {
            HibernateInit hibernateInstance = new HibernateInit();
            Session sessionInstance = hibernateInstance.init();
            Customer customer = new Customer();
            customer.setAge(age);
            customer.setName(name);
            customer.setRating(rating);
            sessionInstance.save(customer);
            sessionInstance.close();
        } catch (Exception e) {
            System.out.println("something went wrong FetchCustomers.insertCustomers()");
            System.out.println(e.getMessage());
        }

    }

    public void deleteCustomers(int id) {
        HibernateInit hibernateInstance = new HibernateInit();
        Session sessionInstance = hibernateInstance.init();
        Transaction transaction = sessionInstance.beginTransaction();
        try {
            String hql = "delete from Customer where id = :customerId";
            Query query = sessionInstance.createQuery(hql);
            System.out.println(id);
            query.setParameter("customerId", id);
            query.executeUpdate();
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
            System.out.println("something went wrong in delete customers method ");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            sessionInstance.close();
        }

    }

    public void editCustomers(int id, String name, long age, double rating) {
        HibernateInit hibernateInstance = new HibernateInit();
        Session sessionInstance = hibernateInstance.init();
        Transaction transaction = sessionInstance.beginTransaction();
        try {

            String hql = "update Customer c set c.age = :age ,c.name = :name,c.rating = :rating where c.id = :customerId";
            Query query = sessionInstance.createQuery(hql);
            query.setParameter("age", age);
            query.setParameter("name", name);
            query.setParameter("rating", rating);
            query.setParameter("customerId",id);
            query.executeUpdate();
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
            System.out.println("something went wrong in edit customer method,fetchcustomer class");
            System.out.println(e.getMessage());
        } finally {
            sessionInstance.close();
        }

    }

}
