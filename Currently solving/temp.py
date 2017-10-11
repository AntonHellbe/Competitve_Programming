import sys

def sum1(listname):
    total, length = 0, len(listname)
    for x in range(length):
        for y in range(x + 1, length):
            if listname[y] == listname[x] + 1:
                total += y - x
                break
    return total


lines = [line for line in sys.stdin]

data = list(map(int, lines[0].split(" ")))

print(sum1(data))
