package org.fundaciobit.plugins.documentcustody.filesystem;

import java.io.File;
import java.net.URLEncoder;

import org.fundaciobit.plugins.documentcustody.DocumentCustody;

/**
 * 
 * @author anadal
 *
 */
public class TestFileSystemCustody {

  
  public static void main(String[] args) {
    try {
      /*
      MD2
      MD5
      SHA
      SHA-256
      SHA-384
      SHA-512
      */
      
      String algorithm = "MD5"; // "SHA-512"); //"MD5");
      
      String dades="dades a \\à encriptar";
      String password = "pwd";
      for (int i = 1; i < 10; i++) {
        String result = FileSystemDocumentCustodyPlugin.generateHash(dades, "MD5", password + i);
        
        System.out.println(" MD5: (" + i + "): " + result); 
        if (!URLEncoder.encode(result).equals(result)) {
          break;
        }
      }
      System.out.println(" MD5: " + FileSystemDocumentCustodyPlugin.generateHash(dades, algorithm,  password));

      System.out.println(FileSystemDocumentCustodyPlugin.class.getCanonicalName());
      
      File info = new File("hola_info.txt");
      
      DocumentCustody clone = new DocumentCustody();
      clone.setDocumentType(DocumentCustody.DOCUMENT_ONLY);
      clone.setName("holacaracola.txt");
      clone.setData("holacaracola".getBytes());

      FileSystemDocumentCustodyPlugin.write(clone, info);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    
  }
  
  
  
  
  
}
