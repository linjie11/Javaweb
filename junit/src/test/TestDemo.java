package test;

import cn.linjie.TestJunit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestDemo {
    /**
     * 初始化方法：
     * 用于资源申请，所有测试方法在执行之前都会先执行该方法
     */
    @Before
    public void init(){
        System.out.println("init...");
    }

    /**
     * 释放资源方法：
     * 在所有测试方法执行完后，都会自动执行该方法
     */
    @After
    public void close(){
        System.out.println("close...");
    }

    @Test
    public void testAdd1(){
        TestJunit test01 = new TestJunit();
        int result = test01.testAdd(2,3);
        System.out.println("testAdd1");
        Assert.assertEquals(5,result);
    }
}
