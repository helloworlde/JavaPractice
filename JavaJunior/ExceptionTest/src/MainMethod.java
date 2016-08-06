import exceptions.ThrowsException;

/**
 * Created by alpha on 16-8-1.
 */
public class MainMethod {
    public static void main(String[] args) {
//        try {
//            new AutoCloseTest().closeTest();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        AuctionTest auctionTest = new AuctionTest();
//        try {
//            auctionTest.bid("10");
//        } catch (AuctionException e) {
//            System.err.println(e.getMessage());
//        }
        new ThrowsException().test();
    }
}
