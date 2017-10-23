import sys
import math


lines = [line.rstrip("\n") for line in sys.stdin]

def getCorrectYvalues(x, d, s_y):
    instrip = list()

    for point in s_y:
        if point[0] > x - d and point[0] < x + d:
            instrip.append(point)

    return instrip


def solve_bruteforce(coordinate_list):
    distances = list()
    for i in range(len(coordinate_list)):

        for j in range(len(coordinate_list)):
            if i == j:
                continue
            else:
                distances.append(math.sqrt(math.pow((coordinate_list[i][0]-coordinate_list[j][0], 2) + math.pow((coordinate_list[i][1] - coordinate_list[j][1]), 2))))

    return distances

def closestPair(pointlist):

    s_x = sorted(pointlist, key=lambda item: item[0])
    s_y = sorted(pointlist, key=lambda item: item[1])
    return solveClosestPairs(s_x, s_y)


def solveClosestPairs(s_x, s_y):
    if len(s_x) <= 3:
        solve_bruteforce(s_x)

    mid_index = int(len(s_x) / 2)
    x = int((s_x[int(len(s_x) / 2)][0] + s_x[int(len(s_x) / 2) + 1][0]) / 2)
    points_left  = solveClosestPairs(s_x[:mid_index + 1], s_y)
    points_right = solveClosestPairs(s_x[mid_index:], s_y)

    d = min(points_left, points_right)

    s_y = getCorrectYvalues(x, d, s_y)

    for i in range(len(s_y)):
        for j in range(len(s_y)):
            if i == j:
                continue
            x_d = s_y[i][0] - sy[j][0]
            y_d = s_y[i][1] - sy[j][1]
            if y_d < d:
                d = math.sqrt(math.pow(x_d, 2) + math.pow(y_d, 2))

    return d


current_line = 0

while(True):
    no_points = int(lines[current_line])

    if(no_points == 0):
        break

    current_line += 1

    points_list = list()

    for i in range(no_points):
        data = list(map(float, lines[current_line].split()))
        points_list.append((data[0], data[1]))
        current_line += 1

    print(closestPair(points_list))
