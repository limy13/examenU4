import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class UsuarioSerializer {

    public static void serialize() {
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.json"));
            json.toJson(Sistema.usuarios, writer);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}