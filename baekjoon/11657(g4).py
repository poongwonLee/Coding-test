import sys
si=sys.stdin.readline

INF=1000000000000
n,m=map(int,si().split())
dist=[INF]*(n+1)
g=[[] for i in range(n+1)]
for i in range(m):
    u,v,w=map(int,si().split())
    g[u].append([v,w])
  
cycle=0
dist[1]=0

for i in range(1,n+1):
    for j in range(1,n+1):
        for now,cost in g[j]:
           
            if(dist[j]!=INF and dist[now] >dist[j]+cost):
                dist[now]=dist[j]+cost
                if(n==i): cycle=1

if cycle:
    print(-1)
else:
    for i in range(2,n+1):
        if(dist[i]==INF):print(-1)
        else: print(dist[i])

