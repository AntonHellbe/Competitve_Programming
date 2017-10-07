import sys

lines = [line.rstrip('\n') for line in open('testcasesEcologicalPremium.txt')]
# lines = [line.rstrip('\n') for line in sys.stdin]
lineCount = 0
allInput = []

for line in lines:
    allInput.append(line.split(' '))

testcases = []
totalMoney = 0
firstIndex = int(allInput[1][0]) + 2

for k in range(2, len(allInput)):
    if len(allInput[k]) != 1:
        yardSize = int(allInput[k][0])
        animals = int(allInput[k][1])
        equipmentStatus = int(allInput[k][2])
        totalMoney += round((yardSize / animals) * equipmentStatus * animals)

    if k == firstIndex or k == len(allInput) - 1:
        testcases.append(totalMoney)
        totalMoney = 0
        firstIndex += (int(allInput[k][0]) + 1)

for testcase in testcases:
    print(testcase)
