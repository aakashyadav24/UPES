#include <stdio.h>
#include <limits.h> 

void findMaxSubarrayBruteForce(int arr[], int n) {
    int maxSum = INT_MIN;
    int startIdx = -1;
    int endIdx = -1;

    for (int i = 0; i < n; i++) {
        int currentSum = 0;
        
        for (int j = i; j < n; j++) {
            currentSum += arr[j];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                startIdx = i;
                endIdx = j;
            }
        }
    }

    printf("Maximum Subarray Sum: %d\n", maxSum);
    printf("Subarray: [");
    for (int k = startIdx; k <= endIdx; k++) {
        printf("%d", arr[k]);
        if (k < endIdx) {
            printf(", ");
        }
    }
    printf("]\n");
}

int main() {
    int n;
    printf("Enter the length of array: ");
    scanf("%d",&n);

    int arr[n],i;
    printf("Enter the values of array");
    for(i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }

    findMaxSubarrayBruteForce(arr, n);

    return 0;
}