import sys
si = sys.stdin.readline
sys.setrecursionlimit(10**6)

n,m=map(int,si().split())

arr=[]
ch=[[0]*m for i in range(n)]
dx=[-1,0,1,0]
dy=[0,1,0,-1]
wolf=0
sheep=0
for i in range(n):
    arr.append(list(si()))


def dfs(x,y):
    global a,b
    if(ch[x][y]==0):
        ch[x][y]=1
        if(arr[x][y]=='o'):a+=1
        if(arr[x][y]=='v'):b+=1
        for i in range(4):
            xx=x+dx[i]
            yy=y+dy[i]
            if(0<=xx<n and 0<=yy<m and arr[xx][yy]!= '#'):
                dfs(xx,yy)

for i in range(n):
    for j in range(m):
        a,b=0,0
        if(ch[i][j]==0 and arr[i][j]!='#'):
            dfs(i,j)
            if(a>b): sheep+=a
            else:    wolf+=b
            
print(sheep,wolf)            
