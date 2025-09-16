#include <iostream>
using namespace std;

class QueueNode {
public:
    char data;
    QueueNode* next;

    QueueNode(char data) {
        this->data = data;
        this->next = nullptr;
    }
};

class Queue {
private:
    QueueNode* front;
    QueueNode* rear;

public:
    Queue() {
        front = rear = nullptr;
    }

    void enqueue(char data) {
        QueueNode* newNode = new QueueNode(data);
        if (rear == nullptr) {
            front = rear = newNode;
        } else {
            rear->next = newNode;
            rear = newNode;
        }
        cout << "Enqueue: " << data << endl;
        tampilkan();
    }

    void dequeue() {
        if (front == nullptr) {
            cout << "Queue kosong, tidak bisa dequeue!" << endl;
            return;
        }
        cout << "Dequeue: " << front->data << endl;
        QueueNode* temp = front;
        front = front->next;
        if (front == nullptr) rear = nullptr;
        delete temp;
        tampilkan();
    }

    void swap(char a, char b) {
        if (front == nullptr) return;

        QueueNode* nodeA = nullptr;
        QueueNode* nodeB = nullptr;
        QueueNode* current = front;

        while (current != nullptr) {
            if (current->data == a) nodeA = current;
            if (current->data == b) nodeB = current;
            current = current->next;
        }

        if (nodeA != nullptr && nodeB != nullptr) {
            char temp = nodeA->data;
            nodeA->data = nodeB->data;
            nodeB->data = temp;
            cout << "Swap: " << a << " <-> " << b << endl;
        } else {
            cout << "Tidak bisa swap, salah satu elemen tidak ditemukan." << endl;
        }
        tampilkan();
    }

    void tampilkan() {
        QueueNode* current = front;
        cout << "Queue: ";
        while (current != nullptr) {
            cout << current->data << " ";
            current = current->next;
        }
        cout << endl;
    }
};

int main() {
    cout << "\n=== (:v) ===" << endl;
    Queue queue;
    queue.dequeue(); // dequeue kosong
    queue.enqueue('I');
    queue.enqueue('N');
    queue.enqueue('F');
    queue.enqueue('O');
    queue.dequeue();
    queue.swap('O', 'N');

    return 0;
}
