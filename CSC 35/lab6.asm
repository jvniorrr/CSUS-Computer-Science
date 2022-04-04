# lab6.asm
# First Last
# Section #
#
# 1. Assemble  : as -o fileN.0 fileN.asm
# 2. Link      : ld -o a.out fileN.o csc35.0
# 3. Execute   : ./a.out

.intel_syntax noprefix
.data

Description:
    .ascii "Good morning! On your way up the hill? What do you want?\n\n\0"

# ---------------------------------------------
# Menu options
Menu:
    .ascii "1. Miner's Pan (171 cents)\n"
    .ascii "2. Mountaineer's Map (85 cents)\n"
    .ascii "3. Flint (34 cents)\n"
    .ascii "4. Donkey (2294 cents)\n"
    .ascii "5. Bowie knife (352 cents)\n\n\0"
MenuSelect:
    .ascii "Enter your selection:\n\0"

# ---------------------------------------------
# Prompt user for their total cents and store value into register rax
GivenCents:
    .ascii "How many cents did you give the clerk?\n\0"

# ----------------------
# Pan
PanState:
    .ascii "\nAh, yes. You can't go without a pan!\n\n\0"
PanCost:
    .quad 171
# ----------------------
# Map
MapState:
    .ascii "\nAh, yes. You can't go without a map!\n\n\0"
MapCost:
    .quad 85
# ----------------------
# Flint
FlintState:
    .ascii "\nAh, yes. You can't go without a flint!\n\n\0"
FlintCost:
    .quad 34
# ----------------------
# Donkey
DonkeyState:
    .ascii "\nAh, yes. You can't go without a donkey!\n\n\0"
DonkeyCost:
    .quad 2294
# ----------------------
# Knife
KnifeState:
    .ascii "\nAh, yes. You can't go without a knife!\n\n\0"
KnifeCost:
    .quad 352

# ---------------------------------------------
# Ending Statements
Change:
    .ascii "\nYour change is \0"
ChangeTwo:
    .ascii " cents. Good fortune to you.\n\0"

# ---------------------------------------------
# PROGRAM START
.text
.global _start
_start:
# ---------------------------------------------
# Print description of app
    lea rcx,            Description
    call                PrintStringZ
# ---------------------------------------------
# Menu options
    lea rcx,            Menu
    call                PrintStringZ
# ---------------------------------------------
# User Selection
    lea rcx,            MenuSelect
    call                PrintStringZ
# ------------
# Scan users input
    call                ScanInt
# ---------------------------------------------
# Compare the users input
    cmp rcx,            1                                       # if the user enters 1 as selection switch
    je Pan
    cmp rcx,            2                                       # if the user enters 2 as selection switch
    je Map
    cmp rcx,            3                                       # if the user enters 3 as selection switch
    je Flint
    cmp rcx,            4                                       # if the user enters 4 as selection switch
    je Donkey
    cmp rcx,            5                                       # if the user enters 5 as selection switch
    je Knife



Pan:
# ---------------------------------------------
# Use rax to store the cost of said item
    mov rax,            PanCost
# ----------------------
# Print the statement of each item
    lea rcx,            PanState
    call                PrintStringZ
    jmp End
Map:
# ---------------------------------------------
# Use rax to store the cost of said item
    mov rax,            MapCost
# ----------------------
# Print the statement of each item
    lea rcx,            MapState
    call                PrintStringZ
    jmp End

Flint:
# ---------------------------------------------
# Use rax to store the cost of said item
    mov rax,            FlintCost
# ----------------------
# Print the statement of each item
    lea rcx,            FlintState
    call                PrintStringZ
    jmp End
Donkey:
# ---------------------------------------------
# Use rax to store the cost of said item
    mov rax,            DonkeyCost
# ----------------------
# Print the statement of each item
    lea rcx,            DonkeyState
    call                PrintStringZ
    jmp End
Knife:
# ---------------------------------------------
# Use rax to store the cost of said item
    mov rax,            KnifeCost
# ----------------------
# Print the statement of each item
    lea rcx,            KnifeState
    call                PrintStringZ
    jmp End

End:
# ----------------------
# Ask user how many cents they gave clerk
lea rcx, Label
    lea rcx,            GivenCents
    call                PrintStringZ
    call                ScanInt
# ----------------------
# Arithmetic Logic
    sub rcx,            rax
    mov rbx,            rcx
# ----------------------
# Print the users change
    lea rcx,            Change
    call                PrintStringZ
# ----------------------
# Copy back the subtracted totals
    mov rcx,            rbx
    call                PrintInt
    lea rcx,            ChangeTwo
    call                PrintStringZ

    call                Exit

