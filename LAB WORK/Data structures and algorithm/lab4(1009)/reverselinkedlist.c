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

node * reverseLinkedList(node *head){
    node *pnode, *cnode, *nnode;
    pnode=nnode=NULL;
    cnode=head;
    while(cnode)
    {
        nnode=cnode->next;
        cnode->next=pnode;
        pnode=cnode;
        cnode=nnode;
    }
    return pnode;
}

node* reverseLinkedListPos(node* head, int m, int n) {
    node *pnode = NULL, *cnode = head, *nnode = NULL;
    node *tempnode1 = NULL, *tempnode2 = NULL;
    int k = 1;

    if (m == 1) {
        tempnode1 = NULL;
        tempnode2 = cnode;
    } else {
        while (k < m) {
            tempnode1 = cnode;
            cnode = cnode->next;
            k++;
        }
        tempnode2 = cnode;
    }

    pnode = NULL;
    while (cnode && m <= n) {
        nnode = cnode->next;
        cnode->next = pnode;
        pnode = cnode;
        cnode = nnode;
        m++;
    }

    if (tempnode1)  
        tempnode1->next = pnode;
    else          
        head = pnode;

    tempnode2->next = cnode;

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

    head=reverseLinkedList(head);
    printf("Reversed Linked List:\n");
    display(head); 
    
    int m, o;
    printf("Enter the positions you want to reverse the Linked List:");
    scanf("%d %d",&m,&o);
    head=reverseLinkedListPos(head, m ,o);
    printf("Reversed Linked List:\n");
    display(head);        

    return 0;
}
