class Solution {

    public int findResult(int a, int b, String token){
        if(token.equals("+")){
            return a + b;
        }
        else if(token.equals("-")){
            return a - b;
        }
        else if(token.equals("*")){
            return a * b;
        }
        else return a / b;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int n = tokens.length;

        for(int i = 0; i<n; i++){
            if(tokens[i].equals("+") || tokens[i].equals("*") || tokens[i].equals("-") || tokens[i].equals("/")){
                int second = st.pop();
                int first = st.pop();
                int result = findResult(first, second, tokens[i]);
                st.push(result);
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}
