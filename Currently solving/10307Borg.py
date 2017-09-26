import sys
from collections import deque



class Vertice:
    def __init__(self, x, y, dist):
        self.x = x
        self.y = y
        self.dist = dist

    def setDistance(self, distance):
        self.dist = distance

    def describe(self):
        print("%d" % self.x, "%d" % self.y, "%d" % self.dist)

def find(x, y):
    for vertice in vertices:
        if(vertice.x == x and vertice.y == y):
            return vertice


def bfs(vertices, start):
    v = 0
    q = deque()
    for vertice in vertices:
        vertice.dist = 999999
        if(vertice.x == start[0] and vertice.y == start[1]):
            v = vertice
    v.dist = 0
    print("%d" % v.x, "%d" % v.y)
    q.append(v)
    while len(q) != 0:
        v = q.pop()
        if(v.x + 1 <= x and v.x >= 0 and v.y >= 0 and v.y < y and matrix[v.x + 1][v.y] != '#'):
            vertice = find(v.x + 1, v.y)
            if(v.dist + 1 < vertice.dist):
                vertice.setDistance(v.dist + 1)
                q.append(vertice)
        if(v.x <= x and v.x - 1 >= 0 and v.y >= 0 and v.y < y) and matrix[v.x - 1][v.y] != '#':
            vertice = find(v.x -1, v.y)
            if(v.dist + 1 < vertice.dist):
                vertice.setDistance(v.dist + 1)
                q.append(vertice)
        if(v.x <= x and v.x >= 0 and v.y >= 0 and v.y + 1 < y) and matrix[v.x][v.y + 1] != '#':
            vertice = find(v.x, v.y + 1)
            if(v.dist + 1 < vertice.dist):
                vertice.setDistance(v.dist + 1)
                q.append(vertice)
        if(v.x <= x and v.x >= 0 and v.y - 1 >= 0 and v.y < y) and matrix[v.x][v.y - 1]:
            vertice = find(v.x, v.y - 1)
            if(v.dist + 1 < vertice.dist):
                vertice.setDistance(v.dist + 1)
                q.append(vertice)







lines = [line.rstrip('\n') for line in sys.stdin]

vertices = []
testcases = int(lines[0])
aliens = []
start = 0
lineCount = 1

x = 0
y = 0
matrix = []


for i in range(1):
    data = list(map(int, lines[lineCount].split()))
    x = data[0]
    y = data[1]

    lineCount += 1

    for j in range(0, y):
        temp = list(lines[lineCount])
        print(temp)
        lineCount += 1
        temp2 = []
        for k in range(0, x - 1):
            vertices.append(Vertice(j, k, 999999))
            if(temp[k] == 'A'):
                aliens.append((j, k))
            if(temp[k] == 'S'):
                start = (j, k)
            if(k == len(temp)):
                temp.append(" ")
            else:
                temp2.append(temp[k])


        matrix.append(temp2)
    print(start)
    print(aliens)
    bfs(vertices, start)
    for vertice in vertices:
        vertice.describe()
