/**
 * Created by cerebro on 27/06/16.
 */
public class Demo {
    public static void main(String[] args) {

        try {
            Home.makeBreakfast();
        } catch (DukkanBandException e) {
            e.printStackTrace();
        }
    }
}
