package org.example.aston.collections;


import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class MyArrayList<T> {
    private final int DEFAULT_CAPACITY = 10;
    private T[] defaultArray = (T[]) new Object[DEFAULT_CAPACITY];
    private int arraySize = 0;

    public MyArrayList() {
    }

    public int size() {
        return this.arraySize;
    }

    private void resize(int newLength) {
        T[] newArray = (T[]) new Object[newLength];
        System.arraycopy(defaultArray, 0, newArray, 0, arraySize);
        defaultArray = newArray;
    }

    public void add(T object) {
        if (arraySize == defaultArray.length - 1)
            resize(defaultArray.length * 2);
        defaultArray[arraySize++] = object;
    }

    public boolean addAll(Collection<? extends T> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0) {
            return false;
        } else {
            Object[] elementData = defaultArray;
            int s = arraySize;
            if (numNew > defaultArray.length - s) {
                elementData = Arrays.copyOf(elementData, s + numNew);
            }

            System.arraycopy(a, 0, elementData, s, numNew);
            arraySize = s + numNew;
            return true;
        }
    }


    public T get(int index) {
        return defaultArray[index];
    }

    public void remove(int index) {
        for (int i = index; i < arraySize; i++)
            defaultArray[i] = defaultArray[i + 1];
        defaultArray[arraySize] = null;
        arraySize--;
        if (defaultArray.length > DEFAULT_CAPACITY && arraySize < defaultArray.length / 4)
            resize(defaultArray.length / 2);
    }

    public T set(int index, T element) {
        Objects.checkIndex(index, arraySize);
        T oldValue = defaultArray(index);
        defaultArray[index] = element;
        return oldValue;
    }

    T defaultArray(int index) {
        return this.defaultArray[index];
    }


    public static <T extends Comparable<T>> void bubbleSort(MyArrayList<T> list) {
        T temp;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
    }
}
