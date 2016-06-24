import javax.swing.*;

class Convert {
  private String inputPath;
  private String outputPath;
  private String dataPath;
  public static void main(String[] args) throws Exception {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(DNEtoXMLUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> new DNEtoXMLUI().setVisible(true));
  }

  public void convert() throws Exception{
    if(this.inputPath == null || this.outputPath == null || this.dataPath == null) {
      return;
    }
    FileHandler fh = new FileHandler();
    String contents = fh.read(this.inputPath);
    DNEParse parse = new DNEParse(contents);
    WriteXML writer = new WriteXML();
    String[] nodes = parse.getNodeNames();
    String[][] nodeAttributes = new String[nodes.length][1];
    /* String[] attribute = new String[1]; */

    for(int i = 0 ; i < nodeAttributes.length ; i++) {  nodeAttributes[i] = parse.getAttributes(nodes[i]);  }
    for (String node : nodes) { System.out.print(node + " "); }
    writer.write(nodes, nodeAttributes, this.outputPath, this.dataPath);

    //Omnigram requires XML to begin on line 11
    String newln = "";
    for(int i = 1 ; i < 11 ; i++) {
      newln += "\n";
    }
    fh.write(outputPath,newln+fh.read(outputPath));
    //parse.getParents(nodes);
  }

  void setInputPath(String inputPath) {
    this.inputPath = inputPath;
  }

  void setOutputPath(String outputPath) {
    this.outputPath = outputPath;
  }

  void setDataPath(String dataPath) {
    this.dataPath = dataPath;
  }

}