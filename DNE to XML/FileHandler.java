import java.io.*;

class FileHandler {
  //method to read file
  String read(String path) throws IOException {
    /* String keyword = "node"; */
    FileReader file = new FileReader(path);
    BufferedReader reader = new BufferedReader(file);

    String contents = "";
    String line = reader.readLine();
    while(line != null) {
      contents = contents + line + "\n";
      line = reader.readLine();
    }
    reader.close();
    //System.out.println(contents);
    return contents;
  }

  void write(String path, String text) throws FileNotFoundException, UnsupportedEncodingException {

    try {
      BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"));
      bufferedWriter.write(text);
      bufferedWriter.close();
    }
    catch(IOException ex) {
      System.out.println("Could not write to file '" + path + "'");
    }
  }

}
