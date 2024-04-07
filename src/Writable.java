import java.io.Serializable;

public interface Writable {
    void save (Serializable serializable, String filePath);
    void read(String filePath);
}
