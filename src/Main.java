import java.util.*;

public class Main {
    public static void main(String[] args) {
        GroupAnagramsAL groupAnagramsAL = new GroupAnagramsAL();
        String []str = new String[]{"bdddddddddd","bbbbbbbbbbc"};
        List<List<String>> retList = groupAnagramsAL.groupAnagrams(str);
        System.out.println(String.valueOf(retList));

    }

}