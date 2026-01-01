#include<stdio.h>
#include<stdlib.h>

void main(){
    int n;
    printf("Enter the length of array: ");
    scanf("%d",&n);

    int arr[n],i;
    printf("Enter the values of array");
    for(i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    int k;
    printf("Enter the value of k: ");
    scanf("%d",&k);
    
    int left = 0;        
    int right = 0;       
    int zeroCount = 0;   
    int maxLen = 0;      

    while (right < n) {
        if (arr[right] == 0) {
            zeroCount++; 
        }

        
        while (zeroCount > k) {
            if (arr[left] == 0) {
                zeroCount--; 
            }
            left++; 
        }

        
        int currentWindowLength = right - left + 1;
        if (currentWindowLength > maxLen) {
            maxLen = currentWindowLength;
        }

        right++; 
    }

    
    printf("Maximum consecutive ones after flipping at most %d zeros: %d\n", k, maxLen);

    

}