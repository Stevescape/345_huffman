public class MinHeap {
    private Node[] heap;
    private int numItems;
    private int size;

    public MinHeap(int size){
        this.size = size;
        this.numItems = 0;
        heap = new Node[size];
    }

    public int size(){
        return numItems;
    }

    private int leftChild(int pos){
        return (2*pos)+1;
    }
    private int rightChild(int pos){
        return (2*pos)+2;
    }
    private int parent(int pos){
        return (pos-1)/2;
    }

    private void swap(int one, int two){
        Node phony = heap[one];
        heap[one] = heap[two];
        heap[two] = heap[one];
    }

    private void resize(boolean larger) {
        int newSize = (larger) ? size * 2 : size / 2;
        Node[] new_array = new Node[newSize];
        if (numItems >= 0) System.arraycopy(heap, 0, new_array, 0, numItems);
        heap = new_array;
        size = newSize;
    }

    public void insert(Node el){
        if (size==numItems){
            resize(true);
        }
        heap[numItems++] = el;
        int cur = numItems-1;
        int curFreq = heap[cur].freq;
        int parentFreq = heap[parent(cur)].freq;
        while(curFreq<parentFreq){
            swap(cur, parent(cur));
            cur = parent(cur);
            curFreq = heap[cur].freq;
            parentFreq = heap[parent(cur)].freq;
        }
    }

    private void heapify(int pos){
        int curFreq = heap[pos].freq;
        int freqLeft = (leftChild(pos)<numItems) ? heap[leftChild(pos)].freq : Integer.MAX_VALUE ;
        int freqRight = (rightChild(pos)<numItems) ? heap[rightChild(pos)].freq : Integer.MAX_VALUE;
        if (curFreq > freqLeft && freqLeft<=freqRight){
            swap(pos, leftChild(pos));
            heapify(leftChild(pos));
        } else if (curFreq > freqRight) {
            swap(pos, rightChild(pos));
            heapify(rightChild(pos));
        }
    }

    public Node remove(){
        Node rem = heap[0];
        heap[0] = heap[--numItems];
        heapify(0);
        if (size > 0 && numItems <= size/4 ){
            resize(false);
        }
        return rem;
    }

}
