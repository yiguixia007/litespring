package org.litespring.test.v2;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.PropertyValue;
import org.litespring.beans.factory.config.RuntimeBeanReference;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.core.io.ClassPathResource;

import java.util.List;

public class BeanDefinitionTestV2 {

    @Test
    public void testGetBeanDefinition() {

        // 1、读取配置文件
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions(new ClassPathResource("petstore-v2.xml"));

        // 2、获取BeanDefinition对象
        BeanDefinition bd = factory.getBeanDefinition("petStore");

        // 3、获取PropertyValue列表
        List<PropertyValue> pvs = bd.getPropertyValues();

        // 因为配置文件里是两个property所以为2
        Assert.assertTrue(pvs.size() == 2);
        {
            // 4、获取accountDao的value的值
            PropertyValue pv = this.getPropertyValue("accountDao", pvs);

            Assert.assertNotNull(pv);

            // 5、判断是否为对象实例
            Assert.assertTrue(pv.getValue() instanceof RuntimeBeanReference);
        }

        {
            // 6、获取accountDao的value的值
            PropertyValue pv = this.getPropertyValue("itemDao", pvs);

            Assert.assertNotNull(pv);

            // 7、判断是否为对象实例
            Assert.assertTrue(pv.getValue() instanceof RuntimeBeanReference);
        }

    }

    private PropertyValue getPropertyValue(String name, List<PropertyValue> pvs){
        for(PropertyValue pv : pvs){
            if(pv.getName().equals(name)){
                return pv;
            }
        }
        return null;
    }
}
