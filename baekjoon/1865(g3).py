import sys
si=sys.stdin.readline

INF=10000000000000
k=int(si())
while k:
    k-=1
    n,m,W=map(int,si().split())
 
    dist=[INF]*(n+1)
    g=[[] for i in range(n+1)]

    for i in range(m):
        u,v,w=map(int,si().split())
        g[u].append([v,w])
        g[v].append([u,w])
    
    for i in range(W):
        u,v,w=map(int,si().split())
        g[u].append([v,-w])
        
    cycle=0
    dist[1]=0
    for i in range(1,n+1):
        for j in range(1,n+1):
            for now,cost in g[j]:
            
                if(dist[now] >dist[j]+cost):
                    dist[now]=dist[j]+cost
                    if(n==i): cycle=1

    if cycle: print("YES")
    else: print("NO")

