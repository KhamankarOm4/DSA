
#class TreeNode(object):
 #    def __init__(self, val=0, left=None, right=None):
  #      self.val = val
   #     self.left = left
    #    self.right = right
        
class Solution(object):
    def generateTrees(self, n):
        """
        :type n: int
        :rtype: List[Optional[TreeNode]]
        """
        if n == 0:
            return []
        
        def generate(start, end):
            trees = []
            if start > end:
                trees.append(None)
                return trees
            
            for i in range(start, end + 1):
                left_trees = generate(start, i - 1)
                right_trees = generate(i + 1, end)
                
                for left in left_trees:
                    for right in right_trees:
                        root = TreeNode(i)
                        root.left = left
                        root.right = right
                        trees.append(root)
            
            return trees
        
        return generate(1, n)