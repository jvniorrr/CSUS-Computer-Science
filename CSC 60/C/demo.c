#include <string.h>
#include <stdlib.h>
#include <stdio.h>

int main() {
    
    // printf("%d", strcmp("Walking", "walking"));
    char *ptr = "Hello";
    char *p = "hello";

    printf("%d", strcmp(ptr, p));

    return 0;
}