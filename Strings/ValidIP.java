/**
 * InnerValidIP
 */
public class ValidIP {
    static boolean checkValid(String s) {
        if(s.charAt(0) == '.' || s.charAt(s.length()-1) == '.') {
            return false;
        }
        
        String[] str = s.split("\\.");
        if(str.length != 4) {
            return false;
        }
        for(String i: str) {
            if(i.matches("[a-zA-Z]")) {
                return false;
            }
            if(i.length() == 0 || i.length() > 4) {
                return false;
            }
            if(i.equals("000") || i.equals("00") || i.equals("0000")) {
                return false;
            }
            if(i.length() > 1 && i.charAt(0) == '0') {
                return false;
            }
            int check = Integer.parseInt(i);
            if(check < 0 || check > 255) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        boolean ans = checkValid("5555..555");
        System.out.println(ans);
    }
}
