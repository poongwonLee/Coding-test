from collections import deque
from queue import PriorityQueue
import sys
si=sys.stdin.readline
sys.setrecursionlimit(10**5)


n=int(si())
arr={}
for i in range(n):
    book=si()
    if book in arr:
        arr[book]+=1
    else:
        arr[book]=1
        
arr=sorted(arr.items(),key=(lambda x: (-x[1],x[0])))
    

print(list(arr)[0][0])
    
