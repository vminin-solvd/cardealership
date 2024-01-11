package com.solvd.mybatis.dao;

import com.solvd.interfaces.ITestDriveDAO;
import com.solvd.models.TestDrive;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TestDriveDAO implements ITestDriveDAO {

    private final Logger LOGGER = LogManager.getLogger(TestDriveDAO.class);
    private static SqlSessionFactory sqlSessionFactory;
    private static ITestDriveDAO myBatisDAO;

    @Override
    public void saveEntity(TestDrive testDrive) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ITestDriveDAO.class);
            myBatisDAO.saveEntity(testDrive);
            sqlSession.commit();
        }
    }

    @Override
    public TestDrive getEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ITestDriveDAO.class);
            return myBatisDAO.getEntityById(id);
        }
    }

    @Override
    public void updateEntity(TestDrive testDrive) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ITestDriveDAO.class);
            myBatisDAO.updateEntity(testDrive);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ITestDriveDAO.class);
            myBatisDAO.removeEntityById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<TestDrive> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ITestDriveDAO.class);
            return myBatisDAO.getAll();
        }
    }

    @Override
    public List<TestDrive> getTestDrivesByEmployeeID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(ITestDriveDAO.class);
            return myBatisDAO.getTestDrivesByEmployeeID(id);
        }
    }
}
