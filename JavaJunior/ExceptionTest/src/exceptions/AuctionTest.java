package exceptions;

/**
 * Created by alpha on 16-8-1.
 */
public class AuctionTest {
    private double initPrice = 30.0;

    public void bid(String bidPrice) throws AuctionException {
        double d = 0;
        try {
            d = Double.parseDouble(bidPrice);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuctionException("必须是整数");
        }
        if (initPrice > d) {
            throw new AuctionException("数值太低");
        }
        initPrice = d;
    }
}
