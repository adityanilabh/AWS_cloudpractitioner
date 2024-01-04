import java.util.*;
import java.lang.*;
import java.io.*;
/* This Solution is based on gfg practice session that i had solved. */
class Solution {
    public boolean Dfs(ArrayList<ArrayList<Integer>> adj, int presentIndex, ArrayList<Boolean> visited, int previousIndex) {
        visited.set(presentIndex, true);

        for (int index = 0; index < adj.get(presentIndex).size(); index++) {
            int nextIndex = adj.get(presentIndex).get(index);

            if (!visited.get(nextIndex)) {
                if (Dfs(adj, nextIndex, visited, presentIndex)) {
                    return true;
                }
            } else if (nextIndex != previousIndex) {
                return true;
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Boolean> visited = new ArrayList<>(Collections.nCopies(V, false));

        for (int index = 0; index < V; index++) {
            if (!visited.get(index)) {
                if (Dfs(adj, index, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
/* driver code starts here */

class detectCycle {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends