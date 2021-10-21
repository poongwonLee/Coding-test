import sys
from collections import deque
si=sys.stdin.readline
n,m=map(int,si().split())

arr=[ [] for i in range(n+1)]
ch=[0]*(n+1)
for i in range(m):
    x,y=map(int,si().split())
    arr[x].append(y)
    ch[y]+=1

q=deque()
for i in range(1,n+1):
    if(ch[i]==0):
        q.append(i)

while q:
    x=q.popleft()
    print(x,end=" ")
    for i in arr[x]:
        ch[i]-=1
        if(ch[i]==0):
            q.append(i)
