/**
 * Created by cerebro on 27/06/16.
 */
public class Home {

    private static boolean shopOpen = true;
    private static boolean breadAvailable = false;


    public static void makeBreakfast() throws DukkanBandException {
        System.out.println("Making breakfast");


        try {
            System.out.println("entered try");
            String bread = Home.bringBread();

            System.out.println(bread);
            System.out.println("we are making sandwitches");
        } catch (BreadKhatamException e) {
            System.out.println("bring maggie");

        } finally {

        }



        System.out.println("hello world");


    }

    public static String bringBread() throws BreadKhatamException, DukkanBandException {


        if(!Home.shopOpen) {
            throw new DukkanBandException();
        }

        if(!Home.breadAvailable) {
            throw new BreadKhatamException();
        }

        return "Fresh Bonn bread";
    }

}
