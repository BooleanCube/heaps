package structures;

import java.util.ArrayList;
import java.util.Collections;

public class SortedIndexedList implements PQueue {

    private final ArrayList<Integer> indexedList;

    public SortedIndexedList() {
        this.indexedList = new ArrayList<>();
    }

    @Override
    public void insert(Integer value) {
        int index = Collections.binarySearch(this.indexedList, value);

        if (index < 0) {
            index = -(index + 1);
        }

        this.indexedList.add(index, value);
    }

    @Override
    public Integer popHead() {
        if(this.indexedList.isEmpty()) {
            return null;
        }

        return this.indexedList.remove(0);
    }

    @Override
    public Integer peekHead() {
        return this.indexedList.get(0);
    }

    @Override
    public void printList() {
        System.out.println(this.indexedList);
    }

}
