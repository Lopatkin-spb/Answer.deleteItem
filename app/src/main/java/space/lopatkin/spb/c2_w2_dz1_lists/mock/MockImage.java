package space.lopatkin.spb.c2_w2_dz1_lists.mock;

public class MockImage {

    private int resource;

    private int value;


//    public MockImage(int resource) {
//        this.resource = resource;
//    }

    public MockImage(int resource, int value) {
        this.resource = resource;
        this.value = value;
    }

    public String getValue() {
        return String.valueOf(value);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }


    @Override
    public String toString() {
        return "" + value;
    }
}
