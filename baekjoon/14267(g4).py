import sys
from collections import deque
sys.setrecursionlimit(100005)
si = sys.stdin.readline


n,m=map(int,si().split())
arr=[[] for i in range(n+1)]
ch=[0]*(n+1)

tmp=list(map(int,si().split()))
for i in range(2,n+1):
    arr[tmp[i-1]].append(i)
   
def dfs(x):
    
    for i in arr[x]:
        ch[i]+=ch[x]
        dfs(i)

for i in range(m):
    x,y=map(int,si().split())
    ch[x]+=y

dfs(1)
print(*ch[1:])
