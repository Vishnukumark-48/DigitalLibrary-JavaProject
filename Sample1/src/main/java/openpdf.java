import java.awt.Desktop;
import java.net.URI;

public class openpdf {
    String name, pass;

    public openpdf(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public void open(String name, String pass) {
        if (name.equals("War and Peace") && pass.equals("Leo Tolstoy")) {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/file/d/1DOLLxO5nPMX3BTpDt27k_G9I6OLKXRWp/view?usp=drive_link"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (name.equals("The Three Musketeers") && pass.equals("Alexandre Dumas")) {
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/file/d/1QjOxt29_G4d-gFHPcLDn3yLcm_jDHozw/view?usp=drive_link"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (name.equals("The White Company") && pass.equals("Arthur Conan Doyle")) {
            // Replace the link later
            try {
                Desktop.getDesktop().browse(new URI("https://drive.google.com/file/d/14WqH5Kldm5DP3sU9B9RHHFruN-Pa0g7g/view?usp=drive_link"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

   
}
