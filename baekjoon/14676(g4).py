import sys
from collections import deque
si=sys.stdin.readline
sys.setrecursionlimit(10**6)

n,m,k=map(int,si().split())

arr=[[] for i in range(n+1)]
ch=[0]*(n+1)

for i in range(m):
    x,y=map(int,si().split())
    arr[x].append(y)
    ch[y]+=1

cnt=[0]*(n+1)
re=[0]*(n+1)
flags=0
for i in range(k):
    
    a,b=map(int,si().split())
    if a==1:
        if( re[b]<ch[b]):
            print("Lier!")
            exit()
            
        cnt[b]+=1
        if cnt[b]==1:
            for i in arr[b]:
                re[i]+=1
    else:
        if cnt[b]==0:
            print("Lier!")
            exit()
        cnt[b]-=1
        if cnt[b]==0:
            for i in arr[b]:
                re[i]-=1
                
print("King-God-Emperor")
