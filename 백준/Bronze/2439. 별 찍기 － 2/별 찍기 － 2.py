n=int(input())
a=" "
b="*"
cnt=1
for i in reversed(range(n)):
    print(i*a+b*cnt)
    cnt +=1