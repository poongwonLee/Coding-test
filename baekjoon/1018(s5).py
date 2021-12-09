a,b=map(int,input().split())

c=[]
min2=1251212616126126
for i in range(0,a):
    tmp=input()
    c.append(tmp)
for x in range(0,a-7):
    for y in range(0,b-7):
        
        cnt1=0
        cnt2=0
        for i in range(0+x,8+x):
            for j in range(0+y,8+y):
                
                  
                if(i%2== 0 and j%2==0 and c[i][j]=='W'): cnt1+=1
                if(i%2== 0 and j%2==1 and c[i][j]=='B'): cnt1+=1

                if(i%2== 1 and j%2==0 and c[i][j]=='B'): cnt1+=1
                if(i%2== 1 and j%2==1 and c[i][j]=='W'): cnt1+=1

              
                if(i%2== 0 and j%2==0 and c[i][j]=='B'): cnt2+=1
                if(i%2== 0 and j%2==1 and c[i][j]=='W'): cnt2+=1

                if(i%2== 1 and j%2==0 and c[i][j]=='W'): cnt2+=1
                if(i%2== 1 and j%2==1 and c[i][j]=='B'): cnt2+=1

        min2=min(min2,cnt1,cnt2)

print(min2)             
