#include <stdio.h>
#include <stdlib.h>

void printNonPrime(int value) {
    int flag = 0; // assume its not 
    for (int i = 2; i<value; i++) {
        if (value % i == 0) {
            // means we have a prime value
            flag = 1;
            printf("%d ", value);
            break;
        }
    }
}
void printPrimeVal(int value) {
    int flag = 0; // assume its not 
    for (int i = 2; i<value; i++) {
        if (value % i == 0) {
            // means we have a prime value
            flag = 1;
            break;
        }
    }
    if (flag == 0) {
        printf("%d ", value);
    }
}

int main() {
    unsigned int  data[] = {  3, 7, 11, 18, 25, 31, 37, 41, 71, 90 } ;
    unsigned int printPrime;

    printf("Would you like to print non prime or prime numbers: Enter 0 or 1.\n");

    scanf("%d", &printPrime);

    // prompt user until enter 1 or 0.
    while (printPrime > 1 || printPrime < 0) {
        printf("Would you like to print non prime or prime numbers: Enter 0 or 1.\n");

        scanf("%d", &printPrime);
    }

    // handle now if want prime or not
    int arraySize = 10;
    int cell = sizeof(data) / sizeof(data[0]);

    if (printPrime == 0) {
        printf("The non prime numbers are: \n");
        for (int i =0; i<cell; i++) {
            printNonPrime(data[i]);
        }
    } else if (printPrime == 1) {
        printf("The prime numbers are: \n");
        for (int i =0; i<cell; i++) {
            printPrimeVal(data[i]);
        }
    }
    return 0;
}