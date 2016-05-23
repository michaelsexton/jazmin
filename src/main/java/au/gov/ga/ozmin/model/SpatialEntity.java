package au.gov.ga.ozmin.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vividsolutions.jts.geom.Geometry;

/**
 * Created by michael on 10/09/2015.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ENTITY_TYPE", discriminatorType = DiscriminatorType.STRING)
@Table(schema = "A", name = "ENTITIES")
public abstract class SpatialEntity {

	@Id
	@Column(name = "ENO")
	private Long id;

	@Column(name = "ENTITYID")
	private String name;

	@Column(name = "GEOM")
	@Type(type = "org.hibernate.spatial.GeometryType")
	private Geometry geometry;
	
	@Column(name = "GEOM_ORIGINAL")
	@Type(type = "org.hibernate.spatial.GeometryType")
	private Geometry originalGeometry;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Geometry getGeometry() {
		return geometry;
	}
    
	@JsonIgnore
	public double getX() {
		if (geometry != null) {
			return geometry.getCoordinate().x;

		}
		return 0.0;
	}

	@JsonIgnore
	public double getY() {
		if (geometry != null) {
			return geometry.getCoordinate().y;

		}
		return 0.0;
	}

	@JsonIgnore
	public double getZ() {
		if (geometry != null) {
			return geometry.getCoordinate().z;

		}
		return 0.0;
	}

	public Geometry getOriginalGeometry() {
		return originalGeometry;
	}

	public void setOriginalGeometry(Geometry originalGeometry) {
		this.originalGeometry = originalGeometry;
	}

}
