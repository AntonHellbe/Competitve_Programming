import sys

inputData = []
outputData = []
stacksTuples = []

# lines = [line.rstrip('\n') for line in open('testcasesBoxofbricks.txt')]
lines = [line.rstrip('\n') for line in sys.stdin]

for line in lines:
    inputData.append(list((map(int, line.split(' ')))))


sortedHeights = 'None'
stacksNotEqual = True
currentStack = 0
stackCounter = 1
moves = 0
firstIndex = 0
x = 0

if(currentStack == 0):
    stacks = inputData[currentStack][0]
    currentStack += 1
    totalBricks = sum(inputData[currentStack])
    equalHeight = (totalBricks / stacks)
    sortedHeights = sorted(inputData[currentStack])
    lastIndex = len(sortedHeights) - 1
    halfLength = int(len(sortedHeights) / 2)

while(stacksNotEqual):

    if (lastIndex < firstIndex or firstIndex > lastIndex):
        currentStack += 1
        outputData.append('Set #%d' % stackCounter)
        outputData.append('The minimum number of moves is %d.\n' % moves)
        if(inputData[currentStack][0] == 0):
            stacksNotEqual = False
            continue
        else:
            moves = 0
            firstIndex = 0
            stackCounter += 1
            stacks = inputData[currentStack][0]
            currentStack += 1
            totalBricks = sum(inputData[currentStack])
            equalHeight = (totalBricks / stacks)
            sortedHeights = sorted(inputData[currentStack])
            lastIndex = len(sortedHeights) - 1
            halfLength = int(len(sortedHeights) / 2)

    if (sortedHeights[firstIndex] != equalHeight and sortedHeights[lastIndex] != equalHeight):
        sortedHeights[firstIndex] += 1
        sortedHeights[lastIndex] -= 1
        moves += 1

    if(sortedHeights[lastIndex] == equalHeight):
        lastIndex -= 1
    if(sortedHeights[firstIndex] == equalHeight):
        firstIndex += 1

for line in outputData:
    print(line)
