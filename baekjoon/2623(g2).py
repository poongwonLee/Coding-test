import sys
from collections import deque
si=sys.stdin.readline
sys.setrecursionlimit(10**6)


n,m=map(int,si().split())

ch=[0]*(n+1)
arr=[[] for i in range(n+1)]

q=deque()
for i in range(m):
    tmp=list(map(int,si().split()))
    for j in range(1,tmp[0]):
        
        arr[tmp[j]].append(tmp[j+1])
        ch[tmp[j+1]]+=1
    

for i in range(1,n+1):
    if ch[i]==0: q.append(i)

res=[]
while q:
    x=q.popleft()
    res.append(x)   
    for i in arr[x]:
        ch[i]-=1
        if(ch[i]==0):
            q.append(i)

if n != len(res):
     print(0)
else:
    for i in res:
        print(i)
