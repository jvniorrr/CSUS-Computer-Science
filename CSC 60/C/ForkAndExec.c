#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

int main() {
    int pid = fork();

    if (pid == 0) {
        execl("./sum.sh", "sum.sh", "5", "9", "10", NULL);
    } else {
        int status;
        wait(&status);
        printf("Parent: Thank you.\n");
    }

    return 0;
}