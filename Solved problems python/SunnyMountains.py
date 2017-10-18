import sys
import math

lines = [line.rstrip("\n") for line in sys.stdin]

currentLine = 0
testcases = int(lines[currentLine])
currentLine += 1

for i in range(testcases):
    total_distance = 0
    mountain_tops = int(lines[currentLine])
    coordinate_list = list()
    currentLine += 1
    for i in range(mountain_tops):
        data = list(map(int, lines[currentLine].split()))
        coordinate_list.append((data[0], data[1]))
        currentLine += 1

    coordinate_list = sorted(coordinate_list, key= lambda item: item[0], reverse = True)

    startIndex = 1
    savedIndex = 0
    prev_peak = 0
    total_distance = 0

    current_peak = coordinate_list[startIndex]
    prev_peak = coordinate_list[startIndex - 1]
    distance_diff = current_peak[0] - prev_peak[0]
    height_diff = current_peak[1] - prev_peak[1]
    total_distance += math.sqrt((math.pow(height_diff, 2) + math.pow(distance_diff, 2))) ###FIRST PEAK

    while(True):
        saved_peak = current_peak
        for peakIndex, peak in enumerate(coordinate_list):
            if peak[1] > current_peak[1]:
                startIndex = peakIndex
                break

        current_peak = coordinate_list[startIndex]
        if(current_peak[1] == saved_peak[1]):
            break

        prev_peak = coordinate_list[peakIndex - 1]
        k = (current_peak[1] - prev_peak[1]) / (current_peak[0] - prev_peak[0])
        m = (current_peak[1] - (k * current_peak[0]))
        x = ((saved_peak[1] - m) / k)
        ydelta = current_peak[1] - saved_peak[1]
        xdelta = current_peak[0] - x
        total_distance += math.sqrt((math.pow(xdelta, 2) + math.pow(ydelta, 2)))


    total_distance = '{:.2f}'.format(total_distance)
    print(total_distance)
