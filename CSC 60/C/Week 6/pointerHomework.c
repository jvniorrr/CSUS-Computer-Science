#include <stdlib.h>
#include <stdio.h>

int main() {
    int x = 200;
    int iData[] = {4300, 4400, 4500, 4600, 4700};
    int *iPtr1, *iPtr2;

    // #1
    iPtr1 = &x; // was missing amperand sign to store the address

    // #2.
    printf("#3: %d\n", *iPtr1); // need to derefence the pointer's value
    // can also dereference ptr using LHS, *ptr = x;

    // #3. Need ptr2 point to the array iData
    iPtr2 = iData;

    // #4
    printf("#4: %d \n",*iPtr2); // prints 4300

    // #5; what does following print after incrementing the ptr value
    iPtr2++;
    printf("#5: %d \n",*iPtr2); // prints 4400

    // #6; what does following print after incrementing the ptr value
    iPtr2++;
    printf("#6: %d \n",*iPtr2); // prints 4500


    // now let us make statement below make iPtr2 point to iPtr1
    iPtr2 = iPtr1;
    // #7: what does it print?
    printf("#7: %d\n", *iPtr2); // prints 200


    // now consider this, answer question 8 & 9
    int y = 4100;
    iPtr1 = &y;
    iPtr2 = iPtr1;

    // #8: what does it print
    printf("#8: %d\n", *iPtr1); // prints 4100

    // #9: what does it print
    printf("#9: %d\n", *iPtr1); // prints 4100

    // #10: what does it print
    y = 450;
    // new value stored in the address of y, thus iPtr1 & iPtr2 have a new value in that address.
    printf("#10: %d \n", *iPtr1); // prints 450


    // Consider this and answer Question 11 and 12
    iPtr2 = iData + 2; // reference the 3rd value or 2nd (when doing 0 index)
    iPtr1 = ++iPtr2; // this increments the address value before the assignment thus both will have the same value after this line

    // #11: what does it print
    printf("#11: %d \n", *iPtr1); // prints 4600

    // #12: what does it print
    printf("#12: %d \n", *iPtr2); // prints 4600


    // we are then defining a new array, answer question 13 & 14
    int nameBuf[5] = {0x8, 0x12, 0xdeadbeef, 0xabcdabcd};

    // #13: is the next statement correct? -> NO
    // nameBuf++; // incorrect, you cant increment an array like this

    // #14: is the next statement correct?
    // nameBuf = 20; // not correct but, cant assign a ptr address like this, has to point to some address. Cant assign an array like this

    
    // Consider the below statements and asnwer question 15 & 16
    int count;
    // Question 15; 
    // int *extraPtr1 = 10; 
    // for 15: terribly wrong cause the data 10 is stored into the pointer varialbe. Meaning extraPointer would be pointing to the address 10 which may be the memory in the kernel space and would result in system err and the program crashing.
    
    // Question 16, assign address to extraPtr2
    // int extraPtr2 = &count; 
    // for 16: this is incorrect because we never dereference the pointers address. in order to store tha address of a variable into a pointer variable we must derefence the pointer variable


    // Consider this and answer question 17 & 18
    short sh;
    // Question 17: Is this a good statement?
    // short *shortPtr1 = sh; 
    // no we cant store values into a pointer it has to be a memory address

    // Question 18: Is this a good statement?
    short *shortPtr2 = &sh; 
    // this is fine because we both dereference the ptr and we utilize address operator (&) to return the address of its operand in this case sh


    // consider these statements below and answer question 19 & 20
    int numData[10] = {19, 12, 23, 43, 87, 34};
    int *numPtr = numData+2;
    numPtr = numPtr +1;

    // #19: what is the value of numData[8]
    printf("#19: %d\n", numData[8]); // prints 0; thus value of numData[8] is 0 because values are auto initialized to 0 (those that aren't assigned)

    // #20 Do you know why a program might crash? 
    // I believe the program may run intially but it may cause issues in the future as when we add 20, we are getting out of the arrays memory address bounds and thus when we create a diff value it could effect this as we have a ptr assigned to this address. 
    numPtr = numPtr + 20;
    printf("#20: %d\n", *numPtr);
    printf("TEST: %p\n", numData);
    printf("TEST: %p\n", numPtr);

    return 0;
}