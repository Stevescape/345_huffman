public class PriorityQueue 
{
    // Implement a min heap comparing node frequencies
    private MinHeap minHeap;

    public PriorityQueue(){
        minHeap = new MinHeap(10);
    }
    public void insert(Node node)
    {
        minHeap.insert(node);
    }

    public Node removeMin()
    {
        return minHeap.remove();
    }

    public int size()
    {
        return minHeap.size();

    }
}
