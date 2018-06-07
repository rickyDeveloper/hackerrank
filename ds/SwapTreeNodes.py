#!/bin/python3
#https://www.hackerrank.com/challenges/swap-nodes-algo/problem
import os
import sys


def inOrderTraversal(indexes, traversalResults):

    if(indexes is None or len(indexes) ==0):
        return traversalResults

    nodes = [[indexes[0][0], 1,indexes[0][1]]]

    while len(nodes) != 0:
        currentNode = nodes[0]

        if(currentNode[0] == -1):
            traversalResults.append(currentNode[1])
            nodes.pop(0)
            if(currentNode[2] != -1):
                nodes = [[indexes[currentNode[2]-1][0], currentNode[2],indexes[currentNode[2]-1][1]]] + nodes
        else:
            prefix = [[indexes[currentNode[0]-1][0], currentNode[0],indexes[currentNode[0]-1][1]]]
            nodes[0][0] = -1
            nodes = prefix + nodes

    return traversalResults

#
# Complete the swapNodes function below.
#
def swapNodes(indexes, queries):
    results = []

    if indexes is None or len(indexes) ==0 or queries is None or len(queries) ==0:
        return results


    for query in queries:
        depth = 1
        rootNodes =  [1]
        childNodes = []

        while len(rootNodes) !=0:
            tempIndex = rootNodes.pop(0)-1

            if(indexes[tempIndex][0] != -1):
                childNodes.append(indexes[tempIndex][0])


            if(indexes[tempIndex][1] != -1):
                childNodes.append(indexes[tempIndex][1])

            if(depth%query == 0):
                indexes[tempIndex][1], indexes[tempIndex][0] = indexes[tempIndex][0], indexes[tempIndex][1]

            if len(rootNodes) == 0:
                rootNodes = childNodes
                childNodes = []
                depth = depth + 1


        result = []
        inOrderTraversal(indexes, result)
        results.append(result)

    return results

def inputData():

    indexes = []

    indexes.append([2,3])
    indexes.append([4,-1])
    indexes.append([5,-1])
    indexes.append([6,-1])
    indexes.append([7,8])
    indexes.append([-1,9])
    indexes.append([-1,-1])
    indexes.append([10,11])
    indexes.append([-1,-1])
    indexes.append([-1,-1])
    indexes.append([-1,-1])

    queries = []
    queries.append(2)
    queries.append(4)

    print (swapNodes(indexes, queries))


inputData()
