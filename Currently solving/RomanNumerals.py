import sys
import re

romanDictionary = {
    'M':1000,
    'CM':900,
    'D':500,
    'CD':400,
    'C':100,
    'XC':90,
    'L':50,
    'XL':40,
    'X':10,
    'IX':9,
    'V':5,
    'IV':4,
    'III':3,
    'II':2,
    'I':1
}

def makesum_left(numeral1, numeral2):
    totalSum = 0
    beforeAddition = list()
    afterAddition = list()
    startIndex = 0
    sumString = ""

    if len(numeral1) == 1:
        totalSum += romanDictionary[numeral1[0]]
    else:
        for j in range(0, len(numeral1) - 1, 2):
            if numeral1[j] < numeral1[j + 1]:
                sumString = numeral1[j] + numeral1[j + 1]
                totalSum += romanDictionary[sumString]
            else:
                totalSum += romanDictionary[numeral1[j]]
                totalSum += romanDictionary[numeral1[j + 1]]
    if len(numeral2) == 1:
        totalSum += romanDictionary[numeral2[0]]
    else:
        for j in range(0, len(numeral2) - 1, 2):
            if numeral2[j] < numeral2[j + 1]:
                sumString = numeral2[j] + numeral2[j + 1]
                totalSum += romanDictionary[sumString]
            else:
                totalSum += romanDictionary[numeral2[j]]
                totalSum += romanDictionary[numeral2[j + 1]]


    return totalSum

def makesum_right(numerals):
    totalSum = 0
    if(len(numerals) == 1):
        return romanDictionary[numerals[0]]

    for j in range(0, len(numerals) - 1, 2):
        if numerals[j] < numerals[j + 1]:
            sumString = numerals[j] + numerals[j + 1]
            totalSum += romanDictionary[sumString]
        else:
            totalSum += romanDictionary[numerals[j]]
            totalSum += romanDictionary[numerals[j + 1]]

    return totalSum

def arabic_encoding():
    print()



lines = [line.rstrip("\n") for line in sys.stdin]

currentLine = 0
data = []


while(True):

    try:
        data = re.split(r'[\+=]', lines[currentLine])
    except:
        break

    right_side = list(data[2])

    left_value = makesum_left(data[0], data[1])
    right_value = makesum_right(right_side)

    if left_value == right_value:
        print("Correct")
    else:
        print("Incorrect")


    break
