public class LengthofLongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = { "geeksforgeeks", "geeks", "geek",
                "geezer" };
        int n = arr.length;

        int i;
        String temp = arr[0];
        for (int j = 0; j < n; j++) {
            i = 0;
            while (i < temp.length() && i < arr.length) {
                if (temp.charAt(i) != arr[j].charAt(i)) {
                    break;
                } else {
                    i++;
                }
            }
            temp = temp.substring(0, i);
        }
        if (temp.length() == 0) {
            System.out.println("-1");
        } else {
            System.out.println(temp);
        }
    }
}
