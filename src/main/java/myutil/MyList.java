package myutil;

public class MyList <T> {

    int size;
    Node firstNode;
    Node lastNode;

    MyList() {
        this.size = 0;
        this.firstNode = null;
        this.lastNode = null;
    }

    public void add(T data) {
        Node node = new Node<>(data);
        if (size == 0) {
            firstNode = node;
        } else {
            this.lastNode.insertNext(node);
        }
        lastNode = node;
        this.size++;
    }

    public void delete() {
        if (size == 1) {
            this.lastNode = null;
            this.firstNode = null;
        } else {
            this.lastNode = lastNode.prevNode;
        }
        this.size--;
    }

    static class Node <T> {

        Node prevNode;
        Node nextNode;
        T data;

        Node(T data) {
            prevNode = null;
            nextNode = null;
            this.data = data;
        }

        public Node setNextNode(Node node) {
            this.nextNode = node;
            return this;
        }

        public Node setPrevNode(Node node) {
            this.prevNode = node;
            return this;
        }

        public void insertNext(Node node) {
            if (nextNode != null) {
                this.nextNode.setPrevNode(node);
            }
            this.nextNode = node;
        }

        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }
    }
}
