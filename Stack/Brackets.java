public class Brackets
{
    public static void main(String[] args)
    {
        System.out.println("Should be true");
        System.out.println(checkBrackets(" "));
        System.out.println(checkBrackets("{}"));
        System.out.println(checkBrackets("{}{}"));
        System.out.println(checkBrackets("{{}}"));
        System.out.println(checkBrackets("{{{}{{}}}}"));

        System.out.println("\nShould be false");
        System.out.println(checkBrackets("{"));
        System.out.println(checkBrackets("}{"));
        System.out.println(checkBrackets("{}}{"));
        System.out.println(checkBrackets("{{}"));
        System.out.println(checkBrackets("{{}}}{}"));
    }
    
    public static boolean checkBrackets(String b){
        ArrayStack<Character> brackets = new ArrayStack<>();
        if(b.length() == 0){
            return true;
        }
        else if(b.length() % 2 != 0){
            return false;
        }
        for(int i = 0; i < b.length(); i++){
            char c = b.charAt(i);
            if(c == '{'){
                brackets.push(c);
            }
            else{
                if(brackets.size() == 0){
                    return false;
                }
                brackets.pop();
            }
        }
        return true;
    }
}