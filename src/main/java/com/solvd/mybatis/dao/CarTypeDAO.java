package com.solvd.mybatis.dao;

import com.solvd.interfaces.ICarTypeDAO;
import com.solvd.models.CarType;
import com.solvd.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CarTypeDAO implements ICarTypeDAO{

    private final Logger LOGGER = LogManager.getLogger(CarTypeDAO.class);
    private static SqlSessionFactory sqlSessionFactory;
    private static ICarTypeDAO myBatisDAO;

    public CarTypeDAO() {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public void saveEntity(CarType carType) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICarTypeDAO.class);
            myBatisDAO.saveEntity(carType);
            sqlSession.commit();
        }
    }

    @Override
    public CarType getEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICarTypeDAO.class);
            return myBatisDAO.getEntityById(id);
        }
    }

    @Override
    public void updateEntity(CarType carType) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICarTypeDAO.class);
            myBatisDAO.updateEntity(carType);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICarTypeDAO.class);
            myBatisDAO.removeEntityById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<CarType> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICarTypeDAO.class);
            return myBatisDAO.getAll();
        }
    }

    @Override
    public CarType getCarTypeByName(String name) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICarTypeDAO.class);
            return myBatisDAO.getCarTypeByName(name);
        }
    }
}
