package string;

public class SubString {

    /**
     * brute force approach to find the sub string in a given string
     *
     * @param haystack
     * @param needle
     * @return
     */
    static int strStr(String haystack, String needle) {
        // base condition
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;

        for (int i = 0; i < haystack.length(); i++) {
            int k = 0; // track the length of complete substring
            for (int j = 0; j < needle.length(); j++) {
                if (i + j < haystack.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                    k++;
                } else {
                    break;
                }
            }
            if (k == needle.length()) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("index :: " + strStr("mississippi", "issip"));
    }
}