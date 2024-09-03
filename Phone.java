import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.*;

public class Phone {
    public static void main(String[] args) {
        int n = 1;
        int linenumber = 0;
        int checklinenumber = 0;
        String str;
        String phone;

        Scanner scan = new Scanner(System.in);

        while (n != 3) {
            n = scan.nextInt();
            scan.nextLine(); // consume the newline character

            if (n == 1) {
                str = scan.nextLine();
                phone = scan.nextLine();

                try (FileWriter writer = new FileWriter("name.txt", true)) {
                    writer.write(str + "\n");
                    try (FileWriter w1 = new FileWriter("phone.txt", true)) {
                        w1.write(phone + "\n");
                        System.out.println("Successfully appended to the file.");
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

            } else if (n == 2) {
                str = scan.nextLine();

                try (BufferedReader bufferedReader = new BufferedReader(new FileReader("name.txt"))) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        linenumber++;
                        if (line.equals(str)) {
                            checklinenumber = linenumber;
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

                if (checklinenumber > 0) {
                    try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader("phone.txt"))) {
                        int currentLine = 0;
                        String phoneLine;
                        while ((phoneLine = bufferedReader1.readLine()) != null) {
                            currentLine++;
                            if (currentLine == checklinenumber) {
                                System.out.println("Phone: " + phoneLine);
                                break;
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Name not found.");
                }

            } else if (n == 3) {
                System.out.println("End program");
            } else {
                System.out.println("Wrong input");
            }
        }
        scan.close();
    }
}
