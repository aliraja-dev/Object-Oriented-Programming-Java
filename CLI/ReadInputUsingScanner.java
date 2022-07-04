package CLI;

import java.io.File;
import java.util.Scanner;

public class ReadInputUsingScanner {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String filename = args[0];// Pass the function a full filepath
        // beginParsing(filename);// call the parsing function
        beginParsingByLine(filename);// call the parsing function
    }

    public static void beginParsing(String filename) {
        try {
            Scanner sc = new Scanner(new File(filename));// Create our new scanner
            while (sc.hasNext()) {// While the scanner has information to read
                String cmd = sc.next();// Read the next term
                double x;
                double y;
                double radius;
                switch (cmd) {
                    case "debug":
                        System.out.println("debug cmd activated");
                        break;
                    case "add":// Found an add command
                        x = sc.nextDouble();
                        y = sc.nextDouble();
                        String name = sc.next();
                        System.out.println("Insert node at " + x + " " + y + " with name " + name);
                        break;
                    case "delete":// Found a delete command
                        x = sc.nextDouble();
                        y = sc.nextDouble();
                        System.out.println("Remove node at " + x + " " + y);
                        break;
                    case "search":// Found a search command
                        x = sc.nextDouble();
                        y = sc.nextDouble();
                        radius = sc.nextDouble();
                        System.out.println("Search for node near " + x + " " + y + " within radius of " + radius);
                        break;
                    default:// Found an unrecognized command
                        System.out.println("Unrecognized input " + cmd);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void beginParsingByLine(String filename) {
        try {
            Scanner sc = new Scanner(new File(filename));
            Scanner scancmd;// Declare two scanners one to read the file and one to read the text pulled
                            // from the file
            while (sc.hasNextLine()) {// While we have text to read
                String line = sc.nextLine();// Get our next line
                scancmd = new Scanner(line);// Create a scanner from this line
                String cmd = scancmd.next();// Get the first word (the command) on each line
                String type;
                switch (cmd) {
                    case "insert":// In the case of insert change our delimiter from white space to <SEP>
                        scancmd.useDelimiter("<SEP>");
                        String artist = scancmd.next();// Get the artist since it is before <SEP>
                        String song = scancmd.next();// Get the song title that follows <SEP>
                        System.out.println("Insert " + artist + " \\ " + song);
                        break;
                    case "remove":
                        type = scancmd.next();// Get the mode of deletion artist/song
                        String token = scancmd.nextLine();
                        // Since both artist titles and song titles have spaces
                        // get the rest of the line for the song/artist name
                        switch (type) {
                            case "artist":
                                System.out.println("Artist Delete: " + token);
                                break;
                            case "song":
                                System.out.println("Song Delete: " + token);
                                break;
                            default:// Error bad token
                                System.out.println("Error bad remove type " + type);
                                break;
                        }
                        break;
                    case "print":// Print command
                        type = scancmd.next();// get the type of print command
                        switch (type) {
                            case "artist":
                                System.out.println("Print artist mode");
                                break;
                            case "song":
                                System.out.println("Print song mode");
                                break;
                            case "blocks":
                                System.out.println("Print block mode");
                                break;
                            default:
                                System.out.println("Error bad print type" + type);
                                break;
                        }
                        break;
                    default:
                        System.out.println("Unrecognized input");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}