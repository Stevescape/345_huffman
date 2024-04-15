public class PriorityQueue
//Priority queue implemented with min heap to make it cleaner and add any extra methods if necessary
{
    // Implement a min heap comparing node frequencies
    private MinHeap minHeap;

    public PriorityQueue(){
        //Default size of 10 for queue
        minHeap = new MinHeap(10);
    }
    public void insert(Node node) {
        //Insert done in O(logN)
        minHeap.insert(node);
    }

    public Node removeMin() {
        //remove min done in O(logN)
        return minHeap.remove();
    }

    public int size() {
        return minHeap.size();

    }
}
