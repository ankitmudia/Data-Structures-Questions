package Queue;

public class QueuePractice {
    int front;
    int rear;
    int[] queueArr;
    int maxSize;
    int currSize;

    QueuePractice(int size) {
        this.maxSize = size;
        this.queueArr = new int[size];
        this.front = 0;
        this.rear = -1;
        this.currSize = 0;
    }

    void delete() {
        int temp = queueArr[front++];
        currSize--;
        System.out.println("Item removed from Queue: " + temp);
    }

    void peek() {
        System.out.println(queueArr[front]);
    }

    void insertInQueue(int x) {
        if (isFull()) {
            System.out.println("Queue is Full");
        } else {
            queueArr[++rear] = x;
            currSize++;
            System.out.println("Item added to Queue: " + x);
        }
    }

    boolean isEmpty() {
        return (currSize == 0);
    }

    boolean isFull() {
        return (currSize == maxSize);
    }

    void printQueue() {
        for (int i = 0; i < currSize; i++) {
            System.out.print(queueArr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueuePractice q = new QueuePractice(5);
        System.out.println(q.isEmpty());
        System.out.println(q.isFull());
        q.insertInQueue(1);
        q.insertInQueue(2);
        q.insertInQueue(3);
        q.insertInQueue(4);
        q.insertInQueue(5);
        q.insertInQueue(6);
        q.peek();
        q.printQueue();
        q.delete();
        q.peek();
        q.printQueue();
    }
}
