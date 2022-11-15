#!/bin/bash

# let sum = 0
for n in $@
    do
    let "sum = sum + n"
done

echo "The total is " $sum