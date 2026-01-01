#include <stdio.h>
#include <stdlib.h>

// Define the structure for a linked list node
struct Node {
    int data;
    struct Node* next;
};

// Function to create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    if (newNode == NULL) {
        printf("Memory allocation failed!\n");
        exit(EXIT_FAILURE);
    }
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

// Function to print the linked list
void printList(struct Node* head) {
    struct Node* current = head;
    while (current != NULL) {
        printf("%d -> ", current->data);
        current = current->next;
    }
    printf("NULL\n");
}

// Function to merge two sorted linked lists
struct Node* mergeTwoLists(struct Node* l1, struct Node* l2) {
    // Create a dummy node to simplify the merging process
    struct Node* dummyHead = createNode(0); 
    struct Node* current = dummyHead;

    while (l1 != NULL && l2 != NULL) {
        if (l1->data <= l2->data) {
            current->next = l1;
            l1 = l1->next;
        } else {
            current->next = l2;
            l2 = l2->next;
        }
        current = current->next;
    }

    // Append the remaining nodes of whichever list is not exhausted
    if (l1 != NULL) {
        current->next = l1;
    } else if (l2 != NULL) {
        current->next = l2;
    }

    // The merged list starts from the next of the dummy head
    struct Node* mergedHead = dummyHead->next;
    free(dummyHead); // Free the dummy node
    return mergedHead;
}

int main() {
    // Create first sorted linked list: 1 -> 3 -> 5
    struct Node* l1 = createNode(1);
    l1->next = createNode(3);
    l1->next->next = createNode(5);

    // Create second sorted linked list: 2 -> 4 -> 6
    struct Node* l2 = createNode(2);
    l2->next = createNode(4);
    l2->next->next = createNode(6);

    printf("List 1: ");
    printList(l1);
    printf("List 2: ");
    printList(l2);

    struct Node* mergedList = mergeTwoLists(l1, l2);

    printf("Merged List: ");
    printList(mergedList);

    // Free the allocated memory (important to prevent memory leaks)
    struct Node* temp;
    while (mergedList != NULL) {
        temp = mergedList;
        mergedList = mergedList->next;
        free(temp);
    }

    return 0;
}