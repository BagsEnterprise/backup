/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaBO.sistemaVendas.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "tb_adm_pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAdmPessoa.findAll", query = "SELECT t FROM TbAdmPessoa t"),
    @NamedQuery(name = "TbAdmPessoa.findByCodigoPessoa", query = "SELECT t FROM TbAdmPessoa t WHERE t.codigoPessoa = :codigoPessoa"),
    @NamedQuery(name = "TbAdmPessoa.findByNome", query = "SELECT t FROM TbAdmPessoa t WHERE t.nome = :nome"),
    @NamedQuery(name = "TbAdmPessoa.findByDataNascimento", query = "SELECT t FROM TbAdmPessoa t WHERE t.dataNascimento = :dataNascimento")})
public class TbAdmPessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo_pessoa")
    private Long codigoPessoa;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @OneToMany(mappedBy = "reportaSeA")
    private List<TbAdmPessoa> tbAdmPessoaList;
    @JoinColumn(name = "reporta_se_a", referencedColumnName = "codigo_pessoa")
    @ManyToOne
    private TbAdmPessoa reportaSeA;

    public TbAdmPessoa() {
    }

    public TbAdmPessoa(Long codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public TbAdmPessoa(Long codigoPessoa, String nome) {
        this.codigoPessoa = codigoPessoa;
        this.nome = nome;
    }

    public Long getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(Long codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @XmlTransient
    public List<TbAdmPessoa> getTbAdmPessoaList() {
        return tbAdmPessoaList;
    }

    public void setTbAdmPessoaList(List<TbAdmPessoa> tbAdmPessoaList) {
        this.tbAdmPessoaList = tbAdmPessoaList;
    }

    public TbAdmPessoa getReportaSeA() {
        return reportaSeA;
    }

    public void setReportaSeA(TbAdmPessoa reportaSeA) {
        this.reportaSeA = reportaSeA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPessoa != null ? codigoPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAdmPessoa)) {
            return false;
        }
        TbAdmPessoa other = (TbAdmPessoa) object;
        if ((this.codigoPessoa == null && other.codigoPessoa != null) || (this.codigoPessoa != null && !this.codigoPessoa.equals(other.codigoPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaBO.sistemaVendas.entity.TbAdmPessoa[ codigoPessoa=" + codigoPessoa + " ]";
    }
    
}
