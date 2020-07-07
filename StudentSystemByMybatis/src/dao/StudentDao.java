package dao;

import domain.Student;
import org.apache.ibatis.session.SqlSession;
import util.MySqlSessionFactory;

public class StudentDao {
    private SqlSession sqlSession = MySqlSessionFactory.getSqlSession(true);

    //新增一条学生记录
    public void insert(Student student){
        sqlSession.insert("insert", student);
    }
}
