from collections import deque
from queue import PriorityQueue
import sys
si=sys.stdin.readline
sys.setrecursionlimit(10**6)

n,m,k=map(int,si().split())

dx=[-1,0,1,0]
dy=[0,1,0,-1]
arr=[[0]*m for i in range(n)]

for t in range(k):
    x1,y1,x2,y2=map(int,si().split())
    for i in range(y1,y2):
        for j in range(x1,x2):
            arr[i][j]=1


def dfs(x,y):
    global ch,cnt
    cnt+=1
    for i in range(4):
        xx=x+dx[i]
        yy=y+dy[i]
        
        if 0<=xx<n and 0<=yy<m and arr[xx][yy]==0:
            if ch[xx][yy]!=0: continue
            ch[xx][yy]=1
            
            dfs(xx,yy)
   
res=[]
ch=[[0]*m for i in range(n)]

for i in range(n):
    for j in range(m):
        cnt=0
        if(ch[i][j]==0 and arr[i][j]==0):
            ch[i][j]=1
            dfs(i,j)
            res.append(cnt)
            

print(len(res))
print(*sorted(res))
