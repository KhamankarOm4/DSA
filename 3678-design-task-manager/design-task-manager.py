class TaskManager(object):
    def __init__(self, tasks):
        self.task_map = {} 
        self.heap = []
        for userId, taskId, priority in tasks:
            self.add(userId, taskId, priority)
    
    def add(self, userId, taskId, priority):
        self.task_map[taskId] = (userId, priority)
        heapq.heappush(self.heap, (-priority, -taskId, userId))
    
    def edit(self, taskId, newPriority):
        userId, _ = self.task_map[taskId]
        self.task_map[taskId] = (userId, newPriority)
        heapq.heappush(self.heap, (-newPriority, -taskId, userId))
    
    def rmv(self, taskId):
        if taskId in self.task_map:
            del self.task_map[taskId]
    
    def execTop(self):
        while self.heap:
            neg_priority, neg_taskId, userId = heapq.heappop(self.heap)
            taskId = -neg_taskId
            priority = -neg_priority
            
            # Check if this heap entry is still valid
            if (taskId in self.task_map and 
                self.task_map[taskId][1] == priority and 
                self.task_map[taskId][0] == userId):
                del self.task_map[taskId]
                return userId
        return -1


# Your TaskManager object will be instantiated and called as such:
# obj = TaskManager(tasks)
# obj.add(userId,taskId,priority)
# obj.edit(taskId,newPriority)
# obj.rmv(taskId)
# param_4 = obj.execTop()