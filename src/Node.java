import lombok.Data;
import lombok.NonNull;

@Data
public class Node <T extends Comparable <T> > {
    @NonNull private T data;
    private Node <T > left;
    private Node <T > right;
}
