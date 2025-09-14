package Java_Queue;

import java.util.Scanner;

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
    private int size = 0;

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
        size++;
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
        size--;
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

    public void peek() {
        if (front != null) {
            System.out.println("Peek: " + front.data);
        } else {
            System.out.println("Queue kosong!");
        }
    }

    public void clear() {
        front = rear = null;
        size = 0;
        System.out.println("Queue telah dikosongkan.");
        tampilkan();
    }

    public int size() {
        return size;
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
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();
        char inputChar;
        boolean running = true;

        while (running) {
            System.out.println("\n==== MENU QUEUE ====");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Swap");
            System.out.println("4. Peek");
            System.out.println("5. Tampilkan Queue");
            System.out.println("6. Tampilkan Jumlah Elemen");
            System.out.println("7. Clear Queue");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan karakter untuk enqueue: ");
                    inputChar = scanner.nextLine().charAt(0);
                    queue.enqueue(inputChar);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    System.out.print("Masukkan karakter pertama: ");
                    char a = scanner.nextLine().charAt(0);
                    System.out.print("Masukkan karakter kedua: ");
                    char b = scanner.nextLine().charAt(0);
                    queue.swap(a, b);
                    break;
                case 4:
                    queue.peek();
                    break;
                case 5:
                    queue.tampilkan();
                    break;
                case 6:
                    System.out.println("Jumlah elemen dalam queue: " + queue.size());
                    break;
                case 7:
                    queue.clear();
                    break;
                case 0:
                    running = false;
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}
