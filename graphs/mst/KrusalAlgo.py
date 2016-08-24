from Edge import Edge

rootArray = [0] * 7

for index in range(7):
    rootArray[index] = index


def root(x):
    while rootArray[x] != x:
        rootArray[x] = rootArray[rootArray[x]]
        x = rootArray[x]
    return x


edges = [
    Edge(1, 2, 3),
    Edge(1, 3, 4),
    Edge(4, 2, 6),
    Edge(5, 2, 2),
    Edge(2, 3, 5),
    Edge(3, 5, 7)
]


sortedEdges = sorted(edges)
minWeight = 0


def union(f, t):
    fr = root(f)
    tr = root(t)
    rootArray[fr] = tr


for sortedEdge in sortedEdges:
    fe = sortedEdge.getFromVertex()
    te = sortedEdge.getToVertext()
    w = sortedEdge.getWeight()
    if root(fe) != root(te):
        minWeight = minWeight + w
        union(fe, te)

print(minWeight)
