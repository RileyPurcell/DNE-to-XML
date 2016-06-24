class DNEParse {
  private String dneFile;
  DNEParse(String dneFile) {
    this.dneFile = dneFile;
  }

  String[] getNodeNames() {
    String[] names = new String[numberOf("node ")];
    String keyword = "node ";
    String current;
    String currentNodeName = "";
    int currentChar;
    for(int i = 0 ; i < dneFile.length() ; i++){
      if(i+keyword.length() < dneFile.length()){
        current = dneFile.substring(i,i+keyword.length());
        if(current.equals(keyword)) {
          currentChar = i+keyword.length();
          while(dneFile.charAt(currentChar)!=' ' && dneFile.charAt(currentChar)!='{'){
            currentNodeName += Character.toString(dneFile.charAt(currentChar));
            currentChar++;
          }
          for(int j = 0 ; j < names.length ; j++) {
            if(names[j]==null) {
              names[j] = currentNodeName;
              currentNodeName = "";
              break;
            }
          }
        }
      } else {
        break;
      }
    }
    return names;
  }

  String[] getAttributes(String node) {
    String[] attributes = new String[1];
    attributes[0] = checkDiscrete(node);
    return attributes;
  }

  private String checkDiscrete(String node) {
    String keyword = "discrete";
    String current;
    int currentChar;
    String discrete = "";
    for(int i = 0 ; i < dneFile.length() ; i++) {
      current = dneFile.substring(i, i+node.length());
      if(current.equals(node)){
        //found node
        currentChar = i+node.length()+1;
        while(true) {
          current = dneFile.substring(currentChar, currentChar+keyword.length());
          if(current.equals(keyword)) {
            //found discrete
            currentChar += keyword.length()+1;
            while(true) {
              if(dneFile.charAt(currentChar) == 'T') {
                discrete = "discrete";
                return discrete;
              } else if(dneFile.charAt(currentChar) == 'F') {
                discrete = "continuous";
                return discrete;
              }
              currentChar++;
            }
          }
          currentChar++;
        }
      }
    }
    return discrete;
  }


  //returns the index of the first instance of a keyword
  private int searchFor(String keyword) {
    String current;
    for(int j = 0 ; j < dneFile.length() ; j++) {
      if (j + keyword.length() <= dneFile.length()) {
        current = dneFile.substring(j, j + keyword.length());
        if (current.equals(keyword)) {
          return j;
        }
      }
    }
    return 0;
  }
  //returns the index of the first instance of a keyword after index
  private int searchFor(String keyword, int index) {
    String current;
    for (int j = index; j < dneFile.length(); j++) {
      if (j + keyword.length() <= dneFile.length()) {
        current = dneFile.substring(j, j + keyword.length());
        if (current.equals(keyword)) {
          return j;
        }
      }
    }
    return 0;
  }

  int numberOf(String keyword) {
    int count = 0;
    String current;
    for(int i = 0 ; i < dneFile.length() ; i++) {
      if(i+keyword.length() <= dneFile.length()) {
        current = dneFile.substring(i,i+keyword.length());
        if(current.equals(keyword)) {
          count++;
        }
      }
    }
    System.out.println(count);
    return count;
  }

}
