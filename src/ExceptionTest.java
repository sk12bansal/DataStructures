public class ExceptionTest {


    public static void main(String []args){

        try{

            System.out.println("try");
           //System.exit(0);
            return;

        }catch (Exception e){
            System.out.println(e.toString());

        }finally {
            System.out.println("finally");
        }
    }
}
