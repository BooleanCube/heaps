# Priority Queues
> Understand the mechanics of the fibonacci heap by taking small steps through other data structures.

In this example, we assume that the PriorityQueues only pop the minimum element within the data structure. Built-in priority queues are adjustable with their comparators and allow for some customization.

## Data structures (Ranked from slowest to fastest in terms of runtime)

### Sorted Linked List
#### INSERT - `Time complexity: O(n)`
Since Linked Lists aren't indexed, performing a binary search to find the proper location of the insertion element would take an extra O(n) operations for each O(logn) to find the element at that index. So, instead of making it O(nlogn), `SortedLinkedList` has O(n) insertion time with a linear search for its proper insertion location. We are constantly updating the linked list such that it is always sorted.
#### POP - `Time complexity: O(1)`
Even though inserting elements may not be the fastest in SortedLinkedLists, since the nodes are only connected by directed edges and not indexed, removing the first element of an linked list takes O(1) time by just cutting the edge, removing it from the list. There isn't any need to shift the following `n` nodes down 1 index.
#### PEEK - `Time complexity: O(1)`
We just need to return the value of the first element since the SortedLinkedList is already sorted from the insertions.

### Sorted Indexed List
#### INSERT - `Time complexity: O(logn)`
The elements in an indexed list have been assigned indices which means access nodes can be done in O(1) time. That's why we can perform binary search easily to find the proper insertion location of the new element and insert nodes in O(logn) time.
#### POP - `Time complexity: O(1)`
Usually, if the indexed list was sorted in order of lowest to highest, removing the minimum in a priority queue would be O(n) runtime because all nodes following the first one would have to have their indices updated. But, I optimized this `SortedIndexedList` to sort from highest to lowest so that the minimum element in the list is at the end so popping the minimum node would only take O(1) iterations.
#### PEEK - `Time complexity: O(1)`
Since it is an indexed list, accessing elements can be done in O(1) time and the minimum element in the list will always be the last element.

### Binary Heap
Binary Heaps are essentially binary trees with a property stating that children of nodes have to be strictly greater than or equal to its parent node.

#### INSERT - `Time complexity: O(logn)`
`BinaryHeap` works with a full binary tree where each level except the last has to be full. To insert an element, you just add it to the right-most position in the last level and then shift it up the levels with nodes it is smaller than. This takes O(logn) time in a worst-case scenario where it needs to get to the top.
#### POP - `Time complexity: O(logn)`
Popping an element from a BinaryHeap works the same as insert. You swap the minimum and the last node in the `BinaryHeap`. This makes removing the last element capable of running in O(1) time. The new root node of the `BinaryHeap` is then swapped with its smallest child until it can no longer shift down anymore. This is again O(logn) in a worst-case scenario.
#### PEEK - `Time complexity: O(1)`
Since the minimum element is always just the root of the binary tree in the `BinaryHeap`, we can access the root in O(1) time.

### Fibonacci Heap
#### INSERT - `Time complexity: O(1)`
A `FibonacciHeap` allows for insert operations to be lazy. Being lazy means, leaving expensive operations for later, to reduce total runtime and unecessary repetition. Inserting a new Tree into our `IndexedList` takes O(1) time. To check if the minimum element pointer is updated, also only takes O(1) runtime as you can check against the current minimum and the new element on insert everytime instead of a linear search for the minimum element in the list. The trees aren't necessary binary trees but work similarly to BinaryHeaps in which the property states that children have to be larger than the parent nodes.
#### POP - `Time complexity: O(logn)`
Removing the minimum element in a node is quite the complex process. First, you have to add all of its children as separate trees in the fibonacci heap so you can consider them as candidates for the new minimum. If we were to simply just linear search through all trees in the new `FibonacciHeap` this would be too slow. To reduce the amount of trees and the degrees (number of children) that each tree root has, we can perform some operations that we saved for later with the lazy insert. We can join trees with different degrees and keep joining until all trees have distinct degrees. This shortens the amount of trees and also keeps the maximum degree among all trees to an absolute minimum.
#### PEEK - `Time complexity: O(1)`
Since we keep a pointer to the minimum element at all times, access the minimum element only takes O(1) time.
