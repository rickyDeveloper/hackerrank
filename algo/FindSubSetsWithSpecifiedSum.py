numbers = [int(x) for x in input().split()]
sum = int(input())


def printSubSetsWithSpecifiedSum(inputNumbers, startIndex, sum, currentSum, currentSubSet):
    if(sum == 0):
        print("{}")
        return

    if(sum == currentSum):
        print("{" + currentSubSet + "}")
        return


    if(startIndex >= len(inputNumbers)):
        return

    printSubSetsWithSpecifiedSum(inputNumbers, startIndex+1, sum,currentSum,currentSubSet)

    if(inputNumbers[startIndex] <= (sum - currentSum)):
        if(len(currentSubSet)):
            newSubSet = currentSubSet + "," + str(inputNumbers[startIndex])
        else:
            newSubSet = str(inputNumbers[startIndex])
        printSubSetsWithSpecifiedSum(inputNumbers, startIndex+1, sum,currentSum+inputNumbers[startIndex],newSubSet)


printSubSetsWithSpecifiedSum(numbers,0,sum,0,"")





















