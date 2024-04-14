public class HuffmanTree 
{
    private PriorityQueue queue;
    private Node head;
    private HashMap map;
    private String encoding;

    public HuffmanTree(PriorityQueue queue)
    {
        this.queue = queue;
        head = null;
        map = new HashMap();
    }

    public HuffmanTree()
    {
        queue = new PriorityQueue();
        head = null;
        map = new HashMap();
    }

    public void insertLeaf(Node leaf)
    {
        assert leaf.left == null && leaf.right == null;
        queue.insert(leaf);
    }

    public Node createTree()
    {
        while (queue.size() > 1)
        {
            // More frequent goes left
            // Less frequent goes right
            Node right = queue.removeMin();
            Node left = queue.removeMin();
            
            assert(left.freq >= right.freq);
            Node head = new Node(left.freq + right.freq);
            head.left = left;
            head.right = right;
            queue.insert(head);
        }
        
        // Should only be new head remaining in queue
        assert queue.size() == 1;
        this.head = queue.removeMin();
        return this.head;
    }

    public HashMap convertMap()
    {
        convertRec(head, "");
        return map;
    }

    public void convertRec(Node cur, String str)
    {
        if (cur.isLeaf())
        {
            map.put(cur.val, str);
            return;
        }

        convertRec(cur.left, str+"0");
        convertRec(cur.right, str+"1");
    }

    public void printEncodings()
    {
        printRec(head, "");
    }

    private void printRec(Node cur, String str)
    {
        if (cur.isLeaf())
        {
            System.out.printf("%s : %s\n", cur.val, str);
            return;
        }

        printRec(cur.left, str+"0");
        printRec(cur.right, str+"1");
    }


    public String decode(String binaryString) {
        String decodedText = "";
        Node current = head; // Start at the head of the Huffman tree

        for (int i = 0; i < binaryString.length(); i++) {
            char bit = binaryString.charAt(i);

            // Move left for '0', right for '1'
            if (bit == '0') {
                current = current.left;
            } else if (bit == '1') {
                current = current.right;
            }

            // If a leaf node is reached, append the character
            // and reset current to start from the head again
            if (current.isLeaf()) {
                decodedText += current.val + "";
                current = head;
            }
        }
        return decodedText.toString();
    }
}
