#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

int main()
{

    char *mBuf;
    int memsize = -1;

    if ((mBuf = malloc(memsize)) == NULL)
    {
        printf("error NO %d \n", errno);
        perror("Malloc ");
        printf("Malloc occurred %s \n", strerror(errno));
        exit(1);
    }
}