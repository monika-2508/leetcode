// Last updated: 9/15/2026, 9:20:43 AM
1class Solution {
2    private final String[] LESS_THAN_20 = {
3        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
4        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
5    };
6
7    private final String[] TENS = {
8        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
9    };
10
11    private final String[] THOUSANDS = {
12        "", "Thousand", "Million", "Billion"
13    };
14
15    public String numberToWords(int num) {
16        if (num == 0) return "Zero";
17
18        int i = 0;
19        String words = "";
20
21        while (num > 0) {
22            if (num % 1000 != 0) {
23                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
24            }
25            num /= 1000;
26            i++;
27        }
28
29        return words.trim();
30    }
31
32    private String helper(int num) {
33        if (num == 0) {
34            return "";
35        } else if (num < 20) {
36            return LESS_THAN_20[num] + " ";
37        } else if (num < 100) {
38            return TENS[num / 10] + " " + helper(num % 10);
39        } else {
40            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
41        }
42    }
43}