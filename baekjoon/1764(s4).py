
n,m=map(int,input().split())
arr1=[]
arr2=[]
for i in range(n):
    arr1.append(input())
for i in range(m):
    arr2.append(input())

arr2.sort()
res=[]
for i in range(n):    
    l=0
    r=m-1
    while(l<=r):
        mid=(l+r)//2
        if(arr1[i]==arr2[mid]):
            res.append(arr1[i])
            break
        elif(arr1[i]<arr2[mid]):
            r=mid-1
        else:
            l=mid+1

res.sort()
print(len(res))
for i in res:
    print(i)
                
