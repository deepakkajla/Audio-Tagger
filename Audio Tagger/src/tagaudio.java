/**
 * Created by Deepak Kajla on 30-Jun-17.
 */

import org.jaudiotagger.audio.*;
import org.jaudiotagger.tag.*;
import java.io.File;
import java.util.Scanner;

public class tagaudio {
    public static void main(String[] args) {
        int choice;
        String path,ip;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter path of mp3 file:");
        path = sc.nextLine();
        File file = new File(path);
        try {
            AudioFile f = AudioFileIO.read(file);
            Tag tag = f.getTagOrCreateAndSetDefault();
            if(!tag.isEmpty()) {
                System.out.println("Tags found on audio file");
                System.out.println("Title: " + tag.getFirst(FieldKey.TITLE));
                System.out.println("Artist: " + tag.getFirst(FieldKey.ARTIST));
                System.out.println("Album: " + tag.getFirst(FieldKey.ALBUM));
                System.out.println("Year: " + tag.getFirst(FieldKey.YEAR));
            }
            while(true) {
                System.out.println("1. Add Title");
                System.out.println("2. Add Artist");
                System.out.println("3. Add Album");
                System.out.println("4. Add Year");
                System.out.println("0. Exit");
                System.out.println("Enter your choice:");
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 0:
                        f.commit();
                        System.exit(0);
                        break;
                    case 1:
                        System.out.println("Enter Title:");
                        ip = sc.nextLine();
                        tag.setField(FieldKey.TITLE, ip);
                        break;
                    case 2:
                        System.out.println("Enter Artist:");
                        ip = sc.nextLine();
                        tag.setField(FieldKey.ARTIST, ip);
                        break;
                    case 3:
                        System.out.println("Enter Album:");
                        ip = sc.nextLine();
                        tag.setField(FieldKey.ALBUM, ip);
                        break;
                    case 4:
                        System.out.println("Enter Year:");
                        ip = sc.nextLine();
                        tag.setField(FieldKey.YEAR, ip);
                        break;
                    default:
                        System.out.println("Enter valid input...");
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
