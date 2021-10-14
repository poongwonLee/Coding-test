import sys
sys.setrecursionlimit(100005)
si = sys.stdin.readline

k=int(si())

def dfs(v):
    global ch,arr,res
    if ch[v]==1:
        res=v
        return
    ch[v]=1
    for i in arr[v]:
        dfs(i)
        

while k:
    n=int(si())
    arr=[[] for i in range(n+1)]
    for i in range(n-1):
        a,b=map(int,si().split())
        arr[b].append(a)

    x,y=map(int,si().split())
    ch=[0]*(n+1)
    
    dfs(x)
    dfs(y)
    
    print(res)
    

    k-=1
    
