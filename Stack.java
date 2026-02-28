public class Stack {
    private int maxSize ;
    private double[] stackArray ;
    private int top ;

    public Stack(int Size) { //Constructor เพื่อจะกำหนด'ขนาด'ของ Stack
        this.maxSize = Size ;
        this.stackArray = new double[maxSize] ;
        this.top = -1 ; //จุดเริ่มของ Stack (ตัวแรกเป็น 0 แปลว่า ก่อนที่จะเป็นตัวแรกก็ต้องเป็น -1)
    }

    public void push(double value) { // method push เข้ากล่อง
        if(top < maxSize-1) {
             stackArray[++top] = value ;
        }
        else {
            System.out.println("Stack Overflow!"); // check stack overflow (ข้อมูลล้นกล่อง)
        }
    }

    public double pop() { // method pop ข้อมูลออกกล่อง
        if(!isEmpty()) {
            return stackArray[top--] ;
        }
        else {
            System.out.println("Stack Underflow!"); // check stack underflow
            return -1 ;
        }
    }

    public double peek() { //แอบส่องกล่อง
        if(!isEmpty()) {
            return stackArray[top] ;
        }
        else {
            System.out.println("Stack is Empty!!");
            return -1 ;
        }
    }

    public boolean isEmpty() { //กล่องว่างมั้ยน้อ
        return (top == -1) ;
    }

    public boolean isFull() {
        return (top == maxSize-1) ; //กล่องเต็มมั้ยน้อ
    }
}
