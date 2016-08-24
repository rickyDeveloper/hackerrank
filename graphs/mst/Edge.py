class Edge:
    fromVertex = 0
    toVertex = 0
    weight = 0

    def __init__(self,fVertex, tVertext, w):
        self.fromVertex = fVertex
        self.toVertex = tVertext
        self.weight = w


    def getFromVertex(self):
        return self.fromVertex

    def getToVertext(self):
        return self.toVertex


    def getWeight(self):
        return self.weight

    def __lt__(self, other):
        if hasattr(other, 'weight'):
            return self.weight < other.weight

    def __cmp__(self, other):
        if hasattr(object, 'weight'):
            return self.weight.__cmp__(other.weight)

    def __repr__(self):
        return '{}: {} {}'.format(self.weight,
                                  self.fromVertex,
                                  self.toVertex)




