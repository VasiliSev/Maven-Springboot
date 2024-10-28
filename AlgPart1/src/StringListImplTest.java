import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    private final StringListImpl testList = new StringListImpl();

    @Test
    void addItem() {
        String expected = "test";
        assertEquals(expected, testList.add("test"));
    }

    @Test
    void addForIndex() {
        String expected = "test";
        assertEquals(expected, testList.add(9, "test"));
    }

    @org.junit.jupiter.api.Test
    void set() {
        String expected = "test";
        assertEquals(expected, testList.set(9, "test"));
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void testRemove() {
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

    @org.junit.jupiter.api.Test
    void getMyArray() {
    }

    @org.junit.jupiter.api.Test
    void setMyArray() {
    }
}