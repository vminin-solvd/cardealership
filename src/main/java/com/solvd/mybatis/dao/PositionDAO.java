package com.solvd.mybatis.dao;

import com.solvd.interfaces.IManufacturerDAO;
import com.solvd.interfaces.IPositionDAO;
import com.solvd.models.Position;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PositionDAO implements IPositionDAO {

    private final Logger LOGGER = LogManager.getLogger(PositionDAO.class);
    private static SqlSessionFactory sqlSessionFactory;
    private static IPositionDAO myBatisDAO;

    @Override
    public void saveEntity(Position position) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IPositionDAO.class);
            myBatisDAO.saveEntity(position);
            sqlSession.commit();
        }
    }

    @Override
    public Position getEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IPositionDAO.class);
            return myBatisDAO.getEntityById(id);
        }
    }

    @Override
    public void updateEntity(Position position) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IPositionDAO.class);
            myBatisDAO.updateEntity(position);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IPositionDAO.class);
            myBatisDAO.removeEntityById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Position> getAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IPositionDAO.class);
            return myBatisDAO.getAll();
        }
    }

    @Override
    public Position getPositionByName(String positionName) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            myBatisDAO = sqlSession.getMapper(IPositionDAO.class);
            return myBatisDAO.getPositionByName(positionName);
        }
    }
}
