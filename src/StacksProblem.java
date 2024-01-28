import java.util.ArrayList;

public class StacksProblem {
    public static class Stack{
        int top;
        ArrayList<Character> st;
        static  int size;
        Stack(){
            st = new ArrayList<Character>();
            size=0;
            top = -1;
        }
        void display(){
            if(top == -1){
                System.out.println("Stack is empty");
                return;
            }
            for(int i = top ; i >= 0  ; i--){
                System.out.print(this.st.get(i)+" ");
            }
            System.out.println();
        }
        private void displayReverse(int top){
            if(top == 0){
                System.out.print(st.get(top)+ " ");
                return;
            }
            displayReverse(top-1);
            System.out.print(st.get(top)+ " ");
        }
        void displayReverse(){
            displayReverse(top);
        }
        void push(char c){
            top++;
            st.add(top,c);
            size++;
        }
        void pop(){
            if(top == -1) {
                System.out.println("Stack is empty");
                return;
            }
            --top;
            size--;
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push('B');
        s.push('A');
        s.push('T');
//        s.display();
        s.displayReverse();
        System.out.println();
        s.pop();
        s.pop();
        s.push('O');
        s.push('T');
//        s.display();
        s.displayReverse();
    }
}
