package challenges.assorted.ctci.ll;

import static java.lang.String.format;

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public void addNode(int data){
        Node node = new Node(data);


    }


    @Override
    public String toString() {
        if (next == null) {
            return format("[ %d ]", data);
        } else {
            return format("[ %d ] -> ", data);
        }
    }
}
