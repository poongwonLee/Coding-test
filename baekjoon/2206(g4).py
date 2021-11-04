from collections import deque
from queue import PriorityQueue
import sys
si=sys.stdin.readline
n,m=map(int,si().split())

dx=[-1,0,1,0]
dy=[0,1,0,-1]
arr=[]

for i in range(n):
    arr.append(list(si()))

q=deque()


ch=[[[0]*2 for i in range(m)] for j in range(n) ]
ch[0][0][0]=1

q.append([0,0,0])
while q:
    x,y,z=q.popleft()
    for k in range(4):
        xx=x+dx[k]
        yy=y+dy[k]
        if not (0<=xx<n and 0<=yy<m) :continue

        if arr[xx][yy]=='0' and ch[xx][yy][z]==0: 
            ch[xx][yy][z]+=ch[x][y][z]+1
            q.append([xx,yy,z])


        if arr[xx][yy]=='1' and z==0:
            ch[xx][yy][z+1]+=ch[x][y][z]+1
            q.append([xx,yy,1])

if ch[n-1][m-1][z]==0:
    print(-1)
else:
    print(ch[n-1][m-1][z])
