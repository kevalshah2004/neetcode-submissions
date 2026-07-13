class Pair{
    int val;
    int min;
    Pair(int val, int min){
        this.val = val;
        this.min = min;
    }
}

class MinStack {

    Stack<Pair> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Pair(val, val));
            return;
        }
        int lastMin = st.peek().min;
        if(val < lastMin)
            st.push(new Pair(val, val));
        else st.push(new Pair(val, lastMin));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}
