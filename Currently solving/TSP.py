import sys
import time
directionDict = {'UPRIGHT': (1, 1), 'DOWNRIGHT':(-1, 1), 'RIGHT':(0, 1)}


def timing(f):
    def wrap(*args):
        time1 = time.time()
        ret = f(*args)
        time2 = time.time()
        print ('%s function took %0.3f ms' % (f.__name__, (time2-time1)*1000.0))
        return ret
    return wrap


def minimum_weight(best_path, col):
    mymin = min(best_path, key = lambda item: item[col])
    return [path for path in best_path if path[col] == mymin[col]]

def go_right_down(y, x, row):
    if(y + 1 == row):
        return (0, x + 1)
    return (y + 1, x + 1)

def go_right_up(y, x, row):
    if(y - 1 == -1):
        return(row - 1, x + 1)
    return (y - 1 , x + 1)

def go_right(y, x, row):
    return (y, x + 1)


def min_path_finder(node, row, col):

    row1 = node[0]
    col1 = node[1]


    if(savedPositions[row1][col1] != 9999):
        return (savedPositions[row1][col1], (row1, col1))

    if col1 == col - 1:
        if len(paths[row1][col1]) == 0:
            paths[row1][col1].append((row1, col1))
        return (matrix[row1][col1], (row1, col1))


    rightup_position = go_right_up(row1, col1, row)
    rightdown_position = go_right_down(row1, col1, row)
    right_position = go_right(row1, col1, row)

    upright = min_path_finder(rightup_position, row, col)
    downright = min_path_finder(rightdown_position, row, col)
    right = min_path_finder(right_position, row, col)

    bestvalue = min(upright, downright, right, key = lambda item: (item[0], item[1][0]))

    savedPath = []
    savedPath.extend(paths[bestvalue[1][0]][bestvalue[1][1]])
    savedPath.append((row1, col1))

    paths[row1][col1] = savedPath

    savedPositions[row1][col1] = matrix[row1][col1] + bestvalue[0]

    return (savedPositions[row1][col1], (row1, col1))





lines = [line.rstrip("\n") for line in sys.stdin]


currentLine = 0


while(currentLine < len(lines)):
    matrix = []
    data = list(map(int, lines[currentLine].split(" ")))
    best_paths = []
    row = data[0]
    col = data[1]

    paths = [[list() for j in range(col)] for i in range(row)]

    savedPositions = [[9999 for i in range(col)] for j in range(row)]

    currentLine += 1

    for i in range(row):
        temp = list(map(int, lines[currentLine].split(" ")))
        matrix.append(temp)
        currentLine += 1

    for i in range(row):
        min_path_finder((i,0), row, col)

    for i in range(len(paths)):
        # print(paths[i][0])
        best_paths.append(paths[i][0])
        # print(paths[i][0])

    for row in best_paths:
        print(row)

    # for i in range(row):
    #     memoryDict[(i,0)] = matrix[i][0]
    #     min_path_finder2((i,0), row, col)

    # temp = minimum_weight(best_path, col)



    # for path in temp:
        # print(path)



    # temp = min(best_path, key = lambda item: item[col])
    #
    # for j in range(len(temp) - 1):
    #     if(j == len(temp) - 2):
    #         print(temp[j][0] + 1)
    #     else:
    #         print(temp[j][0] + 1, end=" ")
    #
    # print(temp[len(temp) - 1])

    # currentLine += 1
