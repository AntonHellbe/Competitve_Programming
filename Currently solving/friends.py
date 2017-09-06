import sys

class Node:
    def __init__(self, data, rank):
        self.data = data
        self.parent = 0
        self.rank = rank

def makeSet(data, rank):
    node = Node(data, rank)
    node.parent = node
    nodeMap[data] = node

def union(data1, data2):
    node1 = nodeMap[data1]
    node2 = nodeMap[data2]
    parent1 = findset(node1)
    parent2 = findset(node2)

    if(parent1.data == parent2.data):
        return

    if(parent1.rank >= parent2.rank):
        if(parent1.rank == parent2.rank):
            parent1.rank += 1
            parent2.parent = parent1

        parent2.parent = parent1
    else:
        parent1.parent = parent2

def findset(node):
    node_parent = node.parent
    if(node == node_parent):
        return node_parent
    node_parent = findset(node_parent.parent)
    return node_parent

inputData = []

lines = [line.rstrip('\n') for line in sys.stdin]

for line in lines:
    inputData.append(list((map(int, line.split(' ')))))



testcases = inputData[0]
currentLine = 1


for i in range(0, testcases[0]):
    population = inputData[currentLine][0]
    pairOfFriends = inputData[currentLine][1]
    currentLine += 1

    nodeMap = {}

    for j in range(1, population + 1):
        makeSet(j, 0)

    for k in range(0, pairOfFriends):

        friend1 = inputData[currentLine][0]
        friend2 = inputData[currentLine][1]
        union(friend1, friend2)

        currentLine += 1

    myDict = {}

    for node in nodeMap:
        node1 = nodeMap[node]
        parent = findset(node1)
        if(parent.data not in myDict):
            myDict[parent.data] = [node1.data]
        else:
            myDict[parent.data].append(node1.data)

    biggestGroup = 0
    for mySet in myDict.values():
        if(len(mySet) > biggestGroup):
            biggestGroup = len(mySet)

    print(biggestGroup)
