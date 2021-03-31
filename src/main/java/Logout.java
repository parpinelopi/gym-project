import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logout {

    public void Logout() {


        BufferedWriter clearToken = null;

        try {
            //specify user path
            File userFile = new File("user.txt");

            /* This logic will make sure that the file
             * gets created if it is not present at the
             * specified location*/
            if (!userFile.exists()) {
                userFile.createNewFile();
            }

            FileWriter tokenWriter = new FileWriter(userFile);
            clearToken = new BufferedWriter(tokenWriter);
            clearToken.write("");
            System.out.println("User has successfully logged out");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {

            {
                try {
                    if (clearToken != null)
                        clearToken.close();
                } catch (Exception ex) {
                    System.out.println("Error in closing the BufferedWriter" + ex);
                }

            }


        }
    }


}

