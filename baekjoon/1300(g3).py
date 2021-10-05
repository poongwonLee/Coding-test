n=int(input())
k=int(input())

def func(mid):
   sum=0
   for i in range(1,n+1):
      sum+=min(mid//i,n)
   return sum>=k


l,r=0,n**2
while(l<=r):
   mid=(l+r)//2
   if func(mid):
      r=mid-1
      res=mid
   else:
      l=mid+1
print(res)
