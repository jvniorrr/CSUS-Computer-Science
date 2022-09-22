#include <stdlib.h>
#include <stdio.h>
#include <math.h>

#define COUNT 10 // symbolic constant and assigned 10.; Called a MACRO

int main(void)
{
    int i;
    // for (i = 0; i < COUNT; i++)
    // {
    //     printf("i = %d\n", i);
    // }

    // sometimes want to compile based on some conditions
    // CONDITIONAL MACROS
    /*
    #if 0
    #define  COUNT 10
    #else
    #define  COUNT 10000
    #endif
    //
    #define WINDOWS
    */

    /*
    int x;
    #ifdef WINDOWS

    scanf_s ( "%d", &x ) ;

    #else

    scanf ( "%d", &x ) ;

    #end
    */

    /* PRE-DEFINED MACROS
    __FILE__    The macro gets expanded to the current absolute path of the file that is getting compiled. The expanded path is in the form of a string



     __LINE__    gets expanded to the current line number.  This is not string, but integer.



     __DATE__    gets expanded to string

     __TIME__    gets expanded to string



     __FUNCTION__ a gcc macro,  gets expanded to the name of the function.
    */

    /**
     * Variable Rules:
     *    Must begin w/ alphabetic char (a-z, A-Z, or _ (underscore) )
     *        digits valid but not as first char
     *        can be any length but first 31 char's must be unique
     *
     */

    double x = 157.8926;

    // scientific notation
    /* 
    printf("%.3E\n", x); // 1.579E+02
    printf("%.3e\n", x); // 1.579e+02
    printf("%.2e\n", x); // 1.58e+02
    printf("%g\n", x); // 157.893
     */

    double test_val = ceil(x);
    printf("%f\n", test_val);

    // scanf very picky
    // 1. You MUST use the & sybol (pointer)
    // 2. You MUST be sure your conversion specifiers AGREE with your variables

    return EXIT_SUCCESS;
}
