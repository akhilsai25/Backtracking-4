class Solution {
    List<String> response = new ArrayList();
    public String[] expand(String s) {
        List<List<Character>> strings = new ArrayList();
        int i=0;
        while(i<s.length()) {
            List<Character> string = new ArrayList();
            if(s.charAt(i)=='{') {
                i++;
                while(s.charAt(i)!='}') {
                    if(s.charAt(i)!=',') {
                        string.add(s.charAt(i));
                    }
                    i++;
                }
            } else if(s.charAt(i)!=','){
                string.add(s.charAt(i));
            }
            i++;
            Collections.sort(string);
            strings.add(string);
        }
        
        getExpansion(strings, new StringBuilder(""), 0);
        return response.toArray(new String[0]);
    }

    private void getExpansion(List<List<Character>> strings, StringBuilder string, int ref) {
        if(ref==strings.size()) {
            response.add(string.toString());
            return;
        }

        List<Character> chars = strings.get(ref);
        for(int i=0;i<chars.size();i++) {
            char c = chars.get(i);
            string.append(c);
            getExpansion(strings, string, ref+1);
            string.deleteCharAt(string.length()-1);
        }
    }
}
