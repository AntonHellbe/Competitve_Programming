"Passes all testcases, running time 70 ms"

import sys

lines = [line.rstrip("\n") for line in sys.stdin]

currentLine = 0

while(len(lines) != 0):
    temp = lines[currentLine].split()
    del lines[currentLine]

    sequence = temp[0]
    coded_str = temp[1]
    counter = 0

    for charIndex, char in enumerate(coded_str):
        if(counter >= len(sequence)):
            break

        if(char == sequence[counter]):
            counter += 1

    if(counter == len(sequence)):
        print("Yes")
    else:
        print("No")
