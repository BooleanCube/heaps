package structures;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A Fibonacci heap implementation of a priority queue.
 */
public class FibonacciHeap implements PQueue {

    // An ArrayList of Tree objects that stores the roots of the trees in the heap.
    private ArrayList<Tree> heap;

    // An array of size two that stores the minimum value in the heap and its index in the heap.
    private Integer[] minimum;

    /**
     * Constructs a new FibonacciHeap object.
     */
    public FibonacciHeap() {
        this.heap = new ArrayList<>();

        this.minimum = new Integer[]{Integer.MAX_VALUE, -1};
    }

    /**
     * Inserts a new value into the heap.
     * @param value the value to be inserted
     */
    @Override
    public void insert(Integer value) {
        if(value < this.minimum[0]) {
            this.minimum[0] = value;
            this.minimum[1] = this.heap.size();
        }

        Tree newTree = new Tree(new Node(value));
        this.heap.add(newTree);
    }

    /**
     * Removes and returns the minimum value in the heap.
     * @return the minimum value in the heap
     */
    @Override
    public Integer popHead() {
        if (this.heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        Node minNode = this.heap.get(this.minimum[1]).head;
        int minValue = minNode.value;

        // Remove the minimum node from the heap's root list
        this.heap.remove((int)this.minimum[1]);
        this.minimum[1] = -1;
        this.minimum[0] = Integer.MAX_VALUE;

        // Add the minimum node's children to the root list
        if (minNode.children != null) {
            for (Node child : minNode.children) {
                this.heap.add(new Tree(child));
            }
        }

        // Consolidate the heap
        consolidate();

        return minValue;
    }

    /**
     * Consolidates the heap by merging trees with the same degree until no trees with the same degree remain.
     */
    private void consolidate() {
        int numTrees = this.heap.size();
        int maxDegree = (int) Math.floor(Math.log(numTrees) / Math.log(1.618));

        // Initialize an array to hold trees of each degree
        Tree[] degreeArray = new Tree[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            degreeArray[i] = null;
        }

        // Make a copy of the heap list to avoid ConcurrentModificationException
        List<Tree> heapCopy = new ArrayList<>(this.heap);

        // Find the root nodes with the same degree and merge them
        for (Tree currentTree : heapCopy) {
            int currentDegree = currentTree.head.children.size();

            while (degreeArray[currentDegree] != null) {
                Tree otherTree = degreeArray[currentDegree];

                // Make the current tree the one with the smaller root value
                if (currentTree.head.value > otherTree.head.value) {
                    Tree temp = currentTree;
                    currentTree = otherTree;
                    otherTree = temp;
                }

                // Make the other tree a child of the current tree
                linkTrees(currentTree, otherTree);

                // Remove the other tree from the degree array
                degreeArray[currentDegree] = null;

                // Increment the degree of the current tree
                currentDegree++;
            }

            // Put the current tree in the degree array
            degreeArray[currentDegree] = currentTree;
        }

        // Rebuild the heap from the trees in the degree array
        this.heap.clear();
        for (int i = 0; i <= maxDegree; i++) {
            if (degreeArray[i] != null) {
                this.heap.add(degreeArray[i]);
            }
        }

        // Update the minimum value
        for (int i = 0; i < this.heap.size(); i++) {
            Tree tree = this.heap.get(i);
            if (tree.head.value < this.minimum[1]) {
                this.minimum[0] = tree.head.value;
                this.minimum[1] = i;
            }
        }
    }

    /**
     * Links two trees together by making one the child of the other.
     * @param parentTree the tree that will become the parent
     * @param childTree the tree that will become the child
     */
    private void linkTrees(Tree parentTree, Tree childTree) {
        // Remove the child tree from the heap's root list
        this.heap.remove(childTree);

        // Make the child tree a child of the parent tree
        parentTree.head.children.add(childTree.head);
        childTree.head.parent = parentTree.head;
    }

    /**
     * Returns the minimum value in the heap without removing it.
     * @return the minimum value in the heap
     */
    @Override
    public Integer peekHead() {
        return this.minimum[0];
    }

    /**
     * Clears the FibonacciHeap values entirely.
     * Time complexity: O(1)
     */
    @Override
    public void clear() {
        this.heap.clear();
        this.minimum = new Integer[]{Integer.MAX_VALUE, -1};
    }

    /**
     * Prints the memory addresses of the Tree Objects within the Fibonacci Heap.
     */
    @Override
    public void printList() {
        System.out.println("{");
        for(Tree tree : this.heap) {
            System.out.println(tree);
        }
        System.out.println("}");
    }

    /**
     * A data structure representing a tree in a Fibonacci heap.
     */
    private static class Tree {

        /**
         * The root node of the tree.
         */
        public Node head;

        /**
         * Creates a new tree with the specified root node.
         *
         * @param head the root node of the tree
         */
        public Tree(Node head) {
            this.head = head;
        }

    }

    /**
     * A node in a Fibonacci heap.
     */
    private static class Node {

        /**
         * The value stored in the node.
         */
        public int value;

        /**
         * The parent node of this node.
         */
        public Node parent;

        /**
         * The child nodes of this node.
         */
        public ArrayList<Node> children;

        /**
         * Creates a new node with the specified value.
         *
         * @param value the value to store in the node
         */
        public Node(int value) {
            this.value = value;
            this.children = new ArrayList<>();
        }

    }

}
