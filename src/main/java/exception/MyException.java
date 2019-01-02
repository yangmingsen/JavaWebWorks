package exception;

public class MyException  {

    private String message;

    public MyException(String message) {
        this.message = message;
        printException();
    }


    public void printException() {
        System.out.println(this.message);
    }
}
