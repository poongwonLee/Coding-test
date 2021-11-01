from collections import deque
from queue import PriorityQueue
import sys
si=sys.stdin.readline
sys.setrecursionlimit(10**6)

n=int(si())

dx=[-1,0,1,0]
dy=[0,1,0,-1]
arr=[]

for i in range(n):
    arr.append(list(map(int,si().split())))

def dfs(x,y):
    global ch,k

    for i in range(4):
        xx=x+dx[i]
        yy=y+dy[i]
       
        if 0<=xx<n and 0<=yy<n and arr[xx][yy]>k:
            if ch[xx][yy]!=0: continue
            ch[xx][yy]=1
            dfs(xx,yy)
    


k=1
res=1
while k!=101:
    cnt=0
    ch=[[0]*n for i in range(n)]
    for i in range(n):
        for j in range(n):
            if(ch[i][j]==0 and arr[i][j]>k):
                ch[i][j]=1
                dfs(i,j)
                cnt+=1

    res=max(cnt,res)
    k+=1
print(res)
