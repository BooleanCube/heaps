package structures;

import java.util.ArrayList;

public class FibonacciHeap implements PQueue {

    private final ArrayList<Tree> heap;
    private final Integer[] minimum;

    public FibonacciHeap() {
        this.heap = new ArrayList<>();

        this.minimum = new Integer[]{Integer.MAX_VALUE, -1};
    }

    @Override
    public void insert(Integer value) {
        if(value < this.minimum[0]) {
            this.minimum[0] = value;
            this.minimum[1] = this.heap.size();
        }

        Tree newTree = new Tree(new Node(value));
        this.heap.add(newTree);
    }

    @Override
    public Integer popHead() {
        int minValue = this.heap.get(this.minimum[1]).head.value;
        for(Node child : this.heap.get(this.minimum[1]).head.children) {
            this.heap.add(new Tree(child));
        }
        this.heap.remove((int)this.minimum[1]);

        ArrayList<Tree> newHeap = new ArrayList<>();
        Integer[] newMinimum = new Integer[]{Integer.MAX_VALUE, -1};

        for(Tree tree : this.heap) {
            int degree = tree.head.children.size();
            int value = tree.head.value;

            if(value < newMinimum[0]) {
                newMinimum[0] = value;
                newMinimum[1] = degree;
            }

            for(int i=newHeap.size(); i<=degree; i++) {
                newHeap.add(null);
            }
            if(newHeap.get(degree) == null) {
                newHeap.set(degree, tree);
            }
            else if(newHeap.get(degree).head.value < tree.head.value) {
                Tree current = newHeap.get(degree);
                Tree previous = tree;

                while(current != null) {
                    current.head.children.add(previous.head);
                    newHeap.set(degree, null);
                    degree++;

                    if(newHeap.size() < degree) {
                        newHeap.add(null);
                    }

                    previous = new Tree(current.head);
                    current = newHeap.get(degree);
                }
                newHeap.set(degree, previous);

                if(previous.head.value <= newMinimum[0]) {
                    newMinimum[0] = tree.head.value;
                    newMinimum[1] = degree;
                }
            }
            else {
                Tree current = tree;
                Tree previous = newHeap.get(degree);

                while(current != null) {
                    current.head.children.add(previous.head);
                    newHeap.set(degree, null);
                    degree++;

                    if(newHeap.size() < degree) {
                        newHeap.add(null);
                    }

                    previous = new Tree(current.head);
                    current = newHeap.get(degree);
                }
                newHeap.set(degree, previous);

                if(previous.head.value <= newMinimum[0]) {
                    newMinimum[0] = tree.head.value;
                    newMinimum[1] = degree;
                }
            }
        }

        return minValue;
    }

    @Override
    public Integer peekHead() {
        return this.minimum[0];
    }

    @Override
    public void printList() {
        System.out.println("{");
        for(Tree tree : this.heap) {
            System.out.println(tree);
        }
        System.out.println("}");
    }

    private static class Tree {

        public Node head;

        public Tree(Node head) {
            this.head = head;
        }

    }

    private static class Node {

        public int value;
        public Node parent;
        public ArrayList<Node> children;

        public Node(int value) {
            this.value = value;
        }

    }

}
