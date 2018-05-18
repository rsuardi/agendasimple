package practice.util;

public class Util {

    public static boolean isNumber(String value){

        try{
            Integer.parseInt(value);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }

    public static boolean isMultipleOf(int value , int multiple){

        if(value % multiple == 0){
            return true;
        }else{
            return false;
        }
    }
}
