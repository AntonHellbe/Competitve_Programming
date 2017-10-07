import re
import sys
# lines = [line.rstrip('\n') for line in open('testcaseDecodethetape.txt')]
lines = [line.rstrip('\n') for line in sys.stdin]
inputData = []
tapeText = ''

for line in lines:
    inputData.append(list(line.split('|')))

for k in range (1, len(inputData) - 1):
    newCol = [re.sub(r'[\s]', '0', col) for col in inputData[k]]
    newCol = [re.sub(r'[\.]', '', col) for col in newCol]
    newCol = [re.sub(r'[o]', '1', col) for col in newCol]
    tapeText += chr(int(newCol[1], 2))

print(tapeText, end='')
