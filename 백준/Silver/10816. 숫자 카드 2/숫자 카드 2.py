
n=int(input())
arr1=list(map(int,input().split()))
    

m=int(input())
arr2=list(map(int,input().split()))

arr1.sort()
res=[0]*m
for i in range(m):    
    l=0
    r=n-1
    tmp=n
    while(l<=r):
        mid=(l+r)//2
        
        if(arr1[mid]>arr2[i]):
            tmp=mid
            r=mid-1
        else:
            l=mid+1
    res[i]=tmp


for i in range(m):    
    l=0
    r=n-1
    tmp=n
    while(l<=r):
        mid=(l+r)//2

        if(arr1[mid]>=arr2[i]):
            tmp=mid
            r=mid-1
        else:
            l=mid+1
    res[i]-=tmp    
print(*res)
         



                