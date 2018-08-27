testCasesCount = int(input())

def findMaxSubSeqArray(arr, start, end):

    results = [0 for i in range(start, end)]

    results[0] = arr[start]
    maxTillNow = arr[start]
    sumTillNow = arr[start]

    for index in range(start+1, end):
        results[index] = max(arr[index], arr[index] + results[index - 1], results[index - 1])
        sumTillNow = max(sumTillNow + arr[index], arr[index])
        maxTillNow = max(maxTillNow, sumTillNow)

    print(maxTillNow, results[end-1])


for testIndex in range(0,testCasesCount):
    numberCount = int(input())
    data = [int(x) for x in input().split()]
    findMaxSubSeqArray(data, 0, numberCount)

