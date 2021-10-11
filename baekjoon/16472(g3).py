import sys
si = sys.stdin.readline

n=int(si())
arr=si()
ch=[0]*27
r=0
res=0
cnt=0

for l in range(len(arr)-1):
    while r<len(arr)-1 :

        if( ch[ord(arr[r])-96]==0):
            if cnt>=n:
                
                break
            cnt+=1

        ch[ord(arr[r])-96]+=1
        r+=1
    res=max(res,r-l)

    if(ch[ord(arr[l])-96]==1):
        cnt-=1
    ch[ord(arr[l])-96]-=1
    
    
print(res)
    
    
