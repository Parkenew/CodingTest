T = int(input())

for t in range(1, T + 1):
    words = input().split()
    reversed_words = ' '.join(reversed(words))
    print(f"Case #{t}: {reversed_words}")
