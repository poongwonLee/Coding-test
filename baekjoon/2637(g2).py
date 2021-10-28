import sys
from collections import deque
si=sys.stdin.readline
sys.setrecursionlimit(10**6)

n=int(si())
arr=[[] for i in range(n+1)]

price=[[0]*(n+1) for i in range(n+1) ]

ch=[0]*(n+1)
res=[]
q=deque()

m=int(si())
for i in range(m):
    x,y,z=map(int,si().split())
    arr[y].append([x,z])
    ch[x]+=1

for i in range(1,n+1):
    if(ch[i]==0):
        q.append(i)
        price[i][i]=1


while q:
    x=q.popleft()
    for i,j in arr[x]:
        ch[i]-=1
        for k in range(1,n+1):
            price[i][k]+=(price[x][k]*j)
        if(ch[i]==0):
            q.append(i)


for i in range(len(price[n])):
    if(price[n][i]):
        print(i,price[n][i])
    
