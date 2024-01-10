package com.solvd.mybatis.dao;

import com.solvd.interfaces.IServiceTypeDAO;
import com.solvd.models.ServiceType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ServiceTypeDAO implements IServiceTypeDAO {

    private final Logger LOGGER = LogManager.getLogger(AdditionalServiceDAO.class);
    private static SqlSessionFactory sqlSessionFactory;
    private static IServiceTypeDAO myBatisDAO;

    @Override
    public void saveEntity(ServiceType serviceType) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IServiceTypeDAO.class);
            myBatisDAO.saveEntity(serviceType);
            sqlSession.commit();
        }
    }

    @Override
    public ServiceType getEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IServiceTypeDAO.class);
            return myBatisDAO.getEntityById(id);
        }
    }

    @Override
    public void updateEntity(ServiceType serviceType) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IServiceTypeDAO.class);
            myBatisDAO.updateEntity(serviceType);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IServiceTypeDAO.class);
            myBatisDAO.removeEntityById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<ServiceType> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IServiceTypeDAO.class);
            return myBatisDAO.getAll();
        }
    }

    @Override
    public ServiceType getServiceTypeByName(String serviceTypeName) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IServiceTypeDAO.class);
            return myBatisDAO.getServiceTypeByName(serviceTypeName);
        }
    }
}
