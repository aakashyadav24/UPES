#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* next;
} node;

node* head = NULL;   

void createnode() {
    node *q, *temp;
    temp = (node*)malloc(sizeof(node));
    printf("Enter data:");
    scanf("%d", &temp->data);
    temp->next = NULL;

    if (head == NULL) {
        head = temp;
    } else {
        q = head;
        while (q->next != NULL) {
            q = q->next;
        }
        q->next = temp;
    }
}

void display(node* h) {
    int k=1;
    while (h != NULL) {
        printf("Data %d: %d\n", k, h->data);
        h = h->next;
        k++;
    }
}

void displayMiddle(node *head){                                        
    node *slow,*fast;
    slow=fast=head;
    if(head==NULL){
        printf("The list is empty");
    }
    while(fast!=NULL && fast->next!=NULL){
        fast=fast->next->next;
        slow=slow->next;
    }
    printf("\nMiddle data:%d",slow->data);
}

node* deleteatBegin(node *head){
    if (head == NULL) {
        printf("\nList is already empty!\n");
        return NULL;
    }
    node *temp = head;
    head = head->next;
    free(temp);
    return head;
}


int main() {
    int n, i;
    printf("Enter the number of nodes: ");
    scanf("%d", &n);

    for (i = 0; i < n; i++) {
        createnode();
    }

    printf("Linked list contents:\n");
    display(head);
    displayMiddle(head);
    head = deleteatBegin(head);
    printf("\nNew list after deletion at the beginning:\n");
    display(head);

    return 0;
}
