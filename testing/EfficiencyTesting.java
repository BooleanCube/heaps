package testing;

import structures.*;

public class EfficiencyTesting {

    private static final SortedLinkedList priorityQueue1 = new SortedLinkedList();
    private static final SortedIndexedList priorityQueue2 = new SortedIndexedList();
    private static final BinaryHeap priorityQueue3 = new BinaryHeap();
    private static final FibonacciHeap priorityQueue4 = new FibonacciHeap();

    public static Result simulateTestCase(String inputString, String outputString, PQueue queue) {
        long startTime = System.currentTimeMillis();

        String[] input = inputString.split("/");
        String[] output = outputString.split("/");
        int outputCounter = 0;

        boolean pass = true;
        for(String operation : input) {
            if(operation.startsWith("I")) {
                queue.insert(Integer.parseInt(operation.split(" ")[1]));
            }
            else if(operation.equals("R")) {
                int value = queue.popHead();
                if(value != Integer.parseInt(output[outputCounter])) pass = false;
                outputCounter++;
            }
            else if(operation.equals("M")) {
                int value = queue.peekHead();
                if(value != Integer.parseInt(output[outputCounter])) pass = false;
                outputCounter++;
            }
        }

        return new Result(pass, System.currentTimeMillis() - startTime);
    }

    public static void runAllTestCases() {

        // SortedLinkedList performance on all 4 test cases
        Result pq1tc1 = simulateTestCase(TestCase.INPUT1, TestCase.OUTPUT1, priorityQueue1);
        priorityQueue1.clear();
        Result pq1tc2 = simulateTestCase(TestCase.INPUT2, TestCase.OUTPUT2, priorityQueue1);
        priorityQueue1.clear();
        Result pq1tc3 = simulateTestCase(TestCase.INPUT3, TestCase.OUTPUT3, priorityQueue1);
        priorityQueue1.clear();
        Result pq1tc4 = simulateTestCase(TestCase.INPUT4, TestCase.OUTPUT4, priorityQueue1);

        // SortedIndexedList performance on all 4 test cases
        Result pq2tc1 = simulateTestCase(TestCase.INPUT1, TestCase.OUTPUT1, priorityQueue2);
        priorityQueue2.clear();
        Result pq2tc2 = simulateTestCase(TestCase.INPUT2, TestCase.OUTPUT2, priorityQueue2);
        priorityQueue2.clear();
        Result pq2tc3 = simulateTestCase(TestCase.INPUT3, TestCase.OUTPUT3, priorityQueue2);
        priorityQueue2.clear();
        Result pq2tc4 = simulateTestCase(TestCase.INPUT4, TestCase.OUTPUT4, priorityQueue2);

        // BinaryHeap performance on all 4 test cases
        Result pq3tc1 = simulateTestCase(TestCase.INPUT1, TestCase.OUTPUT1, priorityQueue3);
        priorityQueue3.clear();
        Result pq3tc2 = simulateTestCase(TestCase.INPUT2, TestCase.OUTPUT2, priorityQueue3);
        priorityQueue3.clear();
        Result pq3tc3 = simulateTestCase(TestCase.INPUT3, TestCase.OUTPUT3, priorityQueue3);
        priorityQueue3.clear();
        Result pq3tc4 = simulateTestCase(TestCase.INPUT4, TestCase.OUTPUT4, priorityQueue3);

        // FibonacciHeap performance on all 4 test cases
        Result pq4tc1 = simulateTestCase(TestCase.INPUT1, TestCase.OUTPUT1, priorityQueue4);
        priorityQueue4.clear();
        Result pq4tc2 = simulateTestCase(TestCase.INPUT2, TestCase.OUTPUT2, priorityQueue4);
        priorityQueue4.clear();
        Result pq4tc3 = simulateTestCase(TestCase.INPUT3, TestCase.OUTPUT3, priorityQueue4);
        priorityQueue4.clear();
        Result pq4tc4 = simulateTestCase(TestCase.INPUT4, TestCase.OUTPUT4, priorityQueue4);

        System.out.println(
                "SortedLinkedList Performance ===>\n" +
                        "-----------------------------------------------------\n" +
                        "---> Test Case #1: " + pq1tc1.getSuccess() + " (" + pq1tc1.getRuntime() + " ms)\n" +
                        "---> Test Case #2: " + pq1tc2.getSuccess() + " (" + pq1tc2.getRuntime() + " ms)\n" +
                        "---> Test Case #3: " + pq1tc3.getSuccess() + " (" + pq1tc3.getRuntime() + " ms)\n" +
                        "---> Test Case #4: " + pq1tc4.getSuccess() + " (" + pq1tc4.getRuntime() + " ms)\n"
        );
        System.out.println();
        System.out.println(
                "SortedIndexedList Performance ===>\n" +
                        "-----------------------------------------------------\n" +
                        "---> Test Case #1: " + pq2tc1.getSuccess() + " (" + pq2tc1.getRuntime() + " ms)\n" +
                        "---> Test Case #2: " + pq2tc2.getSuccess() + " (" + pq2tc2.getRuntime() + " ms)\n" +
                        "---> Test Case #3: " + pq2tc3.getSuccess() + " (" + pq2tc3.getRuntime() + " ms)\n" +
                        "---> Test Case #4: " + pq2tc4.getSuccess() + " (" + pq2tc4.getRuntime() + " ms)\n"
        );
        System.out.println();
        System.out.println(
                "BinaryHeap Performance ===>\n" +
                        "-----------------------------------------------------\n" +
                        "---> Test Case #1: " + pq3tc1.getSuccess() + " (" + pq3tc1.getRuntime() + " ms)\n" +
                        "---> Test Case #2: " + pq3tc2.getSuccess() + " (" + pq3tc2.getRuntime() + " ms)\n" +
                        "---> Test Case #3: " + pq3tc3.getSuccess() + " (" + pq3tc3.getRuntime() + " ms)\n" +
                        "---> Test Case #4: " + pq3tc4.getSuccess() + " (" + pq3tc4.getRuntime() + " ms)\n"
        );
        System.out.println();
        System.out.println(
                "FibonacciHeap Performance ===>\n" +
                        "-----------------------------------------------------\n" +
                        "---> Test Case #1: " + pq4tc1.getSuccess() + " (" + pq4tc1.getRuntime() + " ms)\n" +
                        "---> Test Case #2: " + pq4tc2.getSuccess() + " (" + pq4tc2.getRuntime() + " ms)\n" +
                        "---> Test Case #3: " + pq4tc3.getSuccess() + " (" + pq4tc3.getRuntime() + " ms)\n" +
                        "---> Test Case #4: " + pq4tc4.getSuccess() + " (" + pq4tc4.getRuntime() + " ms)\n"
        );

    }

    private static class Result {

        private final boolean success;
        private final long runtime;

        public Result(boolean success, long runtime) {
            this.success = success;
            this.runtime = runtime;
        }

        public boolean wasSuccessful() {
            return this.success;
        }

        public String getSuccess() {
            return this.success ? "Success!" : "Fail!";
        }

        public long getRuntime() {
            return this.runtime;
        }

    }

}
