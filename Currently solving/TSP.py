import sys
import time

# print(sys.version)

tempinput = "3 98\n-9840 3642 4170 -3819 -6309 -4241 -1432 8226 -3745 8932 -1176 4243 -3331 -1204 -9791 8041 -9245 9252 3787 -7166 1637 7322 -8764 4278 -1606 2450 2261 -1973 -220 5692 -6464 -8099 -2764 -1513 -935 4319 409 -1058 -6284 -2377 9888 -5889 9554 -855 -4429 -2213 -4385 1329 -5011 -2818 1829 -1621 7800 2255 4864 -7379 823 4199 -9540 2450 -2365 9288 8314 -9721 7532 -679 2158 9687 -8683 8378 -5920 1180 5267 -220 3717 8126 4596 -557 3556 -4005 -1566 -7728 -7529 9566 2089 -9243 -1413 -3340 9309 6378 2428 -6914 1386 2012 4261 6411 -2514 -1716\n254 -3810 2282 9785 9382 5994 -428 -2983 3793 424 -2696 -7532 -2360 -7908 -9934 -2748 -7030 2011 9382 -7294 -8411 1712 -5801 5468 -4781 -5158 2645 -583 4786 8199 5853 -8816 6792 -6961 1510 -6944 4861 4564 6763 -8849 -4599 2965 2281 5283 5629 5726 6452 -264 7324 -2955 -5409 6264 1171 2895 -9882 -1566 -1303 -589 -9581 8105 -8448 -3199 381 5324 4186 259 287 670 -5861 1016 -7582 8875 3494 7349 -2216 -7873 5652 9299 4911 1812 9019 -6175 2281 -7930 -2460 -1977 7520 -1151 -3083 2999 -2018 -8531 -191 -4210 2546 5431 1238 1208\n8918 -8164 575 328 1511 -2196 -2526 1561 -516 -1910 -5564 -6852 -4415 -4238 -9108 133 -5726 -9379 -3126 -9358 1067 9856 -7592 5796 6165 2195 1344 2112 9645 -6945 -5899 -3696 4090 -4704 8042 -3859 9093 2635 4591 -7200 -4349 1458 -2117 -4688 3220 1848 -965 4143 -7856 2387 -4866 7359 -3724 -1391 -3150 -8773 -4613 8587 -4082 9706 8125 -9594 6970 -2459 -571 260 -918 2122 7256 -2099 -8970 9483 -8963 5894 -1215 -1031 3199 -1489 -1584 1132 -9936 4043 4062 -1915 3378 -8622 9997 2569 -3570 8042 2501 2335 -8050 1187 -6865 -4154 7817 111\n"

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

    # print(currentLine)
    # print(row, col)

    paths = [[list() for j in range(col)] for i in range(row)]

    savedPositions = [[9999 for i in range(col)] for j in range(row)]
    # print(row, col)
    # print(currentLine)
    currentLine += 1
    tempzz = 0
    for i in range(row):
        if(tempzz == row):
            break
        temp = list(map(int, lines[currentLine].split()))
        print(len(temp))
        if(len(temp) > col):
            matrix.append(temp[:col])
            matrix.append(temp[col:])
            tempzz += 2
            currentLine += 1
        else:
            tempzz += 1
            currentLine += 1
            matrix.append(temp)

    for rowz in matrix:
        if col > len(rowz):
            col = len(rowz)

    # for rowz in matrix:
        # print(len(rowz))

    for i in range(row):
        min_path_finder((i,0), row, col)

    for row in paths:
        best_paths.append(row[0])

    size = len(best_paths[0])  - 1

    # for pathz in best_paths:
        # print(pathz[len(pathz) - 1])

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
        prettyprint(best_paths[index], col)
    else:
        prettyprint(best_paths[0], col)

    # print(best_paths[index])
