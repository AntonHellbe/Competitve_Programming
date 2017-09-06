import sys

class UnionFind:
    """
    Unionfind implementation
    """

    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [0 for x in range(n)]

    def find(self, v):
        if not v == self.parent[v]:
            self.parent[v] = self.find(self.parent[v])
        return self.parent[v]

    def union(self, x, y):
        xRoot = self.find(x)
        yRoot = self.find(y)
        if xRoot == yRoot:
            return
        if self.rank[xRoot] > self.rank[yRoot]:
            self.parent[yRoot] = xRoot
        else:
            self.parent[xRoot] = yRoot
            if self.rank[xRoot] == self.rank[yRoot]:
                self.rank[yRoot] += 1


inputData = []

lines = [line.rstrip('\n') for line in sys.stdin]
# lines = [line.rstrip('\n') for line in open('friendstestcases.txt')]

for line in lines:
    inputData.append(list((map(int, line.split(' ')))))


testcases = inputData[0]
currentLine = 1

for i in range(0, testcases[0]):
    population = inputData[currentLine][0]
    pairOfFriends = inputData[currentLine][1]
    currentLine += 1

    uf = UnionFind(population + 1)

    friends = []

    for k in range(0, pairOfFriends):
        friend1 = inputData[currentLine][0]
        friend2 = inputData[currentLine][1]

        uf.union(friend1, friend2)

        currentLine += 1

    myDict = {}
    for node in range(population + 1):
        root = uf.find(node)
        if not root in myDict:
            myDict[root] = set([node])
        else:
            myDict[root].add(node)

    best = 0
    for mySet in myDict.values():
        if(len(mySet) > best):
            best = len(mySet)

    print(best)
    # print(friends)
