from collections import deque
from queue import PriorityQueue
import sys
si=sys.stdin.readline

n,m=map(int,(si().split()))

arr=[ [] for i in range(n+1)]
ch=[0]*(n+1)
for i in range(m):
    x,y=map(int,si().split())
    arr[x].append(y)
    ch[y]+=1

q= PriorityQueue()
for i in range(1,n+1):
    if(ch[i]==0):
      q.put(i)

while not q.empty():
    x=q.get()
    print(x,end=" ")
    for i in arr[x]:
        ch[i]-=1
        if(ch[i]==0):
            q.put(i)
