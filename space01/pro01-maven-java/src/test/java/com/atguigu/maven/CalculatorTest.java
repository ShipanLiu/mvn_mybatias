package com.atguigu.maven;

import org.junit.Assert;
// 或者 静态导入 所有Assert 中的 方法， 调用就不用类名 了。
import static org.junit.Assert.*;
import org.junit.Test;

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
