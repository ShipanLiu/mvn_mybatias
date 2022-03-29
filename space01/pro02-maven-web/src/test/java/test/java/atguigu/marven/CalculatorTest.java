package test.java.atguigu.marven;

import com.atguigu.maven.Calculator;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;


/*
* 因为你导入jar 包了， 所以 测试你写的jar包里面的东西。，
*
* */
public class CalculatorTest {

    @Test
    public void testSum() {
        Calculator calculator = new Calculator();

        int res = calculator.sum(1, 2);
        int expectResult = 3;

        /*
         * 如果一致 ： 通过。   不一致 ： 抛出异常
         *
         * */
//        Assert.assertEquals(res, expectResult);
        assertEquals(res, expectResult);
    }

}