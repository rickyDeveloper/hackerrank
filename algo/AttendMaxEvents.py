eventsCount = int(input())
startTimeofEvents = [int(x) for x in input().split()]
endTimeofEvents = [int(x) for x in input().split()]


def getEventsAttendedCount(count, startTimeArray, endTimeArray):
    if(count == 0):
        return 0

    timeTuples = []

    for i in range(count):
        timeTuples.append(tuple([startTimeArray[i], endTimeArray[i]]))


    sortedTuples = sorted(timeTuples, key=lambda x: x[1])

    maxEventsCount = 1
    lastFinishTime = sortedTuples[0][1]

    for j in range(1,count):
        if(sortedTuples[j][0] >= lastFinishTime):
            maxEventsCount = maxEventsCount + 1
            lastFinishTime = sortedTuples[j][1]

    print("Max events count", maxEventsCount)


getEventsAttendedCount(eventsCount, startTimeofEvents,endTimeofEvents)

