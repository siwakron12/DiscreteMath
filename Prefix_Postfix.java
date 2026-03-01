
public class Prefix_Postfix {

    String infix;
    String postfix;
    String prefix;
    String inFixReverse;
    Stack Box;

    public Prefix_Postfix(String infix) {
        this.Box = new Stack(infix.length());
        this.infix = infix;
        this.inFixReverse = reverse(infix);

        this.postfix = InfixToPostfix();
        this.prefix = InfixToPrefix();
    }

    String InfixToPostfix() {
        String postfix = "";

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            // operand
            if (!isOperator(c)) {
                postfix += c;
            } // วงเล็บเปิด
            else if (c == '(') {
                Box.push(String.valueOf(c));
            } // วงเล็บปิด
            else if (c == ')') {
                postfix += stackFoundbracket();
            } // operator ปกติ
            else {
                postfix += stackProcess(c);
            }

        }

        // เทที่เหลือใน stack
        while (!Box.isEmpty()) {
            postfix += Box.pop();
        }

        return postfix;
    }

    String stackProcess(char c) { // helper method สำหรับการเอา operator เข้า stack
        String postfix = "";
        // เช็กลำดับของ op ว่าถ้าใน stack มากกว่า c ปัจจุบัน ให้เอาออกมาเขียนก่อน แล้วค่อยเอา c เข้า stack
        while (!Box.isEmpty() && precedence(Box.peek().charAt(0)) >= precedence(c)) {
            postfix += Box.pop();
        }

        Box.push(String.valueOf(c));
        return postfix;
    }

    String stackFoundbracket() { // helper method สำหรับการเอา operator ออก stack จนเจอ ( แล้วทิ้ง (
        String postfix = "";

        while (!Box.isEmpty() && Box.peek().charAt(0) != '(') {
            postfix += Box.pop();
        }

        if (!Box.isEmpty()) {
            Box.pop(); // เอา ( ทิ้ง
        }

        return postfix;
    }

    String InfixToPrefix() {
        return reverse(InfixToPostfix());
    }

    boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')') {
            return true;
        }
        return false;
    }

    int precedence(char op) {
        if (op == '+') {
            return 1;
        }
        if (op == '-') {
            return 2;
        }
        if (op == '*') {
            return 3;
        }
        if (op == '/') {
            return 4;
        }
        if (op == '^') {
            return 5;
        }

        return 0; // อื่น ๆ หรือวงเล็บ
    }

    //กลับสตริง เชยๆ แต่ต้องเช็คด้วยว่าเจอวงเล็บมั้ย ถ้าเจอให้สลับกัน
    String reverse(String s) {
        String[] arrString = s.split("");
        String reverseString = "";

        for (int i = arrString.length - 1; i >= 0; i--) {
            if (arrString[i].equals("(")) {
                arrString[i] = ")";
            } else if (arrString[i].equals(")")) {
                arrString[i] = "(";
            }

            reverseString += arrString[i];
        }
        return reverseString;
    }

}
