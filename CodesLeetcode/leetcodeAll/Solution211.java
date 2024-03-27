class TrieNode {
    TrieNode[] characters;
    boolean isEnd;

    public TrieNode() {
        characters = new TrieNode[26];
        isEnd = false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            int digit = word.charAt(i) - 'a';
            if (currNode.characters[digit] == null) {
                currNode.characters[digit] = new TrieNode();
            }
            currNode = currNode.characters[digit];
        }
        currNode.isEnd = true;
    }

    public boolean searchString(String word, TrieNode curr, int len) {
        if (len == 0) {
            return curr.isEnd;
        }
        if (len < 0) {
            return false;
        }
        char charIndex = word.charAt(0);
        if (charIndex == '.') {
            for (int i = 0; i < 26; i++) {
                if (curr.characters[i] != null) {
                    String postStr = word.substring(1, word.length());
                    boolean result = searchString(postStr, curr.characters[i], len - 1);
                    if (result) {
                        return true;
                    }
                }
            }
        } else {
            int digit = charIndex - 'a';
            if (curr.characters[digit] == null) {
                return false;
            }
            String wordSub = word.substring(1, word.length());
            return searchString(wordSub, curr.characters[digit], len - 1);
        }
        return false;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        int len = word.length();
        return searchString(word, curr, len);
    }
}
