package org.litespring.test.v1;

import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.service.v1.PetStoreService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BeanFactoryTest {

    /**
     * 给定一个配置文件获取bean的定义
     */
    @Test
    public void testGetBean(){
        // 1、获取bean的定义
        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
        BeanDefinition bd = factory.getBeanDefinition("petStore");

        // 2、判断与xml文件ClassName是否相等
        assertEquals("org.litespring.service.v1.PetStoreService", bd.getBeanClassName());

        // 3、获取petStoreService实例
        PetStoreService petStore = (PetStoreService) factory.getBean("petStore");

        // 4、判断实例是否为空
        assertNotNull(petStore);
    }

}
