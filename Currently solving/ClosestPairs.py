import sys
import math



lines = [line.rstrip("\n") for line in sys.stdin]

current_line = 0


def dist_helper(x, y):
    return math.sqrt((math.pow(x, 2) + math.pow(y, 2)))


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

    best_dist = 99999
    diff = (0, 0)
    for i in range(len(points_list)):
        for j in range(i + 1, len(points_list)):
            temp = abs(points_list[j][0] - points_list[i][0]) + abs(points_list[j][1] - points_list[i][1])
            if temp < best_dist:
                best_dist = temp
                diff = (points_list[j][0] - points_list[i][0], points_list[j][1] - points_list[i][1])
    print(best_dist)
    print(diff)
    dist = dist_helper(diff[0], diff[1])
    # print(dist)
    # print(best_dist)
    if dist >= 10000:
        print("INFINITY")
    else:
        dist = '{:.4f}'.format(dist)
        print(dist)
