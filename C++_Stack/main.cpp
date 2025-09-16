#include <iostream>
using namespace std;

class StackNode {
public:
    char data;
    StackNode* next;

    StackNode(char data) {
        this->data = data;
        this->next = nullptr;
    }
};

class Stack {
private:
    StackNode* top;

public:
    Stack() {
        top = nullptr;
    }

    void push(char data) {
        StackNode* newNode = new StackNode(data);
        newNode->next = top;
        top = newNode;
        cout << "Push: " << data << endl;
        tampilkan();
    }

    void pop() {
        if (top == nullptr) {
            cout << "Stack kosong, tidak bisa pop!" << endl;
            return;
        }
        cout << "Pop: " << top->data << endl;
        StackNode* temp = top;
        top = top->next;
        delete temp;
        tampilkan();
    }

    void swap(char a, char b) {
        if (top == nullptr) return;

        StackNode* nodeA = nullptr;
        StackNode* nodeB = nullptr;
        StackNode* current = top;

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
        StackNode* current = top;
        cout << "Stack: ";
        while (current != nullptr) {
            cout << current->data << " ";
            current = current->next;
        }
        cout << endl;
    }
};

int main() {
    cout << "\n=== STACK DEMO (:v) ===" << endl;
    Stack stack;
    stack.pop(); // pop kosong
    stack.push('I');
    stack.push('N');
    stack.push('K');
    stack.push('O');
    stack.pop();
    stack.swap('I', 'O');

    return 0;
}
