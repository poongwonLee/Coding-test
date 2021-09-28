def arrSum(arr,H,m):
    Sum=0
    for i in range(len(arr)):
        if(arr[i]>H):
            Sum+= arr[i]-H
            
    return Sum>=m
    
    
n,m=input().split()


arr=sorted(map(int,input().split()))

l=0
r=2000000000
while(l<=r):
    mid=(l+r)//2
    
    if(arrSum(arr,mid,int(m))):
        l=mid+1
        res=mid
       
    else:
        r=mid-1
        
print(res)


