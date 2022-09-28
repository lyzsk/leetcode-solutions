class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.dummyHead = DoublyLinkedListNode()
        self.dummyTail = DoublyLinkedListNode()
        self.dummyHead.next = self.dummyTail
        self.dummyTail.prev = self.dummyHead
        self.cache = dict()
        self.size = 0

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        node = self.cache[key]
        self.moveToHead(node)
        return node.value

    def put(self, key: int, value: int) -> None:
        if key not in self.cache:
            newNode = DoublyLinkedListNode(key, value)
            self.cache[key] = newNode
            self.addToHead(newNode)
            self.size += 1
            if self.size > self.capacity:
                tail = self.dummyTail.prev
                self.cache.pop(tail.key)
                self.removeNode(tail)
                self.size -= 1
        else:
            node = self.cache[key]
            node.value = value
            self.moveToHead(node)

    def addToHead(self, node):
        node.prev = self.dummyHead
        node.next = self.dummyHead.next
        self.dummyHead.next.prev = node
        self.dummyHead.next = node

    def removeNode(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev

    def moveToHead(self, node):
        self.removeNode(node)
        self.addToHead(node)


class DoublyLinkedListNode:
    def __init__(self, key=0, value=0):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
