import operator

testCasesCount = int(input())

testCaseNumber = 0

while testCaseNumber < testCasesCount:
    inputLine = input().split()
    nodeCodes = int(inputLine[0])
    edgesCount = int(inputLine[1])
    graph = {}
    edgeNumber = 0
    testCaseNumber += 1

    while edgeNumber < edgesCount:
        edgeLine = input().split()
        x = int(edgeLine[0])
        y = int(edgeLine[1])
        r = int(edgeLine[2])
        v = graph.keys()
        if x not in v:
            graph[x] = {}
            graph[x][y] = r
        else:
            edgesX = graph[x]
            xt = edgesX.keys()
            if y in xt:
                if edgesX[y] > r:
                    edgesX[y] = r
            else:
                edgesX[y] = r

        if y not in v:
            graph[y] = {}
            graph[y][x] = r
        else:
            edgesY = graph[y]
            yT = edgesY.keys()
            if x in yT:
                if edgesY[x] > r:
                    edgesY[x] = r
            else:
                edgesY[x] = r

        edgeNumber += 1

    inputStartKey = int(input())

    minSumMap = [-1] * (nodeCodes + 1)
    minSumMap[inputStartKey] = 0

    visited = [0] * (nodeCodes + 1)
    neighborEdges = list()
    startKey = inputStartKey

    while graph.keys():
        if not visited[startKey]:
            neighbors = graph[startKey].items()
            tempSum = minSumMap[startKey]
            visited[startKey] = 1
            for (k, v) in neighbors:
                if minSumMap[k] == -1 or minSumMap[k] > tempSum + v:
                    minSumMap[k] = tempSum + v
                if not visited[k]:
                    neighborEdges.append((k, minSumMap[k]))

            del graph[startKey]

        if neighborEdges:
            tempList = sorted(neighborEdges, key=lambda x: x[1])
            startKey = tempList[0][0]
            del tempList[0]
            neighborEdges = tempList

    del minSumMap[inputStartKey]
    del minSumMap[0]
    print(' '.join(str(x) for x in minSumMap))
