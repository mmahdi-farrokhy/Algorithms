import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Connection {
    private String name;
    private int level;

    public boolean isMangoSeller() {
        return name.endsWith("m");
    }
}
