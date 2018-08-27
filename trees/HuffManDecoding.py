from HuffManNode import HuffManNode


# Util method to create BST
def createTree():

    left = HuffManNode(4,'B',None, None,1)

    right = HuffManNode(5,'C',None, None, 1)

    root1 = HuffManNode(3,'\0',left,right, 2)

    right1 = HuffManNode(2,'A',None, None, 3)

    root = HuffManNode(1,'\0',root1,right1, 5)

    return root



def decodeHuff(root , s):

    if root is None:
        return

    temp = root

    index = 0
    outputString = ""

    while index < len(s):
        char = s[index]

        if char == '1':
            temp = temp.right
            if temp.left is None and temp.right is None:
                outputString = outputString + temp.value
                temp = root

        if char == '0':
            temp = temp.left
            if temp.left is None and temp.right is None:
                outputString = outputString + temp.value
                temp = root

        index = index + 1

    print(outputString)


tree = createTree()

decodeHuff(tree, "1001011")



