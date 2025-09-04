class Solution(object):
    def findClosest(self, x, y, z):
        """
        :type x: int
        :type y: int
        :type z: int
        :rtype: int
        """
        xd = x - z
        yd = y - z
        if(abs(xd)>abs(yd)):
            return 2
        elif(abs(xd)<abs(yd)):
            return 1
        else:
            return 0