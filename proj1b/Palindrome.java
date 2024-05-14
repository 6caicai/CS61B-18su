public class Palindrome {
    public Deque<Character> wordToDeque(String word){

        // create a new LinkedListDeque.
        Deque deque =  new LinkedListDeque();

        // iterate over word and add to deque.
        for (int i = 0, j = word.length(); i < j; i ++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    // helper function that pass in a Deque and return whether it's a palindrome.
    public boolean isPalindromeHelper(Deque T) {
        // basic case.
        if (T.size() == 0 || T.size() == 1) {
            return true;
        }

        // another basic case.
        if (T.removeFirst() != T.removeLast()) {
            return false;
        }

        // recursive other way.
        return isPalindromeHelper(T);
    }

    public boolean isPalindrome(String word) {

//        // basic case.
//        if (word.length() == 0 || word.length() == 1) {
//            return true;
//        }
//
//        // another basic case.
//        int length = word.length();
//        if (word.charAt(0) != word.charAt(length - 1)) {
//            return false;
//        }
//
//        // recursive.
//        return isPalindrome(word.substring(1, length - 2));
//
        // another way to realize.
        return isPalindromeHelper(wordToDeque(word));

    }

    // helper function if given CharacterComparator.
    public boolean isPalindromeHelper(Deque T, CharacterComparator cc) {
        // basic case.
        if (T.size() == 0 || T.size() == 1) {
            return true;
        };

        // another basic case.
        if (!cc.equalChars((char) T.removeFirst(), (char) T.removeLast())) {
            return false;
        }

        // recursive other case.
        return isPalindromeHelper(T, cc);
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindromeHelper(wordToDeque(word), cc);
    }
}
