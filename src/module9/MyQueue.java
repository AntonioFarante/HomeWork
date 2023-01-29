package module9;

public class MyQueue <E> {

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public void add(E e) {

        Node<E> temp = new Node<>();
        temp.setData(e);

        if (head == null) {
            head = temp;
        } else {
            tail.setNext(temp);
        }
        tail = temp;
        size ++;
    }

    public int size() {
        return size;
    }

    public E peek() {
        return tail.getData();
    }

    public E poll() {

        if (size == 0) {
            return null;
        }

        E temp = head.getData();
        head = head.getNext();

        if(head == tail) {
            tail = null;
        }
        size--;
        return temp;
    }

    public void clear() {

    }

    private class Node<E> {
        private E data;
        private Node<E> next;

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
