package softuni.bg.mobilelele.model.entity;

import softuni.bg.mobilelele.model.entity.enums.EngineEnum;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    private String text;

    private EngineEnum engine;
}
