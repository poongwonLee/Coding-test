import sys
si = sys.stdin.readline

n,k=map(int,si().split())
arr=list(map(int,si().split()))


res=n+1
r=0
cnt=0
for l in range(n):
    while r<n and cnt<k:
        if(arr[r]==1):
            cnt+=1
        r+=1

    if cnt>=k:
        res=min(res,r-l)
    if(arr[l]==1):
        cnt-=1
if res==n+1: res=-1
print(res)
