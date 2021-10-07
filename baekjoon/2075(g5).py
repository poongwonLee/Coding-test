import heapq
n=int(input())

hq=[]
for i in range(n):
   k=list(map(int,input().split()))
   for j in range(n):
      
      if len(hq)<n:
         heapq.heappush(hq,k[j])
      else:
         if hq[0] < k[j]:
            heapq.heappop(hq)
            heapq.heappush(hq,k[j])

hq.sort()
print(hq[0])
