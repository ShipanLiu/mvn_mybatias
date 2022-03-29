package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

// 注意这个interface的路径和 在mapper/EmployeeMapper 里面的namespace 名子一样
/**
 * 声明这个接口是为了方便上层代码调用Mybatis的具体功能
 * 接口的全类名要和Mapper配置文件的namespace属性一致，这样才能通过接口找到Mapper配置
 * 接口中的方法名要和Mapper配置文件中SQL语句标签的id属性一致，这样才能通过方法名找到具体SQL语句
 * 又因为在Mapper配置文件中id属性的值是不能重复的，所以当前接口中方名也不能重复——当前接口中的方法不能重载
 */
public interface EmployeeMapper {

    // 注意： 方法的名称 和 在mapper/EmployeeMapper 里面的sql语句的id一样。
    /**
     * 通过这个方法对应Mapper配置文件中的SQL语句
     * @param（就是 Integer empId） empId 当前方法的参数对应SQL语句中#{empId}声明的参数
     * @return（就是 Emp， 表示返回类型） 当前方法的返回值类型和resultType属性指定的类型一致
     */
    Emp selectEmpById(Integer empId);

    /**
     * 执行插入操作
     * @param emp
     * @return 受影响的行数
     */
    int insertEmp(Emp emp);  // 定义完这个之后，就去写sql 语句


    void deleteById(Integer empId);

    //  注意我可以传进来一个实体类
    void updateById(Emp emp); // after this go to create sql


    // 当有多个 参数的时候， 采用注解方式。 这样在sql里面就不会混淆了
    void updateEmployeeWithAnnotation(@Param("diyName") String empName,@Param("diySalary") int salary);

    // 使用map， 当需要的参数大于四五六的时候。
    void updateEmployeeWithMap(Map<String, Object> paraMap);


    // 测试mysql 给你返回时候，是 单个值返回的情况 ：
    Integer selectCount();

    // return an entity class object
    Emp returnOneEmp(Integer select_id);

    Map<String, Object> returnMap(Integer select_id);

    List<Emp> returnList();
}
