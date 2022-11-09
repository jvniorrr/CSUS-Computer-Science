#include <stdlib.h>
#include <stdio.h>

void printArrayData(int *data, int size);
// void printArrayData(int data[], int size); // or using array type with brackets, same was as above

int main() {
    int data[5] = { 10, 40, 50, 60, 80 };

    int *ptr;
    ptr = data;

    // Task 1
    // using ptr, write a for loop code to print all cell values in the array
    int NumberOfCells = sizeof(data) / sizeof(data[0]);

    // int i;
    // for (i = 0; i < NumberOfCells; i++) {
    //     printf("Value #%d: %d\n", i, data[i]);
    // }

    // Task 2
    // write the function given below to print the values of the array data
    printArrayData(ptr, 5);


    return 0;
}


void printArrayData(int *data, int size) {
    int TotalCells = sizeof(*data) / sizeof(data[0]);

    int i;
    for (i = 0; i < size; i++) {
        printf("Value #%d: %d\n", i+1, data[i]);
    }
}