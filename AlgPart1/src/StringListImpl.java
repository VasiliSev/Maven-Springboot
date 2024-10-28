import java.util.Arrays;

public class StringListImpl implements StringList {

    private String[] myArray;
    private int size;

    public StringListImpl(String[] myArray) {
        this.myArray = myArray;
    }

    public StringListImpl() {
        myArray = new String[10];
    }

    public StringListImpl(int initSize) {
        myArray = new String[initSize];
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize() {
        if (size == myArray.length) {
            throw new MyArrayIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index >= myArray.length || index < 0) {
            throw new IllegalIndexException();
        }
    }

    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        myArray[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateIndex(index);
        validateItem(item);
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
    public String set(int index, String item) {
        validateSize();
        validateIndex(index);
        validateItem(item);
        myArray[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = myArray[index];
        if (index != size) {
            System.arraycopy(myArray, index+1, myArray, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (myArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (myArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return myArray[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        int size = 0;
        for (String s : myArray) {
            if (s != null) {
                size++;
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }


    @Override
    public String[] toArray() {
        return Arrays.copyOf(myArray, size);
    }

    public String[] getMyArray() {
        return myArray;
    }

    public void setMyArray(String[] myArray) {
        this.myArray = myArray;
    }
}
