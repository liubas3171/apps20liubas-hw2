package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {
    private final Object[] array;

    public ImmutableArrayList() {
        array = new Object[0];

    }

    public ImmutableArrayList(Object[] array) {
        this.array = array.clone();
    }

    @Override
    public ImmutableList add(Object e) {
        Object[] newArray = {e};
        return this.myAdd(this.size(), newArray);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        checkerIndex(index);
        Object[] newArray = {e};
        return this.myAdd(index, newArray);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return this.myAdd(this.size(), c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        checkerIndex(index);
        return this.myAdd(index, c);
    }

    private ImmutableList myAdd(int index, Object[] c) {
        c = c.clone();
        Object[] newArray = new Object[this.size() + c.length];
        if (index >= 0) System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(c, 0, newArray, index, c.length);

        for (int i = 0; i < this.size() - index; i++) {
            newArray[index + c.length + i] = array[index + i];
        }

        return new ImmutableArrayList(newArray);
    }

    @Override
    public Object get(int index) {
        checkerIndex(index);
        return array[index];
    }

    @Override
    public ImmutableList remove(int index) {
        checkerIndex(index);

        Object[] newArray = new Object[this.size() - 1];
        int indNew = 0;
        int indOld = 0;
        while (indNew < newArray.length) {
            if (indOld == index) {
                indOld++;
            }
            newArray[indNew] = array[indOld];
            indNew++;
            indOld++;
        }
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        checkerIndex(index);

        Object[] newArray = array.clone();
        newArray[index] = e;
        return new ImmutableArrayList(newArray);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.size(); i++) {
            if (array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Object[] toArray() {
        return array.clone();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        for (int i = 0; i < this.size(); i++) {
            if (i == 0) {
                res.append(array[i]);
            } else {
                res.append(", ").append(array[i]);
            }
        }
        res.append("}");
        return res.toString();
    }

    private void checkerIndex(int index) {
        if (index >= this.size() || index < 0) {
            throw new IllegalArgumentException();
        }
    }
}
