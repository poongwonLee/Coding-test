n=int(input())

arr=sorted(list(map(int,input().split())))



res_min=2200000000
idx1,idx2=0,0
for i in range(n-1):
    

    res=n-1
    l=i+1
    r=n-1
    while(l<=r):
        mid=(l+r)//2 # -30 -10 0 10 20 26 35 40  
        if(arr[mid] >= -arr[i]):
            res=mid
            r=mid -1
        else:
            l= mid+1

    if(i< res -1 and abs(arr[i]+arr[res-1])<res_min):
        res_min=abs(arr[i]+arr[res-1])
        idx1,idx2=i,res-1
    if(res < n and abs(arr[i]+arr[res])<res_min):
        res_min=abs(arr[i]+arr[res])
        idx1,idx2=i,res


print(arr[idx1],arr[idx2])

