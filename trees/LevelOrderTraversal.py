from Node import Node


# Util method to create BST
def createTree():
    left = Node(4,10,None, None)
    right = Node(5,14,None, None)
    root1 = Node(3,13,left,right)

    left1 = Node(2,2,None, None)

    root = Node(1,5,left1,root1)

    return root

tree = createTree()

def levelOrder(root):
    if root is None:
        return

    nodeList = [root]

    while(len(nodeList) > 0):
        currentNode = nodeList.pop(0);
        print currentNode.value,

        if currentNode.left is not None:
            nodeList.append(currentNode.left)

        if currentNode.right is not None:
            nodeList.append(currentNode.right)





levelOrder(tree)

