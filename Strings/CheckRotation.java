/**
 * CheckRotation
 */
/**
 * Approach - 
 * we will make a third string temp, which will contain concatenation of string1+string1,
 * will then check if temp contains string2, 
 * if it does, then they are rotation of each other
 */
public class CheckRotation {

    public static void main(String[] args) {
        String string1 = "geeksforgeeks";
        String string2 = "forgeeksgeeks";

        String temp = string1 + string1;

        if(temp.contains(string2)) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }

    }
}