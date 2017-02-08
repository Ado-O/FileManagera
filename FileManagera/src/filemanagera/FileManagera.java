
package filemanagera;

import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Scanner;

public class FileManagera {

    public static void main(String[] args) {

System.out.println("Unesite neku od komandi: list, info, create_dir, rename, copy, move, delete");
Scanner s = new Scanner(System.in);
switch(s.next())
{
case "list":
File path = new File("C:\\Users\\Korisnik PC\\Documents\\NetBeansProjects\\FileManagera");
            if(path.exists() && path.isDirectory())
            {
            String[] elements = path.list();
            
    for (String element : elements) {
        System.out.println(element);
    }
        }
break;
case "info":
 File file = new File("text.txt");
        if(file.exists())
        {
            System.out.println("Ime: " + file.getName());
            System.out.println("Apsolute path: " + file.getAbsolutePath());
            System.out.println("Velicina: " + file.length() + "B");
            Instant instantLastModified = Instant.ofEpochMilli(file.lastModified());
            LocalDateTime dateTimeLastModified = LocalDateTime.ofInstant(instantLastModified, ZoneId.systemDefault());
            System.out.println("Datum posljednje izmjene: " + dateTimeLastModified);
        }
break;
case "create_dir":
File testDirectory = new File("C:\\Users\\Korisnik PC\\Documents\\NetBeansProjects\\FileManagera\\test");
            if(!testDirectory.exists())
            {
            testDirectory.mkdir();
            System.out.println("Novi folder se zove " + testDirectory.getName());
        }
            else
            {
            System.out.println("Folder vec postoji.");
            }
break;
case "rename":
File oldFile = new File("C:\\Users\\Korisnik PC\\Documents\\NetBeansProjects\\FileManagera\\test");
        File newFile = new File("C:\\Users\\Korisnik PC\\Documents\\NetBeansProjects\\FileManagera\\Javatest");
           
            if(!oldFile.exists())
            {
            System.out.println("Fajl ne postoji!");
            return;
            }
            if(newFile.exists())
            {
            System.out.println("Fajl sa zeljenim imenom vec postoji!");
            return;
            }   
            if(oldFile.renameTo(newFile))
            {
            System.out.println("Promijena imena uspela!");
            }
            else
            {
            System.out.println("Promijena imena nije uspela!");
            } 
break;
case "copy":
 File aFile = new File("forCopy.txt");
        File bFile = new File("copied.txt");
        
            try(FileInputStream inStream = new FileInputStream(aFile);
            FileOutputStream outStream = new FileOutputStream(bFile);)
            {
            byte[] buffer = new byte[1024];
            
            int lenght;
            while((lenght = inStream.read(buffer)) > 0)
            {
            outStream.write(buffer, 0, lenght);
            }
        }
            catch(IOException exc)
            {
            System.out.println(exc);
        }
break;
case "move":
        String putanja = "";
        String destinacija = "";
 
        try (BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));) {
 
            System.out.println("Unesite putanju file: ");
            putanja = bufferRead.readLine();
 
            System.out.println("Unesite destinaciju foldera: ");
            destinacija = bufferRead.readLine();
 
        } catch (IOException e) {
            System.out.println(e);
        }
break;
case "delete":
File testDirectory1 = new File("C:\\Users\\Korisnik PC\\Documents\\NetBeansProjects\\FileManagera\\test");
        
            if(testDirectory1.exists())
            {
            testDirectory1.delete();
            System.out.println("Folder " + testDirectory1.getName() + " obrisan");        
            }
            else
            {
            System.out.println("Folder ne postoji!");
        }
break;
default:
System.out.println("Morate unijeti neku od komandi: list, info, create_dir, rename, copy, move, delete");
}       
   }       
    }
          
        
    

