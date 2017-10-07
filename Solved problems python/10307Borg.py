"Passes all test"

import sys
from collections import deque
from collections import defaultdict
import time

def timing(f):
    def wrap(*args):
        time1 = time.time()
        ret = f(*args)
        time2 = time.time()
        print ('%s function took %0.3f ms' % (f.__name__, (time2-time1)*1000.0))
        return ret
    return wrap

class UnionFind:
    def __init__(self):
        self.nodeMap = {}

    def getKeys(self):
        return list(self.nodeMap.keys())

class Node:
    def __init__(self, data, rank):
        self.data = data
        self.parent = 0
        self.rank = rank


class Graph:
    def __init__(self,vertices):
        self.V= vertices
        self.graph = []

    def addEdge(self,u,v,w):
        self.graph.append([u, v, w])

    def getEdges(self):
        return self.graph


def makeSet(data, rank, UnionFind):
    node = Node(data, rank)
    node.parent = node
    UnionFind.nodeMap[data] = node

def union(UnionFind, data1, data2):
    node1 = UnionFind.nodeMap[data1]
    node2 = UnionFind.nodeMap[data2]
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


def getWeight(startNode, toNodes):
    distances = []
    bfs((startNode[1], startNode[2]))
    for node in toNodes:
        distances.append((startNode[0], weights[node[1]][node[2]], node[0]))

    return distances


def createMST(graph):
    mst = []
    uf = UnionFind()
    edges = graph.getEdges()
    for i in range(alientCount):
        makeSet(i, 0, uf)
    sortedEdges = sorted(edges, key= lambda item: item[1])
    for edge in sortedEdges:
        if not findset(uf.nodeMap[edge[0]]) == findset(uf.nodeMap[edge[2]]):
            union(uf, edge[0], edge[2])
            mst.append(edge[1])
    return mst



# @timing
def bfs(start):
    q = deque()
    # print(start[0], start[1])
    weights[start[0]][start[1]] = 0
    q.append(start)

    while len(q) != 0:
        start = q.pop()
        # print(start[0], start[1])
        if start[0] >= 0 and start[0] + 1 < y and matrix[start[0] + 1][start[1]] != '#':
            if weights[start[0]][start[1]] + 1 < weights[start[0] + 1][start[1]]:
                weights[start[0] + 1][start[1]] = weights[start[0]][start[1]] + 1
                q.append((start[0] + 1, start[1]))

        if start[0] - 1 >= 0 and start[0] < y and matrix[start[0] - 1][start[1]] != '#':
            if weights[start[0]][start[1]] + 1 < weights[start[0] - 1][start[1]]:
                weights[start[0] - 1][start[1]] = weights[start[0]][start[1]] + 1
                q.append((start[0] - 1, start[1]))

        if start[1] >= 0 and start[1] + 1 < x and matrix[start[0]][start[1] + 1] != '#':
            if weights[start[0]][start[1]] + 1 < weights[start[0]][start[1] + 1]:
                weights[start[0]][start[1] + 1] = weights[start[0]][start[1]] + 1
                q.append((start[0] , start[1] + 1))

        if start[1] - 1 >= 0 and start[1] < x and matrix[start[0]][start[1] - 1] != '#':
            if weights[start[0]][start[1]] + 1 < weights[start[0]][start[1] - 1]:
                weights[start[0]][start[1] - 1] = weights[start[0]][start[1]] + 1
                q.append((start[0], start[1] - 1))


def clearWeight(x, y):
    return [[999999 for i in range(x)] for j in range(y)]

lines = [line.rstrip('\n') for line in sys.stdin]
weights = 0
testcases = int(lines[0])
start = 0
lineCount = 1
alientCount = 1



for i in range(testcases):
    alientCount = 1
    matrix = []
    aliens = []
    data = list(map(int, lines[lineCount].split()))
    x = data[0]
    y = data[1]
    weights = clearWeight(x, y)
    lineCount += 1

    for j in range(0, y):
        temp = list(lines[lineCount])
        if('A' in temp or 'S' in temp):
            for charIndex, char in enumerate(temp):
                if(char == 'A'):
                    aliens.append((alientCount, j, charIndex))
                    alientCount += 1
                if(char == 'S'):
                    start = (0, j, charIndex)
            matrix.append(temp)
        else:
            matrix.append(temp)

        lineCount += 1

    if(start == 0 or len(aliens) == 0):
        print("0")
        continue
    edges = []

    edges.extend(getWeight(start, aliens))
    weights = clearWeight(x, y)
    while(len(aliens) >= 2):
        temp = aliens[:1][0]
        aliens = aliens[1:]
        edges.extend(getWeight(temp, aliens))
        weights = clearWeight(x, y)

    # print(edges)
    graph = Graph(alientCount)
    for edge in edges:
        graph.addEdge(edge[0], edge[1], edge[2])

    bestWay = sum(createMST(graph))
    print(bestWay)
