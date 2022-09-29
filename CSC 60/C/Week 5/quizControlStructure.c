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

void q4() {
    int x = 0, y = 10;
    while (x) {
        y++;
    }
    printf("%d \n", y);
}

void q5() {
    int x = 1, y = 10;
    while (x < 10) {
        y++;
        x = x + 2;
    }
    printf("%d \n", y);
}

// void q6() {
//     int x = 20, y = 10;
//     switch (x)
//     {
//     case x:
//         /* code */
//         break;
    
//     default:
//         break;
//     }
// }

void q7() {
    int x = 11, y = 20;

    if (x < 10) {
        printf("%d \n", x);
    } else (x > 10) { // syntax err
        printf("%d \n", y);
    }
}

void q8() {
    int x = 10, y = 21;
    for ( ; x< 10; x++) {
        printf("%d \n", y);
    }
}

int main() {
    q1();

    return 1;
}