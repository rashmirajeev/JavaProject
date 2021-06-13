package com.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class StudentController
{

    static int chkFlag = 0;

    public void showSortedFiles()
    {

        // Try-catch Block
        try
        {
            System.out.println("Enter folder path for file details");
            Scanner s1 = new Scanner(System.in);
            String folderPath = s1.next();
            File dir = new File(folderPath);

            File[] files = dir.listFiles();

            Arrays.sort(files, (f1, f2) -> {
                if (f1.isDirectory() && !f2.isDirectory())
                {
                    return -1;
                }
                else if (!f1.isDirectory() && f2.isDirectory())
                {
                    return 1;
                }
                else
                {
                    return f1.compareTo(f2);
                }
            });

            for (File file : files)
            {
                if (!file.isHidden())
                {
                    if (file.isDirectory())
                    {
                        System.out.println("DIR \t" + file.getName());
                    }
                    else
                    {
                        System.out.println("FILE\t" + file.getName());
                    }
                }
            }
        }
        catch (Exception ex1)
        {
        }
    }

    public void FileExit(String name, File file)
    {

        // Try-catch Block
        try
        {
            File[] list = file.listFiles();
            if (list != null)
            {
                for (File fil : list)
                {
                    if (fil.isDirectory())
                    {
                        FileExit(name, fil);
                    }
                    else if (name.equalsIgnoreCase(fil.getName()))
                    {
                        System.out.println(fil.getParentFile());
                        chkFlag = 1;
                    }
                }
            }

        }
        catch (Exception ex2)
        {
        }
    }

    public void searchFile()
    {

        // Try-catch Block
        try
        {
            StudentController ff = new StudentController();
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the file to be searched.. ");
            String name = scan.next();
            System.out.println("Enter the directory where to search ");
            String directory = scan.next();
           ff.FileExit(name, new File(directory));
            if (chkFlag == 1)
            {
                System.out.println("File is present:");
                chkFlag = 0;
            }
            else
            {
                System.out.println("File is not present:");
            }
        }
        catch (Exception ex3)
        {
        }
    }

    public void showFile()
    {

        // Try-catch Block
        try
        {
            System.out.println("Enter the path to folder to search for files");
            Scanner s1 = new Scanner(System.in);
            String folderPath = s1.next();
            File folder = new File(folderPath);

            System.out.println("Enter the file to search for files");

            if (folder.isDirectory())
            {
                String[] listOfFiles = folder.list();
                if (listOfFiles.length < 1)
                    System.out.println("There is no File inside Folder");
                else
                    System.out.println("List of Files & Folder");
                for (String fileName : listOfFiles)
                {
                        System.out.println(fileName);
                }
            }
            else
                System.out.println("There is no Folder @ given path :" + folderPath);
        }
        catch (Exception ex4)
        {
        }
    }

    // Function To Make New File
    public void newFile()
    {

        String strPath = "", strName = "";

        // Try-catch Block
        try
        {

            // Creating BufferedReadered object
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the file name:");

            // Reading File name
            strName = br.readLine();
            System.out.println("Enter the file path:");

            // Reading File Path
            strPath = br.readLine();

            // Creating File Object
            File file1 = new File(strPath + "" + strName + ".txt");

            file1.createNewFile();
        } // Try-Catch Block
        catch (Exception ex5)
        {
        }
    }

    public void deleteFile()
    {

        String strPath = "", strName = "";

        try
        {
            // Creating BufferedReadered object
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the file name:");

            // Reading File name
            strName = br.readLine();
            System.out.println("Enter the file path:");

            // Reading File Path
            strPath = br.readLine();

            // Creating File Object
            File file1 = new File(strPath + strName + ".txt");
            if (file1.delete())
            {
                System.out.println("Deleted the file: " + file1.getName());
            }
            else
            {
                System.out.println("Failed to delete the file.");
            }
        }
        catch (Exception ex6)
        {
            System.out.println(ex6.getStackTrace());
        }
    }

    public static void main(String[] args) throws Exception
    {

        // Creating New File via function
        StudentController fileobj = new StudentController();
        // fileobj.newFile();

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to My Project");
        System.out.println("Developer name is Rashmi Rajeev");

        while (true)
        {
            System.out.println("   You Are in Main menu:      ");
            System.out.println("   Press 1 for Show Files");
            System.out.println("   Press 2 for Show File Option Menu");
            System.out.println("   Press 3 for Quit");

            System.out.println("   Enter your choice : ");

            int choice = scan.nextInt();// accept user input
            switch (choice)
            {

                case 1:
                    System.out.println("  You have Entered for Show Files ");
                    fileobj.showSortedFiles();
                    System.out.println("  Return Back to Main Menu");
                    break;

                case 2: // System.out.println("2. Show File Option Menu");
                    System.out.println("  Please Enter below cmd for Files Option :");
                    System.out.println("  Press 1 for Create File");
                    System.out.println("  Press 2 for Delete File");
                    System.out.println("  Press 3 for Search File");
                    System.out.println("  Press 4 to Return to Main Menu");

                    int choice2 = scan.nextInt();

                    switch (choice2)
                    {

                        case 1:
                            System.out.println(" Entered for Creating file");
                            fileobj.newFile();
                            break;
                        case 2:
                            System.out.println(" Entered for Deleting file");
                            fileobj.deleteFile();
                            break;
                        case 3:
                            System.out.println(" Entered for Search file");
                            fileobj.searchFile();
                            break;
                        case 4:
                            System.out.println(" Return Back to Main Menu:");
                            break;
                    }

                    break;

                case 3:
                    System.out.println(" Press 3 to Quit the application ");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Incorrect input!!! Please re-enter choice from our menu");
            }

        }

    }

}
