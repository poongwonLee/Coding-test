def solution(survey, choices):
    dic={"R":0 ,"T":1 , "C":2 , "F":3 , "J":4, "M":5,"A":6,"N":7}
    arr=[0]*8
    for i in range(len(survey)):
        a=survey[i][0]
        b=survey[i][1]
        if choices[i]<=3:
            arr[dic[a]]+=4-choices[i]
        elif choices[i]>=5:
            arr[dic[b]]+=choices[i]-4
        print(a,b)
    print(arr)
    answer=""
    if(arr[0]<arr[1]):answer+="T"
    else:answer+="R"
    if(arr[2]<arr[3]):answer+="F"
    else:answer+="C"
    if(arr[4]<arr[5]):answer+="M"
    else:answer+="J"
    if(arr[6]<arr[7]):answer+="N"
    else:answer+="A"

    return answer