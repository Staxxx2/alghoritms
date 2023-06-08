public class HashMap {

    private int size;
    private Node[] data;

    public HashMap() {
        this.size = 0;
        this.data = new Node[16];
    }

    public Object put(Integer key, Integer value) {
        int hash = key.hashCode();
        int index = hash % data.length;
        Node node = data[index];
        while (node != null) {
            if (node.key.equals(key)) {
                Object oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            node = node.next;
        }
        Node newNode = new Node(key, value, hash, null);
        newNode.next = data[index];
        data[index] = newNode;
        size++;
        return null;
    }

    public Object get(Integer key) {
        int hash = key.hashCode();
        int index = hash % data.length;
        Node node = data[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public Object remove(Integer key) {
        int hash = key.hashCode();
        int index = hash % data.length;
        Node node = data[index];
        Node prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    data[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    public Object replace(Integer key, Integer value) {
        int hash = key.hashCode();
        int index = hash % data.length;
        Node node = data[index];
        while (node != null) {
            if (node.key.equals(key)) {
                Object oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            node = node.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean containsKey(Integer key) {
        int hash = key.hashCode();
        int index = hash % data.length;
        Node node = data[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean containsValue(Integer v) {
        for (int i = 0; i < data.length; i++){
            Node node = data[i];
            while (node != null) {
                if (node.value.equals(v)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    private static class Node {
        private Integer key;
        private Integer value;
        private int hash;
        private Node next;

        public Node(Integer key, Integer value, int hash, Node next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }
    }
}
