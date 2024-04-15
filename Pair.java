/*
 * An entry in the hashmap with a string mapped to a string.
 * Also has a pointer to the next object in the hashmap.
 */

public class Pair {
    public String key;
    public String value;
    public Pair next;

    public Pair(String key, String value, Pair next)
    {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Pair(String key, String value)
    {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public String getValue()
    {
        return value;
    }

    public String getKey()
    {
        return key;
    }
}
