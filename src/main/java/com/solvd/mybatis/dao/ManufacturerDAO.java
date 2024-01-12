package com.solvd.mybatis.dao;

import com.solvd.interfaces.IManufacturerDAO;
import com.solvd.models.Manufacturer;
import com.solvd.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ManufacturerDAO implements IManufacturerDAO {

    private final Logger LOGGER = LogManager.getLogger(ManufacturerDAO.class);
    private static SqlSessionFactory sqlSessionFactory;
    private static IManufacturerDAO myBatisDAO;

    public ManufacturerDAO() {
        sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public void saveEntity(Manufacturer manufacturer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IManufacturerDAO.class);
            myBatisDAO.saveEntity(manufacturer);
            sqlSession.commit();
        }
    }

    @Override
    public Manufacturer getEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IManufacturerDAO.class);
            return myBatisDAO.getEntityById(id);
        }
    }

    @Override
    public void updateEntity(Manufacturer manufacturer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IManufacturerDAO.class);
            myBatisDAO.updateEntity(manufacturer);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IManufacturerDAO.class);
            myBatisDAO.removeEntityById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Manufacturer> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IManufacturerDAO.class);
            return myBatisDAO.getAll();
        }
    }

    @Override
    public Manufacturer getManufacturerByName(String manufacturerName) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IManufacturerDAO.class);
            return myBatisDAO.getManufacturerByName(manufacturerName);
        }
    }
}
