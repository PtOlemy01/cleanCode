package chapter14.changed;

public class ArgsMain {
    public static void main(String[] args) {
        try{
            Args arg = new Args("l,p#,d*", args);
            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');

        }catch (ArgsException e){
            System.out.printf("Argument error : %s\n", e.errorMessage());
        }
    }
}
