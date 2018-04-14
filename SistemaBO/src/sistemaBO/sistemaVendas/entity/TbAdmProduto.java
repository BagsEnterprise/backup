/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaBO.sistemaVendas.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "tb_adm_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAdmProduto.findAll", query = "SELECT t FROM TbAdmProduto t"),
    @NamedQuery(name = "TbAdmProduto.findByCodigoProduto", query = "SELECT t FROM TbAdmProduto t WHERE t.codigoProduto = :codigoProduto"),
    @NamedQuery(name = "TbAdmProduto.findByCodigoBarras", query = "SELECT t FROM TbAdmProduto t WHERE t.codigoBarras = :codigoBarras"),
    @NamedQuery(name = "TbAdmProduto.findByNomeProduto", query = "SELECT t FROM TbAdmProduto t WHERE t.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "TbAdmProduto.findByPrecoCusto", query = "SELECT t FROM TbAdmProduto t WHERE t.precoCusto = :precoCusto"),
    @NamedQuery(name = "TbAdmProduto.findByPrecoVenda", query = "SELECT t FROM TbAdmProduto t WHERE t.precoVenda = :precoVenda"),
    @NamedQuery(name = "TbAdmProduto.findByQtdMinima", query = "SELECT t FROM TbAdmProduto t WHERE t.qtdMinima = :qtdMinima"),
    @NamedQuery(name = "TbAdmProduto.findByQtdMaxima", query = "SELECT t FROM TbAdmProduto t WHERE t.qtdMaxima = :qtdMaxima"),
    @NamedQuery(name = "TbAdmProduto.findByQtdEstoque", query = "SELECT t FROM TbAdmProduto t WHERE t.qtdEstoque = :qtdEstoque"),
    @NamedQuery(name = "TbAdmProduto.findByAtivo", query = "SELECT t FROM TbAdmProduto t WHERE t.ativo = :ativo")})
public class TbAdmProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo_produto")
    private Long codigoProduto;
    @Column(name = "codigo_barras")
    private String codigoBarras;
    @Column(name = "nome_produto")
    private String nomeProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco_custo")
    private Float precoCusto;
    @Column(name = "preco_venda")
    private Float precoVenda;
    @Column(name = "qtd_minima")
    private Integer qtdMinima;
    @Column(name = "qtd_maxima")
    private Integer qtdMaxima;
    @Column(name = "qtd_estoque")
    private Integer qtdEstoque;
    @Column(name = "ativo")
    private String ativo;
    @OneToMany(mappedBy = "codigoProdutoPai")
    private List<TbAdmProduto> tbAdmProdutoList;
    @JoinColumn(name = "codigo_produto_pai", referencedColumnName = "codigo_produto")
    @ManyToOne
    private TbAdmProduto codigoProdutoPai;

    public TbAdmProduto() {
    }

    public TbAdmProduto(Long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Float precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Integer getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(Integer qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    public Integer getQtdMaxima() {
        return qtdMaxima;
    }

    public void setQtdMaxima(Integer qtdMaxima) {
        this.qtdMaxima = qtdMaxima;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    @XmlTransient
    public List<TbAdmProduto> getTbAdmProdutoList() {
        return tbAdmProdutoList;
    }

    public void setTbAdmProdutoList(List<TbAdmProduto> tbAdmProdutoList) {
        this.tbAdmProdutoList = tbAdmProdutoList;
    }

    public TbAdmProduto getCodigoProdutoPai() {
        return codigoProdutoPai;
    }

    public void setCodigoProdutoPai(TbAdmProduto codigoProdutoPai) {
        this.codigoProdutoPai = codigoProdutoPai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoProduto != null ? codigoProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAdmProduto)) {
            return false;
        }
        TbAdmProduto other = (TbAdmProduto) object;
        if ((this.codigoProduto == null && other.codigoProduto != null) || (this.codigoProduto != null && !this.codigoProduto.equals(other.codigoProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaBO.sistemaVendas.entity.TbAdmProduto[ codigoProduto=" + codigoProduto + " ]";
    }
    
}
