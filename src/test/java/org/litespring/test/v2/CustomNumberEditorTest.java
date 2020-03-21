package org.litespring.test.v2;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.beans.propertyeditors.CustomNumberEditor;

public class CustomNumberEditorTest {
    @Test
    public void testConvertString() {
        CustomNumberEditor editor = new CustomNumberEditor(Integer.class,true);

        // 输入值为3，期望返回Integer类型的3
        editor.setAsText("3");
        Object value = editor.getValue();
        Assert.assertTrue(value instanceof Integer);
        Assert.assertEquals(3, ((Integer)editor.getValue()).intValue());


        // 输入值为空，期望返回null
        editor.setAsText("");
        Assert.assertTrue(editor.getValue() == null);


        try{
            // 输入非法的值
            editor.setAsText("3.1");

        }catch(IllegalArgumentException e){
            return ;
        }
        Assert.fail();
    }
}
