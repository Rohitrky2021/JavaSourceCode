import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        long ticketCount = inputScanner.nextLong();
        Map<TicketPair, Long> pairCountMap = new HashMap<>();
        String[] tickets = new String[(int) ticketCount];

        for (int i = 0; i < ticketCount; i++) {
            tickets[i] = inputScanner.next();
            String ticket = tickets[i];
            long digitSum = 0;

            for (char digitChar : ticket.toCharArray()) {
                digitSum += (digitChar - '0');
            }

            long parity = ticket.length() % 2;
            pairCountMap.put(new TicketPair(digitSum, parity), pairCountMap.getOrDefault(new TicketPair(digitSum, parity), 0L) + 1L);
        }

        long luckyPairCount = 0;

        for (int i = 0; i < ticketCount; i++) {
            long parity = tickets[i].length() % 2;
            long digitSum = 0;

            for (char digitChar : tickets[i].toCharArray()) {
                digitSum += (digitChar - '0');
            }

            luckyPairCount += pairCountMap.getOrDefault(new TicketPair(digitSum, parity), 0L);
            long ticketSize = tickets[i].length();

            if (parity == 1) {
                for (long j = 1; j < ticketSize; j += 2) {
                    long halfLength = (ticketSize + j) / 2;
                    long tempSum = 0;

                    for (long k = 0; k < halfLength; k++) {
                        tempSum += (tickets[i].charAt((int) k) - '0');
                    }

                    long findSum = Math.abs(digitSum - 2 * tempSum);
                    long pairParity = j % 2;
                    luckyPairCount += pairCountMap.getOrDefault(new TicketPair(findSum, pairParity), 0L);
                    tempSum = 0;

                    for (long k = 0; k < halfLength; k++) {
                        tempSum += (tickets[i].charAt((int) (ticketSize - k - 1)) - '0');
                    }

                    findSum = Math.abs(digitSum - 2 * tempSum);
                    luckyPairCount += pairCountMap.getOrDefault(new TicketPair(findSum, pairParity), 0L);
                }
            } else {
                for (long j = 2; j < ticketSize; j += 2) {
                    long halfLength = (ticketSize + j) / 2;
                    long tempSum = 0;

                    for (long k = 0; k < halfLength; k++) {
                        tempSum += (tickets[i].charAt((int) k) - '0');
                    }

                    long findSum = Math.abs(digitSum - 2 * tempSum);
                    long pairParity = j % 2;
                    luckyPairCount += pairCountMap.getOrDefault(new TicketPair(findSum, pairParity), 0L);
                    tempSum = 0;

                    for (long k = 0; k < halfLength; k++) {
                        tempSum += (tickets[i].charAt((int) (ticketSize - k - 1)) - '0');
                    }

                    findSum = Math.abs(digitSum - 2 * tempSum);
                    luckyPairCount += pairCountMap.getOrDefault(new TicketPair(findSum, pairParity), 0L);
                }
            }
        }
        System.out.println(luckyPairCount);
    }

    public static boolean isSorted(long[] arr) {
        long length = arr.length;

        for (long i = 0; i < length - 1; i++) {
            if (arr[(int) i] > arr[(int) (i + 1)]) {
                return false;
            }
        }
        return true;
    }

    static class TicketPair {
        long first;
        long second;

        TicketPair(long first, long second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int hashCode() {
            return (int) (first * 31 + second);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            TicketPair pair = (TicketPair) obj;
            return first == pair.first && second == pair.second;
        }
    }
}
