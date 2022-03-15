.intel_syntax noprefix
.data

Description:
	.ascii "Let's play Chuck-a-Luck!\nEnter 0 to exit\n\0"

# direct storage for our dies
Die1:
	.quad 0
Die2:
	.quad 0
Die3:
	.quad 0

# funds to track the users betting allowance
Funds:
	.quad 100					# initialize the users fund to 100


# Statements for our die functions
Die1State:
	.ascii "First Die is: \0"
Die2State:
	.ascii "\nSecond Die is: \0"
Die3State:
	.ascii "\nThird Die is: \0"

# Statements for the total $ left
MoneyLeft:
	.ascii "\nYou have $\0"

# Statement to retrieve betting input
Betting:
	.ascii "\nHow much are you betting?\n\0" 


# Winner and loser Labels
Loser:
	.ascii "\n\nYou Lose!\n\0"
Winner:
	.ascii "\n\nYou win!\n\0"




.text
.global _start
_start:	
	lea rcx, Description
	call PrintStringZ			# print out the description of the program

Do:	
	lea rcx, MoneyLeft
	call PrintStringZ			# print the total ammount they currently have - You have X money left
	mov rcx, Funds
	call PrintInt	


	lea rcx, Betting
	call PrintStringZ
	call ScanInt				# retrieve input from user for the bet ammount -  money ammount
	mov rbx, rcx				# store the users bet ammount into RBX


	# check if the user enters a be less than 0
	cmp rcx, 0					# compare the users bet with 0 to see if want to continue
	jle End

	lea rcx, Die1State
	call PrintStringZ
	
	mov rcx, 6					# retrieve a random num using cook library
	call Random
	add rcx, 1
	mov Die1, rcx				# store Die 1
	call PrintInt				# print the random number for Die 1


	lea rcx, Die2State
	call PrintStringZ
	
	mov rcx, 6					# retrieve a random num using cook library
	call Random
	add rcx, 1
	mov Die2, rcx				# store Die 2
	call PrintInt				# print the random number for Die 1


	lea rcx, Die3State
	call PrintStringZ
	
	mov rcx, 6					# retrieve a random num using cook library
	call Random
	add rcx, 1
	mov Die3, rcx				# store Die 3
	call PrintInt				# print the random number for Die 1

	
	cmpq Die1, 6				# compare die1 with 6 to see if they the same
	je callWinner 
	cmpq Die2, 6				# compare die2 with 6 to see if they the same
	je callWinner 
	cmpq Die3, 6				# compare die3 with 6 to see if they the same
	je callWinner 
		

	# if the user not a winner continue to this one and subtract
	jmp callLoser				# call the loser statement

		
callLoser:
	lea rcx, Loser
	call PrintStringZ

	sub Funds, rbx				# subtract the users bet ammount from the total
		
	jmp Do						# continue the while loop


callWinner:
	lea rcx, Winner
	call PrintStringZ
	
	add Funds, rbx				# add the users bet ammount from the total

	jmp Do						# continue the while loop

	
End:
	call Exit
