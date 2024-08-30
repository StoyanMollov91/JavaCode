package Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PostOffice  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        Pattern pattern1 = Pattern.compile("([#$%*&])([A-Z]+)\\1");
        Pattern pattern2 = Pattern.compile("(\\d{2}):(\\d{2})");
        String[] arr = code.split("\\|");
        String first = arr[0]; String second = arr[1]; String third = arr[2];
        String[] words = third.split("\\s+");
        Matcher matcher1 = pattern1.matcher(first);
        List<Character> chars = new ArrayList<>();
        if (matcher1.find()){
            chars = Arrays.stream(matcher1.group(2).split("")).map(e -> e.charAt(0)).collect(Collectors.toList());
        }
        Matcher matcher2 = pattern2.matcher(second);
        while (matcher2.find() && !chars.isEmpty()) {
            char c = (char) Integer.parseInt(matcher2.group(1));
            int length = Integer.parseInt(matcher2.group(2)) + 1;
            if (c == chars.get(0)) {
                for (String word : words) {
                    if (word.charAt(0) == c && word.length() == length) {
                        chars.remove(0);
                        System.out.println(word);
                        matcher2.reset();
                        break;
                    }
                }
            }
        }
    }
}
