import sys

currentLine = 2
eq = True
inputData = list()
lines = [line.rstrip('\n') for line in sys.stdin]

def fulcrum():
    global currentLine
    global eq
    inputData = list(map(int, lines[currentLine].split()))
    left = inputData[0]
    right = inputData[2]

    currentLine += 1

    if(inputData[0] == 0):
        left = fulcrum()

    if(inputData[2] == 0):
        right = fulcrum()


    if ((left * inputData[1]) != (right * inputData[3])):
        eq = False

    return left + right


for i in range(int(lines[0])):
    eq = True
    fulcrum()
    if eq:
        print("YES")
    else:
        print("NO")
    if(i != int(lines[0]) - 1):
        print("")

    currentLine += 1
