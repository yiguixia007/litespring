package org.litespring.test.v1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 运行一套 test
 */
@RunWith(Suite.class)
@SuiteClasses({
        ApplicationContextTest.class,
        BeanFactoryTest.class ,
        ResourceTest.class})
public class V1AllTests {

}
