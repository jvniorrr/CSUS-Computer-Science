/**
 * Fernando Mendoza
 * Simple computation program
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void) 
{
    // when compiling add the lm field for some reason for math
    // gcc computations.c -o computations -ld
    
    double x1 = 1, y1 = 5, x2 = 4, y2 = 7,
            side_1, side_2, distance;

    printf("\nJane Smith\n\n");

    side_1 = x2 - x1;
    side_2 = y2 - y1;

    distance = sqrt(side_1 * side_1 + side_2 * side_2);

    printf("The distance between the two points is %5.2f\n\n", distance);

    return EXIT_SUCCESS;
}