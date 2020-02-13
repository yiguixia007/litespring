package org.litespring.test.v1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.beans.factory.support.BeanDefinitionRegistry;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XMLBeanDefinitionReader;
import org.litespring.service.v1.PetStoreService;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BeanFactoryTest {
    BeanFactory factory ;
    XMLBeanDefinitionReader reader ;

    /**
     * 运行每一个测试用例之前运行一次本方法
     */
    @Before
    public void setUP(){
        factory = new DefaultBeanFactory();
        reader = new XMLBeanDefinitionReader((BeanDefinitionRegistry) factory);
    }

    /**
     * 给定一个配置文件获取bean的定义
     */
    @Test
    public void testGetBean(){
        // 1、获取bean的定义
        reader.loadBeanDefinitions("petstore-v1.xml");
        BeanDefinition bd = factory.getBeanDefinition("petStore");

        // 2、判断与xml文件ClassName是否相等
        assertEquals("org.litespring.service.v1.PetStoreService", bd.getBeanClassName());

        // 3、获取petStoreService实例
        PetStoreService petStore = (PetStoreService) factory.getBean("petStore");

        // 4、判断实例是否为空
        assertNotNull(petStore);
    }

    /**
     * 测试不存在的bean
     */
    @Test
    public void testInvalidBean(){
        reader.loadBeanDefinitions("petstore-v1.xml");

        try {
            factory.getBean("invalidBean");
        } catch (BeanCreationException e) {
            return;
        }

        // 如果走到这行，则说明失败了
        Assert.fail("expect BeanCreationException ");
    }

    /**
     * 测试不存在的XML
     */
    @Test
    public void testInvalidXML(){

        try {
            reader.loadBeanDefinitions("xxx.xml");
        } catch (BeanDefinitionStoreException e) {
            return;
        }

        Assert.fail("expect BeanDefinitionStoreException ");
    }
}
