#include <stdio.h>

int main()
{

    int **p2p;

    int x = 10;
    int *p = &x; // make p point to x

    p2p = &p; // make p2p point to p

    printf("&x=%p \n", &x);
    printf("p=%p \n", p);
    printf("x=%d *p = %d \n", x, *p);

    printf("p2p=%p , &p=%p \n", p2p, &p);

    printf("veritfy *p2p %p \n", *p2p); // dereference
    printf("**p2p=%d \n", **p2p);

    int ***p3p;

    p3p = &p2p;
    printf("veritfy *p3p %p \n", *p3p); // dereference
    printf("***p2p=%d \n", ***p3p);
}