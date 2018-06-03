from Node import Node

class HuffManNode:
    frequency = 0

    def __init__(self, number, value, left, right,frequency):
        Node.__init__(self,number,value,left,right)
        self.frequency = frequency


    def getFrequency(self):
        return self.frequency







