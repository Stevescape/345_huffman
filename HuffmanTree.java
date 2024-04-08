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
    }

    public HashMap convertMap()
    {
        return new HashMap();
    }

}
