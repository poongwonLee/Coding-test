from collections import deque
import sys
sys.setrecursionlimit(10**6)
si=sys.stdin.readline

n=int(si())
arr=[[] for i in range(n+1)]
ch=[0]*(n+1)

for i in range(n-1):
   x,y=map(int,si().split())
   arr[x].append(y)
   arr[y].append(x)

def dfs(v):
   for i in arr[v]:
      if(ch[i]==0):
         ch[i]=v
         dfs(i)

dfs(1)
for i in range(2,n+1):
   print(ch[i])
