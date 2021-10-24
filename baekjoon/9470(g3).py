import sys
from collections import deque
si=sys.stdin.readline
sys.setrecursionlimit(10**6)


T=int(si())
while T:
    T-=1
    k,m,p=map(int,si().split())

    ch=[0]*(m+1)
    price=[0]*(m+1)
    max_price=[0]*(m+1)
    arr=[[] for i in range(m+1)]
    for i in range(p):
        x,y=map(int,si().split())
        arr[x].append(y)
        ch[y]+=1
    
   
    q=deque()
    for i in range(1,m+1):
        if(ch[i]==0):
            q.append(i)
            price[i]=1
    
    
    while q:
        x=q.popleft()
    
        for i in arr[x]:
            ch[i]-=1
            if price[i] < price[x]:
                price[i]=price[x]
                max_price[i]=1

            elif price[i]==price[x]:
                max_price[i]+=1
            
            if(ch[i]==0):
                if(max_price[i]>=2):
                    price[i]+=1
                
                q.append(i)
    
    print(k,max(price))
