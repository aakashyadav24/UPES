#include<stdio.h>


void main() {
    int n;
    printf("Enter the length of array: ");
    scanf("%d",&n);

    int arr[n],i;
    printf("Enter the values of array");
    for(i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    int max_c= arr[0];
    int max_g=arr[0];
    int start=0,end=0,s=0;
    for(i=1;i<n;i++){
        if(arr[i]>(max_c+arr[i])){
            max_c=arr[i];
            s=i;
        }
        else
            max_c=max_c+arr[i];
        if(max_c>max_g){
            max_g=max_c;
            start=s;
            end=i;
        }      
    }
    printf("Maximum Subarray Sum: %d\n", max_g);
    printf("Subarray: [");
    for (int k = start; k <= end; k++) {
        printf("%d", arr[k]);
        if (k < end) {
            printf(", ");
        }
    }
    printf("]\n");
}