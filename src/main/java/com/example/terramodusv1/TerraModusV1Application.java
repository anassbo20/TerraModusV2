package com.example.terramodusv1;
import com.lowagie.text.DocumentException;
import com.microsoft.schemas.office.drawing.x2008.diagram.CTShape;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootApplication
public class TerraModusV1Application {

    public static void main(String[] args) throws IOException, DocumentException {
        SpringApplication.run(TerraModusV1Application.class, args);

        /*PdfReader reader = new PdfReader("C:\\Users\\anass\\Downloads\\springboot-jasperreports-advanced-demo-master\\TerraModusV1\\src\\main\\resources\\Devis 51-2023 CBRE - Comparables- Ain Sebaa - Casablanca.pdf");
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("C:\\Users\\anass\\Downloads\\exported_report.pdf"));
        AcroFields fields = stamper.getAcroFields();
        fields.setField("ice", "111111111111111111111");
        fields.setField("ville", "rabat");
        fields.setField("ref-numero", "11111111");
        fields.setField("dev-numero", "11111111");
        fields.setField("date", "13/04/2023");
        fields.setField("test", "etttttttttttttttttttttttttttttttttttttdgggg");
        fields.setField("cons", "etttttttttttttttttttttttttttttttttttttdgggg");
        fields.setFieldProperty("ice", "setfflags", PdfFormField.FF_READ_ONLY, null);
        fields.setFieldProperty("ville", "setfflags", PdfFormField.FF_READ_ONLY, null);
        fields.setFieldProperty("ville", "setfflags", PdfFormField.FF_READ_ONLY, null);
        stamper;
        stamper.close();
    */
        String[] plaaceholders = new String[] {"NICE","VILLE","DATE","OBJET","DEMANDEUR","REF","NDEVIS"};
        String[] plaaceholdersValues = new String[] {"100","ZAGORA",LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),"JUST TEST","M. BENKEBBOU Omar par email le 14/04/2023","REF1","NDEVIS1"};
        FileInputStream inputStream = new FileInputStream("C:\\Users\\anass\\Downloads\\springboot-jasperreports-advanced-demo-master\\TerraModusV1\\src\\main\\resources\\digital.docx");
        XWPFDocument document = new XWPFDocument(inputStream);
        List<XWPFParagraph> paragraphs = document.getParagraphs();
        //System.out.println(document.getHeaderList()+"----");


        for (XWPFParagraph paragraph : paragraphs) {
            List<XWPFRun> runs = paragraph.getRuns();
            for (XWPFRun run : runs) {
                String text = run.getText(0);
                System.out.println(text);
                for (int i=0;i< plaaceholders.length;i++) {
                    if (text != null && text.contains(plaaceholders[i])) {
                        text = text.replace(plaaceholders[i], plaaceholdersValues[i]);
                        run.setText(text, 0);
                    }
                }
            }
        }


        for (XWPFParagraph paragraph : document.getParagraphs()) {
            for (XWPFRun run : paragraph.getRuns()) {
                CTR ctr = run.getCTR();
                for (CTDrawing drawing : ctr.getDrawingList()) {
                    if (drawing instanceof CTAnchor) {
                        CTAnchor anchor = (CTAnchor) drawing;
                        CTGraphicalObject graphic = anchor.getGraphic();
                        if (graphic instanceof CTShape) {
                            CTShape shape = (CTShape) graphic;
                            if (shape.getTxBody() != null) {
                                CTTextBody textBody = shape.getTxBody();
                                if (textBody.getPArray().length > 0) {
                                    CTTextParagraph paragraph1 = textBody.getPArray(0);
                                    if (paragraph1.getRArray().length > 0) {
                                        CTRegularTextRun textRun = paragraph1.getRArray(0);
                                        if (textRun.getT() != null) {
                                            textRun.setT("New textbox text");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (XWPFParagraph p : document.getParagraphs()) {
            for (XWPFRun r : p.getRuns()) {
                for (CTText ctText : r.getCTR().getTList()) {
                    if (ctText.getDomNode().getNodeName().equals("wps:wsp")) {
                        XmlCursor cursor = ctText.newCursor();
                        cursor.selectPath("./*");
                        while (cursor.toNextSelection()) {
                            if (cursor.getObject() instanceof CTTextBody) {
                                CTTextBody ctTextBody = (CTTextBody) cursor.getObject();
                                String text = ctTextBody.getPArray(0).getRArray(0).getT();
                                // Do something with the text
                                text = "New text";
                                ctTextBody.getPArray(0).getRArray(0).setT(text);
                            }
                        }
                    }
                }
            }
        }







        FileOutputStream outputStream = new FileOutputStream("src/main/resources/exported_report.docx");
        document.write(outputStream);
        ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
        document.write(outputStream1);
        byte[] byteArray = outputStream1.toByteArray();
        outputStream.close();
        document.close();
        outputStream1.close();
        File file = new File("C:\\Users\\anass\\Downloads\\exported_report.docx");

        /*try {
            // Open the XML file
            File xmlFile = new File("C:\\Users\\anass\\Downloads\\springboot-jasperreports-advanced-demo-master\\TerraModusV1\\src\\main\\resources\\Devis 51-2023 CBRE - Comparables- Ain Sebaa - Casablanca.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Modify the XML document
            Element root = doc.getDocumentElement();
            NodeList nodes = root.getElementsByTagName("Textbox");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                NodeList textList = node.getChildNodes();
                System.out.println("-------------------------------------::"+textList);
                for (int j=0;i<textList.getLength();i++){
                    String text = textList.item(i).getTextContent();
                    if (text.contains("Casablanca")) {
                        textList.item(i).setTextContent(text.replace("Casablanca", "new text"));
                    }
                }
            }

            // Write the modified XML document to a new file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\anass\\Downloads\\exported_report.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Step 1: Set up the FOP factory
            FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

            // Step 2: Set up the output stream
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\anass\\Downloads\\output.pdf"));

            // Step 3: Construct the FOP instance
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);

            File inputFile = new File("C:\\Users\\anass\\Downloads\\exported_report.xml");
            File outputFile = new File("C:\\Users\\anass\\Downloads\\output.xsl");

            // Create a stream reader for the input XML file
            FileInputStream inputStream1 = new FileInputStream(inputFile);
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream1);

            // Use the TransformerFactory to generate an XSL stylesheet from the StAXSource
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            StAXSource source = new StAXSource(xmlStreamReader);
            Transformer transformer = transformerFactory.newTransformer(source);
            transformer.setOutputProperty("indent", "yes"); // Set the output properties as needed

            // Write the XSL stylesheet to the output file
            FileOutputStream outputStream2 = new FileOutputStream(outputFile);
            transformer.transform(source, new StreamResult(outputStream2));

            inputStream1.close();
            outputStream2.close();

            // Step 4: Set up the XSLT transformation
            TransformerFactory transformerFactory1 = TransformerFactory.newInstance();
            Transformer transformer1 = transformerFactory1.newTransformer(new StreamSource(new File("C:\\Users\\anass\\Downloads\\output.xsl")));

            // Step 5: Set up the input stream
            StreamSource source1 = new StreamSource(new File("C:\\Users\\anass\\Downloads\\exported_report.xml"));

            // Step 6: Start the transformation and rendering process
            SAXResult result = new SAXResult(fop.getDefaultHandler());
            transformer1.transform(source1, result);

            // Step 7: Clean up
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

    }
}