n,k=map(int,input().split())
c=0
for i in range(2,n+1):
    c=(c+k)%i
print(c+1)
