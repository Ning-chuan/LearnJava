package newdao;

import domain.Student;
import orm.annotation.Insert;
import orm.annotation.Select;

import java.util.List;

public interface StudentDao {

    @Insert("insert into t_student values(#{sid},#{sname},#{ssex},#{sage})")
    public void insert(Student student);

    @Select("select * from t_student where sid = #{sid}")
    public Student selectOne(Integer sid);

    @Select("select * from t_student")
    public List<Student> selectList();

}
