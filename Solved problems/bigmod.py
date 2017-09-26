" https://www.youtube.com/watch?v=DtV4Fwvn0e8 "
"Algorithms page 18-19"
import math
import sys

def modexp(x, y, n):
    if y == 0:
        return 1

    z = modexp(x, int(y / 2), n)

    if y % 2 == 0:
        return (pow(z, 2, n))
    else:
        return (x * pow(z, 2) % n)


# lines = [line.rstrip('\n') for line in open('bigmodtestcases.txt')]
lines = [line.rstrip('\n') for line in sys.stdin]

lines = [int(line) for line in lines if line != '']

data = [int(number) for number in lines]
result = []
for k in range(0, len(data) - 2, 3):
    result.append(modexp(data[k], data[k+1], data[k + 2]))

for numbres in result:
    print(numbres)
