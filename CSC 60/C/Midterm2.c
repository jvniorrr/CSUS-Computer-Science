#include <stdlib.h>
#include <stdio.h>

void printArrayData(int *data, int size);
// void printArrayData(int data[], int size); // or using array type with brackets, same was as above

void printGreeting(char string[]);

int main()
{
    int data[5] = {10, 40, 50, 60, 80};

    int *ptr;
    ptr = data;

    // Task 1
    // using ptr, write a for loop code to print all cell values in the array
    int NumberOfCells = sizeof(data) / sizeof(data[0]);

    // TASK 1: DONE
    // int i;
    // for (i = 0; i < NumberOfCells; i++) {
    //     printf("Value #%d: %d\n", i, data[i]);
    // }

    // Task 2
    // write the function given below to print the values of the array data
    // printArrayData(ptr, 5);

    // TASK 3
    char greeting[32]= "Hello Good Morning" ;
    // write a function to print the length of the string
    // without using strlen function.
    printGreeting(greeting);

    return 0;
}

// TASK 2: DONE
void printArrayData(int *data, int size)
{
    int TotalCells = sizeof(*data) / sizeof(data[0]);

    int i;
    for (i = 0; i < size; i++)
    {
        printf("Value #%d: %d\n", i + 1, data[i]);
    }
}



// TASK 3: DONE
void printGreeting(char string[]) {
    int i=0;
    while (*string++ != '\0') {
        i++;
    }

    printf("String length is: %d\n", i);
}



// TASK 4: