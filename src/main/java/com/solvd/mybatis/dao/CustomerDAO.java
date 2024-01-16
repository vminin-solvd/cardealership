package com.solvd.mybatis.dao;

import com.solvd.interfaces.ICustomerDAO;
import com.solvd.models.Customer;
import com.solvd.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomerDAO implements ICustomerDAO {

    private final Logger LOGGER = LogManager.getLogger(CustomerDAO.class);
    private static SqlSessionFactory sqlSessionFactory;
    private static ICustomerDAO myBatisDAO;

    public CustomerDAO() {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public void saveEntity(Customer customer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICustomerDAO.class);
            myBatisDAO.saveEntity(customer);
            sqlSession.commit();
        }
    }

    @Override
    public Customer getEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICustomerDAO.class);
            return myBatisDAO.getEntityById(id);
        }
    }

    @Override
    public void updateEntity(Customer customer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICustomerDAO.class);
            myBatisDAO.updateEntity(customer);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICustomerDAO.class);
            myBatisDAO.removeEntityById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Customer> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICustomerDAO.class);
            return myBatisDAO.getAll();
        }
    }

    @Override
    public Customer getCustomerByFirstName(String firstName) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICustomerDAO.class);
            return myBatisDAO.getCustomerByFirstName(firstName);
        }
    }
}
