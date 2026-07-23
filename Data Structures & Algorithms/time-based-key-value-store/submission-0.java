class Pair{
    String value;
    int timestamp;

    Pair(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {

    HashMap<String, ArrayList<Pair>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        ArrayList<Pair> al = new ArrayList<>();
        if(hm.containsKey(key)){
            al = hm.get(key);
        }
        al.add(new Pair(value, timestamp));
        hm.put(key, al);
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)) return "";
        ArrayList<Pair> al = hm.get(key);

        int low = 0;
        int high = al.size()-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            int midStamp = al.get(mid).timestamp;
            if(midStamp > timestamp){
                high = mid - 1;
            }
            else 
                low = mid+1;
        }
        if(high == -1) return "";
        return al.get(high).value;
    }
}
