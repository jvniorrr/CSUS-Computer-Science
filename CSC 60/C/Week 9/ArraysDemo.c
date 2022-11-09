#include <stdlib.h>
#include <stdio.h>

int main()
{
    // size of an array is the number of cells times the size of its data type
    int data[] = {8, 9, 7, 6, 5};

    int NumberOfCells = sizeof(data) / sizeof(data[0]);
    
    // address of cells using %p format specifier
    // int data[4];
    // printf("The address of first cell is %p\n", &data[0]);
    // printf("The address of second cell is %p\n", &data[1]);
    // printf("The address of third cell is %p\n", &data[2]);
    // printf("The address of fourth cell is %p\n", &data[3]);

    // // can also use a for loop
    int i;
    for (i = 0; i < NumberOfCells; i++) {
        printf("The address of cell at %dth cell is %p\n", i, &data[i]);
    }
    return 0;
}