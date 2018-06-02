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

def insert(r,val):

    #Enter you code here.
    if r is None:
        r = Node(None, None,val)
        return r

    inserted = False
    temp = r

    while inserted is not True:
        if val < temp.value:
            if temp.left is not None:
                temp = temp.left
            else:
                temp.left = Node(None, None, val)
                inserted = True

        if val >= temp.value:
            if temp.right is not None:
                temp = temp.right
            else:
                temp.right = Node(None, None, val)
                inserted = True

    return r



