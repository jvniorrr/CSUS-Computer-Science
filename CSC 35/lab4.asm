# First Last
# Lab 4
# Section #
#
# 1. Assemble: as -o lab4.o lab4.asm
# 2. Linker: ld -o a.out lab4.o csc35.o
# 3. Output: ./a.out


.intel_syntax noprefix
.data

description:
	.ascii "Sutter's Mill Contract\n\n\0"

orderedTrees:
	.ascii "How many trees were ordered?\n\0"

cutTrees:
	.ascii "How many trees were cut down?\n\0"

rejectedTrees:
	.ascii "How many trees were rejected?\n\0"

lostTrees:
	.ascii "How many trees were lost down the river?\n\0"

harvestedTrees:
	.ascii "\nThey harvested \0"
harvestedTreesTwo:
	.ascii " trees.\n\0"

success:
	.ascii "\nThey SUCCESSFULLY fulfilled the contract!\n\0"

failure:
	.ascii "\nThey FAILED to fulfill the contract!\n\0"

.text
.global _start
_start:	
	lea rcx, description				# print the description of the program; rcx = some string loaded
	call PrintStringZ

	lea rcx, orderedTrees				# How many trees were ordered?
	call PrintStringZ
	call ScanInt
	mov rbx, rcx						# store the total num of trees ordered; rbx = input("Total # trees")

	lea rcx, cutTrees					# How many trees were cut dowwn?
	call PrintStringZ
	call ScanInt
	mov rax, rcx						# store the cut down trees; rax = input("How many trees were cut down")
		
	lea rcx, rejectedTrees				# How many trees were rejected?
	call PrintStringZ
	call ScanInt
	mov rdx, rcx						# store the rejected trees; rdx = input("How many trees rejected")
	
	sub rax, rdx						# subtract the rejected trees from the total cut down here; TotalTrees - rejected

	lea rcx, lostTrees					# How many trees were lost down the river?
	call PrintStringZ
	call ScanInt
	sub rax, rcx						# subtract the lost trees from the total trees here; TotalTrees - lostTrees


	lea rcx, harvestedTrees				# now the LOGICAL OPERATIONS
	call PrintStringZ
	
	mov rcx, rax						# copy the total number of trees which are valid; rcx = TotalTrees
	call PrintInt						# print the number of trees; TotalTrees printed
	
	lea rcx, harvestedTreesTwo
	call PrintStringZ

	cmp rax, rbx
	jge successState					# if the totalTrees >= ammount ordered; jump to success label
	
	lea rcx, failure					# else we will continue here
	call PrintStringZ
	jmp end


successState:
	lea rcx, success
	call PrintStringZ
	jmp end

failureState:
	lea rcx, failure
	call PrintStringZ
	jmp end

	
end:
	call Exit

