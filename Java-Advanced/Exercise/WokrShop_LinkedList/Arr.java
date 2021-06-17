package WokrShop_LinkedList;

public class Arr {

    private static final int INITIAL_CAPACITY = 4;
    private int[] arr;
    private int size;
    private int capacity;

    public Arr() {
        this.arr = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public void add(int element) {
         if (this.size == this.capacity) {

             this.resize();
         }
         this.arr[this.size++] = element;
    }

    public boolean contains(int element) {

        for (int i = 0; i < this.size ; i++) {
            if (arr[i] == element) {
                return true;
            }
        }
        return false;

    }



    private void resize() {
        this.capacity *= 2;
        int[] newArr = new int[this.capacity];

        for (int i = 0; i < this.size ; i++) {

            newArr[i] = this.arr[i];
        }
        this.arr = newArr;
    }

 @Override
    public String toString() {
        return String.format("%d",this.size);
 }
}
