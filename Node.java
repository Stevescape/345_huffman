/*
 * A node in the Huffman tree that stores the frequency
 * of a chracter, the character itself, and pointers
 * to the left and right child
 * 
 * The node can also be used without storing a character and represent
 * a subtree with the combiend frequency
 */
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
        if (this.freq >= other.freq)
        {
            return 1;
        } else
        {
            return -1;
        }
    }
}
