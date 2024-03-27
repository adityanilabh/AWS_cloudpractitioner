class TrieNode {
    TrieNode[] characters;
    boolean isEnd;

    public TrieNode() {
        characters = new TrieNode[26];
        isEnd = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int data = word.charAt(i) - 'a';
            if (curr.characters[data] == null) {
                curr.characters[data] = new TrieNode();
            }
            curr = curr.characters[data];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            int data = word.charAt(i) - 'a';
            if (currNode.characters[data] == null) {
                return false;
            }
            currNode = currNode.characters[data];
        }
        return currNode.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode currNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            int data = prefix.charAt(i) - 'a';
            if (currNode.characters[data] == null) {
                return false;
            }
            currNode = currNode.characters[data];
        }
        return true;
    }
}
