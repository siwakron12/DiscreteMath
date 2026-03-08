import java.util.Scanner;                // โปรแกรมนำเข้า Scanner เพื่อใช้รับข้อมูลจากผู้ใช้

public class App {               // คลาส Application ควบคุมการทำงานของโปรแกรมทั้งหมด

    public void run() {                  // เมธอด run จัดการลำดับการทำงานของโปรแกรม

        Scanner sc = new Scanner(System.in);   // โปรแกรมสร้าง Scanner เพื่อรับข้อมูลจากผู้ใช้

        while(true){                     // โปรแกรมวนลูปเพื่อแสดงเมนูจนกว่าผู้ใช้จะออกจากโปรแกรม

            System.out.println("1. Convert to Prefix");     // โปรแกรมแสดงตัวเลือกแปลง Infix เป็น Prefix
            System.out.println("2. Convert to Postfix");    // โปรแกรมแสดงตัวเลือกแปลง Infix เป็น Postfix
            System.out.println("3. Show ALU Stack");        // โปรแกรมแสดงตัวเลือกจำลองการคำนวณของ ALU
            System.out.println("4. Exit");                  // โปรแกรมแสดงตัวเลือกออกจากโปรแกรม

            System.out.print("Choose: ");                   // โปรแกรมแสดงข้อความให้ผู้ใช้เลือกเมนู
            int choice = sc.nextInt();                      // โปรแกรมรับค่าตัวเลือกจากผู้ใช้
            sc.nextLine();                                  // โปรแกรมล้าง buffer หลังรับตัวเลข

            if(choice == 1){                                // โปรแกรมตรวจสอบว่าผู้ใช้เลือกเมนู Prefix

                System.out.print("Enter Infix: ");          // โปรแกรมแสดงข้อความให้ผู้ใช้ใส่ Infix
                String infix = sc.nextLine();               // โปรแกรมรับนิพจน์ Infix จากผู้ใช้

                Prefix_Postfix converter = new Prefix_Postfix(infix);   // โปรแกรมสร้างอ็อบเจกต์ converter เพื่อแปลงนิพจน์

                System.out.println("Prefix = " + converter.prefix);     // โปรแกรมแสดงผล Prefix

            }

            else if(choice == 2){                           // โปรแกรมตรวจสอบว่าผู้ใช้เลือกเมนู Postfix

                System.out.print("Enter Infix: ");          // โปรแกรมแสดงข้อความให้ผู้ใช้ใส่ Infix
                String infix = sc.nextLine();               // โปรแกรมรับนิพจน์ Infix จากผู้ใช้

                Prefix_Postfix converter = new Prefix_Postfix(infix);   // โปรแกรมสร้างอ็อบเจกต์ converter เพื่อแปลงนิพจน์

                System.out.println("Postfix = " + converter.postfix);   // โปรแกรมแสดงผล Postfix

            }

            else if(choice == 3){                           // โปรแกรมตรวจสอบว่าผู้ใช้เลือกเมนู ALU

                System.out.print("Enter Postfix Expression: ");   // โปรแกรมแสดงข้อความให้ผู้ใช้ใส่ Postfix
                String postfix = sc.nextLine();                   // โปรแกรมรับนิพจน์ Postfix จากผู้ใช้

                ALUStackSimulator.simulate(postfix);              // โปรแกรมเรียกเมธอด simulate เพื่อจำลองการคำนวณของ ALU

            }

            else{                                       // โปรแกรมตรวจสอบว่าผู้ใช้ต้องการออกจากโปรแกรม

                System.out.println("Program End");      // โปรแกรมแสดงข้อความจบการทำงาน
                break;                                  // โปรแกรมหยุดการทำงานของลูป

            }

        }

    }

}