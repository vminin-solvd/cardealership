package com.solvd.mybatis.dao;

import com.solvd.interfaces.ICarDAO;
import com.solvd.models.Car;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CarDAO implements ICarDAO {

    private final Logger LOGGER = LogManager.getLogger(CarDAO.class);
    private static SqlSessionFactory sqlSessionFactory;
    private static ICarDAO myBatisDAO;

    @Override
    public void saveEntity(Car car) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICarDAO.class);
            myBatisDAO.saveEntity(car);
            sqlSession.commit();
        }
    }

    @Override
    public Car getEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICarDAO.class);
            return myBatisDAO.getEntityById(id);
        }
    }

    @Override
    public void updateEntity(Car car) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICarDAO.class);
            myBatisDAO.updateEntity(car);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICarDAO.class);
            myBatisDAO.removeEntityById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Car> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICarDAO.class);
            return myBatisDAO.getAll();
        }
    }

    @Override
    public List<Car> getCarsByModel(String model) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICarDAO.class);
            return myBatisDAO.getCarsByModel(model);
        }
    }
}
