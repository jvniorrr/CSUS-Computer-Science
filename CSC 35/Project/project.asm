# project.asm
# Fernando Mendoza
# Section 01
#
# 1. Assemble  : as -o project.0 project.asm
# 2. Link      : ld -o a.out project.o csc35.0
# 3. Execute   : ./a.out

.intel_syntax noprefix
.data

# DESCRIPTIONS #
description:
    .ascii "====================\n"
    .ascii "CALIFORNIA GOLD RUSH\n"
    .ascii "====================\n\n\0"

endDescription:
    .ascii "====== GAME OVER ======\n\0"
endDescriptionTwo:
    .ascii "You ended the game with $\0"
endDescriptionThree:
    .ascii "Your endurance was \0"
endDescriptionFourLove:
    .ascii "\nYour love was \0"
endDescriptionFour:
    .ascii "%\n\0"

rules:
    .ascii "1. 20 weeks (5 months)\n"
    .ascii "2. Your endurance and love drops 10% to 30% each week. If your endurance reaches 0%, the game ends.\n"
    .ascii "3. Going to camp adds 50% to 75% to your endurance, and adds 20% to 30% to your love, but costs $25 to $100.\n"
    .ascii "4. Staking out a new claim will cost a week of work.\n"
    .ascii "5. Going to the bar adds 40% to 70% to your endurance, 10% to 30% to your love, but costs $20 to $70\n"
    .ascii "6. Go fishing with your buddies adds 15% to 40% endurance and increases money by $5 to $20.\n\n\0"

weekStatement:
    .ascii "WEEK \0"

weeklyStatement:
    .ascii "\n\nIt\'s Sunday!\n"
    .ascii "You have $\0"                       # print their total money following this statement

enduranceStatement:
    .ascii "\nYour endurance is at \0"
loveStatement:
    .ascii "%\nYour love is at \0"


gameChoices:
    .ascii "%"
    .ascii "\n1. Do Nothing, 2. Go to camp (-$25 to -$100), 3. Stake a new claim, 4. Go to the bar (-$20 to -$70), 5. Go fishing with your buddies (+$5 to +$20).\n\0"


# CHARACTER MONEY AND ENDURANCE #
wallet:
    .quad 100

endurance:
    .quad 100

love:
    .quad 150

totalGold:
    .quad 0

# LABELS FOR WEEKLY MINING BLOCK #
minedGold:
    .ascii "\nYou mined $\0"
minedGoldTwo:
    .ascii " in gold.\n\0"

# LABELS FOR WEEKLY ENDURANCE BLOCK #
enduranceLost:
    .ascii "You lost \0"
enduranceLostTwo:
    .ascii "% endurance.\n\n\0"
# LABELS FOR LOVE ENDURANCE BLOCK #
loveLost:
    .ascii "You lost \0"
loveGained:
    .ascii "You regained \0"
loveGainedOptTwo:
    .ascii "\nYou regained \0"
loveLostTwo:
    .ascii "% love.\n\0"



# LABELS FOR GOING TO CAMP OPTION 2#
townCost:
    .ascii "\nGoing to town cost you $\0"

townEndurance:
    .ascii "\nYou regained \0"
townEnduranceOptTwo:
    .ascii "You regained \0"
townEnduranceTwo:
    .ascii "% endurance.\n\0"


# LABELS FOR STAKE CLAIM OPTION 3 #
leftClaim:
    .ascii "\nYou head off into the wilderness to stake a new claim. You left $\0"
leftClaimTwo:
    .ascii " behind\n\n\0"

# LABELS FOR STAKE CLAIM OPTION 4 - Going to bar #
barCost:
    .ascii "\nGoing to the bar cost you $\0"
barEndurance:
    .ascii "\nYou regained \0"
barEnduranceOptTwo:
    .ascii "You regained \0"
barEnduranceTwo:
    .ascii "% endurance.\n\0"

# LABELS FOR STAKE CLAIM OPTION 5 - Going to fish #
fishCost:
    .ascii "\nAfter going fishing with friends, you gained $\0"
fishEndurance:
    .ascii "\nYou regained \0"
fishEnduranceTwo:
    .ascii "% endurance.\n\0"


