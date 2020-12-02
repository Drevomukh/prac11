package prac11;

import java.util.ArrayList;


public class ArrayQueue<E> {
    private int size;
    private int front;
    private int rear;
    private int capacity;
    private ArrayList<E> data;

    public ArrayQueue() {
        capacity=10;
        data = new ArrayList<>(capacity);
    }

    private void fixCapacity()
    {
        int len = data.size()+2;
        if (len>capacity)
        {
            capacity = data.size()*2;
            ArrayList<E> newElements = new ArrayList<E>(capacity);
            int i = 0;
            while (rear != front)
            {
                newElements.set(front,data.get(front));
                front = (front + 1) % len;
                i++;
            }
            front = 0;
            rear = len - 1;
            data = newElements;
        }
    }


    public void enqueue(E element)
    {
        assert element != null;
        fixCapacity();

        data.add(element);
        rear = (rear + 1) % data.size();
        size++;
    }



    public E element()
    {
        assert size > 0;
        return data.get(front);
    }


    public E dequeue()
    {
        E first = element();
        data.remove(front);
        front = (front + 1) % data.size();
        size--;
        return first;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    public void clear()
    {
        front = 0;
        rear = 0;
        size = 0;
        data.clear();
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "data=" + data.toString() +
                '}';
    }
}