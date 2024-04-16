/*
 * Hashmap that uses separate chaining for collision management
 */
public class HashMap 
{
    private int DEFAULT_SIZE = 11;
    private Pair[] arr;
    private int size;

    public HashMap()
    {
        arr = new Pair[DEFAULT_SIZE];
        size = 0;
    }

    public HashMap(int cap)
    {
        arr = new Pair[cap];
        size = 0;
    }

    public String get(String name)
    {
        Pair cur = arr[hash(name, arr.length)];
        while (cur != null)
        {
            
            if (cur.key.equals(name))
            {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    public void put(String key, String value)
    {
        Pair p = new Pair(key, value);
        int index = hash(p.key, arr.length);
        // Need to check if already exist in table
        Pair cur = arr[index];
        while (cur != null)
        {
            // Update value if it exists
            if (cur.key.equals(key))
            {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }

        // Only runs if it doesn't already exist

        // Check size to see if we need to resize (see if current size is == to cap)
        if (size >= arr.length-1)
        {
            resize(getNextPrime(arr.length*2));
            index = hash(key, arr.length);
        }
        arr[index] = linkedInsert(arr[index], p);
        size++;
    }

    public int size()
    {
        return size;
    }

    private int hash(String str, int max)
    {
        return (str.hashCode() & 0x7fffffff) % max;
    }

    private int getNextPrime(int num)
    {
        if (num == 2 || num == 3)
        {
            return num;
        }
        int remainder = num % 6;
        switch (remainder)
        {
            case 0:
                num++;
                break;
            case 2:
                num+=3;
                break;
            case 3:
                num+=2;
                break;
            case 4:
                num++;
                break;
        }
        return num;
    }

    private Pair linkedInsert(Pair list, Pair p)
    {
        // Insert at head
        return new Pair(p.key, p.value, list);
    }

    private void resize(int size)
    {
        Pair[] newTable = new Pair[size];

        // Loop through each bucket
        for (int i = 0; i < arr.length; i++)
        {   
            // If bucket is not empty
            if (arr[i] != null)
            {
                // Traverse linked list, inserting each element into new table
                Pair cur = arr[i];
                while (cur != null)
                {
                    int index = hash(cur.key, newTable.length);
                    newTable[index] = linkedInsert(newTable[index], cur);
                    cur = cur.next;
                }
            }
        }
        this.arr = newTable;
    }
}
