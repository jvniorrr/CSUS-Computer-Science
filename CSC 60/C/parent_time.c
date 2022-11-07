#include <stdio.h>
#include <stdlib.h>
#include <sys/times.h>
#include <time.h>
#include <unistd.h>

int main()
{
   clock_t start, end;

   struct tms st_start, st_end;
   start = times(&st_start);

   // task 1
   // we are making the program run a long for loop and
   // check the time.
   // you will see the program take around 5 seconds
   pid_t pid;
   pid = fork();

   int i;
   if (pid == 0) {
      for (i = 0; i < 1000000000;)
         i++;
   } else {
      // parent process
      int status;
      wait(&status);
   }
  

   end = times(&st_end);

   printf ( "Time taken by system command %6.2f \n", (float)( end-start)/sysconf( _SC_CLK_TCK ) );

   printf("Time taken by parent process in User mode %6.2f \n", (float)(st_end.tms_utime - st_start.tms_utime) / sysconf(_SC_CLK_TCK));
   printf("Time taken by parent process in kernel mode %6.2f \n", (float)(st_end.tms_stime - st_start.tms_stime) / sysconf(_SC_CLK_TCK));

   printf("Time taken by child process in user mode %6.2f \n", (float)(st_end.tms_cutime - st_start.tms_cutime) / sysconf(_SC_CLK_TCK));
   printf("Time taken by child process in kernel mode %6.2f \n", (float)(st_end.tms_cstime - st_start.tms_cstime) / sysconf(_SC_CLK_TCK));
}
