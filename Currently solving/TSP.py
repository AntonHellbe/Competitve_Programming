import sys

"Works, 2.5 sec according to UVA judge. Needs to be optimized"

lines = [line.rstrip("\n") for line in sys.stdin]
currentLine = 0

def go_right_down(y, x, row):
    if(y + 1 == row):
        return (0, x + 1)
    return (y + 1, x + 1)

def go_right_up(y, x, row):
    if(y - 1 == -1):
        return(row - 1, x + 1)
    return (y - 1 , x + 1)

def go_right(y, x):
    return (y, x + 1)

while(currentLine < len(lines) - 1):
    data = lines[currentLine].split(' ')
    row = int(data[0])
    col = int(data[1])
    INF = 9999
    min_weight = 99999999
    maxPos = (row, col)
    matrix = [[0 for i in range(col)] for j in range(row)]
    saved_weights = [[INF for i in range(col + 1)] for j in range(row)]
    paths = [[0 for i in range(col + 1)] for j in range(row)]
    input_as_list = list()
    currentLine += 1

    while(len(input_as_list) < (row * col)):
        tempRow = lines[currentLine].split(' ')
        for char in tempRow:
            try:
                input_as_list.append(int(char))
            except:
                continue

        currentLine+= 1

    for i in range(len(input_as_list)):
        matrix[int(i/col)][i % col] = input_as_list[i]

    for j in range(row):
        saved_weights[j][col - 1] = matrix[j][col - 1]


    for j in range(col - 2, -1, -1):
        for i in range(row):

            right_up = go_right_up(i, j, row)
            right_down = go_right_down(i, j, row)
            right = go_right(i, j)

            right_up = (right_up, saved_weights[right_up[0]][right_up[1]])
            right_down = (right_down, saved_weights[right_down[0]][right_down[1]])
            right = (right, saved_weights[right[0]][right[1]])

            best_path = min([right_up, right_down, right], key=lambda item: item[1])

            saved_weights[i][j] = matrix[i][j] + saved_weights[best_path[0][0]][best_path[0][1]]

    for i in range(row):
        if(saved_weights[i][0] < min_weight):
            min_weight = saved_weights[i][0]

    possibleMins = list()
    for i in range(row):
        if saved_weights[i][0] == min_weight:
            possibleMins.append(i)

    startIndex = min(possibleMins)
    traverseCol = 0
    traverseRow = startIndex
    path = list()
    path.append(traverseRow + 1)
    for i in range(col - 1):

        right_up = go_right_up(traverseRow, traverseCol, row)
        right_down = go_right_down(traverseRow, traverseCol, row)
        right = go_right(traverseRow, traverseCol)

        right_up = (right_up, saved_weights[right_up[0]][right_up[1]])
        right_down = (right_down, saved_weights[right_down[0]][right_down[1]])
        right = (right, saved_weights[right[0]][right[1]])

        best_path = min([right_up, right_down, right], key=lambda item: (item[1], item[0][0]))

        traverseRow = best_path[0][0]
        traverseCol = best_path[0][1]
        path.append(traverseRow + 1)


    for j in range(len(path)):
        if(j == len(path) - 1):
            print(path[j])
        else:
            print(path[j], end=' ')

    print(saved_weights[startIndex][0])
