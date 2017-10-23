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

def arabic_encoding(character_list, leading_char, current_index, used, value, sol_no, a, b, c):
    if sol_no > 1:
        return sol_no

    if(current_index == len(character_list)):
        n1, n2, n3 = 0, 0, 0

        for c in a:
            n1 = n1 * 10 + value[ord(c)]
        for c in b:
            n2 = n2 * 10 + value[ord(c)]
        for c in c:
            n3 = n3 * 10 + value[ord(c)]

        if(n1 + n2 == n3):
            sol_no += 1

        return

    curren_char = leading_char[ord(character_list[current_index])]

    leading_or_not_leading = 0
    if not curren_char:
        leading_or_not_leading = 0
    else:
        leading_or_not_leading = 1

    for i in range(leading_or_not_leading, 10 and sol_no <= 1, 1):
        if not used[i]:
            value[ord(character_list[current_index])] = i
            used[i] = True
            solve(character_list, leading_char, current_index + 1, used, value, sol_no, a, b , c)
            used[i] = False



def roman_to_number(character_list):
    number = 0
    tempstr = ""
    for i in range(len(character_list) - 1, 2):
        if character_list[i] < character_list[i + 1]:
            tempstr = character_list[i] + character_list[i + 1]
            number += romanDictionary[tempstr]
        else:
            number += romanDictionary[character_list[i]]
            number += romanDictionary[character_list[i + 1]]

    return number






lines = [line.rstrip("\n") for line in sys.stdin]
currentLine = 0
data = []


while(True):
    try:
        data = re.split(r'[\+=]', lines[currentLine])
    except:
        break
    sol_no = 0
    first = data[0]
    second = data[1]
    third = data[2]
    containsCharacters = []
    leading_characters = [False for i in range(129)]
    potential_encoding = [False for j in range(10)]

    for character in lines[currentLine]:
        if character not in containsCharacters and character != '=' and character != '+':
            containsCharacters.append(character)



    val = [0 for i in range(129)]
    leading_characters[ord(first[0])] = True
    leading_characters[ord(second[0])] = True
    leading_characters[ord(third[0])] = True

    print(arabic_encoding(containsCharacters, leading_characters, 0, potential_encoding, val, sol_no, first, second, third))
