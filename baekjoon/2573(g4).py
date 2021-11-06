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
    global ch

    for i in range(4):
        xx=x+dx[i]
        yy=y+dy[i]

        if 0<=xx<n and 0<=yy<m:
            if arr[xx][yy]==0 and ch[xx][yy]==0:
                arr[x][y]-=1
                if arr[x][y]<0: arr[x][y]=0   

            if(arr[xx][yy]!=0  and ch[xx][yy]==0):
            
                ch[xx][yy]=1
                dfs(xx,yy)
             
res=0
while True:
    ch=[[0]*m for i in range(n)]
    flag=1
    cnt=0
    for i in range(n):
        for j in range(m):
            if arr[i][j]>0:flag=0
            if(arr[i][j]!=0 and ch[i][j]==0):
                ch[i][j]=1
                cnt+=1
                dfs(i,j)
               
            if cnt>=2:
                
                print(res)
                exit()
    if flag:
        print(0)
        exit()
    res+=1

