import sys
from collections import deque
si=sys.stdin.readline
sys.setrecursionlimit(10**6)

n=int(si())
price=[0]*(n+1)
price_max=[0]*(n+1)

ch=[0]*(n+1)
arr=[[] for i in range(n+1)]
for i in range(1,n+1):
    tmp=list(map(int,si().split()))
    price[i]=tmp[0]
    for j in range(1,len(tmp)-1):
        arr[tmp[j]].append(i)
        ch[i]+=1

q=deque()
for i in range(1,n+1):
    if(ch[i]==0):
        q.append(i)
        price_max[i]=price[i]
while q:
    x=q.popleft()
    for i in arr[x]:
        ch[i]-=1
        if(ch[i]==0):
            q.append(i)
        price_max[i]=max(price_max[i],price_max[x]+price[i])


for i in range(1,n+1):
    print(price_max[i])
