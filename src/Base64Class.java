import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class Base64Class {
    public static void main(String[] args) throws Exception {
        String fileForEncode = Files.readString(Path.of("FileForEncode"));
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encode = encoder.encode(fileForEncode.getBytes());
        FileOutputStream outputStream = new FileOutputStream("EncodeFile");
        outputStream.write(encode);
    }
}