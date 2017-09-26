import sys
from collections import deque
from collections import defaultdict

class Graph:

    def __init__(self,vertices):
        self.V= vertices #No. of vertices
        self.graph = [] # default dictionary to store graph


    # function to add an edge to graph
    def addEdge(self,u,v,w):
        self.graph.append([u,v,w])

    # A utility function to find set of an element i
    # (uses path compression technique)
    def find(self, parent, i):
        if parent[i] == i:
            return i
        return self.find(parent, parent[i])

    # A function that does union of two sets of x and y
    # (uses union by rank)
    def union(self, parent, rank, x, y):
        xroot = self.find(parent, x)
        yroot = self.find(parent, y)

        # Attach smaller rank tree under root of high rank tree
        # (Union by Rank)
        if rank[xroot] < rank[yroot]:
            parent[xroot] = yroot
        elif rank[xroot] > rank[yroot]:
            parent[yroot] = xroot
        #If ranks are same, then make one as root and increment
        # its rank by one
        else :
            parent[yroot] = xroot
            rank[xroot] += 1

    def KruskalMST(self):
        i = 0
        e = 0
        result = []
        self.graph = sorted(self.graph, key=lambda item: item[2])
        parent = [] ; rank = []

        for node in range(self.V):
            parent.append(node)
            rank.append(0)

        while i < self.V - 1:
            # print(i)
            u,v,w = self.graph[i]
            i = i + 1
            x = self.find(parent, u)
            y = self.find(parent, v)
            if x != y:
                e = e + 1
                result.append([u, v, w])
                self.union(parent, rank, x, y)

        # print the contents of result[] to display the built MST
        print("Following are the edges in the constructed MST")
        for u,v,weight in result:
            print("%d -- %d == %d" % (u,v,weight))



def getWeight(startNode, toNodes):
    distances = []
    bfs((startNode[1], startNode[2]))
    for node in toNodes:
        distances.append((startNode[0], weights[node[1]][node[2]], node[0]))

    return distances



def bfs(start):
    q = deque()

    for row in weights:
        for weight in row:
            weight = 99999

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



lines = [line.rstrip('\n') for line in sys.stdin]

testcases = int(lines[0])
aliens = []
start = 0
lineCount = 1
alientCount = 1





matrix = []


for i in range(1):

    data = list(map(int, lines[lineCount].split()))
    x = data[0]
    y = data[1]

    weights = [[999999 for i in range(x)] for j in range(y)]
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

    edges = []

    edges.extend(getWeight(start, aliens))
    while(len(aliens) >= 2):
        temp = aliens[:1][0]
        aliens = aliens[1:]
        edges.extend(getWeight(temp, aliens))

    # print(len(edges))

    graph = Graph(len(edges))

    for edge in edges:
        graph.addEdge(edge[0], edge[2], edge[1])
    # print(len(graph.graph))
    graph.KruskalMST()





for weight in weights:
    print(weight)
