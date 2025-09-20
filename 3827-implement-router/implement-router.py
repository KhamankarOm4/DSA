class Router:

    def __init__(self, memoryLimit: int):
        self.memoryLimit = memoryLimit
        self.queue = deque()               # FIFO queue of packets
        self.packetSet = set()             # To check duplicates
        self.destMap = defaultdict(list) 

    def addPacket(self, source: int, destination: int, timestamp: int) -> bool:
        packet = (source, destination, timestamp)
        if packet in self.packetSet:  # Duplicate check
            return False

        # Remove oldest packet if memory limit exceeded
        if len(self.queue) >= self.memoryLimit:
            old = self.queue.popleft()
            self.packetSet.remove(old)
            # Remove timestamp from destMap
            dest_list = self.destMap[old[1]]
            idx = bisect.bisect_left(dest_list, old[2])
            if idx < len(dest_list) and dest_list[idx] == old[2]:
                dest_list.pop(idx)

        # Add new packet
        self.queue.append(packet)
        self.packetSet.add(packet)
        bisect.insort(self.destMap[destination], timestamp)
        return True

    def forwardPacket(self) -> List[int]:
        if not self.queue:
            return []
        pkt = self.queue.popleft()
        self.packetSet.remove(pkt)
        dest_list = self.destMap[pkt[1]]
        idx = bisect.bisect_left(dest_list, pkt[2])
        if idx < len(dest_list) and dest_list[idx] == pkt[2]:
            dest_list.pop(idx)
        return list(pkt)

    def getCount(self, destination: int, startTime: int, endTime: int) -> int:
        timestamps = self.destMap[destination]
        left = bisect.bisect_left(timestamps, startTime)
        right = bisect.bisect_right(timestamps, endTime)
        return right - left


# Your Router object will be instantiated and called as such:
# obj = Router(memoryLimit)
# param_1 = obj.addPacket(source,destination,timestamp)
# param_2 = obj.forwardPacket()
# param_3 = obj.getCount(destination,startTime,endTime)