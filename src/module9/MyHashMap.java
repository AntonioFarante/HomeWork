package module9;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.hash;

public class MyHashMap <K, V> {
    private Node<K, V>[] hashTable;
    private int size = 0;
    private float threshold;

    public MyHashMap() {
        hashTable = new Node[16];
        threshold = hashTable.length * 0.75f;
    }
    public void clear() {
        Node<K,V>[] tab;

        if ((tab = hashTable) != null && size > 0) {
            size = 0;
            for (int i = 0; i < tab.length; ++i)
                tab[i] = null;
        }
    }
    public boolean push(K key, V value) {
        if (size + 1 >= threshold) {
            threshold *= 2;
            arrDoubl();
        }

        Node<K, V> newNode = new Node<>(key, value);
        int index = hash(key);
        if (hashTable[index] == null) {
            return simpleAdd(index, newNode);
        }

        List <Node<K, V>> nodeList = hashTable[index].getNodes();

        for(Node<K, V> node : nodeList) {
            if(keyExistButValueNew(node, newNode, value) ||
                    collisionProcessing(node, newNode, nodeList)) {
                return true;
            }
        }
        return false;
    }

    private boolean simpleAdd(int index, Node<K, V> newNode) {
        hashTable[index] = new Node<>(null, null);
        hashTable[index].getNodes().add(newNode);
        size++;
        return true;
    }

    private boolean keyExistButValueNew(final Node<K, V> nodeFromList,
                                        final Node<K, V> newNode,
                                        final V value) {
        if (newNode.getKey().equals(nodeFromList.getKey()) &&
        !newNode.getValue().equals(nodeFromList.getValue())) {
            nodeFromList.setValue(value);
            return true;
        }
        return false;
    }

    private boolean collisionProcessing(final Node<K, V> nodeFromList,
                                        final Node<K, V> newNode,
                                        final List<Node<K, V>> nodes) {
        if(newNode.hashCode() == nodeFromList.hashCode() &&
        !Objects.equals(newNode.key, nodeFromList.key) &&
        !Objects.equals(newNode.value, nodeFromList.value)) {
            nodes.add(newNode);
            size++;
            return true;
        }
        return false;
    }

    private void arrDoubl() {
        Node<K, V>[] oldHashTable = hashTable;
        hashTable = new Node [oldHashTable.length * 2];
        size = 0;
        for(Node<K, V> node: oldHashTable) {
            if(node != null) {
                for (Node<K, V> n: node.getNodes()) {
                    push(n.key, n.value);
                }
            }
        }
    }

    public boolean remove(K key) {
        int index = hash(key);
        if (hashTable[index] == null) {
            return false;
        }
        if (hashTable[index].getNodes().size() == 1) {
            hashTable[index].getNodes().remove(0);
            size--;
            return true;
        }
        List<Node<K, V>> nodeList = hashTable[index].getNodes();
        for (Node<K, V> node: nodeList) {
            if (key.equals(node.getKey())) {
                nodeList.remove(node);

                return true;
            }
        }
        return false;
    }

    public V get (K key) {
        int index = hash(key);
        if (index < hashTable.length && hashTable[index] != null) {
            List<Node<K, V>> list = hashTable[index].getNodes();
            for (Node<K, V> node: list) {
                if (key.equals(node.getKey())) {
                    return node.getValue();
                }
            }
        }
        return null;
    }

     private int hash (K key) {
        int hash = 31;
         hash = hash * 17 + key.hashCode();
         return Math.abs(hash % hashTable.length);
    }

    public int size() {
        return  size;
    }

    private class Node<K, V> {
        private List<Node <K,V>> nodes;
        private int hash;
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            nodes = new LinkedList<Node<K, V>>();
        }

        public List<Node<K, V>> getNodes() {
            return nodes;
        }

        public int hash() {

            return hashCode() % hashTable.length;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
           if (this == o)
               return  true;
           if (o instanceof Node) {
               Node<K, V> node = (Node) o;
               return (Objects.equals(key, node.getKey()) &&
                       Objects.equals(value, node.getValue()) ||
                       Objects.equals(hash, node.hashCode()));
           }
           return  false;
        }

//        @Override
//        public int hashCode() {
//            hash = 31;
//            hash = hash * 17 + key.hashCode();
//            hash = hash * 17 + value.hashCode();
//            return hash;
//        }
    }
}
