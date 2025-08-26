class Solution(object):
    def areaOfMaxDiagonal(self, dimensions):
        """
        :type dimensions: List[List[int]]
        :rtype: int
        """
        md = 0
        ma = 0

        for l,w in dimensions:
            d = l*l + w*w
            a = l * w
            if d > md or(d==md and a>ma):
                md = d
                ma = a
        return ma