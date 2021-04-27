package com.project.entity;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfExport {
	
	private List<Student> studentlist2;

	public PdfExport(List<Student> studentlist2) {
		
		this.studentlist2 = studentlist2;
	}
	
	public void writeTableHeader(PdfPTable table1) {
		
		PdfPCell cell=new PdfPCell();
		cell.setBackgroundColor(Color.yellow);
		cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
		cell.setPadding(2);
		
		Font font=FontFactory.getFont(FontFactory.HELVETICA, 14, Color.BLUE);
		
		cell.setPhrase(new Phrase("id", font));
		table1.addCell(cell);
		
		cell.setPhrase(new Phrase("vorname", font));
		table1.addCell(cell);
		
		cell.setPhrase(new Phrase("nachname", font));
		table1.addCell(cell);
		
		cell.setPhrase(new Phrase("email", font));
		table1.addCell(cell);
		
		cell.setPhrase(new Phrase("ProgSprache", font));
		table1.addCell(cell);
		
		cell.setPhrase(new Phrase("GeburtsDatum", font));
		table1.addCell(cell);
		
	}
	
	public void writeTableData(PdfPTable table1) {
		for (Student student : studentlist2) {
			table1.addCell(String.valueOf(student.getId()));
			table1.addCell(student.getVorname());
			table1.addCell(student.getNachname());
			table1.addCell(student.getEmail());
			table1.addCell(student.getProgSprache());
			table1.addCell(student.getGeburtsDatum());
					
		}
	}
	
	public void exportData(HttpServletResponse response) throws DocumentException, IOException {
		Document document=new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		
		Font font=FontFactory.getFont(FontFactory.HELVETICA, 14, Color.BLUE);
		
		Paragraph title=new Paragraph("Student List");
		title.setAlignment(Paragraph.ALIGN_CENTER);
		title.setFont(font);
		title.setSpacingAfter(50);
		
		PdfPTable table=new PdfPTable(6);
		table.setWidthPercentage(100);
		table.setWidths(new int[] {2,2,2,2,2,2});
		
		writeTableHeader(table);
		writeTableData(table);
		document.add(table);
		document.close();
	}

}
