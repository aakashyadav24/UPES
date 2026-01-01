#include <stdio.h>
#define MAX 50

int tree[MAX];
int n;

void inputTree() {
    printf("Enter number of nodes in the binary tree: ");
    scanf("%d", &n);

    printf("Enter %d node values (level-wise):\n", n);
    for (int i = 0; i < n; i++) {
        printf("Node %d: ", i);
        scanf("%d", &tree[i]);
    }
}

void displayTree() {
    printf("\nBinary Tree (Array Representation):\n");
    for (int i = 0; i < n; i++) {
        printf("Index %d-->Data:- %d\n", i, tree[i]);
    }
}

void showRelations() {
    printf("\nParent–Child Relationships:\n");
    for (int i = 0; i < n; i++) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        printf("Parent: %d ", tree[i]);
        if (left < n)
            printf("| Left Child: %d", tree[left]);
        else
            printf("| Left Child: None");

        if (right < n)
            printf(" | Right Child: %d", tree[right]);
        else
            printf(" | Right Child: None");

        printf("\n");
    }
}

int main() {
    inputTree();
    displayTree();
    showRelations();
    return 0;
}
