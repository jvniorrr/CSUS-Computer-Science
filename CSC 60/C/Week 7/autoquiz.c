
// home>cat mathquiz.c
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

void setOperands(char *operand1, char *operand2, char *operator)
{
   *operand1 =  rand() % 20 - 10;
   *operand2 =  rand() % 20 - 10;
   *operator=  rand() % 3;
}

char addition(char operand1, char operand2)
{
   printf("What is %d plus %d =\n", operand1, operand2);
   return operand1 + operand2;
}
void subtraction(char operand1, char operand2, char *answer)
{
   printf("What is %d minus %d =\n", operand1, operand2);
   *answer = operand1 - operand2;
}
void multiplication(char operand1, char operand2, char *answer)
{
   printf("What is %d times %d =\n", operand1, operand2);
   *answer = operand1 * operand2;
}

int main()
{
   srand(time(NULL));

   char operand1, operand2, operator, response;
   char correct_answer;
   unsigned char questionNo = 0;

   // TASK 1: write a loop iteration 5 times
   // int i;
   for (questionNo = 0; questionNo < 5; questionNo++)
   {
      printf("Question No : %d \n", questionNo + 1);
      // TASK 2 : move next three lines to a function that takes
      // three parameters operand1, operand2 and operator by reference
      setOperands(&operand1, &operand2, &operator);

      switch (operator)
      {
      case 0:
         // TASK 3 : move these two lines into a function that takes
         // operand1 and operand2 as parameters by value
         // and returns the correct_answer
         correct_answer = addition(operand1, operand2);
         break;
      case 1:
         // TASK 4: move these two lines into a function that takes
         // operand1 and operand2 as parameters by value and
         // correct_answer as a reference
         subtraction(operand1, operand2, &correct_answer);
         break;
      case 2:
         // TASK 5: move these two lines into a function that takes
         // operand1 and operand2 as parameters by value and
         // correct_answer as a reference
         multiplication(operand1, operand2, &correct_answer);
         break;
      }

      scanf("%hhu", &response);
      if (response == correct_answer)
         printf("Good Job\n");
      else
         printf("oh no\n");
   }
}
