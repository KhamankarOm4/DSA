class Solution(object):
    def maxAverageRatio(self, classes, extraStudents):
        """
        :type classes: List[List[int]]
        :type extraStudents: int
        :rtype: float
        """
        gain_heap=[]

        length = len(classes)

        for pass_c , total_c in classes:
            current_r = (float(pass_c+1)/(total_c+1)) - (float(pass_c)/total_c)

            heapq.heappush(gain_heap,(-current_r,pass_c,total_c))

        for _ in range(extraStudents):
            neg , pass_c,total_c = heapq.heappop(gain_heap)

            pass_c +=1
            total_c +=1

            new_gain = (float(pass_c+1)/(total_c+1)) - (float(pass_c)/total_c)


            heapq.heappush(gain_heap,(-new_gain,pass_c,total_c))
        
        total_ratio_sum = 0
        total_ratio = 0
        
        while gain_heap:
            _, passc,totalc = heapq.heappop(gain_heap)
            total_ratio +=float(passc)/totalc
            
        
        return total_ratio/length
