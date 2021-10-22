import sys
from collections import deque
si=sys.stdin.readline

k=int(si())

while k:
    k-=1
    n,m=map(int,si().split())
    ch=[0]*(n+1)
    arr=[[] for i in range(n+1)]
    price=[0]+list(map(int,si().split()))
    res=[0]*(n+1)

    for i in range(m):
        x,y=map(int,si().split())
        arr[x].append(y)
        ch[y]+=1
    
    q=deque()
    for i in range(1,n+1):
        if(ch[i]==0):
            res[i]=price[i]
            q.append(i)
    
    

    while q:
        x=q.popleft()
        for i in arr[x]:
            ch[i]-=1
            if( ch[i]==0):
                q.append(i)
            res[i]=max(res[i],res[x]+price[i])
    
    print(res[int(si())])
