
import java.awt.Color;
import java.awt.MouseInfo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hieu bach
 */
public class MyHighLighter extends DefaultHighlighter.DefaultHighlightPainter {

    public MyHighLighter(Color c) {
        super(c);
    }

    public void removeHighlight(JTextComponent textArea) {
        Highlighter highligh = textArea.getHighlighter();
        Highlighter.Highlight[] hilighter = highligh.getHighlights();
        for (int i = 0; i < hilighter.length; i++) {
            highligh.removeHighlight(hilighter[i]);
        }
    }

    public int HighLighWordUp(JTextComponent textArea, String find, int pos, boolean match) {

        System.out.println("***************");
        Highlighter highligh = textArea.getHighlighter();
        Document doc = textArea.getDocument();
        String txt = null;
        try {
            txt = doc.getText(0, doc.getLength());
        } catch (BadLocationException ex) {
            Logger.getLogger(MyHighLighter.class.getName()).log(Level.SEVERE, null, ex);
        }

        int temp = 0;
        int tmp = pos;
        int tmpPos = pos;
        System.out.println("tmp="+tmp);
        String test = txt.substring(0, pos);
        if (match) {
            for (int i = pos; i >= 0; i--) {
                if ((temp = test.indexOf(find, i)) >= 0) {
                    try {
                        removeHighlight(textArea);
                        highligh.addHighlight(temp, temp + find.length(), new MyHighLighter(Color.YELLOW));
                    } catch (BadLocationException ex) {
                        Logger.getLogger(MyHighLighter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    pos = temp + 1;
                    tmpPos = temp;
                    break;
                }

            }
        }else{
            for (int i = pos; i >= 0; i--) {
            if ((temp = test.toUpperCase().indexOf(find.toUpperCase(), i)) >= 0) {
                try {
                    removeHighlight(textArea);
                    highligh.addHighlight(temp, temp + find.length(), new MyHighLighter(Color.YELLOW));
                } catch (BadLocationException ex) {
                    Logger.getLogger(MyHighLighter.class.getName()).log(Level.SEVERE, null, ex);
                }
                pos = temp + 1;
                tmpPos = temp;
                break;
            }

        }
        }
       System.out.println("tmpPos="+tmpPos);
        if (tmpPos == tmp) {
            return -2;
        }

        pos--;
        return pos;

    }

    public int HighLighWordDown(JTextComponent textArea, String find, int pos, boolean match) {
        if (pos == textArea.getText().length()) {
            return pos;
        }

        Highlighter highligh = textArea.getHighlighter();
        Document doc = textArea.getDocument();
        int temp = pos;
        String txt = null;
        try {
            txt = doc.getText(0, doc.getLength());
        } catch (BadLocationException ex) {
            Logger.getLogger(MyHighLighter.class.getName()).log(Level.SEVERE, null, ex);
        }
        int count = 0;

        int tmp = pos;
        if (match) {
            if ((pos = txt.indexOf(find, pos)) >= 0) {
                try {
                    removeHighlight(textArea);
                    highligh.addHighlight(pos, pos + find.length(), new MyHighLighter(Color.YELLOW));
                } catch (BadLocationException ex) {
                    Logger.getLogger(MyHighLighter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            if ((pos = txt.toUpperCase().indexOf(find.toUpperCase(), pos)) >= 0) {
                try {
                    removeHighlight(textArea);
                    highligh.addHighlight(pos, pos + find.length(), new MyHighLighter(Color.YELLOW));
                } catch (BadLocationException ex) {
                    Logger.getLogger(MyHighLighter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (pos == -1) {
            return tmp;
        } else {
            pos++;
        }
        return pos;

    }

    public void HighLighWordAll(JTextComponent textArea, String find, boolean match) {
        removeHighlight(textArea);
        Highlighter highligh = textArea.getHighlighter();
        Document doc = textArea.getDocument();

        String txt = null;
        try {
            txt = doc.getText(0, doc.getLength());
        } catch (BadLocationException ex) {
            Logger.getLogger(MyHighLighter.class.getName()).log(Level.SEVERE, null, ex);
        }

        int temp = 0;
        if (match) {
            for (int i = temp; i <= textArea.getText().length(); i++) {
                if ((temp = txt.indexOf(find, i)) >= 0) {
                    System.out.println("temp= " + temp);
                    try {
                        highligh.addHighlight(temp, temp + find.length(), new MyHighLighter(Color.YELLOW));
                    } catch (BadLocationException ex) {
                        Logger.getLogger(MyHighLighter.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        } else {
            for (int i = temp; i <= textArea.getText().length(); i++) {
                if ((temp = txt.toUpperCase().indexOf(find.toUpperCase(), i)) >= 0) {
                    System.out.println("temp= " + temp);
                    try {
                        highligh.addHighlight(temp, temp + find.length(), new MyHighLighter(Color.YELLOW));
                    } catch (BadLocationException ex) {
                        Logger.getLogger(MyHighLighter.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        }

    }

}
