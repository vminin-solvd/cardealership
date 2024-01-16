package com.solvd.mybatis.dao;

import com.solvd.interfaces.ICarSaleDAO;
import com.solvd.models.CarSale;
import com.solvd.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CarSaleDAO implements ICarSaleDAO {

    private final Logger LOGGER = LogManager.getLogger(AdditionalServiceDAO.class);
    private static SqlSessionFactory sqlSessionFactory;
    private static ICarSaleDAO myBatisDAO;

    public CarSaleDAO() {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public void saveEntity(CarSale carSale) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICarSaleDAO.class);
            myBatisDAO.saveEntity(carSale);
            sqlSession.commit();
        }
    }

    @Override
    public CarSale getEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICarSaleDAO.class);
            return myBatisDAO.getEntityById(id);
        }
    }

    @Override
    public void updateEntity(CarSale carSale) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICarSaleDAO.class);
            myBatisDAO.updateEntity(carSale);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICarSaleDAO.class);
            myBatisDAO.removeEntityById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<CarSale> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICarSaleDAO.class);
            return myBatisDAO.getAll();
        }
    }

    @Override
    public List<CarSale> getCarSalesByEmployeeID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ICarSaleDAO.class);
            return myBatisDAO.getCarSalesByEmployeeID(id);
        }
    }
}
