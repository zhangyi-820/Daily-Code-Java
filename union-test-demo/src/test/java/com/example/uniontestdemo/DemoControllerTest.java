package com.example.uniontestdemo;

import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/6/19 20:22
 * @description：
 * @modified By：
 * @version:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UnionTestDemoApplication.class)//
public class DemoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeClass
    public static void testDemoControllerBeforeClassInitialization(){
        System.out.println("所有测试用例执行前被执行，用于初始化");
    }


    @AfterClass
    public static void testDemoControllerAfterClassDestroy(){
        System.out.println("所有测试用例被执行后被执行，用户数据清理");
    }


    @Before
    public void testDemoControllerBefore(){
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        System.out.println("测试函数调用前被执行，一般用于数据的准备工作");
    }


    @Test
    //@Transactional//如果有数据库等操作，但是又不希望对数据库造成影响，可以使用此注解，测试用例执行完后，自动回滚
    public void testDemoController1() throws Exception {
        String result=mockVisit("/demo");
        boolean tag=result.contains("haaaa");
        Assert.assertTrue(tag);
    }

    @Test
    public void testDemoController2()throws Exception{
        String result=mockVisit("/demo");
        boolean tag=result.contains("hello world");
        Assert.assertTrue(tag);
    }

    @After
    public void testDemoControllerAfter(){
        System.out.println("测试函数调用后被执行，一般执行一些测试后的清理工作");
    }


    public String mockVisit(String url){
        try {
            ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(url));
            MvcResult mvcResult = resultActions.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
            return mvcResult.getResponse().getContentAsString();
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
