import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stream {

    public static void main(String[] args) {

        List<String> formatCode = Arrays.asList("IMG", "FLAC", "VID");
        System.out.println("please input:");
        Scanner scan = new Scanner(System.in);
        List<Order> orders= new ArrayList<>();
            try {
                for (int i=0;i<3;i++) {
                    boolean b = false;
                    String[] str = scan.nextLine().split(" ");
                    Order order=new Order();
                   if((numStrVal(str[0], str[1])==false)||(formatCode.stream().anyMatch((e)->e.equals(str[1])))==false){
                       System.out.println("Invalid Input");
                       break;
                   }
                   order.setNums(Integer.parseInt(str[0]));
                   order.setFormatCode(str[1]);
                   orders.add(i,order);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Invalid input");
            }


        }
    private static boolean numStrVal(String s1, String s2) {
            Matcher m= Pattern.compile("^[0-9]*$").matcher(s1);
            Matcher m1= Pattern.compile("^[A-Za-z]+$").matcher(s2);
            return m.matches()&& m1.matches()? true: false;
        }

    }

