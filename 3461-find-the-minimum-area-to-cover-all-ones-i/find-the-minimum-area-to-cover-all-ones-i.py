class Solution(object):
    def minimumArea(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if not grid or not grid[0]:
            return 0

        rows , cols = len(grid),len(grid[0])

        top,left = rows,cols
        bottom , right = -1,-1

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 1:
                    if r < top:top=r
                    if r > bottom:bottom=r 
                    if c < left:left=c
                    if c > right:right=c 

        return 0 if bottom == -1 else (bottom-top+1)*(right-left+1)