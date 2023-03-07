package structures;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryHeap implements PQueue {

    private final ArrayList<Integer> heap;

    public BinaryHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(-1); // dummy node for 1-indexed heap list
    }

    private void swap(int idx1, int idx2) {
        Collections.swap(this.heap, idx1, idx2);
    }

    @Override
    public void insert(Integer value) {
        int index = this.heap.size();
        this.heap.add(value);

        while(index > 1) {
            if(this.heap.get(index >> 1) > this.heap.get(index)) {
                swap(index, index >> 1);
            }
            else {
                break;
            }
            index >>= 1;
        }
    }

    @Override
    public Integer popHead() {
        swap(1, this.heap.size()-1);

        int index = 1;
        while(true) {
            if(this.heap.size() > index*2 && this.heap.get(index*2) < this.heap.get(index)) {
                swap(index, index*2);
                index *= 2;
            }
            else if(this.heap.size() > index*2+1 && this.heap.get(index*2+1) < this.heap.get(index)) {
                swap(index, index*2+1);
                index = index*2+1;
            }
            else {
                break;
            }
        }

        return this.heap.remove(this.heap.size()-1);
    }

    @Override
    public Integer peekHead() {
        return this.heap.get(1);
    }

    @Override
    public void printList() {
        System.out.println(this.heap);
    }

}
