package databases_operations;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class SqlToPdf {
    Document document = new Document();
    final PdfWriter instance;

    {
        try {
            instance = PdfWriter.getInstance(document, Files.newOutputStream(Paths.get("iTextHelloWorld.pdf")));
        } catch (DocumentException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addContent(String docs) throws DocumentException, IOException {
           System.out.println(docs+"data from addContent");
        
        document.open();
        Paragraph subpara = new Paragraph(docs);
        document.add(subpara);
        document.close();
    }

    private static  void addtitlepage(Document docs) throws DocumentException {
        Paragraph preface = new Paragraph();
        preface.add("text");
        docs.add(preface);
        docs.newPage();

    }
}