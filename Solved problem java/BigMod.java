import java.util.Scanner;

/**
 * @Author Anton Hellbe
 * Based upon Algorithms book and video below -
 * https://www.youtube.com/watch?v=DtV4Fwvn0e8
 * Running time 60ms
 */
public class BigMod {

    static Scanner scan;
    static boolean running = true;


    public static void main(String[] args){
        scan = new Scanner(System.in);
        while(running)
            bigmodulus();

        scan.close();
        System.exit(0);
    }


    static void bigmodulus(){
        long base, power, mod;
        try{
            base = Integer.parseInt(scan.nextLine());
            power = Integer.parseInt(scan.nextLine());
            mod = Integer.parseInt(scan.nextLine());

            System.out.println(bigModHelper(base, power, mod));

            String emptyline = scan.nextLine();
        }catch (Exception e){
            running = false;
            return;
        }

    }

    static long bigModHelper(long base, long power, long mod){
        if(power == 0){
            return 1;
        }
        long z = bigModHelper(base,power / 2, mod);

        if(power % 2 == 0){
            return ((long)Math.pow(z, 2)) % mod;
        }else{
            return ((long) Math.pow(z, 2) * base) % mod;
        }
    }
}
