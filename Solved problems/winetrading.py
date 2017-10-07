"Passes all testcases, running time 220 ms"

import sys

lines = [line.rstrip("\n") for line in sys.stdin]

currentLine = 0

while(True):

    if(len(lines[currentLine]) == 1 and int(lines[currentLine]) == 0):
        break

    data = list(map(int, lines[currentLine].split()))

    totalMoved = 0


    inhabitants = data[0]
    currentLine += 1

    data = list(map(int, lines[currentLine].split()))

    firstHalf = data[:int(len(data)/2)]
    secondHalf = data[len(firstHalf):]
    secondHalf.reverse()

    # print(secondHalf)

    for i in range(len(firstHalf) - 1):
        totalMoved += abs(firstHalf[i])
        firstHalf[i + 1] = firstHalf[i] + firstHalf[i + 1]



    for j in range(len(secondHalf) - 1):
        totalMoved += abs(secondHalf[j])
        secondHalf[j + 1] = secondHalf[j] + secondHalf[j + 1]


    totalMoved += abs(firstHalf[len(firstHalf) - 1])



    currentLine += 1


    print(totalMoved)
