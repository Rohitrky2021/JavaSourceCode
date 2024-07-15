public class FastModuloExponensiation {  // (a^n)%m
    // TC-O(log(b))--> Where b=Max number of Bit 
    
}
public int modularAddition(int a, int b, int MOD) {
    return (a % MOD + b % MOD) % MOD;
  }

  public long modularAddition(long a, long b, long MOD) {
    return (a % MOD + b % MOD) % MOD;
  }

  // Modular Multiplication
  public int modularMultiplication(int a, int b, int MOD) {
    return ((a % MOD) * (b % MOD)) % MOD;
  }

  public long modularMultiplication(long a, long b, long MOD) {
    return ((a % MOD) * (b % MOD)) % MOD;
  }

  // Modular Subtraction
  public int modularSubtraction(int a, int b, int MOD) {
    return (a % MOD - b % MOD + MOD) % MOD;
  }

  public long modularSubtraction(long a, long b, long MOD) {
    return (a % MOD - b % MOD + MOD) % MOD;
  }


    //  A gist of BElow is 
    // while(n>0){
    //   if(b & 1)--> odd last bit pow used  res=(res*a)%m;

    //   a=(a*a)%m;-->as increase pow of every bit 
    //   b=b>>1;  --> Shifting and letting it work on next pow

    // }
    public int modularExponentiation(int x, int n, int MOD) {
        if (n == 0)
          return 1 % MOD;
        else if (n % 2 == 0)
          return modularExponentiation(modularMultiplication(x, x, MOD), n / 2, MOD);
        else
          return modularMultiplication(x, modularExponentiation(modularMultiplication(x, x, MOD), (n - 1) / 2, MOD), MOD);
      }
  
    //    M2 for Long 
    public long modularExponentiation(long x, long n, long MOD) {
        long result = 1;
        while (n > 0) {
          if (n % 2 == 1)// if(N & 1 ==1)
            result = modularMultiplication(result, x, MOD);
          x = modularMultiplication(x, x, MOD);
          n /= 2;
        }
        return result;
      }
 }