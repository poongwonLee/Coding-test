n,m=map(int,input().split())
arr=[]
for i in range(n):
    arr.append(int(input()))
 

def func(arr,m,mid):
    res=0
    cnt=1
    for i in range(len(arr)):
      
        if(res+ arr[i]>mid):
            res=0
            cnt+=1
        
        res+=arr[i]
    # cnt 1  >  res 100 cnt 1> cnt 1 res 500 > cnt2  res=300 >  cnt2 res=400 >cnt 3 res 500 > cnt 4 res 101 >
    # cnt1  >  res =100 cnt 1 >  res = 500 cnt 1 > res=300 cnt 2 > res =400 cnt 2 >res 500 cnt 3 > res 101  cnt 4 > res
    return cnt<=m                    

l,r=max(arr),1000000000
while(l<=r):
    mid=(l+r)//2
    
    if(func(arr,m,mid)):
        res=mid
        r=mid-1
    else:
        l=mid+1

print(res)
