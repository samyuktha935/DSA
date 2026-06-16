public class ProcessStringwithSpecialOperationsI {
    static void main(String[] args) {
        String s = "a#b%*";
        String ans = processStr(s);
        System.out.println(ans);
    }

    private static String processStr(String s) {
        StringBuilder str = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c >= 'a' && c<= 'z'){
                str.append(c);
            }else if(c == '*'){
                if(str.length()==0){
                    continue;
                }
                else{
                    str.deleteCharAt(str.length()-1);
                }
            }else if(c == '#'){
                String copyString = str.toString();
                str.append(copyString);
            }else{
                str = str.reverse();
            }
        }
        return str.toString();
    }
}
