package au.gov.ga.ozmin.util;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opower.unitsofmeasure.UnitJacksonModule;

public class CustomMapper extends ObjectMapper {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8054717390969839744L;

	public CustomMapper() {
		super();
		this.registerModule(new JtsModule());
		this.registerModule(new UnitJacksonModule());
	}
}
