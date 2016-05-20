package au.gov.ga.ozmin.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

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

	/*public Geometry getGeometry() {
		return geometry;
	}

	public double getX() {
		if (geometry != null) {
			return geometry.getCoordinate().x;

		}
		return 0.0;
	}

	public double getY() {
		if (geometry != null) {
			return geometry.getCoordinate().y;

		}
		return 0.0;
	}

	public double getZ() {
		if (geometry != null) {
			return geometry.getCoordinate().z;

		}
		return 0.0;
	}*/

	/*public Geometry getOriginalGeometry() {
		return originalGeometry;
	}

	public void setOriginalGeometry(Geometry originalGeometry) {
		this.originalGeometry = originalGeometry;
	}*/

}
