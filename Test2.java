import java.io.FileReader;
import java.io.IOException;

public class Test2 
{
    public static void main(String[] args)
    {
        String text = "";
        String encoding = "";
        PriorityQueue myQueue = new PriorityQueue();
        HashMap map;

        int[] counts = new int[1000];
        char[] temp = new char[1000];
        int j = 0;

        String filePath = "Lorem.txt";

        // loop through characters and find count of each
        try (FileReader fileReader = new FileReader(filePath)) {
            int character;

            while ((character = fileReader.read()) != -1) {
                char cur = (char) character;
                text += "" + cur;

                if (counts[(int) cur] == 0)
                {
                    temp[j] = cur;
                    j++;
                }
                counts[(int) cur] += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // insert keys and values into priority queue
        for (int i = 0;temp[i] != 0;i++)
        {
            myQueue.insert(new Node(String.valueOf(temp[i]), counts[(int) temp[i]]));
        }

        HuffmanTree tree = new HuffmanTree(myQueue);

        tree.createTree();
        map = tree.convertMap();
        tree.printEncodings();

        // get binary val of letter in the returned map
        for (int i = 0; i < text.length(); i++) {
            encoding += map.get(text.charAt(i) + "");
        }
        
        System.out.println(encoding);
        String decoded = tree.decode(encoding); 
        System.out.println(decoded);
    }
}