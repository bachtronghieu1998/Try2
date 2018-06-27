
import java.awt.FileDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hieu bach
 */
public class EditManager {

    FileMangement file;
    MTE parents;

    public EditManager(JFrame parents) {
        file = new FileMangement(parents);
    }

    public String Open(String text) {
        String str = "";
        if (text.length() == 0 || !file.textChange) {
            FileDialog fd = new FileDialog(parents, "Open", FileDialog.LOAD);
            fd.show();
            if (fd.getFile() != null) {
                file.fn=fd.getFile();
                file.FileName = fd.getDirectory() + fd.getFile();
                String hold = file.checkFile();
                return hold;

            }
        }
        if (file.textChange) {
            int confirm = JOptionPane.showConfirmDialog(null, "Do you want to save before opening new file");
            if (confirm == JOptionPane.OK_OPTION) {
                file.saveAs(text);
            } else {
               FileDialog fd = new FileDialog(parents, "Open", FileDialog.LOAD);
                fd.show();
                if (fd.getFile() != null) {
                    file.FileName = fd.getDirectory() + fd.getFile() + ".txt";
                    String hold = file.checkFile();
                   return hold;
                    
                }
            }
        }
        return str;
    }
    
    public String getFileName(){
        return file.fn;
    }
    
    public void Save(String text){
        if (file.FileName == "") {
            file.saveAs(text);
        } else {
            file.saveFile(text);     
        }
    }
}
