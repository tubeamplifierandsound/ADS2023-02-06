package by.it.group251004.arefin.lesson09;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListA<E> implements List<E> {

    //Создайте аналог списка БЕЗ использования других классов СТАНДАРТНОЙ БИБЛИОТЕКИ
    E[] arr = (E[]) new Object[]{};
    int capacity = 0;  // real size
    int size = 0; // size for user
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Обязательные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        if (size == 0){
            return "[]";
        }
        for (int i = 0; i < size; i++) {
                result.append(arr[i].toString());
                result.append(", ");
        }
        if (arr.length > 0) {
            result.delete(result.length() - 2, result.length());
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public boolean add(E e) {
        if (capacity == size()) {
            capacity = (capacity * 3 / 2) + 1;
            E[] oldArr = arr;
            arr = (E[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                arr[i] = oldArr[i];
            }
        }
        arr[size] = e;
        size++;
        return true;
    }

    @Override
    public E remove(int index) {
        if (index <= size && index >= 0){
            E result = arr[index];
            for (int i = index; i < size; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
            return result;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Опциональные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////

    @Override
    public void add(int index, E element) {}

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }


    @Override
    public boolean isEmpty() {
        return false;
    }


    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }


    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    ////////        Эти методы имплементировать необязательно    ////////////
    ////////        но они будут нужны для корректной отладки    ////////////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    @Override
    public Iterator<E> iterator() {
        return null;
    }

}
