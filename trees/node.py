class Node:
    value = 0
    left = None
    right = None
    number = 0

    def __init__(self, number, value, left, right):
        self.number = number
        self.value = value
        self.left = left
        self.right = right


    def getValue(self):
        return self.value

    def getLeft(self):
        return self.left

    def getNumber(self):
        return self.number

    def getRight(self):
        return self.right


