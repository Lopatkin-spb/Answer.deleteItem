package space.lopatkin.spb.c2_w2_dz1_lists.mock;

import android.view.View;
import space.lopatkin.spb.c2_w2_dz1_lists.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MockImageGenerator {


    public static List<MockImage> generate(int count) {

        List<MockImage> mockImages = new ArrayList<>(count);
        int resource = R.drawable.image_katana_grey;

        Random random = new Random();
        int value = random.nextInt( 500);


        for (int i = 0; i < count; i++) {
            mockImages.add(new MockImage(resource, value));
        }
        return mockImages;
    }


}
