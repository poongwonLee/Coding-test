def solution(cards):
    answer = 0
    arr=[0]*(len(cards)+1)
    res=[]
    for i in range(len(cards)):
        j=cards[i]
        cnt=0
        while(arr[j]==0):
            arr[j]=1
            j=cards[j-1]
            cnt+=1
        print(cnt)
        res.append(cnt)
    res.sort()
    return res[-1]*res[-2]