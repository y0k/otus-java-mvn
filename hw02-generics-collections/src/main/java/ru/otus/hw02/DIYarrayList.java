package ru.otus.hw02;

import java.util.*;

/*
 * DIY ArrayList
 * Написать свою реализацию ArrayList на основе массива.
 * class DIYarrayList<T> implements List<T>{...}
 *
 * Проверить, что на ней работают методы из java.util.Collections:
 * Collections.addAll(Collection<? super T> c, T... elements)
 * Collections.static <T> void copy(List<? super T> dest, List<? extends T> src)
 * Collections.static <T> void sort(List<T> list, Comparator<? super T> c)
 *
 * 1) Проверяйте на коллекциях с 20 и больше элементами.
 * 2) DIYarrayList должен имплементировать ТОЛЬКО ОДИН интерфейс - List.
 * 3) Если метод не имплементирован, то он должен выбрасывать исключение UnsupportedOperationException.
 */

public class DIYarrayList<T> implements List<T> {
    /*Размер листа*/
    private int size;

    /*массив для хранения элементов коллекции*/
    private Object[] dataArray;

    /*пустой массив для инициализации пустого значения коллекции*/
    private static final Object[] EMPTY_ARRAY = {};

    /*конструктор. подставляем пустой массив*/
    public DIYarrayList() {
        this.dataArray = EMPTY_ARRAY;
    }

    /*класс итератора*/
    private class DIYarrayListIterator implements ListIterator<T> {
        int cursor;     // индекс следующего элемента для возврата
        int lastRet = -1; // индекс последнего возвращаемого элемента

        /*конструктор*/
        DIYarrayListIterator() {
        }

        /*конструктор*/
        DIYarrayListIterator(int index) {
            super();
            cursor = index;
        }

        /*метод проверяющий на наличие следующего индекса*/
        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        /*берем следующий элемент*/
        @Override
        public T next() {

            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            cursor = i + 1;
            return (T) dataArray[lastRet = i];
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public T previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        /*помещаем элемент в лист данных!*/
        @Override
        public void set(T t) {
            if (lastRet < 0)
                throw new IllegalStateException();

            try {
                DIYarrayList.this.set(lastRet, t);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public void add(T t) {

        }
    }

    /*метод вовращает размер листа данных*/
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator iterator() {
        return new DIYarrayListIterator();
    }

    /*метод копирует массив*/
    @Override
    public Object[] toArray() {

        return Arrays.copyOf(dataArray, size);

    }

    /*расширяет массив*/
    private Object[] grow(int minCapacity) {
        return dataArray = Arrays.copyOf(dataArray, minCapacity);
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    /*добавляет элемент в лист*/
    private void add(T e, Object[] dataArray, int s) {

        if (s == dataArray.length)
            dataArray = grow();
        dataArray[s] = e;
        size = s + 1;
    }

    /*добавляем элемент в лист данных*/
    @Override
    public boolean add(T o) {
        add(o, dataArray, size);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    /*получаем элемент по индексу*/
    @Override
    public T get(int index) {
        return (T) dataArray[index];
    }

    /*устанавливаем элемент в индекс*/
    @Override
    public T set(int index, T element) {
        /*индекс в допустимом диапазоне?*/
        Objects.checkIndex(index, size);

        T oldValue = (T) dataArray[index];
        dataArray[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, Object element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator() {
        return new DIYarrayListIterator(0);
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException();
    }

    /*переопределяем для вывода*/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object str : dataArray) {
            sb.append(str.toString()).append(" ");
        }
        return sb.toString();
    }


}