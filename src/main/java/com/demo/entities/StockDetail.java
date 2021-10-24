package com.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="stock_details")
@DynamicUpdate
@DynamicInsert
@JsonInclude(Include.NON_EMPTY)
public class StockDetail extends Base {

	 	@Id
	    @SequenceGenerator(name = "stock_details_seq", sequenceName = "stock_details_id_seq", allocationSize = 1)
	    @GeneratedValue(generator = "stock_details_seq", strategy = GenerationType.SEQUENCE)
	    @Column(name="id")
	    private Integer itemId;

	    @NotBlank
	    @Size(max = 100)
	    @Column(name="item_name", nullable=false)
	    private String itemName;

	    @NotBlank
	    @Column(name="item_description")
	    @Size(max=200)
	    private String itemDescription;
	    
	    @Column(name="quantity")
	    private Integer quantity;
	    
}
