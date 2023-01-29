package module9;

import java.lang.reflect.Array;
import java.util.*;

public class MyArrayList <E> {

    private E[] data;

    private int size;

    public MyArrayList() {
        data = (E[])new Object[0];
    }
    public void add(E value) {

        ChangeSizeIfNeed();
        data[size] = value;
        size++;
    }

    private void ChangeSizeIfNeed() {

        E[] temp = data;
        data = (E[]) new Object[size + 1];
        System.arraycopy(temp, 0, data, 0, size);

    }

    public void remove(int index) {

        E[] temp = data;
        data = (E[]) new Object[temp.length - 1];
        System.arraycopy(temp, 0 , data, 0, index);
        int newSize = temp.length - index - 1;
        System.arraycopy(temp, index + 1, data, index,newSize);

    }

    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
        size = 0;

    }

    public E get(int index) {
       if (index < 0 || index >= size) {
           throw new IndexOutOfBoundsException("Index " + index + " isn't exist, try another one");
       }
        return (E) data[index];
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < size - 1; i++) {
            result.add(data[i].toString());
        }

        return "[" + result + "]";
    }
}
