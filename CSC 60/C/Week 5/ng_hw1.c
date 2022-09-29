// TASK 1 :  Random number
// TASK 2 : insert while loop
// TASK 3 : Print messages

#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int SCORES = 0;
char ch;

char q1();
char q2();
char q3();
char q4();
char q5();
char q6();
char q7();
char q8();
char q9();
char q10();
char q11();
char q12();
char q13();
char q14();
char q15();
void checkAnswer(char answer);

int main()
{
	srand(time(NULL));
	unsigned char score = 0, questionNum = 1;
	int value; // not used. 
	int scores = 0;
	// create array to store already answered questions
	int arr[] = {0, 0, 0, 0, 0};
	int arrCount = 0;

	int questionsAnswered = 0;
	while (questionsAnswered < 5)
	{

		// maybe create another while loop to get valid question that hasnt been answered
		int alreadyAsked = 1; // assume question has already been asked
		while (alreadyAsked == 1)
		{
			questionNum = 1 + rand() % 15;

			char asked = 0; //reset on every iteration
			int i=0; // dont intialize i in for loop. Do outside so works across diff standads of gcc compiler.
			for (i=0; i < 5; i++)
			{
				if (questionNum == (int) arr[i])
				{
					// this question has already been asked / prompted
					asked = 1; // means we've already prompted
					break;
				}
			}

            // if we didnt find the question in our array, we haven't asked this question
			if (asked == 0)
			{
				alreadyAsked = 0;
			}
		}


		// printf("Entered Val: %d %c\n", ch, ch);
		printf("Question %d : ", questionsAnswered + 1);
		switch (questionNum)
		{   
            int answer;
			case 1:
				answer = q1();
                checkAnswer(answer);
				arr[arrCount] = 1;
				arrCount++;
				break;
			case 2:
				answer = q2();
                checkAnswer(answer);
				arr[arrCount] = 2;
				arrCount++;
				break;
			case 3:
				answer = q3();
                checkAnswer(answer);
				arr[arrCount] = 3;
				arrCount++;
				break;
			case 4:
				answer = q4();
                checkAnswer(answer);
				arr[arrCount] = 4;
				arrCount++;
				break;
			case 5:
				answer = q5();
                checkAnswer(answer);
				arr[arrCount] = 5;
				arrCount++;
				break;
			case 6:
				answer = q6();
                checkAnswer(answer);
				arr[arrCount] = 6;
				arrCount++;
				break;
			case 7:
				answer = q7();
                checkAnswer(answer);
				arr[arrCount] = 7;
				arrCount++;
				break;
			case 8:
				answer = q8();
                checkAnswer(answer);
				arr[arrCount] = 8;
				arrCount++;
				break;
			case 9:
				answer = q9();
                checkAnswer(answer);
				arr[arrCount] = 9;
				arrCount++;
				break;
			case 10:
				answer = q10();
                checkAnswer(answer);
				arr[arrCount] = 10;
				arrCount++;
				break;
			case 11:
				answer = q11();
                checkAnswer(answer);
				arr[arrCount] = 11;
				arrCount++;
				break;
			case 12:
				answer = q12();
                checkAnswer(answer);
				arr[arrCount] = 12;
				arrCount++;
				break;
			case 13:
				answer = q13();
                checkAnswer(answer);
				arr[arrCount] = 13;
				arrCount++;
				break;
			case 14:
				answer = q14();
                checkAnswer(answer);
				arr[arrCount] = 14;
				arrCount++;
				break;
			case 15:
				answer = q15();
                checkAnswer(answer);
				arr[arrCount] = 15;
				arrCount++;
				break;

			default:
                printf("ERROR OCCURED");
				break;
		}
		// increment total questions answered
		questionsAnswered += 1;
	}
    printf("Total score: %d / 5\n", SCORES);
}


char q1()
{
	// char ch;
	printf("The neighbors of USA are \n");
	printf("1. Canada and Mexico\n");
	printf("2. United Kingdom, Russia, Mexico and North Carolina\n");
	printf("3. Brazil, Mexico, Canada\n");
	printf("4. No Neighbors\n");
	// 1 is the correct answer
	return '1';
}

