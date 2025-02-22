package by.it.group251004.tanov.lesson09;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListB<E> implements List<E> {


    //Создайте аналог списка БЕЗ использования других классов СТАНДАРТНОЙ БИБЛИОТЕКИ

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Обязательные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    E[] list;
    private int size;
    private int capacity;
    ListB(){
        size = 0;
        capacity = 10;
        list = (E[]) new Object[capacity];
    }
    @Override
    public String toString() {
        String rez = new String();
        if(!this.isEmpty()) {
            rez = rez + "[";
            int i;
            for (i = 0; i < (size - 1); i++) {
                rez = rez + this.list[i] + ", ";
            }
            rez = rez + this.list[size - 1] + "]";
        }
        else{
            rez = "[]";
        }
        return rez;
    }

    @Override
    public boolean add(E e) {
        if(size == capacity){
            capacity = (int)(capacity*1.5);
            E[] list = (E[]) new Object[capacity];
            System.arraycopy(this.list, 0, list, 0, size);
            this.list = list;
        }
        this.list[size] = e;
        size = size + 1;
        return true;
    }

    @Override
    public E remove(int index) {
        E element = null;
        if((index < size) && (index > (-1))){
            size = size - 1;
            element = this.list[index];
            E[] l = (E[]) new Object[size - index];
            System.arraycopy(list, index + 1, l, 0, l.length);
            System.arraycopy(l, 0, list, index, l.length);
            this.list[size] = null;
            return element;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, E element) {
        while(index >= capacity){
            capacity = (int)(capacity * 1.5);
            E[] list = (E[]) new Object[capacity];
            System.arraycopy(this.list, 0, list, 0, size);
            this.list = list;
        }
        E[] l = (E[]) new Object[size - index];
        System.arraycopy(list, index, l, 0, l.length);
        list[index] = element;
        System.arraycopy(l, 0, list, index + 1, l.length);
        size = size + 1;
    }

    @Override
    public boolean remove(Object o) {
        if(this.contains(o)){
            this.remove(this.indexOf(o));
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public E set(int index, E element) {
        if((index < size) && (index > (-1))){
            E elt = list[index];
            list[index] = element;
            return elt;
        }
        return null;
    }


    @Override
    public boolean isEmpty() {
        return (size == 0);
    }


    @Override
    public void clear() {
        int i;
        for(i = 0; i < size; i++){
            list[i] = null;
        }
        size = 0;
    }

    @Override
    public int indexOf(Object o) {
        int i;
        for(i = 0; i < size; i++){
            if(list[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        if((index < size) && (index > (-1))){
            return list[index];
        }
        else {
            return null;
        }
    }

    @Override
    public boolean contains(Object o) {
        int i;
        for(i = 0; i < size; i++){
            if(list[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        int i;
        for(i = 0; i < size; i++){
            if(list[i].equals(o)){
                return i;
            }
        }
        return -1;
    }


    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Опциональные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////


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
