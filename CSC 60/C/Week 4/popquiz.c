#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    /** REtrieve size of type of char
    short num = sizeof(short); // pass the data type to sizeof fxn
    printf("%d bytes for short\n", num);
     */

    /* TEST Purposes of char type
    char gender = 'M';
    printf("My gender is: %c\nThank you!\n", gender);
     */

    // unsigned values
    /*
    unsigned int age = 30;
    printf("My age is %u", age);
     */

    /* also since C loosely typed language could also get away with
    unsigned char age = 30;
    printf("My age is %u", age);
     */
    // printf("My age is %d", age); // could get away with this since within range of signed int values,,, w/out warning from compiler

    // Lecture notes / doc notes
    /*
    unsigned int ui = 345;
    int i = -40;
    char ch = 48;
    printf(" signed %i \n ", i);
    printf(" signed %d \n ", i); // signed decimal integer
    printf(" unsigned %u \n ", ui);
    printf(" %o \n ", ui);  // unsigned octal
    printf(" %p \n ", &ui); // %p  to print the address of a variable
    printf(" %c \n ", ch);  // print character
    */

    /** PADDING INTEGERS AND VALYUES
     */

    int testVal = 650000;
    printf("|%.8d|\n", 650000); // padding of zeros on the left of the value if sprecision specifier is longer.
    printf("|%.3d|\n", 650000);
    printf("|%.3f|\n", 123.567890); // precision of 3 decimals. thousandths

    /** LONG type variables
     */

    long testLong = 65000; // for long need to pass specifier, else with d formatter will render error due to truncation of ints > long
    printf("%ld\n", testLong);

    return EXIT_SUCCESS;
}