import java.util.Scanner;
import java.io.*;

public class batchRenamer{
    public static void main(String[] args){
        String daSeq = "";
        boolean rename = false;
        String now = "";

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the directory of the files you would like to rename: ");
        File dir = new File(sc.nextLine());
        File[] fileList = dir.listFiles();
        
        System.out.println("Enter the new name for the files: ");
        String newName = sc.nextLine();

        for (int i = 1 ; i < fileList.length+1 ; i++){
            String cur = fileList[i-1].getName();

            for (File f : fileList)
                System.out.println(f);


            String oG = dir + "/" + fileList[i-1].getName();

            if (i < 10){
                now = newName + "-0" + i + ".html";
                daSeq = dir + "/" + newName + "-0" + i + ".html";
            }
            else{
                now = newName + "-" + i + ".html";
                daSeq = dir + "/" + newName + "-" + i + ".html";
            }

            File file = new File(oG);
            File newFile = new File(daSeq);
            
            if (!rename){
                System.out.println("Do you want to go through with the rename(true/false): ");
                rename = sc.nextBoolean(); 
            }
            
            if (rename){
                if(file.renameTo(newFile)) {
                    System.out.println(cur + " has been renamed to " + now);
                } else {
                    System.out.println("Rename Failed");
                }
            }
            else{
                System.exit(0);
            }
        }
    }
}