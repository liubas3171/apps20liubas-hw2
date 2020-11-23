package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private final double delta = 0.00001;

    @Test
    public void testEmptyConstructorEmptyForever() {
        ImmutableLinkedList lst = new ImmutableLinkedList();

        int expVal = 0;
        int actVal = lst.size();
        assertEquals(expVal, actVal, delta);
    }

    @Test
    public void testEmptyConstructorAddedEl() {
        ImmutableLinkedList lst = new ImmutableLinkedList();

        ImmutableList newLst = lst.add(34);

        int expVal = 0;
        int actVal = lst.size();
        assertEquals(expVal, actVal, delta);

        int expNewLstSize = 1;
        int actNewLstSize = newLst.size();
        assertEquals(expNewLstSize, actNewLstSize, delta);
    }

    @Test
    public void testAddWithoutIndex() {
        Integer[] array = {1, 2, 3, 4, 5};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        ImmutableList newLst = lst.add(34);

        Object[] expRes = {1, 2, 3, 4, 5, 34};
        Object[] actRes = newLst.toArray();
        assertArrayEquals(expRes, actRes);

        int expOldSize = 5;
        int actOldSize = lst.size();
        assertEquals(expOldSize, actOldSize, delta);

        int expNewSize = 6;
        int actNewSize = newLst.size();
        assertEquals(expNewSize, actNewSize, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithIndexTooBigIndex() {
        Integer[] array = {1, 2, 3, 4, 5};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        lst.add(100, 33);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithIndexEqualToLen() {
        Integer[] array = {1, 2, 3, 4, 5};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        lst.add(5, 33);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithIndexLessThanZero() {
        Integer[] array = {1, 2, 3, 4, 5};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        lst.add(-1, 33);
    }

    @Test
    public void testAddWithIndexJustValue() {
        Integer[] array = {1, 2, 3, 4, 5};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        ImmutableList newLst = lst.add(0, 33);

        Object[] expNewRes = {33, 1, 2, 3, 4, 5};
        Object[] actNewRes = newLst.toArray();
        assertArrayEquals(expNewRes, actNewRes);

        Object[] expOldRes = {1, 2, 3, 4, 5};
        Object[] actOldSize = lst.toArray();
        assertArrayEquals(expOldRes, actOldSize);
    }

    @Test
    public void testAddAllEndOfArray() {
        Integer[] array = {1, 2, 3, 4, 5};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] smt = {1, 2, 3};

        ImmutableList newLst = lst.addAll(smt);

        Object[] expNewRes = {1, 2, 3, 4, 5, 1, 2, 3};
        Object[] actNewRes = newLst.toArray();
        assertArrayEquals(expNewRes, actNewRes);

        Object[] expOldRes = {1, 2, 3, 4, 5};
        Object[] actOldSize = lst.toArray();
        assertArrayEquals(expOldRes, actOldSize);
    }

    @Test
    public void testAddAllEndOfArrayEmptyNew() {
        Integer[] array = {1, 2, 3, 4, 5};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] smt = {};

        ImmutableList newLst = lst.addAll(smt);

        Object[] expNewRes = {1, 2, 3, 4, 5};
        Object[] actNewRes = newLst.toArray();
        assertArrayEquals(expNewRes, actNewRes);

        Object[] expOldRes = {1, 2, 3, 4, 5};
        Object[] actOldSize = lst.toArray();
        assertArrayEquals(expOldRes, actOldSize);
    }

    @Test
    public void testAddAllEndOfArrayEmptyOld() {
        Integer[] array = {};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] smt = {1, 2, 3};

        ImmutableList newLst = lst.addAll(smt);

        Object[] expNewRes = {1, 2, 3};
        Object[] actNewRes = newLst.toArray();
        assertArrayEquals(expNewRes, actNewRes);

        Object[] expOldRes = {};
        Object[] actOldSize = lst.toArray();
        assertArrayEquals(expOldRes, actOldSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAllWithIndexIndexBiggerThanLen() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] smt = {1, 2, 3};

        lst.addAll(4, smt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAllWithIndexIndexLessThanZero() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] smt = {1, 2, 3};

        lst.addAll(-1, smt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAllWithIndexIndexEqualLen() {
        Integer[] array = {1, 2};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] smt = {1, 2, 3};

        lst.addAll(2, smt);
    }

    @Test
    public void testAddAllWithIndexEmtpyNew() {
        Integer[] array = {1, 2};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] smt = {};

        ImmutableList newLst = lst.addAll(1, smt);

        Object[] expNewRes = {1, 2};
        Object[] actNewRes = newLst.toArray();
        assertArrayEquals(expNewRes, actNewRes);

        Object[] expOldRes = {1, 2};
        Object[] actOldSize = lst.toArray();
        assertArrayEquals(expOldRes, actOldSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAllWithIndexIndexEmtpyOld() {
        Integer[] array = {};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] smt = {1, 2, 3};

        lst.addAll(0, smt);
    }

    @Test
    public void testAddAllWithIndexStandartUse() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] smt = {4, 5, 6};

        ImmutableList newLst = lst.addAll(1, smt);

        Object[] expNewRes = {1, 4, 5, 6, 2, 3};
        Object[] actNewRes = newLst.toArray();
        assertArrayEquals(expNewRes, actNewRes);

        Object[] expOldRes = {1, 2, 3};
        Object[] actOldSize = lst.toArray();
        assertArrayEquals(expOldRes, actOldSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetIndexBiggerThanLen() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        lst.get(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetIndexLessThanZero() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        lst.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetIndexEqualLen() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        lst.get(3);
    }

    @Test
    public void testGetClassicalUse() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        int expRes = 1;
        int actRes = (int) lst.get(0);
        assertEquals(expRes, actRes, this.delta);

        Object[] smt = {1, 2, 3};
        assertArrayEquals(smt, lst.toArray());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testRemoveIndexBigger() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        lst.remove(4);
    }

    @Test
    public void testRemoveClassic() {
        Integer[] array = {1, 2, 3, 4};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] expRes = {1, 2, 4};
        Object[] actRes = lst.remove(2).toArray();
        assertArrayEquals(expRes, actRes);

        Object[] expOld = {1, 2, 3, 4};
        Object[] actOld = lst.toArray();
        assertArrayEquals(expOld, actOld);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveIndexEqualLen() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        lst.remove(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveIndexLessThanZero() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        lst.remove(-1);
    }

    @Test
    public void testRemoveClassicalUse() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] expRes = {2, 3};
        Object[] actRes = lst.remove(0).toArray();
        assertArrayEquals(expRes, actRes);

        Object[] expOld = {1, 2, 3};
        Object[] actOld = lst.toArray();
        assertArrayEquals(expOld, actOld);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testsetIndexBigger() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        lst.set(4, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testsetIndexLessThanZero() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        lst.set(-1, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testsetIndexEqualLen() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        lst.set(3, 5);
    }

    @Test
    public void testSetClassic() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] expRes = {0, 2, 3};
        Object[] actRes = lst.set(0, 0).toArray();
        assertArrayEquals(expRes, actRes);

        Object[] expOld = {1, 2, 3};
        Object[] actOld = lst.toArray();
        assertArrayEquals(expOld, actOld);
    }

    @Test
    public void testSetClassicAlso() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] expRes = {1, 2, 55};
        Object[] actRes = lst.set(2, 55).toArray();
        assertArrayEquals(expRes, actRes);

        Object[] expOld = {1, 2, 3};
        Object[] actOld = lst.toArray();
        assertArrayEquals(expOld, actOld);
    }

    @Test
    public void testIndexOfNoValue() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        int expRes = -1;
        int actRes = lst.indexOf(55);
        assertEquals(expRes, actRes);

        Object[] expOld = {1, 2, 3};
        Object[] actOld = lst.toArray();
        assertArrayEquals(expOld, actOld);
    }

    @Test
    public void testIndexOfFewValues() {
        Integer[] array = {1, 2, 3, 5, 6, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        int expRes = 2;
        int actRes = lst.indexOf(3);
        assertEquals(expRes, actRes);

        Object[] expOld = {1, 2, 3, 5, 6, 3};
        Object[] actOld = lst.toArray();
        assertArrayEquals(expOld, actOld);
    }

    @Test
    public void testIndexOfClassic() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        int expRes = 2;
        int actRes = lst.indexOf(3);
        assertEquals(expRes, actRes);

        Object[] expOld = {1, 2, 3};
        Object[] actOld = lst.toArray();
        assertArrayEquals(expOld, actOld);
    }

    @Test
    public void testSizeEmpty() {
        Integer[] array = {};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        int expRes = 0;
        int actRes = lst.size();
        assertEquals(expRes, actRes);
    }

    @Test
    public void testSizeClassic() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        int expRes = 3;
        int actRes = lst.size();
        assertEquals(expRes, actRes);
    }

    @Test
    public void testSizeAddedLater() {
        Integer[] array = {1, 2};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        int expRes = 2;
        int actRes = lst.size();
        assertEquals(expRes, actRes);

        ImmutableList newArray = lst.add(5);
        int expResOld = 2;
        int actResOld = lst.size();
        assertEquals(expResOld, actResOld);
        expRes = 3;
        actRes = newArray.size();
        assertEquals(expRes, actRes);

        newArray = lst.add(0, 6);
        expResOld = 2;
        actResOld = lst.size();
        assertEquals(expResOld, actResOld);
        expRes = 3;
        actRes = newArray.size();
        assertEquals(expRes, actRes);

        Object[] smt = {1, 2, 3};
        newArray = lst.addAll(smt);
        expResOld = 2;
        actResOld = lst.size();
        assertEquals(expResOld, actResOld);
        expRes = 5;
        actRes = newArray.size();
        assertEquals(expRes, actRes);

        Object[] smt1 = {5, 6, 7, 6};
        newArray = lst.addAll(1, smt1);
        expResOld = 2;
        actResOld = lst.size();
        assertEquals(expResOld, actResOld);
        expRes = 6;
        actRes = newArray.size();
        assertEquals(expRes, actRes);
    }

    @Test
    public void testClearEmpty() {
        Integer[] array = {};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        ImmutableList newArray = lst.clear();

        assertEquals(0, newArray.size());
        Object[] smt = {};
        assertArrayEquals(smt, newArray.toArray());
    }

    @Test
    public void testClearClassic() {
        Integer[] array = {1, 2, 3, 4};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        ImmutableList newArray = lst.clear();

        assertEquals(0, newArray.size());
        Object[] smt = {};
        assertArrayEquals(smt, newArray.toArray());

        int expOldSize = 4;
        int actOldSize = lst.size();
        assertEquals(expOldSize, actOldSize);

        Object[] expOldArray = {1, 2, 3, 4};
        Object[] actOldArray = lst.toArray();
        assertArrayEquals(expOldArray, actOldArray);
    }

    @Test
    public void testIsEmptyEmpty() {
        Integer[] array = {};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        assertTrue(lst.isEmpty());
    }

    @Test
    public void testIsEmptyNotEmpty() {
        Integer[] array = {1};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        assertFalse(lst.isEmpty());
    }

    @Test
    public void testToArrayEmpty() {
        Integer[] array = {};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] expRes = {};
        assertArrayEquals(expRes, lst.toArray());
    }

    @Test
    public void testToArrayClassic() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] expRes = {1, 2, 3};
        assertArrayEquals(expRes, lst.toArray());
    }

    @Test
    public void testToArrayAddedEls() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] smt = {5, 6};
        ImmutableList newList = lst.addAll(1, smt);

        Object[] expRes = {1, 5, 6, 2, 3};
        assertArrayEquals(expRes, newList.toArray());

        Object[] expOld = {1, 2, 3};
        assertArrayEquals(expOld, lst.toArray());
    }

    @Test
    public void testToStringEmpty() {
        Integer[] array = {};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        String expRes = "{}";
        String actRes = lst.toString();

        assertEquals(expRes, actRes);
    }

    @Test
    public void testToStringClassic() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        String expRes = "{1, 2, 3}";
        String actRes = lst.toString();

        assertEquals(expRes, actRes);
    }

    @Test
    public void testAddFirstClassic() {
        Integer[] array = {1, 2, 3};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        ImmutableLinkedList newLst = lst.addFirst(44);

        Object actRes = newLst.get(0);
        assertEquals(44, actRes);

        assertEquals(4, newLst.size());

        assertEquals(3, lst.size());

        Object[] newArr = {44, 1, 2, 3};
        assertArrayEquals(newArr, newLst.toArray());

    }

    @Test
    public void testAddFirstEmptyList() {
        Integer[] array = {};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        ImmutableLinkedList newLst = lst.addFirst(44);

        Object actRes = newLst.get(0);
        assertEquals(44, actRes);

        assertEquals(1, newLst.size());

        assertEquals(0, lst.size());
    }

    @Test
    public void testAddLastEmptyList() {
        Integer[] array = {};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        ImmutableLinkedList newLst = lst.addLast(44);

        Object actRes = newLst.get(0);
        assertEquals(44, actRes);

        assertEquals(1, newLst.size());

        assertEquals(0, lst.size());
    }

    @Test
    public void testAddLastClassic() {
        Integer[] array = {1, 2, 3, 4};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        ImmutableLinkedList newLst = lst.addLast(44);

        Object actRes = newLst.get(4);
        assertEquals(44, actRes);

        assertEquals(5, newLst.size());

        assertEquals(4, lst.size());

        Object[] newArr = {1, 2, 3, 4, 44};
        assertArrayEquals(newArr, newLst.toArray());

    }

    @Test
    public void testAddLastOneEl() {
        Integer[] array = {2};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        ImmutableLinkedList newLst = lst.addLast(44);

        Object actRes = newLst.get(1);
        assertEquals(44, actRes);

        assertEquals(2, newLst.size());

        assertEquals(1, lst.size());
    }

    @Test
    public void testGetFirstClassic() {
        Integer[] array = {2, 4, 8};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object newObj = lst.getFirst();
        assertEquals(2, newObj);
        assertEquals(3, lst.size());
    }

    @Test
    public void testGetLastClassic() {
        Integer[] array = {2, 4, 8};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object newObj = lst.getLast();
        assertEquals(8, newObj);
        assertEquals(3, lst.size());
    }

    @Test
    public void testGetLastOneEl() {
        Integer[] array = {2};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object newObj = lst.getLast();
        assertEquals(2, newObj);
        assertEquals(1, lst.size());
    }

    @Test
    public void testRemoveFirstClassic() {
        Integer[] array = {2, 4, 5};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] actArr = lst.removeFirst().toArray();
        Object[] expArr = {4, 5};
        assertArrayEquals(expArr, actArr);

        actArr = lst.toArray();
        expArr = new Object[]{2, 4, 5};
        assertArrayEquals(actArr, expArr);
    }

    @Test
    public void testRemoveFirstOneEl() {
        Integer[] array = {2};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] actArr = lst.removeFirst().toArray();
        Object[] expArr = {};
        assertArrayEquals(expArr, actArr);

        actArr = lst.toArray();
        expArr = new Object[]{2};
        assertArrayEquals(actArr, expArr);
    }

    @Test
    public void testRemoveLastOneEl() {
        Integer[] array = {2};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] actArr = lst.removeLast().toArray();
        Object[] expArr = {};
        assertArrayEquals(expArr, actArr);

        actArr = lst.toArray();
        expArr = new Object[]{2};
        assertArrayEquals(actArr, expArr);
    }

    @Test
    public void testRemoveLastClassic() {
        Integer[] array = {2, 4, 6, 8};
        ImmutableLinkedList lst = new ImmutableLinkedList(array);

        Object[] actArr = lst.removeLast().toArray();
        Object[] expArr = {2, 4, 6};
        assertArrayEquals(expArr, actArr);

        actArr = lst.toArray();
        expArr = new Object[]{2, 4, 6, 8};
        assertArrayEquals(actArr, expArr);
    }
}
