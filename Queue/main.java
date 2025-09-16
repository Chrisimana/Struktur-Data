package Java_Queue;

class QueueNode {
    char data;
    QueueNode next;

    public QueueNode(char data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    private QueueNode front, rear;

    public Queue() {
        front = rear = null;
    }

    public void enqueue(char data) {
        QueueNode newNode = new QueueNode(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Enqueue: " + data);
        tampilkan();
    }

    public void dequeue() {
        if (front == null) {
            System.out.println("Queue kosong, tidak bisa dequeue!");
            return;
        }
        System.out.println("Dequeue: " + front.data);
        front = front.next;
        if (front == null) rear = null;
        tampilkan();
    }

    public void swap(char a, char b) {
        if (front == null) return;

        QueueNode nodeA = null, nodeB = null;
        QueueNode current = front;
        while (current != null) {
            if (current.data == a) nodeA = current;
            if (current.data == b) nodeB = current;
            current = current.next;
        }

        if (nodeA != null && nodeB != null) {
            char temp = nodeA.data;
            nodeA.data = nodeB.data;
            nodeB.data = temp;
            System.out.println("Swap: " + a + " <-> " + b);
        } else {
            System.out.println("Tidak bisa swap, salah satu elemen tidak ditemukan.");
        }
        tampilkan();
    }

    public void tampilkan() {
        QueueNode current = front;
        System.out.print("Queue: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class QueueDemo {
    public static void main(String[] args) {
        System.out.println("\n=== (:)(:) ===");
        Queue queue = new Queue();
        queue.dequeue(); // dequeue kosong
        queue.enqueue('I');
        queue.enqueue('N');
        queue.enqueue('K');
        queue.enqueue('O');
        queue.dequeue();
        queue.swap('O', 'I');

    }
}
