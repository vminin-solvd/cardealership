package com.solvd.mybatis.dao;

import com.solvd.interfaces.IEmployeeDAO;
import com.solvd.models.Employee;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {

    private final Logger LOGGER = LogManager.getLogger(AdditionalServiceDAO.class);
    private static SqlSessionFactory sqlSessionFactory;
    private static IEmployeeDAO myBatisDAO;

    @Override
    public void saveEntity(Employee employee) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IEmployeeDAO.class);
            myBatisDAO.saveEntity(employee);
            sqlSession.commit();
        }
    }

    @Override
    public Employee getEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IEmployeeDAO.class);
            return myBatisDAO.getEntityById(id);
        }
    }

    @Override
    public void updateEntity(Employee employee) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IEmployeeDAO.class);
            myBatisDAO.updateEntity(employee);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IEmployeeDAO.class);
            myBatisDAO.removeEntityById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Employee> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IEmployeeDAO.class);
            return myBatisDAO.getAll();
        }
    }

    @Override
    public List<Employee> getEmployeeByLastName(String lastName) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IEmployeeDAO.class);
            return myBatisDAO.getEmployeeByLastName(lastName);
        }
    }
}
