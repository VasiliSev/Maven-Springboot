import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {

    private final IntegerListImpl testList = new IntegerListImpl();

    @org.junit.jupiter.api.Test
    void add() {
        Integer expected = 123;
        assertEquals(expected, testList.add(123));
    }

    @org.junit.jupiter.api.Test
    void addForIndex() {
        Integer expected = 123;
        assertEquals(expected, testList.add(9,123));
    }

    @org.junit.jupiter.api.Test
    void set() {
        Integer expected = 123;
        assertEquals(expected, testList.set(9, 123));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        testList.add(8,123);
        Integer expected = 123;
        assertEquals(expected, testList.remove(8));
    }



    @org.junit.jupiter.api.Test
    void contains() {

    }

    @org.junit.jupiter.api.Test
    void indexOf() {
    }

    @org.junit.jupiter.api.Test
    void lastIndexOf() {
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
    }

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void toArray() {
    }
}