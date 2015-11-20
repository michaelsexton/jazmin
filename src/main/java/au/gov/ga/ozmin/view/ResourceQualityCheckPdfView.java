package au.gov.ga.ozmin.view;

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

import au.gov.ga.ozmin.model.MineralResource;
import au.gov.ga.ozmin.model.ResourceGrade;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class ResourceQualityCheckPdfView extends AbstractPdfView {

	private List<String> headerRow = Arrays.asList("Deposit",
			"Mineralised Zone", "Material", "Commodity", "Unit", "Proven",
			"Probable", "Proven & Probable", "Measured", "Indicated",
			"Measured & Indicated", "Inferred", "Other");

	private DateFormat oracleDate = new SimpleDateFormat("dd-MMM-yyyy");

	private int numberOfColumns() {
		return headerRow.size();
	}
	
	private static Font tableFont = new Font(Font.HELVETICA);

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Rectangle rectangle = PageSize.A4.rotate();
		document.setPageSize(rectangle);

		Set<MineralResource> mineralResourcesCollection = (Set<MineralResource>) model
				.get("resourcesCollection");

		Table table = new Table(numberOfColumns());

		table.setPadding(2);

		table.setBorderWidth(0);



		document.setHeader(header);
		document.setFooter(footer);

		for (String headerItem : headerRow) {
			table.addCell(tableString(headerItem));
		}

		for (MineralResource mineralResource : mineralResourcesCollection) {
			table.addCell(mineralResource.getMineralisedZone()
					.getMineralDeposit().getName());
			table.addCell(mineralResource.getMineralisedZone().getName());
			table.addCell(oracleDate.format(mineralResource.getRecordDate())
					.toString().toUpperCase());
			table.addCell("");

			table.addCell(ObjectUtils.toString(mineralResource.getOreUnit()
					.getCode()));
			table.addCell(ObjectUtils.toString(mineralResource.getProven()));
			table.addCell(ObjectUtils.toString(mineralResource.getProbable()));
			table.addCell(ObjectUtils.toString(mineralResource
					.getProvenAndProbable()));
			table.addCell(ObjectUtils.toString(mineralResource.getMeasured()));
			table.addCell(ObjectUtils.toString(mineralResource.getIndicated()));
			table.addCell(ObjectUtils.toString(mineralResource
					.getMeasuredAndIndicated()));
			table.addCell(ObjectUtils.toString(mineralResource.getInferred()));
			table.addCell(ObjectUtils.toString(mineralResource.getOther()));
			for (ResourceGrade resourceGrade : mineralResource
					.getResourceGrades()) {
				table.addCell("");
				table.addCell("");
				table.addCell("");
				table.addCell(ObjectUtils.toString(resourceGrade.getCommodity()
						.getId()));

				table.addCell(ObjectUtils.toString(resourceGrade.getGradeUnit()
						.getCode()));
				table.addCell(ObjectUtils.toString(resourceGrade.getProven()));
				table.addCell(ObjectUtils.toString(resourceGrade.getProbable()));
				table.addCell(ObjectUtils.toString(resourceGrade
						.getProvenAndProbable()));
				table.addCell(ObjectUtils.toString(resourceGrade.getMeasured()));
				table.addCell(ObjectUtils.toString(resourceGrade.getIndicated()));
				table.addCell(ObjectUtils.toString(resourceGrade
						.getMeasuredAndIndicated()));
				table.addCell(ObjectUtils.toString(resourceGrade.getInferred()));
				table.addCell(ObjectUtils.toString(resourceGrade.getOther()));
			}
		}

		document.add(table);
	}

	private HeaderFooter header = new HeaderFooter(new Phrase("OZMIN Resources and Grades (QA Sheet)"), false);
	 
	private HeaderFooter footer = new HeaderFooter(new Phrase("This is page "), new Phrase("."));
	
	@Override
	protected Document newDocument() {
		return new Document(PageSize.A4.rotate(), 0, 0, 36, 36);

	}

	private Phrase tableString(Object obj) {
		String str= ObjectUtils.toString(obj);
		return new Phrase(str, tableFont);
	}
	
}
