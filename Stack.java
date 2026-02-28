/*สำหรับ Stack
push()
pop()
peek()
isEmpty()
isFull()
จัดการ error (Overflow / Underflow) */
public class Stack {
    private int maxSize ;
    private double[] stackArray ;
    private int top ;

    public Stack(int Size) {
        this.maxSize = Size ;
        this.stackArray = new double[maxSize] ;
        this.top = -1 ;
    }

    public void push(double value) {
        if(top < maxSize-1) {
             stackArray[top++] += value ;
        }
    }
}
