#include <stdlib.h>
#include <stdio.h>

#include <stdio.h>

#include <stdlib.h>

#include <time.h>

// function getTwoNumbers : pass by reference or pass address


// PASS POINTERS TO FUNCTIONS
void getTwoNumber(int *, int *, int); // prototype

void getTwoNumbers(int *x, int *y, int max)
{
    do
    {
        *x = rand() % max;
        *y = rand() % max;
    } while (*x == *y);
}

int main()
{

    int *ptr, x = 10;
    ptr = &x; // assignment of our pointer
    int y = 20;

    printf("Ptr value before our dereference with y: %d\n", *ptr);
    printf("X value before our dereference with y: %d\n", x);

    printf("We are setting a new value to mem address of our pointer\n");

    *ptr = y;
    printf("Ptr value before our dereference with y: %d\n", *ptr);
    printf("X value before our dereference with y: %d\n", x);

    // PASSING POINTERS TO FUNCTIONS
    int a, b, max = 10;

    int *ptrA = &a;

    int *ptrB = &b;

    srand(time(NULL));

    getTwoNumbers(ptrA, ptrB, max); // watch passing the pointer.

    printf("Random Number: a=%d b=%d\n", a, b);

    return -1;
}