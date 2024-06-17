import java.util.*;

public class Main {
    public static void main(String[] args) {
        String []strs = new String[] {"aabbcc", "aabbcc","cb"};
        FindLUSlengthAL findLUSlengthAL = new FindLUSlengthAL();
        int result = findLUSlengthAL.findLUSlength(strs);
        System.out.println(result);

    }

}