package module9;

import java.util.LinkedList;
import java.util.StringJoiner;

public class NewLinkedList<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    public NewLinkedList(){
        lastNode = new Node<E>(null, firstNode, null);
        firstNode = new Node<E>(null, null, lastNode);
    }
    Node<E> getNode(int index) {

        if (index < (size)) {
            Node<E> x = firstNode;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = lastNode;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public void addLast(E e) {
        Node<E> addedNode = lastNode;
        addedNode.data = e;
        lastNode = new Node<>(null, addedNode, null);
        addedNode.next = lastNode;
        size++;
    }

    public void addFirst(E e) {
        Node<E> addedNode = firstNode;
        addedNode.data = e;
        firstNode = new Node<>(null, null, addedNode);
        addedNode.prev = firstNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            firstNode = firstNode.next;
        } if (index == size - 1) {
            lastNode = lastNode.prev;
        } else {
            Node<E> toRemove = getNode(index + 1);
            Node<E> beforeRemoved = toRemove.prev;
            Node<E> nextBeforeRemoved = toRemove.next;

            beforeRemoved.next = nextBeforeRemoved;
            nextBeforeRemoved.prev = beforeRemoved;
        }
        size --;
    }
        public void clear() {
            for (int i = 0; i < size; i++) {
                remove(0);
            }
//            firstNode = lastNode = null;
            size = 0;
        }

    public E get(int index) {
        Node<E> temp = firstNode.next;
        for (int i = 0; i < index; i++) {
            temp = getNextElement(temp);
        }
        return temp.data;
    }

    private Node<E> getNextElement(Node<E> thisNode) {
        return thisNode.next;
    }
    
    private Node<E> getPrevElement(Node<E> thisNode) {
        return thisNode.prev;
    }
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < size; i++) {
            result.add(get(i).toString());
        }

        return "[" + result + "]";
    }

    private class Node <E> {

        private E data;
        private Node<E> next;
        private Node<E> prev;

        private Node(E data, Node<E> prev, Node<E> next) {
            this.next = next;
            this.data = data;
            this.prev = prev;
        }

    }
}
