package org.litespring.beans.factory;

public class PropertyValue {

    private final String name;

    private final Object value;

    /**
     * 是否转换过
     * true：转换过  value 已转换成 convertedValue
     * false：未转换 value 未转换成 convertedValue
     */
    private boolean converted = false;

    private Object convertedValue;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public Object getValue() {
        return this.value;
    }
    public synchronized boolean isConverted() {
        return this.converted;
    }


    public synchronized void setConvertedValue(Object value) {
        this.converted = true;
        this.convertedValue = value;
    }

    public synchronized Object getConvertedValue() {
        return this.convertedValue;
    }
}
