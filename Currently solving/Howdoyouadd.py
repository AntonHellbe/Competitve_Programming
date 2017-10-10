import sys


lines = [line.rstrip("\n") for line in sys.stdin]


currentLine = 0

while(True):
    data = list(map(int, lines[currentLine].split(" ")))
    number = int(data[0])
    combinations = int(data[1])

    if(number == 0 and combinations == 0):
        break

    filledArray = [[i for i in range(combinations + 1)] for j in range(number)]

    # for row in filledArray:
        # print(row)

    for i in range(1, number):
        for j in range(1, combinations + 1):
            filledArray[i][j] = filledArray[i -1][j] + filledArray[i][j - 1]

    value = filledArray[number - 1][combinations] % 1000000
    print(value)
    currentLine += 1
