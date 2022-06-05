import java.util.Scanner;

public class PostFixCalc{
    public static Integer EvaluatePostFix(String exp){
        //create a stack
        Stack<Integer> stack=new Stack<>();
         
        // Scan all characters one by one
        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);
             
            // If the scanned character is an operand (number here),
            // push it to the stack.
            if(Character.isDigit(c))
            stack.push(c - '0');
             
            //  If the scanned character is an operator, pop two
            // elements from stack apply the operator
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();
                 
                switch(c)
                {
                    case '+':
                    stack.push(val2+val1);
                    break;
                     
                    case '-':
                    stack.push(val2- val1);
                    break;
                     
                    case '/':
                    stack.push(val2/val1);
                    break;
                     
                    case '*':
                    stack.push(val2*val1);
                    break;
              }
            }
        }
        return stack.pop(); 
    }


    // A utility function to return the precedence of a given operator
    static int precedence(Character ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

        }
        return -1;
    }

    public static String InfixToPostfix(String exp){
        //Check if the expression has no digits or operators or not one of the listed operators 
        int count = 0;
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if(precedence(c) == -1){
              count ++;
            }
        }
        if (count == exp.length()){
            System.out.println("Expression with no digits or operators.");
        }

        String result = "";
        int parenthesesCount = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <exp.length() ; i++) {
            char c = exp.charAt(i);
            //check if char is operator
            if(precedence(c)>0){
                while(stack.isEmpty()==false && precedence(stack.peek())>=precedence(c)){
                    result += stack.pop();
                }
                stack.push(c);
            }else if(c==')'){
                parenthesesCount ++;
                char x = stack.pop();
                while(x!='('){
                    result += x;
                    x = stack.pop();
                }
            }else if(c=='('){
                parenthesesCount++;
                stack.push(c);
            }else{
                //character is neither operator nor ( 
                result += c;
            } 
        }
        if(parenthesesCount != 0 && (parenthesesCount / parenthesesCount != 1)){
            System.out.println("There is a parenthesis mismatch.");
            return null;
        }

        for (int i = 0; i <=stack.getCount() ; i++) {
            result += stack.pop();
        }
        return result;
    }
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Infix Expression: ");
        String InFixExpression = input.nextLine();

        String PostFixExpression = InfixToPostfix((InFixExpression));
        System.out.println(PostFixExpression);

        Integer result = EvaluatePostFix(PostFixExpression);
        System.out.println(result);
        input.close();

    }
}
