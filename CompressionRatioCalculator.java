import java.io.FileReader;
import java.io.IOException;
public class CompressionRatioCalculator {

    public static void main(String[] args) {
        String filePath1 = "Lorem.txt";
        String filePath2 = "random.txt";

        double ratio1 = computeCompressionRatio("Lorem.txt");
        double ratio2 = computeCompressionRatio("random.txt");

        System.out.printf("Compression Ratio for %s: %.2f\n", filePath1, ratio1);
        System.out.printf("Compression Ratio for %s: %.2f\n", filePath2, ratio2);

        if (ratio1 > ratio2) {
            System.out.printf("%s is more efficiently compressed.\n", filePath1);
        } else {
            System.out.printf("%s is more efficiently compressed.\n", filePath2);
        }
    }

    private static double computeCompressionRatio(String filePath) {
        String text = readFile(filePath);
        PriorityQueue myQueue = new PriorityQueue();
        int[] counts = new int[256];
        for (int i = 0; i < text.length(); i++) {
            counts[text.charAt(i)]++;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                myQueue.insert(new Node(Character.toString((char) i), counts[i]));
            }
        }

        HuffmanTree tree = new HuffmanTree(myQueue);
        tree.createTree();
        HashMap map = tree.convertMap();

        int originalSize = text.length() * 8;
        int compressedSize = 0;

        for (int i = 0; i < text.length(); i++) {
            String encoded = map.get(Character.toString(text.charAt(i)));
            compressedSize += encoded.length();
        }

        return (double) originalSize / compressedSize;
    }

    private static String readFile(String filePath) {
        StringBuilder text = new StringBuilder();
        try (FileReader fileReader = new FileReader(filePath)) {
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

