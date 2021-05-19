package space.lopatkin.spb.c2_w2_dz1_lists.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class MockTextGenerator {

    public static List<MockText> generate(int count) {

//      оптимизируем  создание списка
        List<MockText> mockTexts = new ArrayList<>(count);

        Random random = new Random();

        String name = UUID.randomUUID().toString();
        int value = random.nextInt(100 );


        for (int i = 0; i < count; i++) {
            mockTexts.add(new MockText(name, value));
        }

        return mockTexts;

    }


}
