import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

class WriteXML {

  void write(String[] nodes, String[][] attribute, String outputPath, String dataFile) throws ParserConfigurationException, TransformerException {
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.newDocument();
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    transformer.setOutputProperty(OutputKeys.METHOD, "html");

    // model element
    Element model = doc.createElement("model");
    doc.appendChild(model);

    //general element
    Element general = doc.createElement("general");
    model.appendChild(general);
    Attr data = doc.createAttribute("data");
    data.setValue(dataFile);
    general.setAttributeNode(data);
    general.appendChild(doc.createTextNode(""));

    //nodes element
    Element nodesElement = doc.createElement("nodes");
    model.appendChild(nodesElement);

    //node element
    Element[] nodeArray = new Element[nodes.length];
    Attr temp;
    Element label;
    for(int i = 0 ; i < nodes.length ; i++) {
      nodeArray[i] = doc.createElement("node");
      nodesElement.appendChild(nodeArray[i]);
      temp = doc.createAttribute("id");
      temp.setValue(Integer.toString(i));
      nodeArray[i].setAttributeNode(temp);
      temp = doc.createAttribute("datatype");
      temp.setValue(attribute[i][0]);
      nodeArray[i].setAttributeNode(temp);
      temp = doc.createAttribute("role");
      temp.setValue("root");
      nodeArray[i].setAttributeNode(temp);
      label = doc.createElement("label");
      nodeArray[i].appendChild(label);
      label.appendChild(doc.createTextNode(nodes[i]));
    }


    DOMSource source = new DOMSource(doc);
    StreamResult result = new StreamResult(new File(outputPath));
    transformer.transform(source, result);
  }


}

//role = root