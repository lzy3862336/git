// solution 1: backtrack, cant pass test since big n will cause stack overflow/time limit exceeds
// solution 2: same method, a slight optimization so that the time complexity not exceeds the limit
// solution 3: use math to calculate the index of the result and return the corresponding one

//solution 1
class Solution {
    int count = 0;
    String res = "";
    public String getPermutation(int n, int k) {
        StringBuilder str = new StringBuilder();
        for(int i=1;i<=n;i++){
            str.append(i);
        }
        backtrack("",str.toString(),k);
        return res;
    }
    public void backtrack(String a,String b,int k){
        if(b.length()==0){
            count++;
            if(count==k){
                res = a;
                return;
            }
        }
        for(int i=0;i<b.length();i++){
            String aTemp = a+b.charAt(i);
            String bTemp = b.substring(0,i)+b.substring(i+1,b.length());
            backtrack(aTemp,bTemp,k);
        }
    }
}

//solution 2
class Solution {
    int count = 0;
    int K;
    String res;
    public String getPermutation(int n, int k) {
        K = k;
        backtrack("",new boolean[n+1]);
        return res;
    }
    public void backtrack(String str,boolean mark[]){
        if(str.length()==mark.length-1){
            count++;
            if(count==K) res = str;
            return;
        }
        for(int i=1;i<mark.length;i++){
            if(!mark[i]){
                mark[i] = true;
                backtrack(str+i,mark);
                mark[i] = false;
            }
        }
    }
}

//solution 3
class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        StringBuilder str = new StringBuilder();
        //let k starts with 0 to be accordant with index that starts from 0
        k--;
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            fact *= i;
            list.add(i);
        }
        for(int i=n;i>=1;i--){
            fact /= i;
            int tempK = k/fact;
            k -= tempK*fact;
            str.append(list.remove(tempK));
        }
        return str.toString();
    }
}
