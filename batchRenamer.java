import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class batchRenamer{
    public static void main(String[] args){
        rename();
    }    

    public static void rename(){
        try{
            String daSeq = "";
            boolean rename = false;
            String now = "";
        
            Scanner sc = new Scanner(System.in);
        
            System.out.println("Enter the directory of the files you would like to rename: ");
            File dir = new File(sc.nextLine());
            File[] fileList = dir.listFiles();
            
            System.out.println("Enter the new name for the files: ");
            String newName = sc.nextLine();
            
            String[] list = new String[fileList.length+1];
            for (int i = 1 ; i < fileList.length+1 ; i++){
                String cur = fileList[i-1].getName();
                String[] split = cur.split("\\.");
                String ext = "." + split[split.length-1];
        
                String oG = dir + "/" + fileList[i-1].getName();
        
                if (i < 10){
                    now = newName + " - 0" + i + ext;
                    daSeq = dir + "/" + newName + " - 0" + i + ext;
                }
                else{
                    now = newName + " - " + i + ext;
                    daSeq = dir + "/" + newName + " - " + i + ext;
                }
        
                File file = new File(oG);
                File newFile = new File(daSeq);
                
                if (!rename){
                    System.out.println("Do you want to go through with the rename(true/false): ");
                    rename = sc.nextBoolean(); 
                }
                
                if (rename){
                    
                    file.renameTo(newFile);
                    list[i] = (cur + " has been renamed to " + now);
                    System.out.println(cur + " has been renamed to " + now);
                    
                }
                else{
                    System.exit(0);
                }
            }
            PrintWriter writer = new PrintWriter(dir + "\\nameLog.txt", "UTF-8");
            for (int j = 0 ; j < list.length ; j++){
                writer.println(list[j]);
            }
            writer.close();
            sc.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}