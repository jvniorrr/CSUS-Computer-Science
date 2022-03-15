# First Last
# Section #
# Lab 3
#
# 1. Assemble: as -o lab3.o lab3.asm
# 2. Linker: ld -o a.out csc35.o lab3.o
# 3. Output: ./a.out

.intel_syntax noprefix
.data
Description:
	.ascii "Sutter's Fort Finance Calculator\n\0"							# Description of what the program does

CollectStatement:
	.ascii "How much did the Fort collect?\n\0"								# Prompt the user following this statement
Spent:
	.ascii "How much was spent on the employee salaries?\n\0"				# Prompt the user for the spending ammount

Repairs:
	.ascii "How much was spent on the repairs?\n\0"							# Prompt user for repairs cost

CashFlow:
	.ascii "Mr. Sutter, your cash flow is $\0"								# Print to  user cash flow

SpaceAllocate:
	.quad 0																	# allocate block of 8 bytes

.text
.global _start
_start:
	lea rcx, Description
	call PrintStringZ						# Print the description to the screen

	lea rcx, CollectStatement
	call PrintStringZ						# prompt the user asking Forts collection

	call ScanInt							# get input from user for collection
	mov SpaceAllocate, rcx					# copy the input

	lea rcx, Spent
	call PrintStringZ						# prompt the user how much was spent on employee salaries

	call ScanInt
	mov rbx, rcx							# get input from user for salaries	

	lea rcx, Repairs
	call PrintStringZ						# prompt the the repairs costs	

	call ScanInt							# get input for repair costs
	add rbx, rcx							# add the repair expenses to the salaries


	sub SpaceAllocate, rbx					# subtract the total expenses
	lea rcx, CashFlow						# print the cashFlow
	call PrintStringZ
	
	mov rcx, SpaceAllocate					# copy to rcx
	call PrintInt
	call Exit
