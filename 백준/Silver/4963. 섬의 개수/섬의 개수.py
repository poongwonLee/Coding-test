import sys
si = sys.stdin.readline
sys.setrecursionlimit(10**6)
dx=[-1,0,1,0,-1,-1,1,1]
dy=[0,1,0,-1,-1,1,1,-1]

def dfs(x,y):
    global cnt,ch,n,m
    if(ch[x][y]==0):
        ch[x][y]=1
        for i in range(8):
            xx=x+dx[i]
            yy=y+dy[i]
            if(0<=xx<n and 0<=yy<m and arr[xx][yy]==1):
                dfs(xx,yy)

while True:

    m,n=map(int,si().split())
    if(n==0 and m==0): break

    ch=[[0]*m for i in range(n)]
    arr=[]
    for i in range(n):
        arr.append(list(map(int,si().split())))



    cnt=0
    for i in range(n):
        for j in range(m):
            
            if(ch[i][j]==0 and arr[i][j]==1):
                cnt+=1
                dfs(i,j)
    print(cnt)
            
       