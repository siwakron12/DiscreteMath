public class Prefix_Postfix {                     // คลาส Prefix_Postfix ทำหน้าที่แปลง Infix เป็น Prefix และ Postfix

    String infix;                                 // ตัวแปร infix เก็บนิพจน์แบบ Infix
    String postfix;                               // ตัวแปร postfix เก็บผลลัพธ์แบบ Postfix
    String prefix;                                // ตัวแปร prefix เก็บผลลัพธ์แบบ Prefix
    String inFixReverse;                          // ตัวแปร inFixReverse เก็บนิพจน์ Infix ที่ถูกกลับด้าน
    Stack Box;                                    // ตัวแปร Box เก็บ Stack ที่ใช้ระหว่างการคำนวณ

    public Prefix_Postfix(String infix) {         // Constructor รับค่า Infix จากผู้ใช้เพื่อเตรียมการแปลง

        this.Box = new Stack(infix.length());     // โปรแกรมสร้าง Stack และกำหนดขนาดตามความยาวของ Infix
        this.infix = infix;                       // โปรแกรมเก็บนิพจน์ Infix ลงในตัวแปร infix
        this.inFixReverse = reverse(infix);       // โปรแกรมกลับสตริง Infix และเก็บค่าไว้ในตัวแปร inFixReverse

        this.postfix = InfixToPostfix();          // โปรแกรมเรียกเมธอด InfixToPostfix เพื่อสร้าง Postfix
        this.prefix = InfixToPrefix();            // โปรแกรมเรียกเมธอด InfixToPrefix เพื่อสร้าง Prefix
    }

    String InfixToPostfix() {                     // เมธอด InfixToPostfix ทำหน้าที่แปลง Infix เป็น Postfix

        String postfix = "";                      // ตัวแปร postfix สร้างสตริงว่างเพื่อเก็บผลลัพธ์

        for (int i = 0; i < infix.length(); i++) { // โปรแกรมวนลูปเพื่ออ่านตัวอักษรทุกตัวใน Infix
            char c = infix.charAt(i);              // โปรแกรมดึงตัวอักษรตำแหน่งปัจจุบันจาก Infix

            if (!isOperator(c)) {                  // โปรแกรมตรวจสอบว่าตัวอักษรเป็น operand หรือไม่
                postfix += c;                      // โปรแกรมเพิ่ม operand ลงใน postfix
            }

            else if (c == '(') {                   // โปรแกรมตรวจสอบว่าตัวอักษรเป็นวงเล็บเปิด
                Box.push(String.valueOf(c));       // โปรแกรมนำวงเล็บเปิดเข้า Stack
            }

            else if (c == ')') {                   // โปรแกรมตรวจสอบว่าตัวอักษรเป็นวงเล็บปิด
                postfix += stackFoundbracket();    // โปรแกรมนำ operator ออกจาก Stack จนเจอวงเล็บเปิด
            }

            else {                                 // โปรแกรมตรวจสอบว่าตัวอักษรเป็น operator
                postfix += stackProcess(c);        // โปรแกรมประมวลผล operator ด้วย Stack
            }

        }

        while (!Box.isEmpty()) {                   // โปรแกรมตรวจสอบว่า Stack ยังมีข้อมูลเหลืออยู่หรือไม่
            postfix += Box.pop();                  // โปรแกรมนำ operator ที่เหลือใน Stack ออกมาใส่ใน postfix
        }

        return postfix;                            // เมธอดคืนค่าผลลัพธ์ Postfix
    }

    String stackProcess(char c) {                  // เมธอด stackProcess จัดการลำดับ operator ก่อนนำเข้า Stack

        String postfix = "";                       // ตัวแปร postfix สร้างสตริงว่างเพื่อเก็บ operator ที่ pop ออกมา

        while (!Box.isEmpty() && precedence(Box.peek().charAt(0)) >= precedence(c)) { 
            postfix += Box.pop();                  // โปรแกรมนำ operator ที่มี precedence สูงกว่าออกจาก Stack
        }

        Box.push(String.valueOf(c));               // โปรแกรมนำ operator ปัจจุบันเข้า Stack

        return postfix;                            // เมธอดคืนค่า postfix ที่ได้จากการ pop operator
    }

    String stackFoundbracket() {                   // เมธอด stackFoundbracket นำ operator ออกจาก Stack จนเจอวงเล็บเปิด

        String postfix = "";                       // ตัวแปร postfix สร้างสตริงว่างเพื่อเก็บ operator

        while (!Box.isEmpty() && Box.peek().charAt(0) != '(') {
            postfix += Box.pop();                  // โปรแกรมนำ operator ออกจาก Stack จนกว่าจะเจอ '('
        }

        if (!Box.isEmpty()) {                      
            Box.pop();                             // โปรแกรมนำวงเล็บเปิดออกจาก Stack และทิ้งค่า
        }

        return postfix;                            // เมธอดคืนค่า postfix ที่ได้จาก Stack
    }

    String InfixToPrefix() {                       // เมธอด InfixToPrefix แปลง Infix เป็น Prefix
        return reverse(InfixToPostfix());          // โปรแกรมกลับสตริงของ Postfix เพื่อสร้าง Prefix
    }

    boolean isOperator(char c) {                   // เมธอด isOperator ตรวจสอบว่าตัวอักษรเป็น operator หรือไม่

        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')') {
            return true;                           // เมธอดคืนค่า true เมื่ออักขระเป็น operator
        }

        return false;                              // เมธอดคืนค่า false เมื่ออักขระไม่ใช่ operator
    }

    int precedence(char op) {                      // เมธอด precedence กำหนดลำดับความสำคัญของ operator

        if (op == '+') {                           // โปรแกรมตรวจสอบว่า operator เป็น +
            return 1;                              // โปรแกรมกำหนด precedence ของ + เป็น 1
        }

        if (op == '-') {                           // โปรแกรมตรวจสอบว่า operator เป็น -
            return 2;                              // โปรแกรมกำหนด precedence ของ - เป็น 2
        }

        if (op == '*') {                           // โปรแกรมตรวจสอบว่า operator เป็น *
            return 3;                              // โปรแกรมกำหนด precedence ของ * เป็น 3
        }

        if (op == '/') {                           // โปรแกรมตรวจสอบว่า operator เป็น /
            return 4;                              // โปรแกรมกำหนด precedence ของ / เป็น 4
        }

        if (op == '^') {                           // โปรแกรมตรวจสอบว่า operator เป็น ^
            return 5;                              // โปรแกรมกำหนด precedence ของ ^ เป็น 5
        }

        return 0;                                  // เมธอดคืนค่า 0 เมื่อไม่พบ operator
    }

    String reverse(String s) {                     // เมธอด reverse ทำหน้าที่กลับสตริงและสลับวงเล็บ

        String[] arrString = s.split("");          // โปรแกรมแยกสตริงออกเป็น array ของตัวอักษร
        String reverseString = "";                 // ตัวแปร reverseString สร้างสตริงว่างเพื่อเก็บผลลัพธ์

        for (int i = arrString.length - 1; i >= 0; i--) {   // โปรแกรมวนลูปจากท้าย array ไปต้น array

            if (arrString[i].equals("(")) {        // โปรแกรมตรวจสอบว่าวงเล็บเป็น (
                arrString[i] = ")";                // โปรแกรมเปลี่ยน ( เป็น )
            } 
            
            else if (arrString[i].equals(")")) {   // โปรแกรมตรวจสอบว่าวงเล็บเป็น )
                arrString[i] = "(";                // โปรแกรมเปลี่ยน ) เป็น (
            }

            reverseString += arrString[i];         // โปรแกรมนำตัวอักษรที่กลับด้านมาเพิ่มใน reverseString
        }

        return reverseString;                      // เมธอดคืนค่าสตริงที่กลับด้านแล้ว
    }

}