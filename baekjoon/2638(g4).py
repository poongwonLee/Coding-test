from collections import deque
from queue import PriorityQueue
import sys
si=sys.stdin.readline
sys.setrecursionlimit(10**5)


n,m=map(int,si().split())
arr=[]
dx=[-1,0,1,0]
dy=[0,1,0,-1]
for i in range(n):
    arr.append(list(map(int,si().split())))



def dfs(x,y):
    global ch,res,dis
    cnt=0
    for i in range(4):
        xx=x+dx[i]
        yy=y+dy[i]
        if not ( 0<=xx<n and 0<=yy<m): continue
        if(arr[xx][yy]==1 and ch[xx][yy]==0):
            ch[xx][yy]=1
            dfs(xx,yy)
        if arr[xx][yy]==0 and ch[xx][yy]==0 and dis[xx][yy]==1:
            cnt+=1
    if cnt>=2:
        arr[x][y]=0

def bfs():
    global dis
    q=deque()
    q.append([0,0])
    dis[0][0]=1
    while q:
        x,y=q.popleft()
        for i in range(4):
            xx=x+dx[i]
            yy=y+dy[i]
            if not (0<=xx<n and 0<=yy<m): continue
            if arr[xx][yy]==0 and dis[xx][yy]==0:
                dis[xx][yy]=1
                q.append([xx,yy])
        




res=0
while True:
    dis=[[0]*m for i in range(n)]
    bfs()

    flag=1
    ch=[[0]*m for i in range(n)]

    for i in range(n):
        for j in range(m):
            if arr[i][j]==1:
                flag=0
            if(arr[i][j] == 1 and ch[i][j]==0):
                dfs(i,j)

  
    if flag:
        print(res)
        exit()
    res+=1

