# https://www.hackerrank.com/challenges/crush/problem

inputSizes = [int(x) for x in input().split()]

arraySize = inputSizes[0]
querySize = inputSizes[1]



manupulationMatrix=[[] for x in range(querySize)]


for x in range(querySize):
    manupulationMatrix[x] = [int(y) for y in input().split()]


def doManupulation(arraySize, queries):

    array = [0 for x in range(arraySize)]

    if(len(array) ==0 or len(queries) ==0):
        return 0

    for query in range(len(queries)):
        startIndex = queries[query][0]
        endIndex = queries[query][1]
        valuesToBeAdded = queries[query][2]

        if(endIndex >= startIndex and endIndex <= len(array) and valuesToBeAdded != 0):
            for k in range(startIndex-1, endIndex):
                array[k] = array[k] + valuesToBeAdded
                if array[k] > maxValueTillNow:
                    maxValueTillNow = array[k]

    return maxValueTillNow


print(doManupulation(arraySize, manupulationMatrix))


