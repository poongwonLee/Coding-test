from collections import deque
import sys
si=sys.stdin.readline

n,m=map(int,si().split())
arr=[]
visit=[[-1]*m for i in range(n)]
dx=[-1,0,1,0]
dy=[0,1,0,-1]


q=deque()
for i in range(n):     #q에 물위치 추가 및 시작점 탈출점 저장
   arr.append(list(si()))
   for j in range(m):
      if(arr[i][j]=='*'):
         q.append([i,j])
      if(arr[i][j]=='S'):
         S=[i,j]
         visit[i][j]=0
      if(arr[i][j]=='D'):
         D=[i,j]

q.append(S)
while(q):            #물 위치 계산
   x,y=q.popleft()
   for i in range(4):
      xx=x+dx[i]
      yy=y+dy[i]
      if(0<=xx<n and 0<=yy<m):
         if(visit[xx][yy]==-1):

            if(arr[x][y]=='*'):
               if(arr[xx][yy]!='X' and arr[xx][yy]!='D'):
                  visit[xx][yy]=1
                  arr[xx][yy]='*'
                  q.append([xx,yy])

            elif(arr[x][y]=='S' or arr[x][y]=='.' or arr[x][y]=='D'):
               visit[xx][yy]=visit[x][y]+1
               q.append([xx,yy])
            




if(visit[D[0]][D[1]] != -1):
   print(visit[D[0]][D[1]])
else:
   print("KAKTUS")


