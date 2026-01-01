#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *left, *right;
};

struct Node* createNode(int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->left = newNode->right = NULL;
    return newNode;
}

struct Node* createTree() {
    int data;
    printf("Enter root node data (-1 for no tree): ");
    scanf("%d", &data);

    if (data == -1)
        return NULL;

    struct Node* root = createNode(data);

    struct Node* queue[50];
    int front = 0, rear = 0;
    queue[rear++] = root;

    while (front < rear) {
        struct Node* current = queue[front++];

        printf("Enter left child of %d (-1 for no left child): ", current->data);
        scanf("%d", &data);
        if (data != -1) {
            current->left = createNode(data);
            queue[rear++] = current->left;
        }

        printf("Enter right child of %d (-1 for no right child): ", current->data);
        scanf("%d", &data);
        if (data != -1) {
            current->right = createNode(data);
            queue[rear++] = current->right;
        }
    }

    return root;
}

void levelOrder(struct Node* root) {
    if (root == NULL) {
        printf("Tree is empty.\n");
        return;
    }

    struct Node* queue[50];
    int front = 0, rear = 0;

    queue[rear++] = root;

    printf("Level Order Traversal: ");
    while (front < rear) {
        struct Node* current = queue[front++];
        printf("%d ", current->data);

        if (current->left)
            queue[rear++] = current->left;
        if (current->right)
            queue[rear++] = current->right;
    }
}

void preorder(struct Node* root) {
    if (root == NULL) return;
    printf("%d ", root->data);
    preorder(root->left);
    preorder(root->right);
}

void inorder(struct Node* root) {
    if (root == NULL) return;
    inorder(root->left);
    printf("%d ", root->data);
    inorder(root->right);
}

void postorder(struct Node* root) {
    if (root == NULL) return;
    postorder(root->left);
    postorder(root->right);
    printf("%d ", root->data);
}

int search(struct Node* root, int key) {
    if (root == NULL)
        return 0; 

    if (root->data == key)
        return 1;  

    return search(root->left, key) || search(root->right, key);
}

int main() {
    struct Node* root = createTree();
    printf("\n");
    levelOrder(root);
    
    printf("\nPreorder Traversal: ");
    preorder(root);

    printf("\nInorder Traversal: ");
    inorder(root);

    printf("\nPostorder Traversal: ");
    postorder(root);

    int key;
    printf("\n\nEnter element to search: ");
    scanf("%d", &key);

    if (search(root, key))
        printf("Element %d found in the tree.\n", key);
    else
        printf("Element %d not found in the tree.\n", key);

    return 0;
}
