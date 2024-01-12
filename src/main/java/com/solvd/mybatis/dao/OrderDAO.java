package com.solvd.mybatis.dao;

import com.solvd.interfaces.IOrderDAO;
import com.solvd.models.Order;
import com.solvd.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class OrderDAO implements IOrderDAO {

    private final Logger LOGGER = LogManager.getLogger(OrderDAO.class);
    private static SqlSessionFactory sqlSessionFactory;
    private static IOrderDAO myBatisDAO;

    public OrderDAO() {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public void saveEntity(Order order) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IOrderDAO.class);
            myBatisDAO.saveEntity(order);
            sqlSession.commit();
        }
    }

    @Override
    public Order getEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IOrderDAO.class);
            return myBatisDAO.getEntityById(id);
        }
    }

    @Override
    public void updateEntity(Order order) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IOrderDAO.class);
            myBatisDAO.updateEntity(order);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IOrderDAO.class);
            myBatisDAO.removeEntityById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Order> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IOrderDAO.class);
            return myBatisDAO.getAll();
        }
    }

    @Override
    public List<Order> getOrdersByEmployeeID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IOrderDAO.class);
            return myBatisDAO.getOrdersByEmployeeID(id);
        }
    }
}
