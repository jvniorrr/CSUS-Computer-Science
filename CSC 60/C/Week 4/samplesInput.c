#include <stdio.h>
#include <stdlib.h>

int main(void)
{

    int operand1;

    // version 1, READS UNTIL IT SEES DIGITS
    char name[32];
    // printf("please enter your name \n"); // enter Donald95670
    // scanf("%[^0-9]", name);
    // printf("%s\n", name);

    // version=2  READS ONLY CHARACTERS, STOPS WHEN A DIGIT IS FOUND
    // printf("please enter your name \n"); // enter Donald95670
    // scanf("%[a-zA-Z]", name);
    // printf("%s\n", name);

    // READS DIGITS IN A STRING UNTIL IT SEES DASH or space or non number value
    // char zipcode[10];
    // scanf("%[0-9]", zipcode); // enter 95670-9321
    // printf("zipcode=%s\n", zipcode);

    // READ 5 digits
    // int zip; // set width = 5
    // scanf ("%5d", &zip); // enter 956709321; only retrieves first 5 integers if all ints. or stops at last integer seen.
    // printf ( "zip=%d\n", zip );

    // read 5 characters
    // char street[8] = {'\0'}; // set width = 5
    // scanf ("%5c", street); // enter 10230Penns St; Accepts integers or character values since C is loosely typed
    // printf("street=%s\n", street);

    // discard one integer using *, enter 234 567
    // int x;
    // scanf("%*d %d", &x); // PAY ATTETION, ONLY ONE VARIABLE IS PROVIDED
    // printf("The value of x =%d \n", x);

    // discard one word using *, enter sam donald
    // char first[16] = {'\0'}, last[16] = {'\0'};
    // // INCORRECT USAGE scanf ( "%*s %s", first, last);
    // scanf("%*s %s", last);
    // printf("last=%s \n", last);

    // OTHER EXAMPLES
    // scanf("%[^\n]", name); // means read until the end of line
    // printf("Your input was: %s\n", name);
    // scanf("%[^:] ", name);  // means read until you see :, useful in reading /etc/passwd
    // printf("Your input was: %s\n", name);

    // enter 34 + 23
    // int o1, o2;
    // char o;
    // // THE NEXT SCANF WILL IGNORE EXTRA SPACES and reads 34+23
    // scanf("%d %c %d\n", &o1, &o, &o2);
    // printf("o1 = %d\n", o1);
    // printf("o = %c\n", o);
    // printf("o2 = %d\n", o2);
    // printf("%d %c %d\n", o1, o, o2);

    // float representation
    // float fl;
    // printf("Please enter a float \n");
    // scanf("%f", &fl); // input 1234.56
    // printf("%f \n", fl); // PRINTS IN DEFAULT 6 POSITION; // 1234.560059
    // printf("%e \n", fl); // PRINTS IN SCIENTIFIC NOTATION; // 1.234560e+03
    // printf("%g \n", fl); // PRINTS THE SHORTER OF THE ABOVE TWO; // 1234.56

    // float fl = 123456789;
    // printf("%f \n", fl); // PRINTS IN DEFAULT 6 POSITION; // 123456792.000000
    // printf("%e \n", fl); // PRINTS IN SCIENTIFIC NOTATION; // 1.234568e+08
    // printf("%g \n", fl); // PRINTS THE SHORTER OF THE ABOVE TWO; // 1.23457e+08

    int x, y;
    // 1.   x = ( 4 + 2 ) * 5  = 30
    // 2.   x = ( 12 + 6 ) /  5 = 3
    // 3.   y = ( 4 + 3) / 4 = 1
    // 4.   x = 4 + 5 * ( 7 / 3 ) = 14
    // 5.  x =  ( 4  + 3 ) * 11.5 = 80
    // 6.  x = 6 / 7 * 31.0 = 0
    // 7.  x = 31.0 * 6 / 7  = 26
    // 8.  x = 20.0 / 3.0 * 5.0  = 33
    // 9.   30 / 4 * 4.0 = 28 because integer division initally. (initially got wrong only one).
    // 10. 30 * 4.0 / 4 = 30

    // printf("#1: %d\n", (int)((4+2) * 5));
    // printf("#2: %d\n", (int)((12 + 6) / 5));
    // printf("#3: %d\n", (int)(( 4 + 3) / 4));
    // printf("#4: %d\n", (int)( 4 + 5 * ( 7 / 3 )) );
    // printf("#5: %d\n", (int)(( 4  + 3 ) * 11.5));
    // printf("#6: %d\n", (int)(6 / 7 * 31.0));
    // printf("#7: %d\n", (int)(31.0 * 6 / 7));
    // printf("#8: %d\n", (int)(20.0 / 3.0 * 5.0));
    // printf("#9: %d\n", (int)(30 / 4 * 4.0));
    // printf("#10: %d\n", (int)(30 * 4.0 / 4));

    /* ASCII TABLE
    char ch;
    printf("Press any key and press the <Enter> key : \n"); // prompt for user
    ch = getchar(); // part of the IO lib; retrieve input instead of scanf
    printf("The Character value of the key you pressed is: %c\n", ch);
    printf("The ASCII value of the key you pressed i:s %d \n", ch); // print to screen the users input in an ASCII value type.
    printf("The Hex value of the key you pressed is: %x\n", ch);
    */

    /* Can also do addition and subtraction ASCII values
     */
    char ch; 
    ch = '7' + 2; // 7 char value is 55
    printf("The key you entered is %c\n", ch); // '9' char
    ch += 3;
    printf("The key you entered is %d\n", ch); // '<' char
    ch += 'A';
    printf("The key you entered is %d\n", ch); // '}' char


    return EXIT_SUCCESS;
}