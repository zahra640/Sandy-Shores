
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Cammie Labelle and Zahra Hussain
 * May/June 2024
 * Designing the rule screen and setting up the next window
 */

/**
 *
 * @author CaLab7887
 */
public class LabelleHussainRuleScreen extends javax.swing.JFrame {
    
    static LabelleHussainIntroScreen firstWindow;
    
    /**
     * Creates new form LabelleHussainRuleScreen
     * @param m - the main window of the program
     */
    public LabelleHussainRuleScreen(LabelleHussainIntroScreen m) {
        initComponents();
        firstWindow = m;
        
        String rules = readRules();
        jTextArea2.setEditable(false);
        jTextArea2.setText(rules);
        jTextArea2.setCaretPosition(0);
        
    }

    /**
     * A method that reads the rules of Pac-Man: Sandy Shores from a data file 
     * @return an output string that condenses all the rules
     */
    public String readRules(){
        String output = ""; //inititate string for the rule output
        
        try{
            File file = new File("src/rules.txt"); //instantiate new rule object
            Scanner scanner = new Scanner(file); //instantiate new scanner object
            
            while(scanner.hasNextLine()){ //continue looping until there are no more lines in the data file
                output = output + scanner.nextLine() + "\n"; //add each line of the file to the output string
            }
            
        }catch(FileNotFoundException e){
            System.out.println("error "+e); //print error message if there is an error with the file
        }
        
        return output; //return the output string
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 26, 330, 350));

        jButton1.setText("<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //go back to the first window
        firstWindow.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
