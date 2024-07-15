import java.util.Scanner;

public class Fermant_theorem {
    static final long mod = 1000000007;

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long powmod(long a, long b) {
        long res = 1;
        if (a >= mod)
            a %= mod;
        for (; b > 0; b >>= 1) {
            if ((b & 1) == 1)
                res = (res * a) % mod;
            if (res >= mod)
                res %= mod;
            a = (a * a) % mod;
            if (a >= mod)
                a %= mod;
        }
        return res;
    }

    static long mul_ab_mod_c(long a, long b, long c) {
        long x = 0, y = a % c;
        while (b > 0) {
            if ((b & 1) == 1)
                x = (x + y) % c;
            y = (y << 1) % c;
            b >>= 1;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(powmod(n, mod - 2));
    }
}

public class Fermant_theorem1 {
    // Fermant_Little_theorem == > Used in finding Multiplicitive Inverse
    // https://www.youtube.com/watch?v=K_UOxtlAIms

}

// https://chat.openai.com/c/0aab5709-1c45-4347-916b-c04cb0b0225d
// The expression powmod(n, mod - 2) is used to calculate the modular
// multiplicative inverse of n modulo 1000000007. This is based on Fermat's
// Little Theorem, which states that if p is a prime number, then for any
// integer a not divisible by p, the following congruence holds:

// �
// �
// −
// 1
// ≡
// 1
// (
// m
// o
// d
// �
// )
// a
// p−1
// ≡1(modp)

// In this case,
// 1000000007
// 1000000007 is a prime number. Therefore, we can rewrite Fermat's Little
// Theorem as:

// �
// 1000000006
// ≡
// 1
// (
// m
// o
// d
// 1000000007
// )
// n
// 1000000006
// ≡1(mod1000000007)

// Multiplying both sides by
// �
// −
// 1
// n
// −1
// (the modular inverse of
// �
// n), we get:

// �
// −
// 1
// ≡
// �
// 1000000006
// −
// 1
// (
// m
// o
// d
// 1000000007
// )
// n
// −1
// ≡n
// 1000000006−1
// (mod1000000007)

// Simplifying the exponent, we get:

// �
// −
// 1
// ≡
// �
// 1000000005
// (
// m
// o
// d
// 1000000007
// )
// n
// −1
// ≡n
// 1000000005
// (mod1000000007)

// So, the expression powmod(n, mod - 2) calculates
// �
// 1000000005
// (
// m
// o
// d
// 1000000007
// )
// n
// 1000000005
// (mod1000000007), which is the modular multiplicative inverse of
// �
// n modulo
// 1000000007
// 1000000007. The reason for using mod - 2 is because
// 1000000005
// 1000000005 is equal to
// 1000000007
// −
// 2
// 1000000007−2.
