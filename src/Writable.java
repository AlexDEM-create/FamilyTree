import java.io.Serializable;

public interface Writable {
    void save (Serializable serializable, String filePath);
    FamilyTree read(String filePath);
}
