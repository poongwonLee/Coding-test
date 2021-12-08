


dp=[[0]*10 for i in range(1001)]

for i in range(10):
  dp[1][i]=1

n=int(input())
for i in range(2,n+1):
  
  for j in range(10):
    for k in range(j+1):
      dp[i][j]+=dp[i-1][k]
      dp[i][j]%=10007

print(sum(dp[n])) 
