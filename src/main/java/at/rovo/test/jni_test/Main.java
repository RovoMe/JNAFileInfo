/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.rovo.test.jni_test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roman Vottner
 */
public class Main
{
    public static void main(String[] args)
    {
        List<String> fileNames = new ArrayList<>();
        fileNames.add("C:\\Windows\\explorer.exe");
        fileNames.add("D:\\eclipse\\eclipse.exe");
        fileNames.add("C:\\Programme\\Java\\NetBeans 7.3.1\\bin\\netbeans64.exe");
        fileNames.add("C:\\Program Files\\Internet Explorer\\ielowutil.exe");
        fileNames.add("C:\\Program Files\\Logitech\\Gaming Software\\LWEMon.exe");
        fileNames.add("C:\\Program Files\\Java\\jre7\\bin\\java.exe");
        fileNames.add("C:\\Program Files\\Java\\jdk1.7.0_45\\bin\\java.exe");

        List<FileVersion> files = addFiles(fileNames);
        
        try
        {
            for (FileVersion fileVersion : files)
            {
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                System.out.println("XXX Information contained in: "+fileVersion.getFileName());
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                for(FileInfo info : fileVersion.getFileInfos())
                {
                    System.out.println(info);
                    System.out.println();
                }
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getLocalizedMessage());
        }
    }
    
    /**
     * <p>
     * Creates a FileVersion instance for each passed file if the file does not
     * throw an exception.
     * </p>
     * 
     * @param names The names of the files to create FileVersion instances for
     * @return The list of created FileVersion instances
     */
    private static List<FileVersion> addFiles(List<String> names)
    {
        List<FileVersion> files = new ArrayList<>();
        for (String fileName : names)
        {
            try
            {
                files.add(new FileVersion(fileName));
            }
            catch (Exception e)
            {
                System.err.println(e.getLocalizedMessage());
            }
        }
        return files;
    }
}
