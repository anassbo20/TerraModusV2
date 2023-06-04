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
    }
}