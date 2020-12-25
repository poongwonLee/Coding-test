import timeit
start_time = timeit.default_timer()

n,k=map(int,input().split()) # n k값 입력
a=n
b=k
cnt=0
while n!=1:         #n이 1이면 종료
    if(n%k==0): n//=k    #n에 k를 나눠 나머지값이 0 이면 n를 k로 나눈다
    else: n-=1          #위의 조건이 거짓이면 n에 1을 빼준다
    cnt+=1              #연산 시 cnt 1 증가
print(cnt)              #결과 출력

################책에 있는 코드 #######################
# n=a
# k=b
# terminate_time = timeit.default_timer()
# print(terminate_time)
#
# start_time1 = timeit.default_timer()
# result=0
# while True:
#     target=(n//k)*k
#     result+=(n-target)
#     n=target
#     if n<k:
#         break
#     result+=1
#     n//=k
# result+=(n-1)
# print(result)
# terminate_time1 = timeit.default_timer()
# print(terminate_time1)