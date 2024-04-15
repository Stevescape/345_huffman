import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class CompressionRatioCalculator {
    //Class made to compare Compression Ratios of two files
    //Compression ratio = uncompressed size / compressed size

    public static void main(String[] args) {
        /*
        Uses two test files that were made, Lorem.txt has placeholder text
        based on nonsensical latin. random.txt has randomly generated characters.
        Both are the same size, but Lorem.txt should have recognizable patterns
        in repeated characters just based on language, while random will have 
        no patterns at all.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first file name:");
        String file1 = scanner.nextLine();
        System.out.println("Enter second file name:");
        String file2 = scanner.nextLine();
        scanner.close();

        double ratio1 = computeCompressionRatio(file1);
        double ratio2 = computeCompressionRatio(file2);

        System.out.printf("Compression Ratio for %s: %.2f\n", file1, ratio1);
        System.out.printf("Compression Ratio for %s: %.2f\n", file2, ratio2);

        if (ratio1 > ratio2) {
            System.out.printf("%s is more efficiently compressed.\n", file1);
        } else {
            System.out.printf("%s is more efficiently compressed.\n", file2);
        }
    }

    private static double computeCompressionRatio(String file) {
        //Calculates the compression ratio for given file
        String text = readFile(file);
        PriorityQueue pq = new PriorityQueue();
        int[] counts = new int[256];
        for (int i = 0; i < text.length(); i++) {
            //counts for each char
            counts[text.charAt(i)]++;
        }

        for (int i = 0; i < counts.length; i++) {
            //adds each char to queue
            if (counts[i] > 0) {
                pq.insert(new Node(Character.toString((char) i), counts[i]));
            }
        }

        //create huffman tree and generate hashmap
        HuffmanTree tree = new HuffmanTree(pq);
        tree.createTree();
        HashMap map = tree.convertMap();

        //calculate original size based on 8 bits per char
        int originalSize = text.length() * 8;
        int compressedSize = 0;

        for (int i = 0; i < text.length(); i++) {
            //count bits per encoding and add them to total size
            String encoded = map.get(Character.toString(text.charAt(i)));
            compressedSize += encoded.length();
        }

        return (double) originalSize / compressedSize;
    }

    private static String readFile(String file) {
        //Reads text file in and returns string with all the text
        StringBuilder text = new StringBuilder();
        try (FileReader fileReader = new FileReader(file)) {
            int character;
            while ((character = fileReader.read()) != -1) {
                text.append((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}

