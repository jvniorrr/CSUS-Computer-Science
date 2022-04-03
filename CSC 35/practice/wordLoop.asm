# lab2.asm
# First Last
# Section #
#
# 1. Assemble  : as -o fileN.0 fileN.asm
# 2. Link      : ld -o a.out fileN.o csc35.0
# 3. Execute   : ./a.out

.intel_syntax noprefix          	            # Use Intel formatting
.data

TestString:
    .ascii "Hello World\n\0"

.text
.global _start
_start:
# ---------------------------------------------
# Loading in a string from memory and print plain white text
    lea rcx,        TestString
    # call            PrintStringZ

# ---------------------------------------------
# Get String size & store it into a register
    call            LengthStringZ
    mov r8,         rcx
    
# ---------------------------------------------
# while loop around text
    mov rdi,        0
LetterLoop:
    # add break if not its infinite
    cmp r8,         rdi
    je              End
    # load the ascii character. if did mov then it stores the decimal value i believe
    movb cl,        [TestString+rdi]
    call            PrintChar
# ---------------------------------------------
# get a random color to print the text
    mov rcx,        7
    call            Random
# ---------------------------------------------
# Set the text color
    call            SetForeColor
# ---------------------------------------------
# increment rdi or our index
    add rdi,        1

# ---------------------------------------------
# jump back to while loop
    jmp             LetterLoop

End:
# ---------------------------------------------
# reset the color
    mov rcx,        7 
    call            SetForeColor
    call            Exit

