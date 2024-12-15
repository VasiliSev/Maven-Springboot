import java.util.Arrays;
import java.util.Objects;

import static java.util.Arrays.copyOf;
import static java.util.Arrays.sort;

public class IntegerListImpl implements IntegerList {

    private Integer[] myArray;
    private int size = 9;

    public IntegerListImpl(Integer[] myArray) {
        this.myArray = myArray;
    }

    public IntegerListImpl() {
        myArray = new Integer[10];
    }

    public IntegerListImpl(int initSize) {
        myArray = new Integer[initSize];
    }

    private void validateElement(Integer element) {
        if (element == null) {
            throw new NullElementException();
        }
    }

    private void validateIndex(int index) {
        if (index >= myArray.length || index < 0) {
            throw new IllegalIndexException();
        }
    }

    private void growIfNeeded() {
        if (size == myArray.length) {
            grow();
        }
    }

    public void grow() {
        myArray = copyOf(myArray, size + size / 2);
    }

    private void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin - 1;
        for (int j = 0; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private void swapElements(Integer[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    private boolean binarySearch(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (Objects.equals(item, arr[mid])) {
                return true;
            }
            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public Integer add(Integer item) {
        validateElement(item);
        myArray[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateElement(item);
        validateIndex(index);
        growIfNeeded();
        if (index == size) {
            myArray[size++] = item;
            return item;
        }
        System.arraycopy(myArray, index, myArray, index + 1, size - index);
        myArray[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateElement(item);
        myArray[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateElement(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = myArray[index];
        if (index != size) {
            System.arraycopy(myArray, index + 1, myArray, index, size - (index + 1));
        }
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] myArrayCopy = toArray();
        sort(myArrayCopy);
        return binarySearch(myArrayCopy, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(myArray[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (myArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        return myArray[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(myArray, size);
    }
}
