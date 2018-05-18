from Node import Node

def createTree():
    left = Node(4,10,None, None)
    right = Node(5,14,None, None)
    root1 = Node(3,13,left,right)

    left1 = Node(2,2,None, None)

    root = Node(1,5,left1,root1)

    return root


def sumNodes(root, prevSum):

    if root is None:
       return 0;

    if root.getRight() is None and root.getLeft() is None:
        root.value = root.getValue() + prevSum
        print ("Node " , root.number , " % value is " , root.value)
        return root.getValue()


    if root.getRight() is not  None:
        prevSum = sumNodes(root.getRight(), prevSum)

    root.value = root.getValue() + prevSum
    print ("Node " , root.number , " % value is " , root.value)

    prevSum = root.value

    if root.getLeft() is not  None:
        prevSum = sumNodes(root.getLeft(), prevSum)

    return prevSum




tree = createTree()
sumNodes(tree,0)
