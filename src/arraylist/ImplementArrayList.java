package arraylist;

/**
 * add(int val)
 * delete(int target)
 * size()
 * increaseCapacity()
 * decreaseCapacity()
 */
public class ImplementArrayList {
    int initialCapacity = 10;
    int[] arrayList = new int[initialCapacity];
    int size = 0;
    int currentCapacity = 0;

    ImplementArrayList() {

    }

    public void add(int val) {
        checkCapacity();
        arrayList[size] = val;
        size++;
    }

    public void insert(int index, int val) {
        if (index > currentCapacity || index < 0) {
            return;
        }
        checkCapacity();
        int[] newArr = new int[currentCapacity];
        for (int i = 0; i < index; i++) {
            newArr[i] = arrayList[i];
        }
        newArr[index] = val;
        for (int j = index + 1; j < arrayList.length; j++) {
            newArr[j] = arrayList[j - 1];
        }
        arrayList = newArr;
    }

    private void checkCapacity() {
        if (size + 1 > arrayList.length) {
            increaseCapacity();
        } else if (size < arrayList.length * 2 && size > 10) {
            decreaseCapacity();
        } else {
            currentCapacity = initialCapacity;
        }

    }

    public void delete(int index) {
        checkCapacity();
        int[] newArr = new int[currentCapacity];
        for (int i = 0; i < index; i++) {
            newArr[i] = arrayList[i];
        }
        for (int j = index; j < arrayList.length - 1; j++) {
            newArr[j] = arrayList[j + 1];
        }
        arrayList = newArr;
    }

    public int size() {
        return size;
    }

    public void increaseCapacity() {
        int newSize = size + size * 2;
        int[] newArr = new int[newSize];
        for (int i = 0; i < arrayList.length; i++) {
            newArr[i] = arrayList[i];
        }
        arrayList = newArr;
        currentCapacity = newSize;
    }

    public void decreaseCapacity() {
        /**
         *  int newSize = size / 2;
         int[] newArr = new int[size / 2];
         for (int i = 0; i < arrayList.length; i++) {
         newArr[i] = arrayList[i];
         }
         arrayList = newArr;
         */
    }

    public int get(int index) {
        for (int i = 0; i < index; i++) {
            if (index == i) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < arrayList.length; i++) {
            System.out.print(arrayList[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ImplementArrayList arrayList = new ImplementArrayList();
        System.out.println("size: " + arrayList.size());
//       for (int i = 0; i < 20; i++) {
//           arrayList.add(i);
//       }
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(4);
        arrayList.print();
        arrayList.insert(2, 3);
        arrayList.insert(4, 5);
        arrayList.print();
        arrayList.delete(3);
        arrayList.print();
    }

}
