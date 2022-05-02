# lab7.asm
# First Last
# Section #
#
# 1. Assemble  : as -o fileN.0 fileN.asm
# 2. Link      : ld -o a.out fileN.o csc35.0
# 3. Execute   : ./a.out

.intel_syntax noprefix
.data

# ---------------------------------------------
# Prompts & Description
# ---------------------------------------------
Description:
    .ascii "Welcome to The Gold Bug Saloon!\n\n\0"
OrderQuestion:
    .ascii "\nWhat is your order?\n\0"
BillQuestion:
    .ascii "\nHow many people are splitting the bill?\n\0"
PartyEnjoy:
    .ascii "\nYour party enjoyed:\n\0"
Witches:
    .ascii "\nOkay, witches and wizards, give \0"
Witches2:
    .ascii " cents each.\n\0"

# ---------------------------------------------
# Strings
# ---------------------------------------------
Option1:
    .ascii "1. Fresh elk steaks (323 cents)\n\0"
Option2:
    .ascii "2. Not-so-fresh steaks (152 cents)\n\0"
Option3:
    .ascii "3. Chicken sandwiches (215 cents)\n\0"
Option4:
    .ascii "4. Milk and mush bowls (97 cents)\n\0"
Option5:
    .ascii "5. Big-o-barrel-of-beer (737 cents)\n\0"


# ---------------------------------------------
# Table of Items
# ---------------------------------------------
Items:
    .quad Option1
    .quad Option2
    .quad Option3
    .quad Option4
    .quad Option5

ItemCosts:
    .quad 323
    .quad 152
    .quad 215
    .quad 97
    .quad 737



.text
.global _start
_start:
    # display description of program
    lea rcx,        Description
    call            PrintStringZ

    # print the menu or options
    # loop through the items
    mov rdi,        0
ItemsLoop:
    cmp rdi,        5
    jge             Continue

    mov rcx,        [Items + rdi * 8]
    call            PrintStringZ
    add rdi,        1
    jmp             ItemsLoop

Continue:
    # ask user what their order is
    lea rcx,        OrderQuestion
    call            PrintStringZ
    # get input from user
    call            ScanInt

    # print what the users choice is
    mov rdi,        rcx

    # print your party enjoyed
    lea rcx,        PartyEnjoy
    call            PrintStringZ

    # 0 indexing
    sub rdi,        1

    # refereing string that stores user input
    mov rcx,        [Items + rdi * 8]
    call            PrintStringZ

    # ask how many are splitting the bill
    lea rcx,        BillQuestion
    call            PrintStringZ

    # get input for people splitting bill
    call            ScanInt
    mov rbx,        rcx

    # print Okay witches and wizards get xxxxx
    lea rcx,        Witches
    call            PrintStringZ

    # logic for splitting bill #
    
    # get the order choices cost
    mov rax,        [ItemCosts + rdi * 8] # itemCost = rax
    CQO             # extend the rax reg
    IDIV            rbx

    # copy value and print?
    mov rcx,        rax
    call            PrintInt

    # print second part of witches string
    lea rcx,        Witches2
    call            PrintStringZ

    call            Exit