# LABELS FOR ASCII ART #
asciiArtTwo:
    .ascii "               .88888888:.\n"
    .ascii "                88888888.88888.\n"
    .ascii "              .8888888888888888.\n"
    .ascii "              888888888888888888\n"
    .ascii "              88' _`88'_  `88888\n"
    .ascii "              88 88 88 88  88888\n"
    .ascii "              88_88_::_88_:88888\n"
    .ascii "              88:::,::,:::::8888\n"
    .ascii "              88`:::::::::'`8888\n"
    .ascii "             .88  `::::'    8:88.\n"
    .ascii "            8888            `8:888.\n"
    .ascii "          .8888'             `888888.\n"
    .ascii "         .8888:..  .::.  ...:'8888888:.\n"
    .ascii "        .8888.'     :'     `'::`88:88888\n"
    .ascii "       .8888        '         `.888:8888.\n"
    .ascii "      888:8         .           888:88888\n"
    .ascii "    .888:88        .:           888:88888:\n"
    .ascii "    8888888.       ::           88:888888\n"
    .ascii "    `.::.888.      ::          .88888888\n"
    .ascii "   .::::::.888.    ::         :::`8888'.:.\n"
    .ascii "  ::::::::::.888   '         .::::::::::::\n"
    .ascii "  ::::::::::::.8    '      .:8::::::::::::.\n"
    .ascii " .::::::::::::::.        .:888:::::::::::::\n"
    .ascii " :::::::::::::::88:.__..:88888:::::::::::'\n"
    .ascii "  `'.:::::::::::88888888888.88:::::::::'\n"
    .ascii "        `':::_:' -- '' -'-' `':_::::'`\n\n\0"


asciiHappyFace:
    .ascii "                          oooo$$$$$$$$$$$$oooo\n"
    .ascii "                      oo$$$$$$$$$$$$$$$$$$$$$$$$o\n"
    .ascii "                   oo$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$o         o$   $$ o$\n"
    .ascii "   o $ oo        o$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$o       $$ $$ $$o$\n"
    .ascii "oo $ $ \"$      o$$$$$$$$$    $$$$$$$$$$$$$    $$$$$$$$$o       $$$o$$o$\n"
    .ascii "\"$$$$$$o$     o$$$$$$$$$      $$$$$$$$$$$      $$$$$$$$$$o    $$$$$$$$\n"
    .ascii "  $$$$$$$    $$$$$$$$$$$      $$$$$$$$$$$      $$$$$$$$$$$$$$$$$$$$$$$\n"
    .ascii "  $$$$$$$$$$$$$$$$$$$$$$$    $$$$$$$$$$$$$    $$$$$$$$$$$$$$  \"\"\"$$$\n"
    .ascii "   \"$$$\"\"\"\"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$     \"$$$\n"
    .ascii "    $$$   o$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$     \"$$$o\n"
    .ascii "   o$$\"   $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$       $$$o\n"
    .ascii "   $$$    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\" \"$$$$$$ooooo$$$$o\n"
    .ascii "  o$$$oooo$$$$$  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$   o$$$$$$$$$$$$$$$$$\n"
    .ascii "  $$$$$$$$\"$$$$   $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$     $$$$\"\"\"\"\"\"\"\"\n"
    .ascii " \"\"\"\"       $$$$    \"$$$$$$$$$$$$$$$$$$$$$$$$$$$$\"      o$$$\n"
    .ascii "            \"$$$o     \"\"\"$$$$$$$$$$$$$$$$$$\"$$\"         $$$\n"
    .ascii "              $$$o          \"$$\"\"$$$$$$\"\"\"\"           o$$$\n"
    .ascii "               $$$$o                                o$$$\"\n"
    .ascii "                \"$$$$o      o$$$$$$o\"$$$$o        o$$$$\n"
    .ascii "                  \"$$$$$oo     \"\"$$$$o$$$$$o   o$$$$\"\"\n"
    .ascii "                     \"\"$$$$$oooo  \"$$$o$$$$$$$$$\"\"\"\n"
    .ascii "                       \"\"$$$$$$$oo $$$$$$$$$$\n"
    .ascii "                                \"\"\"\"$$$$$$$$$$$\n"
    .ascii "                                    $$$$$$$$$$$$\n"
    .ascii "                                     $$$$$$$$$$\"\n"
    .ascii "                                      \"$$$\"\"\"\"\n\n\0"
    


