package com.solvd.mybatis.dao;

import com.solvd.interfaces.IAdditionalServiceDAO;
import com.solvd.models.AdditionalService;
import com.solvd.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AdditionalServiceDAO implements IAdditionalServiceDAO {

    private final Logger LOGGER = LogManager.getLogger(AdditionalServiceDAO.class);
    private static SqlSessionFactory sqlSessionFactory;
    private static IAdditionalServiceDAO myBatisDAO;

    public AdditionalServiceDAO() {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public AdditionalService getAdditionalServiceByServiceName(String serviceName) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IAdditionalServiceDAO.class);
            return myBatisDAO.getAdditionalServiceByServiceName(serviceName);
        }
    }

    @Override
    public void saveEntity(AdditionalService additionalService) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IAdditionalServiceDAO.class);
            myBatisDAO.saveEntity(additionalService);
            sqlSession.commit();
        }
    }

    @Override
    public AdditionalService getEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IAdditionalServiceDAO.class);
            return myBatisDAO.getEntityById(id);
        }
    }

    @Override
    public void updateEntity(AdditionalService additionalService) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IAdditionalServiceDAO.class);
            myBatisDAO.updateEntity(additionalService);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IAdditionalServiceDAO.class);
            myBatisDAO.removeEntityById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<AdditionalService> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IAdditionalServiceDAO.class);
            return  myBatisDAO.getAll();
        }
    }
}