char q2()
{
	// char ch;
	printf("What is USA stands for\n");
	printf("1. United States of America\n");
	printf("2. United Stand Always\n");
	printf("3. United South Africa\n");
	printf("4. United State Employees\n");
	// 1 is the correct answer
	return '1';
}

char q3()
{
	// char ch;
	printf("Where is USA\n");
	printf("1. Above Canada\n");
	printf("2. Below Canada\n");
	printf("3. Below Mexico\n");
	printf("4. Next to Texas\n");
	// 2 is the correct answer
	return '2';
}

char q4()
{
	printf("Where is Canada\n");
	printf("1. Below USA\n");
	printf("2. Next to Australia\n");
	printf("3. Below Mexico\n");
	printf("4. Above USA\n");
	// 4 is the correct answer
	return '4';
}

char q5()
{
	// char ch;
	printf("Where is California\n");
	printf("1. Next to Nevada\n");
	printf("2. Next to Texas\n");
	printf("3. Next to Washington DC\n");
	printf("4. Next to Washington State\n");
    // 1 is correct answer
	return '1';
}

char q6()
{
	printf("Where is Nevada\n");
	printf("1. in Mexico\n");
	printf("2. Next to Texas\n");
	printf("3. Next to Las Vegas\n");
	printf("4. Next to California\n");
	// 4 is the correct answer
    return '4';
}

char q7()
{

	printf("White house is in \n");
	printf("1. Canada\n");
	printf("2. California\n");
	printf("3. Next to my house\n");
	printf("4. Washington DC\n");
	// 4 is correct answer
	return '4';
}

char q8()
{
	printf("New York City is in\n");
	printf("1. New York\n");
	printf("2. Maryland\n");
	printf("3. Delaware\n");
	printf("4. New Jersey\n");
	// 1 is the correct answer
	return '1';
}

char q9()
{
	printf("Toranto is in\n");
	printf("1. USA\n");
	printf("2. Canada\n");
	printf("3. Mexico\n");
	printf("4. UK\n");
	// 2 is the correct answer
	return '2';
}

char q10()
{
	printf("UK stands for \n");
	printf("1. Unknown\n");
	printf("2. United Kentucky\n");
	printf("3. United Kings\n");
	printf("4. United Kingdom\n");
	// 4 is the correct answer
	
	return '4';
}

char q11()
{
	printf("Kentucky is in \n");
	printf("1. Canada\n");
	printf("2. Mexico\n");
	printf("3. City in Texas\n");
	printf("4. USA\n");
	// 4 is the correct answer
	
	return '4';
}

char q12()
{
	printf("San Diego is in\n");
	printf("1. Nevada\n");
	printf("2. California\n");
	printf("3. Utah\n");
	printf("4. Oregon\n");
	// 2 is the correct answer
	return '2';
}

char q13()
{
	printf("Los Angeles is in\n");
	printf("1. Texas\n");
	printf("2. Utah\n");
	printf("3. California\n");
	printf("4. Nevada\n");
	// 3 is the correct answer
	return '3';
}

char q14()
{
	printf("Florida is \n");
	printf("1. Next to Texas\n");
	printf("2. Next to Georgia\n");
	printf("3. Next to New York\n");
	printf("4. Next to Memphis\n");
	// 2 is the correct answer
	return '2';
}

char q15()
{
	printf("Sierra Mountains are in \n");
	printf("1. West Coast\n");
	printf("2. Each Coast\n");
	printf("3. Sierra Lone\n");
	printf("4. Africa \n");
	// 1 is correct answer
	return '1';
}

void checkAnswer(char answer) {
    // retrieve response and assure its not blank or new line
    ch = getchar();

    /** Could possibly use this
    scanf("%*[^\n]");
    getchar();
     */
    
    // assure C isnt interpreting new line or blank space as response
    if (ch == '\n' || ch == ' ') {
        ch = getchar();
    }
    if (ch == answer) {
        printf("Correct!\n\n");
        SCORES++;
        return;
    } else {
        printf("Incorrect.\n\n");
        return;
    }
}