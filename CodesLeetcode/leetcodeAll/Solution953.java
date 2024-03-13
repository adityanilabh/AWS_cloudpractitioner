class Solution953 {
    public boolean isSorted(String prev,String curr,int[] sequence)
    {
        for(int i=0;i<prev.length();i++)
        {
            if(i>=curr.length())
            {
                return false;
            }
            int a= prev.charAt(i)-'a';
            int b= curr.charAt(i)-'a';
            
            if(sequence[b]<sequence[a])
            { 
                return false;
            }
            else if(sequence[a]<sequence[b])
            {
                return true;
            }
        }
        return true;
    }
    public boolean compareStrings(String[] words,int[] sequence)
    {
        for(int i=0;i<words.length-1;i++)
        {
            String prev= words[i];
            String curr=words[i+1];
            if(!isSorted(prev,curr,sequence)){
                return false;
            }
        }
        return true;
    }
    public boolean isAlienSorted(String[] words, String order) {
        // my method:
        if(words.length==1)
        {
            return true;
        }
        int sequence[]= new int[26];
        for(int i=0;i<26;i++)
        {
            int data = order.charAt(i) - 'a';
            sequence[data]=i;
            // xab: [1,2,....,0,..];
        }
        
        return compareStrings(words,sequence);
    }
}