asciiGoodBye:
    .ascii "              bbyyeebb                                                                                                                                                      \n"
    .ascii "            yy8888888888                                                                                                                                                    \n"
    .ascii "        bb888888                                                                                                                                                            \n"
    .ascii "        8888                                                                                                                                                                \n"
    .ascii "      8888                                                                                    bb                                                                            \n"
    .ascii "    8888                                                                                      8888                                                                          \n"
    .ascii "    8888                                                                                      8888                                                                          \n"
    .ascii "  ee88bb  8888eeee8888              yy888888yy                                                8888          88                                                              \n"
    .ascii "  8888  888888888888888888      8888888888888888                                              8888          88                                                              \n"
    .ascii "  8888              888888bb    8888yy    88888888        88888888888888                      8888          88                                                              \n"
    .ascii "  8888              888888yy  8888          888888    bb8888yyyy    88888888e                 8888          88                                                              \n"
    .ascii "  ee8888yyyy888888888888      8888        888888yy    888888              8888              bb8888        8888                                                              \n"
    .ascii "    bb88888888888888bb        8888888888888888bb      8888                888  bee88888888ee8888yy        8888                                                              \n"
    .ascii "          bb                  yy88888888bbyybb        8888              888  88888yy      888888bb        8888ee88                                                          \n"
    .ascii "                                                      yy888888888888888888  8888            ee88bb        888888888888          yy                                          \n"
    .ascii "                                                        bbbb888888eeeebb    8888          yy8888bb        8888    888888      8888                                          \n"
    .ascii "                                                                            8888        bb888888ee        8888      yy88bb    8888                      yybbyyyybb          \n"
    .ascii "                                                                            8888bb    bb8888yy8888        88          8888    8888            8888    bbyy8888888888yy      \n"
    .ascii "                                                                              888888888888bb    8888      88          8888    8888bb          8888    yy88888888888888yy    \n"
    .ascii "                                                                                yyeeeebb        ee88    ee88ee      bb88ee    888888yy        88yy  bb8888yy      888888    \n"
    .ascii "                                                                                                        yy88888888888888      bb88888888yy888888bb  ee88bbbb        8888bb  \n"
    .ascii "                                                                                                          yy8888888888bb          ee888888888888    88yyyy8888eeee888888bb  \n"
    .ascii "                                                                                                              yybbyy                  yybbyy8888    88  yy8888888888eebb    \n"
    .ascii "                                                                                                                                            88bb    88  yy88eeeebbbb        \n"
    .ascii "                                                                                                                                            88      8888                    \n"
    .ascii "                                                                                                                                            88      yy8888yy                \n"
    .ascii "                                                                                                                                            88      bb8888888888888888888888\n"
    .ascii "                                                                                                                                            88          ee88ee888888888888bb\n"
    .ascii "                                                                                                                                          8888                  yyyybbeeyy  \n"
    .ascii "                                                                                                                                          8888                              \n"
    .ascii "                                                                                                                      bb88ee            ee88yy                              \n"
    .ascii "                                                                                                                        8888yy8888ee88888888                                \n"
    .ascii "                                                                                                                        888888888888888888bb                                \n"
    .ascii "                                                                                                                        yy888888ee88ee88bb                                  \n\n\0"

.text
.global _start
_start:


# ---------------------------------------------
# ASCII ART w/ COLOR
# ---------------------------------------------
InitializehappyFaceArtLoopColor:
    lea rcx,            asciiHappyFace
    call                LengthStringZ                           # get the length of string to iterate it
    mov r8,             rcx

    mov rdi,            0                                       # set a counter variable so dont pass index
happyFaceArtLoop:
    # add break if not its infinite loop
    cmp r8,             rdi
    je                  InitializeLetterLoopColor

    mov rcx,            7
    call                Random                                  # get a random color to print the text
    call                SetForeColor                            # Set the text color

    movb cl,            [asciiHappyFace+rdi]                    # load the ascii character and print
    call                PrintChar

    add rdi,            1                                       # increment rdi or our index
    
    jmp                 happyFaceArtLoop                        # jump back to while loop


# ---------------------------------------------
# COLORFUL TEXT INTRO
# ---------------------------------------------
InitializeLetterLoopColor:
    lea rcx,            description
    call                LengthStringZ                           # get the length of string to iterate it
    mov r8,             rcx

    mov rdi,            0                                       # set a counter variable so dont pass index
