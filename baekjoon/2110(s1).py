def func(arr,dis,c):
    cnt=1
    p1=arr[0]
    for i in range(1,len(arr)):
        if(arr[i]-p1 >=dis):
            cnt+=1
            p1=arr[i]

        if(c<=cnt): break

    if(c<=cnt) :return True
    else: return False            


n,c=map(int,input().split())
arr=[]
for i in range(n):
    arr.append(int(input()))
arr.sort()

l=0
r=1000000000
while(l<=r):
    mid=(l+r)//2
    if(func(arr,mid,c)):
        l=mid+1
        res=mid
    else:
        r=mid-1
print(res)        
# 1 2 4 8 9
