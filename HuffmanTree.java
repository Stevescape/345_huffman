public class HuffmanTree 
{
    private PriorityQueue queue;
    private Node head;

    public HuffmanTree(PriorityQueue queue)
    {
        this.queue = queue;
        head = null;
    }

    public HuffmanTree()
    {
        queue = new PriorityQueue();
    }

    public void insertLeaf(Node leaf)
    {
        assert leaf.left == null && leaf.right == null;
        queue.insert(leaf);
    }

    public void createTree()
    {
        while (queue.size() > 1)
        {
            // More frequent goes left
            // Less frequent goes right
            Node right = queue.removeMin();
            Node left = queue.removeMin();
            
            assert(left.freq >= right.freq);

        }
    }

    public HashMap convertMap()
    {
        return new HashMap();
    }

}
