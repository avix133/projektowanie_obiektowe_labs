import java.io.Serializable;
import java.util.List;

public class SampleObject implements Serializable {
    private String name;
    private int number;
    private List<Integer> list;

    public SampleObject(String name, int number, List<Integer> list) {
        this.name = name;
        this.number = number;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public List<Integer> getList() {
        return list;
    }
}