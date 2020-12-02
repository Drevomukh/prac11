package prac11;

import java.util.Arrays;

public class ArrayQueueModule {
    private static int size;
    private static int front;
    private static int rear;
    private static Object[] data = new Object[10];

    static void fixCapacity(int capacity)
    {
        int len = data.length;
        if (capacity > len)
        {
            Object[] newElements = new Object[data.length * 2];
            int i = 0;
            while (rear != front)
            {
                newElements[i] = data[front];
                front = (front + 1) % len;
                i++;
            }
            front = 0;
            rear = len - 1;
            data = newElements;
        }
    }


    public static void enqueue(Object element)
    {
        assert element != null;
        fixCapacity(size + 2);
        data[rear] = element;
        rear = (rear + 1) % data.length;
        size++;
    }


    public static Object element()
    {
        assert size > 0;
        return data[front];
    }


    public static Object dequeue()
    {
        Object ret = element();
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return ret;
    }


    public static int size()
    {
        return size;
    }


    public static boolean isEmpty()
    {
        return (size == 0);
    }


    public static void clear()
    {
        front = 0;
        rear = 0;
        size = 0;
        data = new Object[10];
    }

    @Override
    public String toString() {
        return "ArrayQueueModule{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
