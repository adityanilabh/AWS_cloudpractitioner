class Solution1061 {
    public class DSU {
        int[] parent;

        public DSU(int length) {
            parent = new int[length];
            for (int i = 0; i < length; i++) {
                parent[i] = i;
            }
        }

        public int find(int indexofChar) {
            if (parent[indexofChar] != indexofChar) {
                return parent[indexofChar] = find(parent[indexofChar]);
            }
            return parent[indexofChar];
        }

        public void union(int index1, int index2) {
            int parent1 = find(index1);
            int parent2 = find(index2);
            if (parent[parent1] == parent[parent2]) {
                return;
            } else if (parent1 > parent2) {
                parent[parent1] = parent2;
            } else {
                parent[parent2] = parent1;
            }
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DSU dsu = new DSU(26);
        for (int i = 0; i < s1.length(); i++) {
            int valueOfChar1 = s1.charAt(i) - 'a';
            int valueOfChar2 = s2.charAt(i) - 'a';
            dsu.union(valueOfChar1, valueOfChar2);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            int valueOfChar3 = baseStr.charAt(i) - 'a';
            int valueOfParent = dsu.find(valueOfChar3);
            char valueOfChar = (char) ('a' + valueOfParent);
            result.append(valueOfChar);
        }

        return result.toString();

    }
}
