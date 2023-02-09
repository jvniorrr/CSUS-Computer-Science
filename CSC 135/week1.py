# PROBLEM 1
import math
def circle_area(radius):
    """accepts the radius of a circle as a parameter (as a number) and returns the area of a circle with that radius"""
    return math.pi * math.pow(radius, 2)

# PROBLEM 4
def average_of_2(num, num1):
    """takes two integers as parameters and returns the average of the two integers."""
    return (num + num1) / 2

# PROBLEM 5
def median_of_3(n1, n2, n3):
    """returns the median (middle) of three integer values."""
    # check num 1
    if n1 > n3:
        # 1 is biggest right now compare with 2
        if n1 > n2:
            if n2 > n3:
                return n2
            else:
                return n3
        else:
            return n1
    else:
        # 3 is biggest right now compare with 2
        if n3 > n2:
            if n2 > n1:
                return n2
            else:
                return n1
        else:
            return n3

# PROBLEM 6
def count_digits(value):
    """accepts an integer parameter and returns the number of digits in that integer. """
    return( len(str(value).replace("-", "")) )

# PROBLEM 7
def box_of_stars(width, height):
    """prints to the console a 'box' figure whose border is * stars and whose center is made of spaces with the provided parameters"""
    wString = ""
    for i in range(width):
        wString += "*"
    #wString += ""
    print(wString)
    
    hString = "*".ljust(width - 1, " ")
    hString += "*"
    for i in range(height - 2):
        print(hString)
        
    print(wString)
# PROBLEM 8
import random

def coin_flip(occur, side):
    """simulates repeatedly flipping a two-sided coin until a particular side (Heads or Tails) comes up several times consecutively (in a row)."""
    if occur < 0 or not (side == 'H' or side == 'T'):
        print("ERROR!")
        return
    
    match = occur
    flip = ""
    while match != 0:
        flip = random.choice(['H', 'T'])
        print(flip, end= ' ')
        if flip == side:
            match -= 1
        else:
            match = occur
    print(f'\nYou got {side} {occur} times in a row!')


# PROBLEM 9
def average_length(data):
    """computes and returns the average string length of the elements of a list of strings"""
    return (len("".join(data)) / len(data))


# PROBLEM 10
def is_palindrome(data):
    """accepts a list of strings as its argument and returns True if that list is a palindrome"""
    for i in range(len(data) // 2):
        if data[i] != data[-(i + 1)]:
            return False
    return True

# PROBLEM 11
def max_length(data):
    """accepts as a parameter a set of strings, and that returns the length of the longest string in the set."""
    if (len(data) < 1):
        return 0
    data = list(data)
    
    longest = len(data[0])
    
    for i in range(1, len(data)):
        if len(data[i]) > longest:
            longest = len(data[i])
    return longest

# PROBLEM 12
def collapse(data):
    """accepts a list of integers as a parameter and returns a new list where each pair of integers from the original list has been replaced by the sum of that pair."""
    returnValue = []
    j = 0
    for i in range(0, len(data) - 1, 2):
        returnValue.append(data[i] + data[i+1])
        j += 2

    if j != len(data):
        returnValue.append(data[-1])
    return returnValue
        
# PROBLEM 13
def is_stack_sorted2(data):
    # edge case
    tmp = data
    if len(tmp) <= 1:
        return True
    else:
        if (tmp.pop() > ):
            return False # not sorted
        else:
            return is_stack_sorted2(tmp)

def is_stack_sorted(data):
    """accepts a list object that is treated as a stack to see if the stack is sorted"""
    # treat data as stack. FILO

    # edge case that no elements are passed
    if (len(data) == 0):
        return True 

    # Create list to hold the popped objecys
    popped_el = []
    
    # Get the first object currently in our stack; ie the last (since its First in First out)
    lastElem = data.pop()
    popped_el.append(lastElem)

    sortedVar = True

    # can only use len on object since treating as a stack.
    while (len(data) != 0):
        next_last_value = data.pop()  # second to last element
        
        # compare the last element with the 2nd to last element
        if (lastElem <= next_last_value):
            lastElem = next_last_value
            # add the last element stored in a new stack object
            popped_el.append(lastElem)
        else:
            # add the second to last element; edge case?
            popped_el.append(next_last_value)
            sortedVar = False
    # add the removed elements from our original stack; in other words repopulate the stack to its original state
    while (len(popped_el) != 0):
        data.append(popped_el.pop())
    
    return sortedVar

# PROBLEM 14
def has_duplicate_value(data):
    """accepts a dictionary from strings to strings as a parameter and returns True if any two keys map to the same value."""
    keys = [key for key in data]

    # check every key with the next
    for i in range(len(keys)):
        currValue = data[keys[i]] # get the value that is stored in the dictionary
        j = i + 1 # increment by one and reference the following elements
        while j != len(keys):
            if currValue == data[keys[j]]:
                return True
            j += 1

    return False

# PROBLEM 15
def remove_duplicates(data):
    """accepts as a parameter a list of integers, and modifies it by removing any duplicates"""
    # loop through our list and reference the following objects
    i = 0
    while (i < len(data)):
        currValue = data[i]

        # check the following elements and make sure they are not duplicated
        j = i + 1
        while (j < len(data)):
            # compare if duplicated further in list
            if data[j] == currValue:
                # remove the element that follows the currValue
                del data[j]
                j -= 1
            j += 1 # increment our counter variable

        i += 1 # increment the currValue
    return data




if __name__ == "__main__":
    pass