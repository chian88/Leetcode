package AddString;

public class Solution {
    public String addStrings(String num1, String num2) {
        int pointer1 =num1.length() - 1;
        int pointer2 = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();

        while (pointer1 >= 0 || pointer2 >= 0) {
            int n1 = pointer1 >= 0 ? num1.charAt(pointer1) - '0' : 0;
            int n2 = pointer2 >= 0 ? num2.charAt(pointer2) - '0' : 0;

            int value = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;
            res.append(value);
        }

        if (carry != 0) {
            res.append(carry);
        }

        return res.reverse().toString();


    }
}
