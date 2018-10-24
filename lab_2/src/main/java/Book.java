import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description of class:
 * <p>
 * Created on 24 Oct 2018 (19:34)
 *
 * @author dawid
 */
@Data
@AllArgsConstructor
class Book {
    private int id;
    private String title;
    private String author;
    private int userId;
}
