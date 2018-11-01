package com.convert;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import static com.convert.Read.readTitle;
import static com.convert.Read.readData;

public class Convert {
    // Set PDF file location
    public static void createPDF(){
        try {
            System.out.println("Creating empty PDF file...");
            // Create a PDF file
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Acer\\eclipse-workspace\\Assignment2\\Ranking.pdf"));
            document.open();
            PdfPTable table = new PdfPTable(6); 
            table.setHorizontalAlignment(Element.ALIGN_CENTER); 
            table.setWidthPercentage(100); 
            float[]colWidth = {1.4f,10f,2f,1.5f,1.2f,5f}; 
            table.setWidths(colWidth);
            int count = 0;

            for(Title title: readTitle()){
                if(count>=0 && count<3) {
                    Phrase words = new Phrase(new Paragraph(String.valueOf(Read.title.get(count).getTitle())));
                    document.add(words);
                    document.add(Chunk.NEWLINE);
                }
                count++;
                
            }
            
            //add headline of the table
            table.addCell(new PdfPCell(new Paragraph("No.")));
            table.addCell(new PdfPCell(new Paragraph("Name")));
            table.addCell(new PdfPCell(new Paragraph("FideID")));
            table.addCell(new PdfPCell(new Paragraph("FED")));
            table.addCell(new PdfPCell(new Paragraph("RTG")));
            table.addCell(new PdfPCell(new Paragraph("Club/City")));
            
            
            // Make all collected data into a table in PDF, according to Excel Table
            int index = 0;
            for (Data data: readData()) {
                // Align all data based on alignment from Excel Table
                table.addCell(new PdfPCell(new Paragraph(String.valueOf(Read.data.get(index).getNo()))));
                table.addCell(new PdfPCell(new Paragraph(String.valueOf(Read.data.get(index).getName()))));
                table.addCell(new PdfPCell(new Paragraph(String.valueOf(Read.data.get(index).getfidelID()))));
                table.addCell(new PdfPCell(new Paragraph(String.valueOf(Read.data.get(index).getfED()))));
                table.addCell(new PdfPCell(new Paragraph(String.valueOf(Read.data.get(index).getRtg()))));
                table.addCell(new PdfPCell(new Paragraph(String.valueOf(Read.data.get(index).getClubnCity()))));
                index++;
            }
            document.add(table);
            document.close();
            System.out.println("Location: "+ "C:\\Users\\Acer\\eclipse-workspace\\Assignment2\\Ranking.pdf" );
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}