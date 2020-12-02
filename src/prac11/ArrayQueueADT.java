package prac11;

import java.util.Arrays;

public class ArrayQueueADT {
    private int size;
    private int front;
    private int rear;
    private Object[] data = new Object[10];

    static void fixCapacity(ArrayQueueADT queue, int capacity)
    {
        assert queue != null;
        int len = queue.data.length;
        if (capacity > len)
        {
            Object[] newElements = new Object[queue.data.length * 2];
            int i = 0;
            while (queue.rear !=queue.front)
            {
                newElements[i] = queue.data[queue.front];
                queue.front = (queue.front + 1) % len;
                i++;
            }
            queue.front = 0;
            queue.rear = len - 1;
            queue.data = newElements;
        }
    }

    public static void enqueue(ArrayQueueADT queue, Object element)
    {
        assert queue != null;
        assert element != null;
        fixCapacity(queue, queue.size + 2);
        queue.data[queue.rear] = element;
        queue.rear = (queue.rear + 1) % queue.data.length;
        queue.size++;
    }


    public static Object element(ArrayQueueADT queue)
    {
        assert queue != null;
        assert queue.size > 0;
        return queue.data[queue.front];
    }


    public static Object dequeue(ArrayQueueADT queue)
    {
        assert queue != null;
        Object ret = element(queue);
        queue.data[queue.front] = null;
        queue.front = (queue.front + 1) % queue.data.length;
        queue.size--;
        return ret;
    }


    public static int size(ArrayQueueADT queue)
    {
        assert queue != null;
        return queue.size;
    }


    public static boolean isEmpty(ArrayQueueADT queue)
    {
        assert queue != null;
        return (queue.size == 0);
    }


    public static void clear(ArrayQueueADT queue)
    {
        assert queue != null;
        queue.front = 0;
        queue.rear = 0;
        queue.size = 0;
        queue.data = new Object[10];
    }

    @Override
    public String toString() {
        return "ArrayQueueADT{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
