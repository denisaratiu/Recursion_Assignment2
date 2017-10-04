/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

/**
 *
 * @author ratid6445
 */
public class Recursion {

    public int digitalSum(int n) {
        // if the number is a single digit return that digit since you don't need to add any digits together
        if (n >= 0 && n <= 9) {
            // return the single digit
            return n;
        }
        // if the number is not a single digit 
        // create a mod integer to yield the rightmost digit
        int mod = n % 10;
        // create a divide integer to remove the rightmost digit
        int divide = n / 10;
        // create a sum integer that goes through mod and divide 
        // recursively happen until all the digits are added together
        int sum = mod + digitalSum(divide);
        // return the sum 
        return sum;
    }

    public int digitalRoot(int n) {
        // make n call upon the digitalSum method to store the sum of the digits
        n = digitalSum(n);
        // if digitalSum is a single digit return that digit
        if (n >= 0 && n <= 9) {
            // return the digitalSum
            return n;
        }
        // if the digitalSum is not a single digit
        // create a mod and a divide integer to go through all the digits in the digitalSum
        int mod = n % 10;
        int divide = n / 10;
        // add the digits in the digitalSum together
        int ans = mod + digitalRoot(divide);
        // return the root
        return ans;
    }

    public int triangle(int n) {
        // if n is 0 or 1 than return that digit
        if (n == 0 || n == 1) {
            // return 0 or 1
            return n;
        }
        // if n is not 0 or 1
        // start at n and subtract one each time until it gets to 1
        int ans = n + triangle(n - 1);
        // return the answer of the triangle
        return ans;
    }

    public void hailstone(int n) {
        // output the next number in the sequence each time
        System.out.println(n);
        // if the number is 1, stop the sequence
        if (n == 1) {
            // stop the sequence
            return;
        }
        // if n is an even number
        if (n % 2 == 0) {
            // divide n by 2
            hailstone(n / 2);
        } // if n is an odd number
        else {
            // equation for odd number to get the next number in the sequence
            hailstone(3 * n + 1);
        }
    }

    public String binaryConvert(int n) {
        // create a string to hold the binary number
        String binary = new String();
        // if n can be divided by 2 evenly the quotient would be 0
        if (n % 2 == 0) {
            // output the remainder of 0
            binary = ("0");
        } // if it cannot be divided evenly into 2
        else {
            // return 1 as the remainder for odd numbers
            binary = ("1");
        }
        // if the number is 1, stop the sequence
        if (n == 1) {
            // stop the sequence
            return binary;
        }
        // scan in inputted number, first divide by 2 
        // then show whether there is a remainder or not
        String answer = binaryConvert(n / 2) + binary;
        // output the binary each time
        return answer;
    }

    public String convert(int n, int b) {
        // create a string to hold the remainder of the number when divided by the other
        String number = new String();
        // create the letters that will convert the corresponding number to a letter
        String[] letterConversion = {"A", "B", "C", "D", "E", "F"};
        // if the remainder of n divided by b is above 10
        if (n % b >= 10) {
            // convert to the corresponding letter
            number = number + letterConversion[n % b - 10];
        } // if the remainder of n divided by b is less than 10 but more than 2
        if (n % b < 10 || n % b >= 2) {
            // return the remainder
            number = number + n % b;
        }
        // if the remainder is 0
        if (n / b == 0) {
            // stop the sequence and return number
            return number;
        }
        // scan in inputted numbers, first divide by each other 
        // then show remainder
        String answer = convert(n / b, b) + number;
        // output the remainder
        return answer;
    }

    public boolean isPalindrome(String s, int length) {
        // if the length is less than 2 then it is a palindrome
        if (length < 2) {
            return true;
        }
        // start at the first position and look to see if the last position is the same
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            // call upon the method to see if the second and second last position is the same and so on
            // do this by removing the first and last positions each time
            return isPalindrome(s.substring(1, length - 1), length - 2);
        } // if the first and last positions of each set are not the same, it is not a palindrome
        else {
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // test the methods in the file
        Recursion test = new Recursion();

        // test digitalSum
        int A2Q1test = test.digitalSum(49);
        System.out.println(A2Q1test);
        int A2Q1test2 = test.digitalSum(126);
        System.out.println(A2Q1test2);
        int A2Q1test3 = test.digitalSum(12);
        System.out.println(A2Q1test3);

        // test digitalRoot
        int A2Q2test = test.digitalRoot(2019);
        System.out.println(A2Q2test);
        int A2Q2test2 = test.digitalRoot(126);
        System.out.println(A2Q2test2);
        int A2Q2test3 = test.digitalRoot(276);
        System.out.println(A2Q2test3);

        // test triangle
        int A2Q3test = test.triangle(2);
        System.out.println(A2Q2test);
        int A2Q3test2 = test.triangle(4);
        System.out.println(A2Q2test2);
        int A2Q3test3 = test.triangle(7);
        System.out.println(A2Q2test3);

        // test hailstone
        test.hailstone(5);
        test.hailstone(2);
        test.hailstone(7);

        // test binaryConvert
        String A2Q5test = test.binaryConvert(156);
        System.out.println(A2Q5test);
        String A2Q5test2 = test.binaryConvert(13);
        System.out.println(A2Q5test2);

        // test convert
        String A2Q6test = test.convert(1000, 8);
        System.out.println(A2Q6test);
        String A2Q6test2 = test.convert(1000, 16);
        System.out.println(A2Q6test2);
        String A2Q6test3 = test.convert(1000, 2);
        System.out.println(A2Q6test3);

        // test isPalindrome
        boolean A2Q7test = test.isPalindrome("racecar", 7);
        System.out.println(A2Q7test);
        boolean A2Q7test2 = test.isPalindrome("radar", 5);
        System.out.println(A2Q7test2);
        boolean A2Q7test3 = test.isPalindrome("pumpkin", 7);
        System.out.println(A2Q7test3);

    }
}
