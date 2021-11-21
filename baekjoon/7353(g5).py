from collections import deque
import heapq
import sys
si=sys.stdin.readline

v,e=map(int,si().split())
n=int(si())
dist=[10000000000]*(v+1)
arr=[[] for i in range(v+1)]
for i in range(e):
      x,y,z=map(int,si().split())
      arr[x].append([y,z])

dist[n]=0
q=[]
heapq.heappush(q,[0,n])
while q:
      dist_x,x=heapq.heappop(q)
      if(dist[x] != dist_x):continue
      for v,price in arr[x]:
            if dist[v] <= dist[x]+price: continue
            dist[v]=dist[x]+price
            heapq.heappush(q,[dist[v],v])

for i in dist[1:]:
      if i==10000000000: print("INF")
      else: print(i)

