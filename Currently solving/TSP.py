import sys


directionDict = {'UPRIGHT': (1, 1), 'DOWNRIGHT':(-1, 1), 'RIGHT':(0, 1)}
pathDict = {}
memoryDict = {}

def min_path_finder(start, row, col, matrix):
    totalWeight = 0
    row1 = start[0]
    col1 = start[1]
    totalWeight += matrix[row1][col1]
    allPath = [(row1, col1)]
    while(True):
        currentPosition = allPath[len(allPath) - 1]
        print(allPath)
        savedRow1 = currentPosition[0]
        savedCol1 = currentPosition[1]
        best_path = []
        for direct in directionDict.values():
            row1 = savedRow1 + direct[0]
            col1 = savedCol1 + direct[1]
            if(row1 == - 1):
                row1 = row - 1
            elif(row1 == row):
                row1 == 0
            best_path.append(((row1, col1), matrix[row1][col1]))

        temp = min(best_path, key= lambda item: item[1])
        totalWeight += temp[1]
        allPath.append(temp[0])
        if(temp[0][1] == col - 1):
            return allPath, totalWeight



    return allPath

def min_path_finder2(node, row, col):

    row1 = node[0]
    col1 = node[1]
    nodeWeight = matrix[row1][col1
                              ]
    if col1 == col - 1:
        return 1

    for direct in directionDict.values():
        newRow = row1 + direct[0]
        newCol = col1 + direct[1]
        if(newRow == - 1):
            newRow = row - 1
        elif(newRow == row):
            newRow = 0

        if memoryDict[(newRow, newCol)] > memoryDict[(row1, col1)] + matrix[newRow][newCol]:
            memoryDict[(newRow, newCol)] = memoryDict[(row1, col1)] + matrix[newRow][newCol]
            min_path_finder2((newRow, newCol), row, col)






lines = [line.rstrip("\n") for line in sys.stdin]


currentLine = 0
data = list(map(int, lines[currentLine].split(" ")))
row = data[0]
col = data[1]
matrix = []
currentLine += 1

for i in range(row):
    temp = list(map(int, lines[currentLine].split(" ")))
    matrix.append(temp)
    currentLine += 1

for i in range(row):
    for j in range(col):
        visitedDict[(i, j)] = False
        memoryDict[(i, j)] = 9999



memoryDict[(0,0)] = matrix[0][0]
min_path_finder2((0,0), row, col)
for k, v in memoryDict.items():
    print(k, v)
