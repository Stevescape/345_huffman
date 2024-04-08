public class Test 
{
    public static void main(String[] args)
    {
        HuffmanTree tree = new HuffmanTree();

        HashMap map = new HashMap();
        map.put("A", "0101");

        System.out.println(map.get("A").getValue());
    }
}
