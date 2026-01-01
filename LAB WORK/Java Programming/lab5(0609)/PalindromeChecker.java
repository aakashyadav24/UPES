import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string/number
        System.out.print("Enter a string or number: ");
        String input = sc.nextLine();
        
        // Normalize input (optional, in case user types spaces/case differences)
        String str = input.toLowerCase().replaceAll("\\s+", "");

        // ---------- Using FOR loop ----------
        boolean isPalindromeFor = true;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                isPalindromeFor = false;
                break;
            }
        }
        System.out.println("FOR loop -> " + (isPalindromeFor ? "Palindrome" : "Not Palindrome"));

        // ---------- Using WHILE loop ----------
        boolean isPalindromeWhile = true;
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                isPalindromeWhile = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println("WHILE loop -> " + (isPalindromeWhile ? "Palindrome" : "Not Palindrome"));

        // ---------- Using DO-WHILE loop ----------
        boolean isPalindromeDo = true;
        int l = 0, r = str.length() - 1;
        if (str.length() > 1) {  // avoid empty string issue
            do {
                if (str.charAt(l) != str.charAt(r)) {
                    isPalindromeDo = false;
                    break;
                }
                l++;
                r--;
            } while (l < r);
        }
        System.out.println("DO-WHILE loop -> " + (isPalindromeDo ? "Palindrome" : "Not Palindrome"));

        // ---------- Using FOR-EACH loop ----------
        // Trick: Reverse the string using for-each style and compare
        StringBuilder reversed = new StringBuilder();
        for (char c : str.toCharArray()) {
            reversed.insert(0, c); // build reversed string
        }
        boolean isPalindromeFE = str.equals(reversed.toString());
        System.out.println("FOR-EACH loop -> " + (isPalindromeFE ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}
