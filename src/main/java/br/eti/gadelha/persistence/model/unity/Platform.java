package br.eti.gadelha.persistence.model.unity;

import br.eti.gadelha.persistence.model.Country;
import br.eti.gadelha.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Audited @Entity @Table @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class Platform extends GenericEntity {
	private String visualCallsign;
	private String telegraphicCallsign;
	private String internationalCallsign;
	private String name;
	private String internationalName;
//    private String imo;
//    private String navalCallsign;
//    private EnumTypeVessel type;
//    private Date since;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "country")
	private Country country;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "platformCategory")
	private PlatformCategory platformCategory;
}