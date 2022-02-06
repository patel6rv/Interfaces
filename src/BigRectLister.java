import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class BigRectLister {
    public static void main(String[] args)
    {
        ArrayList<Object> rects = new ArrayList<>();

        int perimeter;

        //6 valid rects
        rects.add(new Rectangle(7, 10));
        rects.add(new Rectangle(5, 8));
        rects.add(new Rectangle(3, 5));
        rects.add(new Rectangle(2, 4));
        rects.add(new Rectangle(3, 6));
        rects.add(new Rectangle(5, 9));

        //4 invalid rects
        rects.add(new Rectangle(1, 2));
        rects.add(new Rectangle(1, 3));
        rects.add(new Rectangle(1, 4));
        rects.add(new Rectangle(2, 3));

        List<Object> filtered = ShortLister.collectAll(new BigRectangleFilter(), rects);
        for(Object x: filtered)
        {
            Rectangle rect = (Rectangle) x;
            perimeter = 2*rect.height + 2* rect.width;
            System.out.println(perimeter);

        }
    }
}
