n=int(input())
c=[[0]*100 for i in range(100)]

for i in range(n):
  x,y=map(int,input().split())
  for j in range(y,y+10):
    for k in range(x,x+10):
      c[j][k]=1
cnt=0
for j in range(100):
  for k in range(100):
    if c[j][k]==1: cnt+=1
print(cnt)      