LetterLoop:
    # add break if not its infinite loop
    cmp r8,             rdi
    je                  Initialize

    mov rcx,            7
    call                Random                                  # get a random color to print the text
    call                SetForeColor                            # Set the text color

    movb cl,            [description+rdi]                       # load the ascii character and print
    call                PrintChar

    add rdi,            1                                       # increment rdi or our index
    
    jmp                 LetterLoop                              # jump back to while loop


Initialize:
    
    # reset text color
    mov rcx,            7
    call                SetForeColor

    lea rcx,            rules
    call                PrintStringZ                            # print the rules of the game
    # setup the initial gold stake claim
    mov rcx,            1001
    call                Random
    mov totalGold,      rcx


    # use a pre defined register to store a counter variable
    mov rax,            0                                       # COUNTER = rax
    jmp                 mainGame

mainGame:
    add rax,            1                                       # add to our counter variable
    mov rcx,            rax
    cmpq rcx,           21
    je                  end                                     # end the game after the 20th week

    # add a check for endurance to see if its lower than 0
    mov rcx,            endurance
    cmpq rcx,           0
    jle                 end

    # change the color
    mov rcx,            6                                       # register, color cyan
    call                SetForeColor

    lea rcx,            weekStatement
    call                PrintStringZ
    mov rcx,            rax
    call                PrintInt                                # print "Week X"
    # change the color
    mov rcx,            7                                       # register, color white/reset
    call                SetForeColor



    lea rcx,            weeklyStatement
    call                PrintStringZ

    # change the color
    mov rcx,            2                                       # register, color green
    call                SetForeColor

    mov rcx,            wallet
    call                PrintInt                                # print "You have $XXX"

    # change the color
    mov rcx,            7                                       # register, color white / reset
    call                SetForeColor

    lea rcx,            enduranceStatement
    call                PrintStringZ

    # change the color
    mov rcx,            2                                       # register, color green
    call                SetForeColor

    mov rcx,            endurance
    call                PrintInt                                # print "Your endurance is at XX%"

    # change the color
    mov rcx,            7                                       # register, color white
    call                SetForeColor

    lea rcx,            loveStatement
    call                PrintStringZ

    # change the color
    mov rcx,            2                                       # register, color green
    call                SetForeColor

    mov rcx,            love
    call                PrintInt                                # print "Your love is at XX%"

    # change the color
    mov rcx,            7                                       # register, color white
    call                SetForeColor


    lea rcx,            gameChoices
    call                PrintStringZ                            # print "1. Do Nothing, 2. Go to camp (-$25 to -$100), 3. Stake a new claim, 4. Go to the bar (-$20 to -$70), 5. Go fishing with your buddies (+$5 to +$20)"


    # retrieve input from user for game choice
    # change the color
    mov rcx,            1                                       # register, color red
    call                SetForeColor
    call                ScanInt

    cmpq rcx,           1
    je                  weeklyMine                              # if choice is to do nothing

    cmpq rcx,           2
    je                  goToCamp                                # if choice is to go to camp

    cmpq rcx,           3
    je                  stakeNewClaim                           # if the choice is to stake a new claim

    cmpq rcx,           4
    je                  goToBar                                 # if the choice is to go the bar
    
    cmpq rcx,           5
    je                  goToFish                                 # if the choice is to go the fish

goToFish:
        # change the color
    mov rcx,            7                                       # register, color white/reset
    call                SetForeColor

    lea rcx,            fishCost
    call                PrintStringZ                            # print "Going fishing with friends gained you $XX"


    # change the color
    mov rcx,            2                                       # register, color green
    call                SetForeColor
    # the net gain of fishing is between 5-20
    mov rcx,            16
    call                Random
    add rcx,            5                                      # create a random number variable storing num between 5-20
    call                PrintInt
    add wallet,         rcx                                     # add the gain after fishing to users wallet

    # change the color
    mov rcx,            7                                       # register, color white
    call                SetForeColor


    lea rcx,            fishEndurance
    call                PrintStringZ


    # change the color
    mov rcx,            2                                       # register, color green
    call                SetForeColor
    # the cost of going fishing is + 15-40 endurance
    mov rcx,            26
    call                Random
    add rcx,            15
    call                PrintInt
    add endurance,      rcx

    # change the color
    mov rcx,            7                                       # register, color white/reset
    call                SetForeColor


    lea rcx,            fishEnduranceTwo
    call                PrintStringZ                            # print "You regained XX% endurance"

    jmp                 weeklyMine


