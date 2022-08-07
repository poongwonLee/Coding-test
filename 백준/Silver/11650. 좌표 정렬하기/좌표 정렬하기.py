n=int(input())
c=[]
for i in range(0,n):
    
    a,b=map(int,input().split())
    c.append([a,b])

c=sorted(c)
for i in range(0,n):
    print(c[i][0],c[i][1])
