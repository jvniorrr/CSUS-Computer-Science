# lab8.asm
# First Last
# Section #
#
# 1. Assemble  : as -o lab8.0 lab8.asm
# 2. Link      : ld -o a.out lab8.o
# 3. Execute   : ./a.out

.intel_syntax noprefix
.data


Greeting:
    .ascii "Oh! Hello little friend!\n"
DayGreeting:
    .ascii "You look rather cute today, Mr. Pickles!\n"
WhooseString:
    .ascii "Whoosh!\n"

Brought:
    .ascii "Oh! Thank you! You brought me a pickle.\n"



.text
.global _start
_start:
# ---------------------------------------------
# print the description
    mov rax,        1               # set to write
    mov rdi,        1               # write to screen as output; rdi = file descriptor
    # load the description string
    lea rsi,        Greeting
    mov rdx,        25              # rdx = length of string
    syscall

# ---------------------------------------------
# print the name of my animal and a greeting to it
    mov rax,        1               # set to write
    mov rdi,        1               # write to screen as output; rdi = file descriptor
    # load the greeting string
    lea rsi,        DayGreeting
    mov rdx,        41              # rdx = length of string
    syscall

# ---------------------------------------------
# call the subroutine whoosh
    call            Whoosh
    call            Whoosh

# ---------------------------------------------
# print what my furry friend brought me back
    mov rax,        1               # set to write
    mov rdi,        1               # write to screen as output; rdi = file descriptor
    # load the greeting string
    lea rsi,        Brought
    mov rdx,        40              # rdx = length of string
    syscall
# ---------------------------------------------
# end the program; unconditional jump
    jmp End

# ---------------------------------------------
# create the subroutine Whoosh to be called twice
Whoosh:
    mov rax,        1               # set to write
    mov rdi,        1               # write to screen as output; rdi = file descriptor
    # load the description string
    lea rsi,        WhooseString
    mov rdx,        8              # rdx = length of string
    syscall
    ret

End:
    mov rax,        60              # 60 = exit code for intel
    mov rdi,        0               # 0 -> indicating no errors; we wont see these errors since on school servers
    syscall
