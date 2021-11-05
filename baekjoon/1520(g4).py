from collections import deque
from queue import PriorityQueue
import sys
si=sys.stdin.readline
sys.setrecursionlimit(10**6)


n,m=map(int,si().split())
arr=[]
dx=[-1,0,1,0]
dy=[0,1,0,-1]
for i in range(n):
    arr.append(list(map(int,si().split())))


def dfs(x,y):
    global ch
    if x==n-1 and y==m-1:
        return 1
    if ch[x][y]!=-1:
        return ch[x][y]
    ch[x][y]=0
    for i in range(4):
        xx=x+dx[i]
        yy=y+dy[i]
        if 0<=xx<n and 0<=yy<m:
            if(arr[x][y]>arr[xx][yy] ):
                ch[x][y]+=dfs(xx,yy)
                   
    return ch[x][y]                

ch=[[-1]*m for i in range(n)]
print(dfs(0,0))
