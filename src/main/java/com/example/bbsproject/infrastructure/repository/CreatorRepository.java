package com.example.bbsproject.infrastructure.repository;

import com.example.bbsproject.domain.entity.Creator;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CreatorRepository {

    @Autowired
    protected SqlSessionTemplate sqlSession;

    public Creator selectCreator(Long creatorId) {
        return sqlSession.selectOne("mapper.CreatorRepository.selectCreator", creatorId);
    }

    public int insertCreator(Creator creator) {
        return sqlSession.insert("mapper.CreatorRepository.insertCreator", creator);
    }
}
