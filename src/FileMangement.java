
import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hieu bach
 */
public class FileMangement {

    String FileName = "";

    MTE parents;
    boolean textChange = false;
    String fn;
    String dir;
    int pos;

    public FileMangement(JFrame parents) {
        this.parents = (MTE) parents;
    }

    public FileMangement() {
    }

    public String checkFile() {
        String str = "";
        try {
            BufferedReader read = new BufferedReader(new FileReader(FileName));
            System.out.println(FileName);
            String temp;
            while ((temp = read.readLine()) != null) {
                str = str.concat(temp + "\n");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileMangement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileMangement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }

    void saveAs(String txt) {
        FileDialog fd = new FileDialog(parents, "Save", FileDialog.SAVE);
        fd.show();

        if (fd.getFile() != null) {
            BufferedReader read = null;
            try {
                fn = fd.getFile();
                dir = fd.getDirectory();
                FileName = dir + fn + ".txt";
                read = new BufferedReader(new StringReader(txt));
                DataOutputStream data = new DataOutputStream(new FileOutputStream(FileName));
                String temp;
                while ((temp = read.readLine()) != null) {
                    data.writeBytes(temp + "\r\n");
                    data.close();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileMangement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FileMangement.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    read.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileMangement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        textChange = false;
    }

    void saveFile(String txt) {
        DataOutputStream data = null;
        try {
            //        FileWriter write=null;
//        try {
//            write = new FileWriter(FileName);
//            write.write(txt);
//            textChange=false;
//        } catch (IOException ex) {
//            Logger.getLogger(FileMangement.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                write.close();
//            } catch (IOException ex) {
//                Logger.getLogger(FileMangement.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
            BufferedReader read = new BufferedReader(new StringReader(txt));
            data = new DataOutputStream(new FileOutputStream(FileName));
            String temp;
            try {
                while ((temp = read.readLine()) != null) {
                    data.writeBytes(temp + "\r\n");
                    data.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(FileMangement.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileMangement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                data.close();
            } catch (IOException ex) {
                Logger.getLogger(FileMangement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        textChange = false;
    }

    
}
