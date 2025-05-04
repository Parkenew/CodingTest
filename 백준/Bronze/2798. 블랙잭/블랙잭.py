n,m=map(int,input().split())
card=list(map(int,input().split()))
max_sum=0
for i in range(n-2):
    for j in range(i+1,n-1):
        for h in range(j+1,n):
            cur_sum=card[i]+card[j]+card[h]
            if cur_sum <= m:
                max_sum=max(max_sum,cur_sum)
                    
print(max_sum)                 