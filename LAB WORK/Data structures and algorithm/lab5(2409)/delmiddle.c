#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int stack[MAX];
int top = -1;

void push(int x) {
    if (top == MAX - 1) {
        printf("Stack Overflow\n");
        return;
    }
    stack[++top] = x;
}

int pop() {
    if (top == -1) {
        printf("Stack Underflow\n");
        return -1;
    }
    return stack[top--];
}

int isEmpty() {
    return top == -1;
}

void deleteMiddleUntil(int current, int size) {
    if (isEmpty() || current == size) {
        return;
    }

    int x = pop();
    
    if (current != size / 2) {
        deleteMiddleUntil(current + 1, size);
        push(x);
    } else {
        deleteMiddleUntil(current + 1, size); 
    }
}

void deleteMiddle() {
    int size = top + 1; 
    deleteMiddleUntil(0, size);
}

void printStack() {
    for (int i = top; i >= 0; i--) {
        printf("%d ", stack[i]);
    }
    printf("\n");
}

int main() {
    int n, val;

    printf("Enter number of elements in stack: ");
    scanf("%d", &n);

    printf("Enter %d elements: ", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &val);
        push(val);
    }

    printf("\nOriginal Stack (Top to Bottom): ");
    printStack();

    deleteMiddle();

    printf("After Deleting Middle Element: ");
    printStack();

    return 0;
}
