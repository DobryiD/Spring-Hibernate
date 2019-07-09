package com.springdemo.DAO;

import com.springdemo.entity.Customer;
import com.springdemo.interfaces.CustomerDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Customer> getCustomers() {
        Session theSession = sessionFactory.getCurrentSession();

        Query<Customer> theQuery = theSession.createQuery("from Customer order by lastName",Customer.class);

        List<Customer> list = theQuery.getResultList();

        return list;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session theSession = sessionFactory.getCurrentSession();

        theSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        Session theSession = sessionFactory.getCurrentSession();

        Customer theCustomer = theSession.get(Customer.class,theId);
        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session theSession = sessionFactory.getCurrentSession();

        Query theQuery = theSession.createQuery("delete  from Customer where id=:customerId");
        theQuery.setParameter("customerId",theId);

        theQuery.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String theName) {
        Session theSession = sessionFactory.getCurrentSession();

        Query theQuery = null;
        if(theName!=null &&theName.trim().length()>0){
            theQuery = theSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like:theName",Customer.class);
            theQuery.setParameter("theName","%"+theName.toLowerCase()+"%");
        }else{
            theQuery = theSession.createQuery("from Customer",Customer.class);
        }
        List<Customer> list = theQuery.getResultList();
        return list;
    }
}
