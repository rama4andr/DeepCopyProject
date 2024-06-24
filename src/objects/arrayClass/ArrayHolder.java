package objects.arrayClass;

import java.util.Arrays;

public class ArrayHolder {

    private int[] intArray;

    private String[] stringArray;

    public ArrayHolder() {}

    public ArrayHolder(int[] intArray, String[] stringArray) {
        this.intArray = intArray;
        this.stringArray = stringArray;
    }

    public int[] getIntArray() {
        return intArray;
    }

    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }

    public String[] getStringArray() {
        return stringArray;
    }

    public void setStringArray(String[] stringArray) {
        this.stringArray = stringArray;
    }

    @Override
    public String toString() {
        return "ArrayHolder{" +
                "intArray=" + Arrays.toString(intArray) +
                ", stringArray=" + Arrays.toString(stringArray) +
                '}';
    }
}
