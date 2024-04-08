public class Node implements Comparable<Node>
{
    private boolean leaf;
    public String val;
    public int freq;
    public Node left;
    public Node right;

    public Node(int freq)
    {
        leaf = false;
        this.val = null;
        this.freq = freq;
        left = null;
    }

    public Node(String val, int freq)
    {
        leaf = true;
        this.val = val;
        this.freq = freq;
        right = null;
    }

    public boolean isLeaf()
    {
        return leaf;
    }

    @Override
    public int compareTo(Node other)
    {
        return this.val.compareTo(other.val);
    }
}
