import lombok.Data;
import lombok.NonNull;

@Data
public class Node <T extends Comparable <T> > {
    @NonNull private T data;
    int height=1;
    private Node <T > left;
    private Node <T > right;
}
