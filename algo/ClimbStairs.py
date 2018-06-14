#https://www.geeksforgeeks.org/count-ways-reach-nth-stair/

stairsCount = int(input())
possibleJumps = [int(y) for y in input().split()]


def findWaysToClimbStairs(numOfStairs, jumpTypes):

    if(numOfStairs == 0):
        return numOfStairs

    results = [0 for x in range(numOfStairs+1)]
    results[0] = 1
    stairNumber = 1

    while stairNumber <= numOfStairs:
        for jump in jumpTypes:
            if(jump <= stairNumber):
                results[stairNumber] = results[stairNumber] + results[stairNumber - jump]

        stairNumber = stairNumber + 1

    print(results[numOfStairs])


findWaysToClimbStairs(stairsCount, possibleJumps)













