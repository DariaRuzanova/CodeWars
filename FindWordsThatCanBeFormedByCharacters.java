import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters {
    public static void main(String[] args) {
        String[] words = {"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin",
                "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb",
                "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl",
                "boygirdlggnh",
                "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx",
                "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop",
                "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx",
                "juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr",
                "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo",
                "oxgaskztzroxuntiwlfyufddl",
                "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp",
                "qnagrpfzlyrouolqquytwnwnsqnmuzphne",
                "eeilfdaookieawrrbvtnqfzcricvhpiv",
                "sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz",
                "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue",
                "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv",
                "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo",
                "teyygdmmyadppuopvqdodaczob",
                "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs",
                "qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"};
        String chars = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";
        System.out.println(countCharacters(words, chars));
        System.out.println(sumCharacters(words,chars));
    }

    public static Map<Character,Integer> createCharsMap(String chars,Map<Character,Integer> map){

        for (int i = 0; i < chars.length(); i++) {
            char ch = chars.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        return map;
    }
    private static int sumCharacters(String[] words, String chars) {
        int count = 0;
        Map<Character,Integer> map = new HashMap<>();
        createCharsMap(chars,map);
        for (String word:words) {
            int countChar = 0;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(map.containsKey(ch)&&map.get(ch)>0){
                    map.put(ch, map.get(ch)-1);
                    countChar++;
                }else {
                    countChar=0;
                    break;
                }
            }
            count+=countChar;
            createCharsMap(chars,map);

        }
        return count;
    }


    private static int countCharacters(String[] words, String chars) {
        int count = 0;
        for (String word : words) {
            if (isGood(word, chars)) {
                count += word.length();
            }

        }
        return count;
    }

    private static boolean isGood(String word, String chars) {
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char ch = chars.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        System.out.println("Hashmap before modification  " + hm);
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (hm.containsKey(ch) && hm.get(ch) > 0) {
                hm.put(ch, hm.get(ch) - 1);
            } else {
                return false;
            }
        }
        System.out.println("Hashmap after modification " + hm);
        return true;
    }
}
