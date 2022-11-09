#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <time.h>


int main(void)
{
    int count = 10;
    srand(time(NULL));
    pid_t pid = fork(); //  try calling fork instead and check out the values of count printed

    if (pid == 0)
    {
        // count = rand();
        // printf("child:count=%d \n", count);
        system("pwd");
        _exit(0);
    }
    else
    { // THIS IS PARENT
        int status;
        wait(&status);
        printf("parent: count=%d \n", count);
    }


    return -1;
}