n=int(input())
arr=sorted(list(map(int,input().split())))
k=int(input())

def func(arr,k,mid):
    res=0
    for i in range(len(arr)):
        res+=min(arr[i],mid)
    return res<=k        

l,r=0,max(arr)
while(l<=r):
    mid=(l+r)//2
    if(func(arr,k,mid)):
        res=mid
        l=mid+1
    else:
        r=mid-1

print(res)