goToBar:
    # change the color
    mov rcx,            7                                       # register, color white/reset
    call                SetForeColor

    lea rcx,            barCost
    call                PrintStringZ                            # print "Going to the bar cost you $XX"


    # change the color
    mov rcx,            2                                       # register, color green
    call                SetForeColor
    # the cost of going to the bar is between 20-70
    mov rcx,            51
    call                Random
    add rcx,            20                                      # create a random number variable storing num between 20-70
    call                PrintInt
    sub wallet,         rcx                                     # subtract the cost of going to twon from users wallet

    # change the color
    mov rcx,            7                                       # register, color white
    call                SetForeColor

    
    # print after going to the bar you gained love
    lea rcx,            loveGainedOptTwo
    call                PrintStringZ
    # remove love from the user for going to camp
    # change the color
    mov rcx,            2                                       # register, color green
    call                SetForeColor
    # the result of going to camp is love between 10 to 30% for seeing family
    mov rcx,            21
    call                Random
    add rcx,            10
    call                PrintInt
    add love,           rcx

    # change the color
    mov rcx,            7                                       # register, color white/reset
    call                SetForeColor
    lea rcx,            loveLostTwo
    call                PrintStringZ


    # print You regained X% endurance
    lea rcx,            barEnduranceOptTwo
    call                PrintStringZ

    # change the color
    mov rcx,            2                                       # register, color green
    call                SetForeColor
    # the cost of going to camp is + 40-70 endurance
    mov rcx,            31
    call                Random
    add rcx,            40
    call                PrintInt
    add endurance,      rcx

    # change the color
    mov rcx,            7                                       # register, color white/reset
    call                SetForeColor


    lea rcx,            barEnduranceTwo
    call                PrintStringZ                            # print "You regained XX% endurance"

    jmp                 weeklyMine

goToCamp:
    # change the color
    mov rcx,            7                                       # register, color white/reset
    call                SetForeColor

    lea rcx,            townCost
    call                PrintStringZ                            # print "Going to town cost you $XX"


    # change the color
    mov rcx,            2                                       # register, color green
    call                SetForeColor
    # the cost of going to camp is between 25-100
    mov rcx,            76
    call                Random
    add rcx,            25                                      # create a random number variable storing num between 20-100
    call PrintInt
    sub wallet,         rcx                                     # subtract the cost of going to twon from users wallet


    # change the color
    mov rcx,            7                                       # register, color white/reset
    call                SetForeColor
    # print after going to camp you gained love; using townEndurance since it has a new lin it which we need
    lea rcx,            townEndurance
    call                PrintStringZ
    # remove love from the user for going to camp
    # change the color
    mov rcx,            2                                       # register, color green
    call                SetForeColor
    # the result of going to camp is love between 20 to 30% for seeing family
    mov rcx,            11
    call                Random
    add rcx,            20
    call                PrintInt
    add love,           rcx

    # change the color
    mov rcx,            7                                       # register, color white/reset
    call                SetForeColor
    lea rcx,            loveLostTwo
    call                PrintStringZ

    # change the color
    mov rcx,            7                                       # register, color white
    call                SetForeColor


    # print the endurance the user gained
    lea rcx,            townEnduranceOptTwo
    call                PrintStringZ

    # change the color
    mov rcx,            2                                       # register, color green
    call                SetForeColor
    # the cost of going to camp is 50-75 endurance
    mov rcx,            26
    call                Random
    add rcx,            50
    call                PrintInt
    add endurance,      rcx    

    # change the color
    mov rcx,            7                                       # register, color white/reset
    call                SetForeColor
    lea rcx,            townEnduranceTwo
    call                PrintStringZ                            # print "You regained XX% endurance"


    jmp                 weeklyMine

