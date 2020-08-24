package VK;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;

import java.io.*;
import java.util.HashMap;

public class VKDataBase {

    public static VKCore vkCore;
    static {
        try {
            vkCore = new VKCore();
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }


    public static HashMap<Integer, Integer> infoDialog = new HashMap<>();

    public static void newDialog(int userId) {
        infoDialog.put(userId, 1);
        writeFile(userId, 1);
    }

    public static void uploadDialog(int userId, int level) {
        infoDialog.put(userId, level);
    }

    public static void upLevel(int userId) {
        infoDialog.put(userId, infoDialog.get(userId) + 1);
        writeFile(userId, getLevel(userId));
    }

    public static int getLevel(int userId) {
        return infoDialog.get(userId);
    }

    public static boolean checkUser(int userId) {
        if (infoDialog.get(userId) == null) {
            return false;
        }
        return true;
    }

    public static void readFile() {
        try {
            FileReader reader = new FileReader("src/main/resources/database.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while (line!=null) {
                uploadDialog(Integer.parseInt(line.split(" ")[0]), Integer.parseInt(line.split(" ")[1]));
                line = bufferedReader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(Integer userId, Integer level) {
        try {
            FileWriter writer = new FileWriter("src/main/resources/database.txt", true);
            writer.append(userId + " " + level + "\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
