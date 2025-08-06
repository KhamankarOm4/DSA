class Solution(object):
    def numOfUnplacedFruits(self, fruits, baskets):
        """
        :type fruits: List[int]
        :type baskets: List[int]
        :rtype: int
        """
        n = len(fruits)
        
        class SegmentTree:
            def __init__(self, data):
                self.n = len(data)
                self.size = 1
                while self.size < self.n:
                    self.size <<= 1
                self.tree = [0] * (2 * self.size)
                for i in range(self.n):
                    self.tree[self.size + i] = data[i]
                for i in range(self.size - 1, 0, -1):
                    self.tree[i] = max(self.tree[2 * i], self.tree[2 * i + 1])

            def update(self, idx):
                pos = self.size + idx
                self.tree[pos] = 0
                pos //= 2
                while pos > 0:
                    self.tree[pos] = max(self.tree[2 * pos], self.tree[2 * pos + 1])
                    pos //= 2

            def query(self, f, node=1, node_left=0, node_right=None):
                if node_right is None:
                    node_right = self.size - 1
                if self.tree[node] < f:
                    return -1
                if node_left == node_right:
                    return node_left
                mid = (node_left + node_right) // 2
                left_res = self.query(f, 2 * node, node_left, mid)
                if left_res != -1:
                    return left_res
                return self.query(f, 2 * node + 1, mid + 1, node_right)

        seg = SegmentTree(baskets)
        unplaced = 0
        for f in fruits:
            idx = seg.query(f)
            if idx == -1:
                unplaced += 1
            else:
                seg.update(idx)
        return unplaced
