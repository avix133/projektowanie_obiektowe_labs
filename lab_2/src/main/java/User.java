import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description of class:
 * <p>
 * Created on 24 Oct 2018 (19:33)
 *
 * @author dawid
 */
@Data
@AllArgsConstructor
class User {
    private int id;
    private String name;
    private String surname;
    private int year;
    private int fine;
}
