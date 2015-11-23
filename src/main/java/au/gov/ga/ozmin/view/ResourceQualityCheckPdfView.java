package au.gov.ga.ozmin.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import au.gov.ga.ozmin.model.MineralDeposit;
import au.gov.ga.ozmin.model.MineralResource;
import au.gov.ga.ozmin.model.MineralisedZone;
import au.gov.ga.ozmin.model.ResourceGrade;

public class ResourceQualityCheckPdfView extends AbstractPdfView {

	private List<String> headerRow = Arrays.asList("Deposit", "Mineralised Zone", "Material", "Commodity", "Unit",
			"Proven", "Probable", "Proven & Probable", "Measured", "Indicated", "Measured & Indicated", "Inferred",
			"Other");

	private DateFormat oracleDate = new SimpleDateFormat("dd-MMM-yyyy");

	private int numberOfColumns() {
		return headerRow.size();
	}

	private static Font tableFont = new Font(Font.HELVETICA);

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Rectangle rectangle = PageSize.A4.rotate();
		document.setPageSize(rectangle);

		Set<MineralDeposit> mineralDepositsCollection = (Set<MineralDeposit>) model.get("resourcesCollection");

		Paragraph paragraph = new Paragraph();
		PdfPTable table = new PdfPTable(numberOfColumns());

		// table.getDefaultCell().setBorder(0);
		// table.getDefaultCell().setPhrase(phrase);

		// table.setPadding(2);

		// table.setBorderWidth(0);

		document.setHeader(header);
		document.setFooter(footer);

		for (String headerItem : headerRow) {
			table.addCell(tableString(headerItem));
		}
		for (MineralDeposit mineralDeposit : mineralDepositsCollection) {
			System.out.println(mineralDeposit.getId().toString());
			int i = 0;
			for (MineralisedZone mineralisedZone : mineralDeposit.getMineralisedZones()) {
				if (i == 0) {
					table.addCell(mineralDeposit.getName());
				} else {
					table.addCell(new String());
				}
				int j = 0;
				for (MineralResource mineralResource : mineralisedZone.getMineralResources()) {
					if (j == 0) {
						table.addCell(mineralisedZone.getName());
					} else {
						table.addCell(new String());
						table.addCell(new String());
					}
					table.addCell(oracleDate.format(mineralResource.getRecordDate()).toString().toUpperCase());
					table.addCell(new String());
					table.addCell(ObjectUtils.toString(mineralResource.getOreUnit().getCode()));
					table.addCell(ObjectUtils.toString(mineralResource.getProven()));
					table.addCell(ObjectUtils.toString(mineralResource.getProbable()));
					table.addCell(ObjectUtils.toString(mineralResource.getProvenAndProbable()));
					table.addCell(ObjectUtils.toString(mineralResource.getMeasured()));
					table.addCell(ObjectUtils.toString(mineralResource.getIndicated()));
					table.addCell(ObjectUtils.toString(mineralResource.getMeasuredAndIndicated()));
					table.addCell(ObjectUtils.toString(mineralResource.getInferred()));
					table.addCell(ObjectUtils.toString(mineralResource.getOther()));
					for (ResourceGrade resourceGrade : mineralResource.getResourceGrades()) {
						table.addCell(new String());
						table.addCell(new String());
						table.addCell(new String());
						table.addCell(ObjectUtils.toString(resourceGrade.getCommodity().getId()));
						table.addCell(ObjectUtils.toString(resourceGrade.getGradeUnit().getCode()));
						table.addCell(ObjectUtils.toString(resourceGrade.getProven()));
						table.addCell(ObjectUtils.toString(resourceGrade.getProbable()));
						table.addCell(ObjectUtils.toString(resourceGrade.getProvenAndProbable()));
						table.addCell(ObjectUtils.toString(resourceGrade.getMeasured()));
						table.addCell(ObjectUtils.toString(resourceGrade.getIndicated()));
						table.addCell(ObjectUtils.toString(resourceGrade.getMeasuredAndIndicated()));
						table.addCell(ObjectUtils.toString(resourceGrade.getInferred()));
						table.addCell(ObjectUtils.toString(resourceGrade.getOther()));
					}
					j++;
				}

				i++;
			}

		}
		document.add(table);
	}

	private HeaderFooter header = new HeaderFooter(new Phrase("OZMIN Resources and Grades (QA Sheet)"), false);

	private HeaderFooter footer = new HeaderFooter(new Phrase("This is page "), new Phrase("."));

	@Override
	protected Document newDocument() {
		Document document = new Document();
		document.setPageSize(PageSize.A4.rotate());
		document.setMargins(0, 0, 0, 0);
		document.setMarginMirroring(true);
		return document;
	}

	private Phrase tableString(Object obj) {
		String str = ObjectUtils.toString(obj);
		return new Phrase(str, tableFont);
	}

	PdfPCell resourceTableCell() {
		PdfPCell cell = new PdfPCell();
		cell.setBorder(0);
		return cell;
	}

}
