public class HuffmanTree 
{
    private PriorityQueue queue;
    private Node head;
    private HashMap map;
    private String encoding;

    // Create the object with the queue object added
    public HuffmanTree(PriorityQueue queue)
    {
        this.queue = queue;
        head = null;
        map = new HashMap();
    }

    // Create an object with no queue object 
    public HuffmanTree()
    {
        queue = new PriorityQueue();
        head = null;
        map = new HashMap();
    }

    /*
     * Inserts a leaf node into the priority queue
     * 
     * @param leaf
     */
    public void insertLeaf(Node leaf)
    {
        assert leaf.left == null && leaf.right == null;
        queue.insert(leaf);
    }

    /*
     * Creates a Huffman tree from the priority queue in the object
     * 
     * Returns the root node of the huffman tree
     * 
     * Runtime = O(NLogN)
     */
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

    /*
     * Converts the priority queue into a hashmap with
     * the character being mapped to the encoding
     * 
     * Runtime = O(N)
     */
    public HashMap convertMap()
    {
        convertRec(head, "");
        return map;
    }

    /*
     * Recurisve helper function for converting queue into a
     * hashmap
     */
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

    /*
     * Prints out all the encodings for each character 
     * 
     * O(N)
     */
    public void printEncodings()
    {
        printRec(head, "");
    }

    /*
     *  Recursive helper function for the printEncodings 
     */
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


    /*
     * Returns the decoded string of the binaryString given.
     * 
     * O(N)
     */
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
