#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

struct Node* front = NULL;
struct Node* rear = NULL;

int size = 0;   
int N = 5;      


void enqueue(int x) {
    if (size == N) {
        printf("Circular Queue Overflow\n");
        return;
    }

    struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
    temp->data = x;
    temp->next = NULL;

    if (front == NULL) {
        front = rear = temp;
        rear->next = front; 
    } else {
        rear->next = temp;
        rear = temp;
        rear->next = front;
    }

    size = (size + 1) % (N + 1);  
    printf("%d enqueued\n", x);
}


void dequeue() {
    if (front == NULL) {
        printf("Circular Queue Underflow\n");
        return;
    }

    int x;
    if (front == rear) {
        x = front->data;
        free(front);
        front = rear = NULL;
    } else {
        struct Node* temp = front;
        x = temp->data;
        front = front->next;
        rear->next = front;
        free(temp);
    }

    size--;
    printf("%d dequeued\n", x);
}


void display() {
    if (front == NULL) {
        printf("Circular Queue is empty\n");
        return;
    }

    printf("Circular Queue elements: ");
    struct Node* temp = front;
    do {
        printf("%d ", temp->data);
        temp = temp->next;
    } while (temp != front);
    printf("\n");
}

int main() {
    int choice, value;
    while (1) {
        printf("\n--- Circular Queue using Linked List ---\n");
        printf("1. Enqueue\n2. Dequeue\n3. Display\n4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value to enqueue: ");
                scanf("%d", &value);
                enqueue(value);
                break;
            case 2:
                dequeue();
                break;
            case 3:
                display();
                break;
            case 4:
                exit(0);
            default:
                printf("Invalid choice!\n");
        }
    }
    return 0;
}
