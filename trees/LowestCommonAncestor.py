from Node import Node

# Util method to create BST
def createTree():

    left1234 = Node(7,5,None, None)

    right1234 = Node(7,6,left1234, None)

    right123 = Node(6,3,None, None)

    right11 = Node(5,2,None, right123)

    left11 = Node(4,1,None, right11)

    left1 = Node(2,4,left11, right1234)

    root1 = Node(3,9,None,None)

    root = Node(1,8,left1,root1)

    return root

tree = createTree()

def lca(root , v1 , v2):
    while root is not None:
        if root.value > v1 and root.value > v2:
            root = root.left
        elif root.value < v1 and root.value < v2:
            root = root.right
        else:
            return root

    return root

print(lca(tree, 1, 2).value)