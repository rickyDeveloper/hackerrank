#!/bin/python3
#https://www.hackerrank.com/challenges/swap-nodes-algo/problem
import os
import sys

def inOrderTraversal(indexes, nodeValue, traversalResults):

    if(indexes is None or len(indexes) ==0):
        return traversalResults

    leftNode = indexes[nodeValue-1][0]
    rightNode = indexes[nodeValue-1][1]

    if(leftNode != -1):
        inOrderTraversal(indexes, leftNode, traversalResults)

    traversalResults.append(nodeValue)

    if(rightNode != -1):
        inOrderTraversal(indexes, rightNode, traversalResults)

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
        inOrderTraversal(indexes, 1, result)
        results.append(result)

    return results

def inputData():

    n = int(input())

    indexes = []

    for _ in range(n):
        indexes.append(list(map(int, input().rstrip().split())))

    queries_count = int(input())

    queries = []

    for _ in range(queries_count):
        queries_item = int(input())
        queries.append(queries_item)

    print (swapNodes(indexes, queries))


inputData()
