import operator
firstLine = input().split()
n = int(firstLine[0])
e = int(firstLine[1])

graph = {}
targetNodes = list()
lineNumber = 0

while lineNumber < e:
    edgeLine = input().split()
    x = int(edgeLine[0])
    y = int(edgeLine[1])
    r = int(edgeLine[2])
    v = graph.keys()
    if x not in v:
        graph[x] = {}
        targetNodes.append(x)
        graph[x][y] = r
    else:
        edgesX = graph[x]
        if y in edgesX.keys():
            if edgesX[y] > r:
                edgesX[y] = r
        else:
            edgesX[y] = r

    if y not in v:
        graph[y] = {}
        targetNodes.append(y)
        graph[y][x] = r
    else:
        edgesY = graph[y]
        if x in edgesY.keys():
            if edgesY[x] > r:
                edgesY[x] = r
        else:
            edgesY[x] = r

    lineNumber += 1

startKey = int(input())
sourceNodes = [startKey]
targetNodes.remove(startKey)
visited = [0] * (n+1)
visited[startKey] = 1
verticesToBeConsidered = {}
minSum = 0
index = 0

while index < n - 1:
    nodes = graph[sourceNodes[index]]
    for x in nodes.keys():
        if not visited[x]:
            w = nodes[x]
            if x in verticesToBeConsidered.keys():
                if verticesToBeConsidered[x] > w:
                    verticesToBeConsidered[x] = w
            else:
                verticesToBeConsidered[x] = w

    tempList = sorted(verticesToBeConsidered.items(), key=operator.itemgetter(1))
    (source,targetWeight) = tempList[0]
    sourceNodes.append(source)
    visited[source] = 1
    minSum = minSum + targetWeight
    targetNodes.remove(source)
    verticesToBeConsidered.pop(source, None)
    index += 1

print(minSum)
