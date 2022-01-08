import sys
import queue
from typing import Deque
input = sys.stdin.readline
sys.setrecursionlimit(200000)
si=sys.stdin.readline

dx=[-1,0,1,0]
dy=[0,1,0,-1]

def dfs(x,y):
    global arr,ch,check,L,R,res_arr
    for i in range(4):
        xx=x+dx[i]
        yy=y+dy[i]
       
        if 0<=xx<n and 0<=yy<n and ch[xx][yy]==0:
            if L<=abs(arr[x][y]-arr[xx][yy])<=R:
                ch[xx][yy]=1
                check=True
                res_arr.append([xx,yy])
                dfs(xx,yy)



n,L,R=map(int,si().split())
arr=[]
for i in range(n):
    arr.append(list(map(int,si().split())))


cnt=0
while True:
    flag=False
    cnt+=1
    ch=[[0]*n for i in range(n)]
    
    for i in range(n):
        for j in range(n):
            res_arr=[]
            check=False
            if(ch[i][j]==0):
                ch[i][j]=1
                res_arr.append([i,j])
                dfs(i,j)
                if len(res_arr)>1:
                    flag=True
                    SUM=0
                    for a,b in res_arr:
                        SUM+=arr[a][b]
                    for a,b in res_arr:
                        arr[a][b]=SUM//len(res_arr)

    if not flag:
        print(cnt-1)
        exit()
    
