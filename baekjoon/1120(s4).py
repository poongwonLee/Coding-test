from collections import deque
from queue import PriorityQueue
import sys
si=sys.stdin.readline
a,b = si().split()

min=len(a)
for j in range(len(b)-len(a)+1):
   count=0
   for i in range(len(a)):
      if a[i] != b[i+j]:
         count+=1
   if count < min:
      min =count
  
print(min)
