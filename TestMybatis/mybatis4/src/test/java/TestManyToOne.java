import com.yuziyan.dao.TeacherDao;
import com.yuziyan.pojo.Teacher;
import com.yuziyan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestManyToOne {
    /**
     * 用于测试：多对一查询
     */
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
        Teacher teacher = teacherDao.getTeacherById(1);
        System.out.println("teacher = " + teacher);

        sqlSession.close();
    }

    /**
     * 用于测试：
     */
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
        Teacher teacher = teacherDao.getTeacherById1(1);
        System.out.println("teacher = " + teacher);

        sqlSession.close();
    }
}
