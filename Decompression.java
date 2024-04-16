import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Decompression 
{
    // Class demonstrates the lossless compression 
    // and decompression of the huffman encoding
    public static void main(String[] args)
    {
        /*
            Reads file text file and creates a huffman tree of characters
            displays encoded text and compares decompressed text to original
        */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first file name:");
        String filePath = scanner.nextLine();
        scanner.close();





        String text = ""; // store original file in string
        int[] counts = new int[1000]; // counts frequency of char
        char[] temp = new char[1000]; // contains used characters
        int j = 0;

        // loop through characters and find frequency of each one
        try (FileReader fileReader = new FileReader(filePath)) {
            int character;
             // read file into text string
            while ((character = fileReader.read()) != -1) {
                char cur = (char) character;
                text += "" + cur;
                if (counts[(int) cur] == 0) // if first occurrence
                {
                    temp[j] = cur;
                    j++;
                }
                counts[(int) cur] += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        PriorityQueue myQueue = new PriorityQueue();
        // insert keys and values into priority queue
        for (int i = 0;temp[i] != 0;i++)
        {
            myQueue.insert(new Node(String.valueOf(temp[i]), counts[(int) temp[i]]));
        }

        HuffmanTree tree = new HuffmanTree(myQueue);

        tree.createTree();
        HashMap map = tree.convertMap();


        // get binary val of char in the returned map
        // created encoded string
        String encoding = "";
        for (int i = 0; i < text.length(); i++) {
            encoding += map.get(text.charAt(i) + "");
        }
        
        System.out.println("## Binary encoding of text ## \n" +encoding+"\n");
        String decoded = tree.decode(encoding);
        System.out.println("## Decompressed encoding ## \n" + decoded + "\n");
        System.out.println("decompression == original: " + decoded.equals(text) + "\n");
    }
}