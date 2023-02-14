package module9;

public class MyStack<E> {
    private E[] data;
    private int size;

    public MyStack() {
        this.data = (E[])new Object[0];
    }

    public void push(E value) {

        ChangeSizeIfNeed();
        data[size] = value;
        size++;
    }

    private void ChangeSizeIfNeed() {

        E[] temp = data;
        data = (E[]) new Object[size + 1];
        System.arraycopy(temp, 0, data, 0, size);

    }

    public E remove(int index) {
        E removedElement = data[index];
        E[] temp = data;
        data = (E[]) new Object[temp.length - 1];
        System.arraycopy(temp, 0, data, 0, index);
        int newLength = (temp.length - 1 - index);
        System.arraycopy(temp,index + 1, data, index, newLength);
        size--;

        return removedElement;
    }

    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
        size = 0;

    }

    public int size() {
       return size;
    }

    public E peek() {
       return data[size - 1];
    }

    public E pop() {
        E removedElement = data[data.length - 1];
        E[] temp = data;
        data = (E[]) new Object[temp.length - 1];
        System.arraycopy(temp, 0, data, 0, temp.length -1);
       return removedElement;
    }

}
