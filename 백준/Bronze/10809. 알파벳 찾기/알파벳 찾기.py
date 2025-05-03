s=input()
visited=[-1]*26
for i in range(len(s)):
    idx=ord(s[i])-ord('a')
    if visited[idx]==-1:
        visited[idx]=i
print(' '.join(map(str,visited)))