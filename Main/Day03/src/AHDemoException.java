public class AHDemoException {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // This will trow an Arithmetic Exception
            System.out.println("Result : " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error : Cannot be divided by 0.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("This block will always execute.");
        }
    }
}