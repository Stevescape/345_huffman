public class HuffmanTreeTest
    //This was an initial test done just to make sure everything was running with no errors
{
    public static void main(String[] args)
    {
        HuffmanTree tree = new HuffmanTree();

        String test = "Huffman Test String";
        
        int[] counts = new int[1000];
        char[] temp = new char[1000];
        int j = 0;
        for (int i = 0; i < test.length(); i++)
        {
            char cur = test.charAt(i);
            if (counts[(int) cur] == 0)
            {
                temp[j] = cur;
                j++;
            }
            counts[(int) cur] += 1;
        }

        for (int i = 0;temp[i] != 0;i++)
        {
            tree.insertLeaf(new Node(String.valueOf(temp[i]), counts[(int) temp[i]]));
        }

        tree.createTree();
        tree.printEncodings();
    }
}
