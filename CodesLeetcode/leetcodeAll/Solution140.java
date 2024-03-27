class TrieNode {
    TrieNode[] characters;
    boolean isEnd;
    public TrieNode() {
        this.characters = new TrieNode[26];
        this.isEnd = false;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String str1) {
        TrieNode currNode = root;
        for (int i = 0; i < str1.length(); i++) {
            int data1 = str1.charAt(i) - 'a';
            if (currNode.characters[data1] == null) {
                TrieNode newNode = new TrieNode();
                currNode.characters[data1] = newNode;
            }
            currNode = currNode.characters[data1];
        }
        currNode.isEnd = true;
    }

    public boolean search(String str1) {
        if (str1.isEmpty()) {
            return false;
        }
        TrieNode currNode = root;
        for (int i = 0; i < str1.length(); i++) {
            int data1 = str1.charAt(i) - 'a';
            if (currNode.characters[data1] == null) {
                return false;
            }
            currNode = currNode.characters[data1];
        }
        return currNode.isEnd;
    }
}


class Solution {
     public void insertion(List<String> wordDict, Trie head) {
        for (String str : wordDict) {
            head.insert(str);
        }
    }

    public void isPresent(String s, Trie head, List<String> resultSet, String currentString) {
    if (s.isEmpty()) {
        resultSet.add(currentString.trim()); // Trim to remove trailing space
        return;
    }
    for (int i = 1; i <= s.length(); i++) {
        String preString = s.substring(0, i);
        if (head.search(preString)) {
            String newString = currentString + preString + " ";
            String postString = s.substring(i, s.length());
            isPresent(postString, head, resultSet, newString);
        }
    }
}

    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Trie head = new Trie();
        insertion(wordDict, head);
        List<String>resultSet= new ArrayList<String>();
        String currentString="";
        isPresent(s, head,resultSet,currentString);
        return resultSet;
    }
}