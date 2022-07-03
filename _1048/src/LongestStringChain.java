//https://leetcode.com/problems/longest-string-chain/

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestStringChain {
  public static void main(String[] args) {
    var longestChain = new LongestStringChain();
    var ar = List.of(
        //new String[]{"a", "b", "ba", "ba", "bca", "bda", "bdca"},
        new String[]{"bdca","bda","ca","dca","a"},
        new String[]{"xb", "xbc", "cxbc", "pcxbc", "pcxbcf"},
        new String[]{"abcd", "dbqca"}
    );

    ar.forEach(a -> {
      System.out.println(longestChain.longestStrChain(a));
    });
  }

  public int longestStrChain(String[] words) {

    if (words.length == 1 || words.length == 0) {
      return words.length;
    }

    Arrays.sort(words, Comparator.comparingInt(String::length));

    Map<String, Integer> map = new HashMap<>();

    for (String word : words) {
      var keys = map.keySet()
          .stream()
          .filter(k -> isPredecessor(k, word))
          .toList();
      keys.forEach(w -> map.compute(word,
          (s, val) ->
            val == null ? map.get(w) + 1 : Math.max(val, map.get(w) + 1)
          )
      );
      map.putIfAbsent(word, 1);
    }

    map.forEach((key, value) -> System.out.printf("k=%10s, l=%3d%n", key, value));
    System.out.println();
    return map.values().stream().max(Integer::compareTo).orElse(0);
  }

  private boolean isPredecessor(String w1, String w2) {
    if (w1.length() + 1 != w2.length()) {
      return false;
    }

    int lastLetterInW2 = -1;

    for (int i = 0; i < w1.length(); i++) {
      if (!w2.contains(String.valueOf(w1.charAt(i)))) {
        return false;
      }

      int indexInW2 = w2.indexOf(w1.charAt(i), lastLetterInW2);
      if (lastLetterInW2 > indexInW2) {
        return false;
      }
      lastLetterInW2 = indexInW2;
    }
    return true;

  }
}
