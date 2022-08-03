import sys

n,m=map(int,input().split())
c=[[0]*(n+1) for i in range(n+1)]


for i in range(1,n+1):
    a=list(map(int,sys.stdin.readline().rsplit()))
    for j in range(1,n+1):
        c[i][j]=a[j-1]+c[i-1][j]+c[i][j-1]-c[i-1][j-1]
      
for i in range(m):
    x,y,z,w=map(int,sys.stdin.readline().rsplit())
    print(-c[x-1][w]-c[z][y-1]+c[x-1][y-1]+c[z][w])