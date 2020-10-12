import com.yuziyan.dao.StudentDao;
import com.yuziyan.pojo.Student;
import com.yuziyan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 测试多对一和一对一的查询结果处理
 *
 */
public class MyTest {
    /**
     * 用于测试：环境搭建是否ok
     */
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = studentDao.getStudents();
        for (Student student : students) {
            System.out.println("student = " + student);
        }

        sqlSession.close();
    }

    /**
     * 用于测试：结果集映射
     */
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = studentDao.getStudentById2(1);
        System.out.println("student = " + student);

        sqlSession.close();
    }
}
