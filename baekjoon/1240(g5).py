import sys
from collections import deque
si = sys.stdin.readline

n,m=map(int,si().split())
arr=[[] for i in range(n+1)]

def dfs(v):
    global ch,b
    
        
    for i in arr[v]:
        if ch[i[0]] ==0 and a!=i[0]:
            ch[i[0]]+=i[1]+ch[v]
            dfs(i[0])


for i in range(n-1):
    x,y,z=map(int,si().split())
    arr[x].append([y,z])
    arr[y].append([x,z])
    
for i in range(m):
    ch=[0]*(n+1)
    a,b=map(int,si().split())
    
    dfs(a)
    print(ch[b])
