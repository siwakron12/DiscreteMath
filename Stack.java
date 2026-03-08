public class Stack {                       // คลาส Stack จัดเก็บข้อมูลแบบ LIFO

    private int maxSize;                   // ตัวแปร maxSize เก็บขนาดสูงสุดของ Stack
    private String[] stackArray;           // ตัวแปร stackArray เก็บข้อมูลใน Stack
    private int top;                       // ตัวแปร top เก็บตำแหน่งข้อมูลบนสุดของ Stack

    public Stack(int Size) {               // Constructor สร้าง Stack ใหม่และกำหนดขนาด

        this.maxSize = Size;               // โปรแกรมกำหนดค่าขนาดสูงสุดของ Stack
        this.stackArray = new String[maxSize];  // โปรแกรมสร้าง array สำหรับเก็บข้อมูล
        this.top = -1;                     // โปรแกรมกำหนดตำแหน่งเริ่มต้นของ Stack

    }

    public void push(String value) {       // เมธอด push เพิ่มข้อมูลเข้า Stack

        if(top < maxSize-1){               // โปรแกรมตรวจสอบว่า Stack ยังไม่เต็ม

            stackArray[++top] = value;     // โปรแกรมเพิ่มข้อมูลใหม่ไว้บนสุดของ Stack

        }
        else{
            System.out.println("Stack Overflow");   // โปรแกรมแสดงข้อความเมื่อ Stack เต็ม
        }

    }

    public String pop(){                   // เมธอด pop นำข้อมูลออกจาก Stack

        if(!isEmpty()){                    // โปรแกรมตรวจสอบว่า Stack ไม่ว่าง

            return stackArray[top--];      // โปรแกรมคืนค่าข้อมูลตัวบนสุดและลดตำแหน่ง top

        }
        else{
            System.out.println("Stack Underflow");  // โปรแกรมแสดงข้อความเมื่อ Stack ว่าง
            return null;
        }

    }

    public String peek(){                  // เมธอด peek ดูค่าบนสุดของ Stack

        if(!isEmpty()){                    // โปรแกรมตรวจสอบว่า Stack ไม่ว่าง

            return stackArray[top];        // โปรแกรมคืนค่าข้อมูลบนสุดโดยไม่ลบข้อมูล

        }
        else{
            return null;                   // โปรแกรมคืนค่า null เมื่อ Stack ว่าง
        }

    }

    public boolean isEmpty(){              // เมธอด isEmpty ตรวจสอบว่า Stack ว่างหรือไม่

        return (top == -1);                // โปรแกรมคืนค่า true เมื่อ Stack ไม่มีข้อมูล

    }

}