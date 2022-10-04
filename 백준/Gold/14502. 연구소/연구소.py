from collections import deque

n,m=map(int,input().split())
arr=[]
visit=[[0]*m for _ in range(n)]
dx=[-1,0,1,0]
dy=[0,1,0,-1]
res=0

for i in range(n):
   arr.append(list(map(int,input().split())))

blank=[]
for i in range(n):
   for j in range(m):
      if( arr[i][j]==0):
         blank.append([i,j])


def dfs(idx,cnt):
   if cnt==3:
      bfs()
      return
   
   if idx>=len(blank): return
   
   arr[blank[idx][0]][blank[idx][1]]=1
   dfs(idx+1,cnt+1)
   arr[blank[idx][0]][blank[idx][1]]=0
   dfs(idx+1,cnt)


   
def bfs():
   global res
   q=deque()
   for i in range(n):
      for j in range(m):
         visit[i][j]=0
         if(arr[i][j]==2):
            q.append([i,j])
                       

   cnt=0
   while q:
      x,y=q.popleft()
      for i in range(4):
         xx=x+dx[i]
         yy=y+dy[i]
         if(0<=xx<n and 0<=yy<m):
            if(not visit[xx][yy] and not arr[xx][yy]):
               visit[xx][yy]=1
               q.append([xx,yy])

   for i in range(n):
      for j in range(m):
         if(arr[i][j]==0 and visit[i][j]==0):
            cnt+=1
   res=max(res,cnt)

dfs(0,0)
print(res)
                  