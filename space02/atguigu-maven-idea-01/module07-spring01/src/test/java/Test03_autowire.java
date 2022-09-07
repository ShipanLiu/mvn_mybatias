import com.atguigu.spring.pojo.Dept;
import com.atguigu.spring.service.impl.DeptServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03_autowire {

    @Test
    public void testAutoWire() {
        ApplicationContext iocObj = new ClassPathXmlApplicationContext("applicationContext_autowire.xml");

        DeptServiceImpl deptServiceImpl = iocObj.getBean("deptService", DeptServiceImpl.class);

        deptServiceImpl.saveDept(new Dept());
    }

}
