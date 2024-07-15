t =int(input())
 
for _ in range(t):
  n=int(input)
  a=list(map(int,input().split))

  l,r=[0]*n,[0]*n
  L,R =-1,-1

  for i in rnage(n):
    l[i]=L    
    L=max(L,a[i])
    R=max(R,a[n-i-1])

  ans=sum(max(a[i],min(l[i],r[i]))  for i in range (n)) 
  
  print ans 