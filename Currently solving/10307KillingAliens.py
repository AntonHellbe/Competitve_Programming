import sys
import heapq
import time


def timing(f):
    def wrap(*args):
        time1 = time.time()
        ret = f(*args)
        time2 = time.time()
        print ('%s function took %0.3f ms' % (f.__name__, (time2-time1)*1000.0))
        return ret
    return wrap

class Vertices:
    def __init__(self):
        self.vertices = list()

    def printAll(self):
        for vertice in self.vertices:
            print(vertice)

    def addVertices(self, i, j):
        self.vertices.append((i, j))

    def length(self):
        return len(self.vertices)

    def find(self, i, j):
        if (i, j) in self.vertices:
            return True
        return False

    def getVertices(self):
        return self.vertices

class Graph:
    def __init__(self,vertices):
        self.V = vertices
        self.graph = {}

    def addEdge(self,f,t, t1, w):
        if f not in self.graph:
            self.graph[f] = []

        self.graph[f].append((t, t1, w))

    def getEdges(self):
        return self.graph

    def getEdgesById(self, id):
        return self.graph[id]



def traverseMaze(x, y, aliens, start, lineCount):
    vertices = Vertices()
    alientCount = 1
    for i in range(y):
        temp = list(lines[lineCount])
        for j in range(len(temp)):
            if(temp[j] != '#'):
                vertices.addVertices(i, j)
            if(temp[j] == 'S'):
                start = (i, j)
            if(temp[j] == 'A'):
                aliens.append((i, j))
                alientCount += 1
        lineCount += 1

    lengt = vertices.length() - 1
    graph = Graph(lengt)

    for vertex in vertices.vertices:
        if(vertices.find(vertex[0] + 1, vertex[1])):
            graph.addEdge((vertex[0], vertex[1]), vertex[0] + 1, vertex[1], 1)
        if(vertices.find(vertex[0] - 1, vertex[1])):
            graph.addEdge((vertex[0], vertex[1]), vertex[0] - 1, vertex[1], 1)
        if(vertices.find(vertex[0], vertex[1] + 1)):
            graph.addEdge((vertex[0], vertex[1]), vertex[0], vertex[1] + 1, 1)
        if(vertices.find(vertex[0], vertex[1] - 1)):
            graph.addEdge((vertex[0], vertex[1]), vertex[0], vertex[1] - 1, 1)



    return vertices, aliens, start, lineCount, graph


def dijkstra(graph, vertices, source):
    INF = 9999
    dist = {x: INF for x in vertices.getVertices()}
    dist[source] = 0
    PQ = []

    heapq.heappush(PQ, [dist[source], source])

    while(PQ):
        u = heapq.heappop(PQ)
        u_dist = u[0]
        u_id = u[1]
        if u_dist == dist[u_id]:
            for edge in graph.getEdgesById(u_id):
                v_id = (edge[0], edge[1])
                w = edge[2]
                if(dist[u_id] + w < dist[v_id]):
                    dist[v_id] = dist[u_id] + 1
                    heapq.heappush(PQ, [dist[v_id], v_id])

    return dist

def getDistances(startNode, toNodes, graph, vertices):
    dist = dijkstra(graph, vertices, startNode)
    total = []
    for node in toNodes:
        total.append([startNode, dist[node], node])

    return total

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


def makeSet(data, rank, UnionFind):
    node = Node(data, rank)
    node.parent = node
    UnionFind.nodeMap[data] = node

def union(UnionFind, data1, data2):
    node1 = UnionFind.nodeMap[data1]
    node2 = UnionFind.nodeMap[data2]
    parent1 = findset(node1)
    parent2 = findset(node2)


    if(parent1.rank >= parent2.rank):
        if(parent1.rank == parent2.rank):
            parent1.rank += 1
            parent2.parent = parent1

        parent2.parent = parent1
    else:
        parent1.parent = parent2

# @timing
def findset(node):
    node_parent = node.parent
    if(node == node_parent):
        return node_parent
    node_parent = findset(node_parent.parent)
    node.parent = node_parent
    return node_parent


def createMST(edges, temp, sizeofnodes):
    mst = []
    uf = UnionFind()
    for edge in temp:
        makeSet(edge, 0, uf)

    sortedEdges = sorted(edges, key= lambda item: item[1])
    for edge in sortedEdges:
        if not findset(uf.nodeMap[edge[0]]) == findset(uf.nodeMap[edge[2]]):
            union(uf, edge[0], edge[2])
            mst.append(edge[1])
            if(len(mst) == sizeofnodes):
                break
    return mst



lines = [line.rstrip('\n') for line in open('borgmazetestcases.txt')]
# lines = [line.rstrip('\n') for line in sys.stdin]
weights = 0
testcases = int(lines[0])
lineCount = 1
alientCount = 1

# @timing
def findAll(aliens, graph, vertices):
    edges = []
    while(len(aliens) > 1):
        temp = aliens[:1][0]
        aliens = aliens[1:]
        edges.extend(getDistances(temp, aliens, graph, vertices))
    return edges


for i in range(testcases):
    data = list(map(int, lines[lineCount].split()))
    x = data[0]
    y = data[1]
    aliens = []
    start = 0
    graph = 0
    lineCount += 1

    vertices, aliens, start, lineCount, graph = traverseMaze(x, y, aliens, start, lineCount)

    if(start == 0 or len(aliens) == 0):
        print("0")
        continue

    if(start != 0):
        aliens.insert(0, start)

    edges = []
    temp2 = []
    temp2.extend(aliens)

    edges = findAll(aliens, graph, vertices)



    hello = createMST(edges, temp2, len(temp2))

    print(sum(hello))