stakeNewClaim:

    # change the color
    mov rcx,            7                                       # register, color white/reset
    call                SetForeColor

    # -if user claims new stake create random value for our totalGold

    lea rcx,            leftClaim                               # Print "You head off into the wilderness to stake a new claim. You left $XX begind"
    call                PrintStringZ

    # change the color
    mov rcx,            2                                       # register, color green
    call                SetForeColor

    mov rcx,            totalGold
    call                PrintInt

    # change the color
    mov rcx,            7                                       # register, color white
    call                SetForeColor

    lea rcx,            leftClaimTwo
    call                PrintStringZ

    mov rcx,            1001
    call                Random
    mov totalGold,      rcx                                     # store the total gold at a site


    jmp wearAndTear


weeklyMine:

    # change the color
    mov rcx,            7                                       # register, color white/reset
    call                SetForeColor


    # you mined $16 in gold
    lea rcx,            minedGold
    call                PrintStringZ

    # the user mined X amount from the total stake
    # change the color
    mov rcx,            2                                       # register, color green
    call                SetForeColor

    mov rcx,            totalGold
    call                Random
    call                PrintInt

    # subtract the mined amount from total stake
    sub totalGold,      rcx
    add wallet,         rcx

    # change the color
    mov rcx,            7                                       # register, color white/reset
    call                SetForeColor


    lea rcx,            minedGoldTwo
    call                PrintStringZ

    jmp                 wearAndTear

wearAndTear:

    # remove love because away from family 
    lea rcx,            loveLost
    call                PrintStringZ
    # change the color
    mov rcx,            2                                       # register, color green
    call                SetForeColor


    # create a random variable to get the endurance lost (value between 10-30)
    mov rcx,            21
    call                Random
    add rcx,            10
    sub love,           rcx
    call                PrintInt            

    # change the color
    mov rcx,            7                                       # register, color white
    call                SetForeColor

    lea rcx,            loveLostTwo
    call                PrintStringZ

    
    lea rcx,            enduranceLost
    call                PrintStringZ

    # change the color
    mov rcx,            2                                       # register, color green
    call                SetForeColor


    # create a random variable to get the endurance lost (value between 10-30)
    mov rcx,            21
    call                Random
    add rcx,            10
    sub endurance,      rcx
    call                PrintInt

    # change the color
    mov rcx,            7                                       # register, color white
    call                SetForeColor


    lea rcx,            enduranceLostTwo
    call                PrintStringZ

    jmp                 mainGame

end:
    lea rcx,            endDescription
    call                PrintStringZ

    lea rcx,            endDescriptionTwo
    call                PrintStringZ

    # change the color
    mov rcx,            2                                       # register, color green
    call                SetForeColor

    mov rcx,            wallet
    call                PrintInt
    
    # change the color
    mov rcx,            7                                       # register, color white/reset
    call                SetForeColor

    # print your love was at end
    lea rcx,            endDescriptionFourLove
    call                PrintStringZ

    # change the color
    mov rcx,            2                                       # register, color green
    call                SetForeColor

    mov rcx,            love
    call                PrintInt
    
    # change the color
    mov rcx,            7                                       # register, color white/reset
    call                SetForeColor

    lea rcx,            endDescriptionFour
    call                PrintStringZ

    lea rcx,            endDescriptionThree
    call                PrintStringZ

    # change the color
    mov rcx,            2                                       # register, color green
    call                SetForeColor

    mov rcx,            endurance
    call                PrintInt

    # change the color
    mov rcx,            7                                       # register, color white/reset
    call                SetForeColor

    lea rcx,            endDescriptionFour
    call                PrintStringZ

# ---------------------------------------------
# ASCII ART w/ COLOR
# ---------------------------------------------
InitializeGoodByeColor:
    lea rcx,            asciiGoodBye
    call                LengthStringZ                           # get the length of string to iterate it
    mov r8,             rcx

    mov rdi,            0                                       # set a counter variable so dont pass index
GoodByeLoop:
    # add break if not its infinite loop
    cmp r8,             rdi
    je                  CompleteEnd

    mov rcx,            7
    call                Random                                  # get a random color to print the text
    call                SetForeColor                            # Set the text color

    movb cl,            [asciiGoodBye+rdi]                      # load the ascii character and print
    call                PrintChar

    add rdi,            1                                       # increment rdi or our index
    
    jmp                 GoodByeLoop                             # jump back to while loop

CompleteEnd:
    # change the color
    mov rcx,            7                                       # register, color white/reset
    call                SetForeColor
    call                Exit
    