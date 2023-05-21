/**
 * LookAndSay
 */
public class LookAndSay {

    static String lookandsay(int n) {
        if(n == 1) {
            return "1";
        }
        if(n == 2) {
            return "11";
        }
        
        String result = "11";
        for(int i=3;i<=n;i++) {
            int count = 1;
            String temp = "";
            for(int j=1;j<result.length();j++) {
                if(result.charAt(j) != result.charAt(j-1)) {
                    temp = temp + String.valueOf(count);
                    temp = temp + result.charAt(j-1);
                    count = 1;
                }
                else {
                    count++;
                }   
            }
            temp = temp + String.valueOf(count);
            temp = temp + result.charAt(result.length()-1);
            result = temp; 
        }
        return result;
    }

    public static void main(String[] args) {
        String str = lookandsay(5);
        System.out.println(str);
    }
}