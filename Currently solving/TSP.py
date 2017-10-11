import sys
import time


def timing(f):
    def wrap(*args):
        time1 = time.time()
        ret = f(*args)
        time2 = time.time()
        print ('%s function took %0.3f ms' % (f.__name__, (time2-time1)*1000.0))
        return ret
    return wrap


def minimum_weight(best_path, col):
    mymin = min(best_path, key = lambda item: item[col][1])
    return [path[::-1] for path in best_path if path[col][1] == mymin[col][1]]

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
            paths[row1][col1].append(((row1, col1), matrix[row1][col1]))
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
    savedPath.append(((row1, col1), matrix[row1][col1] + bestvalue[0]))

    paths[row1][col1] = savedPath

    savedPositions[row1][col1] = matrix[row1][col1] + bestvalue[0]

    return (savedPositions[row1][col1], (row1, col1))


def prettyprint(bestchoice, col):
    for i in range(col):
        if(i == col - 1):
            print(bestchoice[i][0][0] + 1)
        else:
            print(bestchoice[i][0][0] + 1, end=" ")
    print(bestchoice[0][1])



lines = [line.rstrip("\n") for line in sys.stdin]


currentLine = 0


while(currentLine < len(lines)):
    matrix = []
    data = list(map(int, lines[currentLine].split()))
    best_paths = []
    row = data[0]
    col = data[1]

    print(currentLine)
    print(row, col)

    paths = [[list() for j in range(col)] for i in range(row)]

    savedPositions = [[9999 for i in range(col)] for j in range(row)]

    currentLine += 1
    for i in range(row):
        try:
            temp = list(map(int, lines[currentLine].split()))
            if not temp:
                continue
            if(len(temp) > col):
                matrix.append(temp[:col])
                matrix.append(temp[col:])
                # currentLine += 1
            else:
                matrix.append(temp)
                currentLine += 1
        except:
            print()


    # print(currentLine)

    # for line in matrix:
    #     print(line)

    # break
    for i in range(row):
        min_path_finder((i,0), row, col)

    for row in paths:
        best_paths.append(row[0])


    size = len(best_paths[0])  - 1
    # for paths in best_paths:
        # print(paths)
    best_paths = minimum_weight(best_paths, size)

    best = 0
    index = 0
    j = 0

    if(len(best_paths) > 1):
        for pathz in best_paths:
            counter = 0
            # print(pathz)
            for i in range(col - 1):
                if(pathz[i] == pathz[i + 1]):
                    counter += 1
                else:
                    break
            if counter > best:
                index = j
                best = counter
            j += 1
        # prettyprint(best_paths[index], col)
    else:
        print()
        # prettyprint(best_paths[0], col)


    # print(best_paths[index])
