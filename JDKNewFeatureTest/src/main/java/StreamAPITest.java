import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPITest {
    /**
     * 用于测试：Stream流式计算的用法
     */
    @Test
    public void testStream() {

        List<Employee> employees = EmployeeData.getEmployees();

        ///1.filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
        //练习：查询员工表中薪资大于7000的员工信息
        Stream<Employee> employeeStream = employees.stream();
        employeeStream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        System.out.println("===================================");
        //2.limit(n)——截断流，使其元素不超过给定数量。
        employees.stream().sorted((e1,e2) -> Double.compare(e2.getSalary(),e1.getSalary())).limit(5).forEach(System.out::println);


    }
}
