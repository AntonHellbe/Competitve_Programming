"Time limit exceeded, TODO - fix it (Somehow this needs to be improved)"

from collections import deque
import sys

def explore(v):
    visitedDict[v] = 'True'
    for edge in edges:
        if visitedDict[edge[1]] != 'True' and edge[0] == v:
            explore(edge[1])

inputData = []

# lines = [line.rstrip('\n') for line in open('friendstestcases.txt')]
lines = [line.rstrip('\n') for line in sys.stdin]

for line in lines:
    inputData.append(list((map(int, line.split(' ')))))


testcases = inputData[0]
currentLine = 1
bestList = []

for i in range(0, testcases[0]):

    visitedDict = {}
    edges = []


    population = inputData[currentLine][0]
    pairOfFriends = inputData[currentLine][1]
    currentLine += 1

    for j in range(1, population + 1):
        visitedDict[j] = 'False'

    for k in range (0, pairOfFriends):
        friend1 = inputData[currentLine][0]
        friend2 = inputData[currentLine][1]
        edges.append([friend1, friend2])
        edges.append([friend2, friend1])

        currentLine += 1


    longestSet = 0
    uniqueSet = set()
    for j in range(1, population + 1):
        if(j in uniqueSet):
            continue
        else:
            uniqueSet = set()
            explore(j)
            for key in visitedDict:
                if(visitedDict[key] == 'True'):
                    visitedDict[key] = 'False'
                    uniqueSet.add(key)

            if(len(uniqueSet) > longestSet):
                longestSet = len(uniqueSet)

    bestList.append(longestSet)


for best in bestList:
    print(best)
