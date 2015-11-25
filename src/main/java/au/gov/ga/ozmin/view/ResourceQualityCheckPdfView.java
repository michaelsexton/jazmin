package au.gov.ga.ozmin.view;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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

		@SuppressWarnings("unchecked")
		Set<MineralDeposit> mineralDepositsCollection = (Set<MineralDeposit>) model.get("resourcesCollection");

		document.setHeader(header);
		document.setFooter(footer);

		for (MineralDeposit mineralDeposit : mineralDepositsCollection) {
			PdfPTable depositTable = new PdfPTable(1);
			depositTable.setWidthPercentage(100);
			depositTable.setSpacingAfter(10);
			PdfPCell depositCell = new PdfPCell();
			depositCell.setPadding(0);
			depositCell.disableBorderSide(1);

			PdfPTable resourcesTable = new PdfPTable(numberOfColumns());
			
			resourcesTable.setWidthPercentage(100);
			resourcesTable.getDefaultCell().setBorder(0);
			for (String headerItem : headerRow) {
				PdfPCell headerCell = new PdfPCell();
				headerCell.addElement(tableString(headerItem));
				headerCell.setPadding(1);
				headerCell.setBackgroundColor(Color.gray);
				resourcesTable.addCell(headerCell);
			}
			// System.out.println(mineralDeposit.getId().toString());
			int i = 0;
			for (MineralisedZone mineralisedZone : mineralDeposit.getMineralisedZones()) {
				if (i == 0) {
					resourcesTable.addCell(mineralDeposit.getName());
				} else {
					resourcesTable.addCell(new String());
				}
				int j = 0;
				for (MineralResource mineralResource : mineralisedZone.getMineralResources()) {
					if (j == 0) {
						resourcesTable.addCell(mineralisedZone.getName());
					} else {
						resourcesTable.addCell(new String());
						resourcesTable.addCell(new String());
					}
					resourcesTable.addCell(oracleDate.format(mineralResource.getRecordDate()).toString().toUpperCase());
					resourcesTable.addCell(new String());
					resourcesTable.addCell(ObjectUtils.toString(mineralResource.getOreUnit().getCode()));
					resourcesTable.addCell(ObjectUtils.toString(mineralResource.getProven()));
					resourcesTable.addCell(ObjectUtils.toString(mineralResource.getProbable()));
					resourcesTable.addCell(ObjectUtils.toString(mineralResource.getProvenAndProbable()));
					resourcesTable.addCell(ObjectUtils.toString(mineralResource.getMeasured()));
					resourcesTable.addCell(ObjectUtils.toString(mineralResource.getIndicated()));
					resourcesTable.addCell(ObjectUtils.toString(mineralResource.getMeasuredAndIndicated()));
					resourcesTable.addCell(ObjectUtils.toString(mineralResource.getInferred()));
					resourcesTable.addCell(ObjectUtils.toString(mineralResource.getOther()));
					for (ResourceGrade resourceGrade : mineralResource.getResourceGrades()) {
						resourcesTable.addCell(new String());
						resourcesTable.addCell(new String());
						resourcesTable.addCell(new String());
						resourcesTable.addCell(ObjectUtils.toString(resourceGrade.getCommodity().getId()));
						resourcesTable.addCell(ObjectUtils.toString(resourceGrade.getGradeUnit().getCode()));
						resourcesTable.addCell(ObjectUtils.toString(resourceGrade.getProven()));
						resourcesTable.addCell(ObjectUtils.toString(resourceGrade.getProbable()));
						resourcesTable.addCell(ObjectUtils.toString(resourceGrade.getProvenAndProbable()));
						resourcesTable.addCell(ObjectUtils.toString(resourceGrade.getMeasured()));
						resourcesTable.addCell(ObjectUtils.toString(resourceGrade.getIndicated()));
						resourcesTable.addCell(ObjectUtils.toString(resourceGrade.getMeasuredAndIndicated()));
						resourcesTable.addCell(ObjectUtils.toString(resourceGrade.getInferred()));
						resourcesTable.addCell(ObjectUtils.toString(resourceGrade.getOther()));
					}
					j++;
				}

				i++;
			}
			depositCell.addElement(resourcesTable);
			depositTable.addCell(depositCell);
			document.add(depositTable);
		}

	}

	private HeaderFooter header = new HeaderFooter(new Phrase("OZMIN Resources and Grades (QA Sheet)"), false);

	private HeaderFooter footer = new HeaderFooter(new Phrase("This is page "), new Phrase("."));

	@Override
	protected Document newDocument() {
		Document document = new Document();
		document.setPageSize(PageSize.A4.rotate());
		//document.setMargins(0, 0, 0, 0);
		//document.setMarginMirroring(true);
	
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
