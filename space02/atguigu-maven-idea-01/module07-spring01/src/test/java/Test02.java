import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Test02 {

    @Test
    public void testDruid() throws SQLException {
        ApplicationContext iocObj = new ClassPathXmlApplicationContext("applicationContext_druid.xml");

        DruidDataSource dataSource = iocObj.getBean("dataSource", DruidDataSource.class);

        // 获取连接, 打开 linux 的 mysql service
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println("the connection is: " + connection); // the connection is: com.mysql.cj.jdbc.ConnectionImpl@6293abcc
    }


}
