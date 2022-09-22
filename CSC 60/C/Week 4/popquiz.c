#include <stdio.h>
#include <stdlib.h>

int main(void) 
{

    short num = sizeof(short); // pass the data type to sizeof fxn
    printf("%d bytes for short\n", num);

    return EXIT_SUCCESS;
}