package Java_Stack;

class StackNode {
    char data;
    StackNode next;

    public StackNode(char data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private StackNode top;

    public Stack() {
        top = null;
    }

    // push = tambah data ke atas stack
    public void push(char data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top; // node baru menunjuk ke node lama
        top = newNode;      // update top
        System.out.println("Push: " + data);
        tampilkan();
    }

    // pop = ambil data dari atas stack
    public void pop() {
        if (top == null) {
            System.out.println("Stack kosong, tidak bisa pop!");
            return;
        }
        System.out.println("Pop: " + top.data);
        top = top.next; // geser ke bawah
        tampilkan();
    }

    // swap = tukar isi node dengan data tertentu
    public void swap(char a, char b) {
        if (top == null) return;

        StackNode nodeA = null, nodeB = null;
        StackNode current = top;

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

    // tampilkan isi stack dari atas ke bawah
    public void tampilkan() {
        StackNode current = top;
        System.out.print("Stack: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class StackDemo {
    public static void main(String[] args) {
        System.out.println("\n=== (:v) ===");
        Stack stack = new Stack();

        stack.pop(); // stack kosong

        stack.push('I');
        stack.push('N');
        stack.push('F');
        stack.push('O');

        stack.pop(); // keluarkan 'O'

        stack.swap('I', 'N'); // tukar isi node 'I' dengan 'N'
    }
}
