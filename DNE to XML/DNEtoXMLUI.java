import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DNEtoXMLUI extends javax.swing.JFrame {
  private Convert convert = new Convert();
  public DNEtoXMLUI() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  private void initComponents() {

    javax.swing.JFrame jFrame1 = new javax.swing.JFrame();
    javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
    javax.swing.JButton jButton2 = new javax.swing.JButton();
    javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
    javax.swing.JButton jButton4 = new javax.swing.JButton();
    javax.swing.JButton jButton1 = new javax.swing.JButton();
    javax.swing.JLabel jLabel1 = new javax.swing.JLabel();

    jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
    jFrame1.getContentPane().setLayout(jFrame1Layout);
    jFrame1Layout.setHorizontalGroup(
        jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
    );
    jFrame1Layout.setVerticalGroup(
        jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
    );

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setFocusableWindowState(false);
    setIconImages(null);
    setPreferredSize(new java.awt.Dimension(250, 200));

    jLabel3.setText("Select input file");

    jButton2.setText("Browse");
    jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        try {
          jButton2MouseClicked(evt);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

    jLabel4.setText("Create output file");

    jButton4.setText("Browse");
    jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        try {
          jButton4MouseClicked(evt);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

    jButton1.setText("Browse");
    jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        try {
          jButton1MouseClicked(evt);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

    jLabel1.setText("Select data file");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton4))))
                .addContainerGap(258, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addContainerGap(208, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>

  private void jButton4MouseClicked(java.awt.event.MouseEvent evt) throws Exception {
    System.out.println("output");
    FileNameExtensionFilter filter = new FileNameExtensionFilter("XML file", "xml");
    JFileChooser outputChooser = new JFileChooser();
    outputChooser.setFileFilter(filter);
    outputChooser.showOpenDialog(null);
    File file = outputChooser.getSelectedFile();
    String outputPath = file.getAbsolutePath();
    convert.setOutputPath(outputPath);
    convert.convert();
  }

  private void jButton2MouseClicked(java.awt.event.MouseEvent evt) throws Exception {
    System.out.println("input");
    FileNameExtensionFilter filter = new FileNameExtensionFilter("DNE file", "dne");
    JFileChooser inputChooser = new JFileChooser();
    inputChooser.setFileFilter(filter);
    inputChooser.showOpenDialog(null);
    File file = inputChooser.getSelectedFile();
    String inputPath = file.getAbsolutePath();
    convert.setInputPath(inputPath);
    convert.convert();
  }

  private void jButton1MouseClicked(java.awt.event.MouseEvent evt) throws Exception {
    System.out.println("data");
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Data file", "data");
    JFileChooser dataChooser = new JFileChooser();
    dataChooser.setFileFilter(filter);
    dataChooser.showOpenDialog(null);
    File file = dataChooser.getSelectedFile();
    String dataPath = file.getAbsolutePath();
    convert.setDataPath(dataPath);
    convert.convert();
  }


}
