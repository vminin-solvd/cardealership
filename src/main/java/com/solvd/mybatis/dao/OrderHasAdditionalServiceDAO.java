package com.solvd.mybatis.dao;

import com.solvd.interfaces.IOrderHasAdditionalServicesDAO;
import com.solvd.models.AdditionalService;
import com.solvd.models.OrderHasAdditionalService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class OrderHasAdditionalServiceDAO implements IOrderHasAdditionalServicesDAO<OrderHasAdditionalService, AdditionalService> {

    private final Logger LOGGER = LogManager.getLogger(OrderHasAdditionalServiceDAO.class);
    private static SqlSessionFactory sqlSessionFactory;
    private static IOrderHasAdditionalServicesDAO myBatisDAO;

    @Override
    public void saveEntity(OrderHasAdditionalService orderHasAdditionalService) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IOrderHasAdditionalServicesDAO.class);
            myBatisDAO.saveEntity(orderHasAdditionalService);
            sqlSession.commit();
        }
    }

    @Override
    public OrderHasAdditionalService getEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IOrderHasAdditionalServicesDAO.class);
            return (OrderHasAdditionalService) myBatisDAO.getEntityById(id);
        }
    }

    @Override
    public void updateEntity(OrderHasAdditionalService orderHasAdditionalService) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IOrderHasAdditionalServicesDAO.class);
            myBatisDAO.updateEntity(orderHasAdditionalService);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IOrderHasAdditionalServicesDAO.class);
            myBatisDAO.removeEntityById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<OrderHasAdditionalService> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IOrderHasAdditionalServicesDAO.class);
            return (List<OrderHasAdditionalService>) myBatisDAO.getAll();
        }
    }

    @Override
    public List<AdditionalService> getAllServicesById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IOrderHasAdditionalServicesDAO.class);
            return (List<AdditionalService>) myBatisDAO.getAllServicesById(id);
        }
    }
}
