package space.lopatkin.spb.c2_w2_dz1_lists.mock;

public class MockText {

    private String name;

    private int value;

    public MockText(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return String.valueOf(value);
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "" + value;
    }
}
