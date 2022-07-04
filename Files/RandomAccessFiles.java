package Files;

import java.io.RandomAccessFile;
import java.util.Random;

public class RandomAccessFiles {

    public static void main(String[] args) {
        readFile(args[0]);
    }

    private static void readFile(String args) {
        try {
            RandomAccessFile raf = new RandomAccessFile(args, "rw");// Open our file with read/write access
            Random rdn = new Random();
            int min = 0;
            int max = (int) raf.length();
            int pos = rdn.nextInt(max - min + 1) + min;
            byte[] file = new byte[(int) raf.length()];// create an array to hold our file
            raf.readFully(file);// Read from our RAF up to the length of our array
            String str = new String(file);// Convert the bytes representing our file to text
            System.out.println(str);// Print out our file size
            raf.seek(pos);// Set our position randomly in the file
            byte b = raf.readByte();// Read the byte at our current spot
            System.out.printf("Set pos to %d, value %d, character %c\n", pos, (int) b, (char) b);
            file = new byte[(int) raf.length()];// Create a new array the size of the file
            pos = (int) raf.getFilePointer();// Get the current position in the file
            int read = raf.read(file, 0, file.length);// Use the read function. The read function requires you
            // provide a byte array, the offset from the current position you want to start
            // and the amount of
            // bytes you would like. This is largely based off a c function as traditionally
            // when you pass an
            // array you have no idea what the size of the array is. In most cases you will
            // simply want to
            // provide the length of the array you are passing in. Note that this function
            // returns an int.
            // This int represents the bytes read from the file.
            System.out.printf("Tried reading at position %d, read %d bytes, array was size %d\n", pos, read,
                    file.length);
            raf.close();// Close our filestream.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeTOFile(String args) {
        try {
            RandomAccessFile raf = new RandomAccessFile(args, "rw");// Open our file with read/write access
            Random rdn = new Random();// Get a new random generator
            int min = 0;
            int max = 999;// Our file will have a maximum size of 999 bytes
            int amin = 0;
            int amax = 25;// The alphabet has 26 letters thus we want to generate a random offset
            // to "pick" those letters
            int length = rdn.nextInt(max - min + 1) + min;// Get the length of our file
            raf.setLength((long) length);// Set the length or size of the file, note that the we do not have to
            // set length of the file as the write method will "grow" the file with each
            // sequential write
            for (int i = 0; i < length; i++) {// Run until our file is full
                int chr = rdn.nextInt(amax - amin + 1) + amin;// Randomly get our offset
                chr += 65;// ASCII capital letters range from 65-90, so add 65 to whatever we got
                raf.write(chr);// Write the int to the file
                System.out.printf("Writing %c at %d\n", chr, raf.getFilePointer());// Ouput our char and where
                // we wrote it.
            }
            raf.close();// Close our filestream.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}