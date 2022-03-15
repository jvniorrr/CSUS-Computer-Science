# lab2.asm
# First Last
# Section #
#
# 1. Assemble  : as -o lab2.0 lab2.asm
# 2. Link      : ld -o a.out lab2.o csc35.0
# 3. Execute   : ./a.out

.intel_syntax noprefix          	# Use Intel formatting
.data						        # Start the data section
Greeting:					        # Message is an address
    .ascii "Howdy, world!\n\0"		# Create a buffer of ASCII

Name:						        # Name is an address
    .ascii "My name is First Last\n\0"	# Create a buffer of ASCII

Advice:
    .ascii "Don't make love with sheep!\n\0"

History:
    .ascii "In \0" 			        # in 1914 the first event of WWI erupted

HistoryTwo:
   .ascii " the first event of WW One erupted.\n\0"

.text						        # Start the text section
.global _start					    # Make the _start label public

_start:
    lea rcx, Greeting				# Put address into rcx; print howdy world
    call PrintStringZ				# Execture the csc35.0 subroutine

    lea rcx, Name				    # Print My name is First Last
    call PrintStringZ

    lea rcx, Advice				    # Print some advice to the our new neighbors
    call PrintStringZ

    lea rcx, History				# load the first part of the string
    call PrintStringZ

    mov rcx, 1914				    # Print the year of the historical fact
    call PrintInt

    lea rcx, HistoryTwo				# Print the second part of the string
    call PrintStringZ				# Print In 1914 the first event of WW Two emerged. 
    call Exit					    # Execute the csc35.0 subroutine
