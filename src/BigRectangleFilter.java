import java.awt.Rectangle;

public class BigRectangleFilter implements Filter{

    @Override
    public boolean accept(Object x) {
        Rectangle rect = (Rectangle) x;
        double perimeter = 2*rect.height + 2*rect.width;

        return perimeter > 10;
    }
}
