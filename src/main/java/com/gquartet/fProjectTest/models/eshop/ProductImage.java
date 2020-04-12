/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gquartet.fProjectTest.models.eshop;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Coily1805
 */
@Entity
@Table(name = "product_image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductImage.findAll", query = "SELECT p FROM ProductImage p"),
    @NamedQuery(name = "ProductImage.findByProductImageId", query = "SELECT p FROM ProductImage p WHERE p.productImageId = :productImageId"),
    @NamedQuery(name = "ProductImage.findByProductFilename", query = "SELECT p FROM ProductImage p WHERE p.productFilename = :productFilename")})
public class ProductImage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_image_id")
    private Integer productImageId;
    @Lob
    @Column(name = "product_image")
    private byte[] productImage;
    @Size(max = 30)
    @Column(name = "product_filename")
    private String productFilename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productImageId")
    private Collection<Product> productCollection;

    public ProductImage() {
    }

    public ProductImage(Integer productImageId) {
        this.productImageId = productImageId;
    }

    public Integer getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(Integer productImageId) {
        this.productImageId = productImageId;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

    public String getProductFilename() {
        return productFilename;
    }

    public void setProductFilename(String productFilename) {
        this.productFilename = productFilename;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productImageId != null ? productImageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductImage)) {
            return false;
        }
        ProductImage other = (ProductImage) object;
        if ((this.productImageId == null && other.productImageId != null) || (this.productImageId != null && !this.productImageId.equals(other.productImageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gquartet.fProjectTest.models.eshop.ProductImage[ productImageId=" + productImageId + " ]";
    }
    
}
