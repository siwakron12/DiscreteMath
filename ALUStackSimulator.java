public class ALUStackSimulator {              // คลาส ALUStackSimulator จำลองการทำงานของ ALU ด้วย Stack

    public static void simulate(String postfix){   // เมธอด simulate รับนิพจน์ postfix เพื่อคำนวณผลลัพธ์

        Stack stack = new Stack(postfix.length()); // โปรแกรมสร้าง Stack เพื่อเก็บตัวเลขระหว่างการคำนวณ

        for(int i=0;i<postfix.length();i++){       // โปรแกรมวนลูปเพื่ออ่านตัวอักษรทุกตัวใน postfix

            char c = postfix.charAt(i);            // โปรแกรมดึงตัวอักษรปัจจุบันจาก postfix

            if(Character.isDigit(c)){              // โปรแกรมตรวจสอบว่าตัวอักษรเป็นตัวเลข

                stack.push(String.valueOf(c));     // โปรแกรมนำตัวเลขเข้า Stack

            }

            else{                                  // โปรแกรมตรวจสอบว่าตัวอักษรเป็น operator

                int b = Integer.parseInt(stack.pop());   // โปรแกรมนำค่าตัวที่สองออกจาก Stack
                int a = Integer.parseInt(stack.pop());   // โปรแกรมนำค่าตัวแรกออกจาก Stack

                int result = 0;                    // โปรแกรมสร้างตัวแปรเก็บผลลัพธ์

                if(c=='+') result = a+b;           // โปรแกรมคำนวณผลบวกของตัวเลขสองตัว
                if(c=='-') result = a-b;           // โปรแกรมคำนวณผลลบของตัวเลขสองตัว
                if(c=='*') result = a*b;           // โปรแกรมคำนวณผลคูณของตัวเลขสองตัว
                if(c=='/') result = a/b;           // โปรแกรมคำนวณผลหารของตัวเลขสองตัว

                stack.push(String.valueOf(result));   // โปรแกรมนำผลลัพธ์กลับเข้า Stack

            }

        }

        System.out.println("Result = " + stack.pop());   // โปรแกรมแสดงผลลัพธ์สุดท้ายจาก Stack

    }

}