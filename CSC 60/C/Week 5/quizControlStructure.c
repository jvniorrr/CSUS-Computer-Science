#include <stdlib.h>
#include <stdio.h>


void q1() {
    /** #1 */
    int x = 20, y = 30, z = 0;
    if ( (x == 30) && (y = 40) ) {
        z= 10;
    }
    printf("%d \n", z);
}

void q2() {
    int x = 20, y = 35, z = 0;
    if ( (x == 30) || (y = 40) ) {
        z = 10;
    }
    printf("%d \n", z);
}
void q3() {
    int x = 20, y = 35, z = 0;
    if ( (x == 30) || (y = 0) ) {
        z = 10;
    }
    printf("%d \n", z);
}
void q3() {
    int x = 0, y = 10;
    while (x) {
        y++;
    }
    printf("%d \n", y);
}

int main() {
    q1();

    return 1;
}