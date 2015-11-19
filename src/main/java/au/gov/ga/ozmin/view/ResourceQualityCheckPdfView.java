package au.gov.ga.ozmin.view;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import au.gov.ga.ozmin.model.MineralResource;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class ResourceQualityCheckPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		

		Set<MineralResource> mineralResourcesCollection = (Set<MineralResource>) model.get("mineralResourcesCollection");
		
		Table table = new Table(2);
		table.addCell("RESOURCENO");
		table.addCell("RECORDDATE");
		
		for (MineralResource mineralResource : mineralResourcesCollection) {
			table.addCell(mineralResource.getId().toString());
			table.addCell(mineralResource.getRecordDate().toString());
		}
		
		document.add(table);
	}

}
