import com.atguigu.spring.pojo.*;
import jdk.nashorn.internal.runtime.regexp.joni.ApplyCaseFoldArg;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void testSpringHelloWorld() {
     // 要去容器中获取对象，而不是直接new
        // Before using Spring
        //Student student = new Student();

        // aufter using Spring
        // 01- 创建容器 Object
        ApplicationContext iocObj =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        // 02-通过容器 Object， 获取需要的对象, 返回值 是一个 Object  ——》 强转成 Student

        // 方式1 ： 需要强转一下：
//        Student stuJiba = (Student)iocObj.getBean("stuJiba");
//        System.out.println("Student: " + stuJiba);

        // 方式2： 不足：  不能区别 当让其中有 多个 Student 的时候， 不行
//        Student bean = iocObj.getBean(Student.class);
//        System.out.println("Student: " + bean);

        // 方式3: (最终用法)  id + class
        Student choosedStudent = iocObj.getBean("stuJiba", Student.class);
        System.out.println("choosedStudent: " + choosedStudent);

    }

    @Test
    public void testEmp() {
        // create iocObj
        ApplicationContext iocObj = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get Emp chai from the bean container
        Emp empChai = iocObj.getBean("empChai", Emp.class);
        System.out.println("emp:" + empChai);

        Dept dept = iocObj.getBean("dept1", Dept.class);
        // 结果是：financial_department 而不是 development_department
        System.out.println("dept1: " + dept);
    }

    @Test
    public void testInternalBean() {
        ApplicationContext iocObj = new ClassPathXmlApplicationContext("applicationContext.xml");
        Emp empXin = iocObj.getBean("empXin", Emp.class);
        System.out.println("empXin: " + empXin);

        /*测试是否 是影响外部bean 的结果*/
        Dept dept = iocObj.getBean("dept1", Dept.class);
        // 结果是：financial_department 而不是 development_department
        System.out.println("dept1: " + dept);

        // ioc 不会存储 内部的bean， 那如何获取 内部的bean 呢？
        System.out.println("internal bean is: " + empXin.getDept());
    }


    @Test
    public void testListAndMap(){
        ApplicationContext iocObj = new ClassPathXmlApplicationContext("applicationContext.xml");

        /* test List*/
        Dept dept4 = iocObj.getBean("dept5", Dept.class);
        System.out.println("dept5: " + dept4);


        /*test Map*/
        Dept dept6 = iocObj.getBean("dept6", Dept.class);
        System.out.println("dept6: " + dept6);

        Dept dept7 = iocObj.getBean("dept7", Dept.class);
        System.out.println("dept7: " + dept7);

    }

}
