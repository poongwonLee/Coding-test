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
    arr.append(list(si()))

def dfs(x,y):
    global ch
    
    for i in range(4):
        xx=x+dx[i]
        yy=y+dy[i]
       
        if 0<=xx<n and 0<=yy<n and arr[x][y]==arr[xx][yy]:
            if ch[xx][yy]!=0: continue
            ch[xx][yy]=1
            
            dfs(xx,yy)
   
res=0
ch=[[0]*n for i in range(n)]
for i in range(n):
    for j in range(n):
        if(ch[i][j]==0):
            ch[i][j]=1
            dfs(i,j)
            res+=1
print(res,end=" ")

res=0

ch=[[0]*n for i in range(n)]

for i in range(n):
    for j in range(n):
        if arr[i][j]=='G':
            arr[i][j]='R'

for i in range(n):
    for j in range(n):
        if(ch[i][j]==0):
            ch[i][j]=1
            dfs(i,j)
            res+=1

print(res)
