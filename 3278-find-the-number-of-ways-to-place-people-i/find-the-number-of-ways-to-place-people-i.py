class Solution(object):
    def numberOfPairs(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        points.sort()   
        count = 0
        n = len(points)

        for i in range(n):
            x1, y1 = points[i]
            for j in range(n):
                if i == j:
                    continue
                x2, y2 = points[j]
           

                if x1<=x2 and y1>=y2:
                    is_empty = True
                    for k in range(n):
                        if k == i or k == j:
                            continue

                        px , py = points[k]

                        if (x1 <= px <= x2) and (y2 <= py <= y1):
                            is_empty = False
                            break
                    if is_empty:
                        count+=1
        return count
