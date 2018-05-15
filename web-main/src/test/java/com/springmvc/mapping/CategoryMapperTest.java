package com.springmvc.mapping;

import com.springmvc.dao.CategoryMapper;
import com.springmvc.pojo.Category;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class CategoryMapperTest {

    @Test
    public void testExample() throws IOException {
        SqlSession session = getSqlSession();
        List<Category> data = session.getMapper(CategoryMapper.class)
                .selectAll();
        for (Category category : data) {
            System.out.println(category.getId() + " " + category.getName());
        }
        System.out.println(data.size());
    }

    @Test
    public void testFind() throws IOException {
        SqlSession session = getSqlSession();
        Category category = session.getMapper(CategoryMapper.class).selectByPrimaryKey(1);
        System.out.println(category.getId());
        System.out.println(category.getName());
    }

    private static SqlSession getSqlSession() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml"));

        return sqlSessionFactory.openSession();

    }

}