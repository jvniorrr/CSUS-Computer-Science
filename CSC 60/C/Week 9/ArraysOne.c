#include <stdlib.h>
#include <stdio.h>


int main() {

    int data [ ] = { 8, 9, 7, 6, 5 };

    //  get the size of our data; total bytes
    int NumberOfCells = sizeof(data) / sizeof(data[0]);

    // can use to loop
    int i;
    for (i = 0; i < NumberOfCells; i++) {
        printf("The address of cell at %d th cell is %p \n", i,  & data[ i ]);
    }

    return 0;
}