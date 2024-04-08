import java.util.PriorityQueue;

public class HuffmanTree 
{
    private PriorityQueue<Node> queue;
    private Node head;

    public HuffmanTree(PriorityQueue<Node> queue)
    {
        this.queue = queue;
        head = null;
    }

    public HuffmanTree()
    {
        queue = new PriorityQueue<Node>();
    }

    public void insertLeaf(Node leaf)
    {
        assert leaf.left == null && leaf.right == null;
        queue.add(leaf);
    }

    public Node createTree()
    {
        while (queue.size() > 1)
        {
            // More frequent goes left
            // Less frequent goes right
            Node right = queue.poll();
            Node left = queue.poll();
            
            assert(left.freq >= right.freq);
            Node head = new Node(left.freq + right.freq);
            head.left = left;
            head.right = right;
            queue.add(head);
        }
        
        // Should only be new head remaining in queue
        assert queue.size() == 1;
        this.head = queue.poll();
        return this.head;
    }

    public HashMap convertMap()
    {
        HashMap map = new HashMap();

        return map;
    }

}
