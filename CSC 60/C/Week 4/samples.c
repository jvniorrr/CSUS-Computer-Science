// HEADER FILES
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int x = 1234567; // simple int
    /*
    printf("|1234567890|\n");
    printf("|%5d|\n", x); // take mores than 5 spaces
    printf("|%15d| - default right justify\n", x);
    printf("|%-15d| - printing left justify\n", x);
    printf("|%015d| - padding 0s on the left\n", x);
    printf("|%-015d| - left justify, padding ignored\n", x);
    printf("|%15i| - prints integer\n", x);     // width of 15 and right aligned, so left side is padded.
    printf("|%15x| - prints in hex\n", x);      // width of 15
    printf("|%15o| - prints in Octal\n", x);    // width of 15
    printf("|%15u| - prints in unsigned\n", x); // width of 15
    */

    // Float value specifier using integers
    /*
    printf("\nI will be printing float numbers now\n\n");

    printf("|%5.2f| - print 5 spaces, no truncation happens\n", (float)x);
    printf("|%10.2f| - print 10 spaces\n", (float)x);
    printf("|%-11.2f| - prints 11 spaces, left justify\n", (float)x);
    printf("|%11.2f| - prints 11 spaces, right justify\n", (float)x); // this is default; does the same if provide the `+` flag.
    printf("|%011.2f| - pad 0s, prints 11 spaces, right justify\n", (float)x);
    */

    // Real float values
    // real float variable
    float y = 123.4567;
    printf("|%10.5f| - print 10 spaces, but check the padding\n", y);
    printf("|%10.4f| - print 10 spaces\n", y);
    printf("|%-10.5f| - print 10 spaces, but check the padding\n", y);
    printf("|%-10.3f| - print 10 spaces, left justify, but truncate\n", y);
    printf("|%10.3f| - print 10 spaces, right justify, but truncate\n", y);

    printf("|%5.3f| - print 5 spaces, right justify, but truncate\n", y);
    printf("|%2.3f| - print 2 spaces, right justify, but truncate\n", y);

    printf("|%f| - print default float, 6 decimal spaces \n", y); // default of floats with out precision specifier is 6 decimal spaces. 

    return EXIT_SUCCESS;
}
