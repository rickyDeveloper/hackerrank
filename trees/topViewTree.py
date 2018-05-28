"""
Node is defined as
self.left (the left child of the node)
self.right (the right child of the node)
self.value (the value of the node)"""

from Node import Node


# Util method to create BST
def createTree():
    left = Node(4,10,None, None)
    right = Node(5,14,None, None)
    root1 = Node(3,13,left,right)

    left1 = Node(2,2,None, None)

    root = Node(1,5,left1,root1)

    return root


def topView(root):

    #Write your code here
    if root is None:
        return

    levelDict = {}
    levelDict[0] = root

    nodes = []
    nodes.append((0, root))

    while( len(nodes) != 0 ):

        nodeTuple = nodes.pop(0)
        columnIndex =  nodeTuple[0]
        node = nodeTuple[1]

        if(node.left is not None) :
            if(columnIndex-1 not in levelDict):
                levelDict[columnIndex-1] = node.left

            nodes.append((columnIndex-1, node.left))


        if(node.right is not None) :

            if(columnIndex+1 not in levelDict):
                levelDict[columnIndex+1] = node.right

            nodes.append((columnIndex+1, node.right))

    for key in sorted(levelDict.keys()):
        print levelDict[key].value,


tree = createTree()
topView(tree)
