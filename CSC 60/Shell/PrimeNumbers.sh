#!/bin/bash

# GNU bash, version 4.3.46


# request a valid number between 1 - 100
validNum=false
while [ $validNum == false ]
do
    echo "Enter a number from 0 - 100"
    read value

    # check if number within range
    if (( value > 0 )) && (( value < 100 )); then
        # valid number
        break;
    fi
done


# check if value is 1; 1 isnt prime -> ie.  2,3,5,7,... 

prime=true
if ((value == 1)) 
then 
    echo "$value is not a prime number"
else
    for ((x=2; x < value; x++)) 
    do
        if (( value % x == 0)) 
        then
            prime=false
            break;
        fi
    done


    if [[ $prime == false ]]
    then
        echo "$value is not a prime number."
    else
        echo "$value is a prime number."
    fi

fi