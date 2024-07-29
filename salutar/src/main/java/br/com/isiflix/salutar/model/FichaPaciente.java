package br.com.isiflix.salutar.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_fichapaciente")
public class FichaPaciente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ficha")
	private Integer idFicha;
	
	@Column(name="nome", length=100, nullable=false)
	private String nomePaciente;
	
	@Column(name="data_nasc")
	private LocalDate dataNascimento;
	
	@Column(name="sexo", length=1)
	private String sexo;
	
	@Column(name="cep", length=10)
	private String cep;
	
	@Column(name="endereco", length=100)
	private String endereco;
	
	@Column(name="numero_complemento", length=45)
	private String numeroComplemento;
	
	@Column(name="cidade", length=45)
	private String cidade;
	
	@Column(name="estado", length=2)
	private String estado;
	
	@Column(name="ocupacao", length=45)
	private String ocupacao;
	
	@Column(name="diagnostico_clinico", columnDefinition="TEXT")
	private String diagnosticoClinico;
	
	@Column(name="queixaPrincipal", columnDefinition="TEXT")
	private String queixaPrincipal;
	
	@Column(name="hmp_hma", columnDefinition="TEXT")
	private String hmpHma;
	
	@Column(name="medicacoes", columnDefinition="TEXT")
	private String medicacoes;
	
	@Column(name="exames_complementares", columnDefinition="TEXT")
	private String examesComplementares;
	
	@Column(name="exame_fisico", columnDefinition="TEXT")
	private String exameFisico;
	
	@Column(name="conduta_clinica", columnDefinition="TEXT")
	private String condutaClinica;
	
	@Column(name="diagnostico", columnDefinition="TEXT")
	private String diagnostico;
	
	@Column(name="uuid", length=45)
	private String uuid;
	
	@Column(name="link_foto", length=255)
	private String linkFoto;
	
	@Column(name="ativo")
	private Integer ativo;
	
	@OneToMany(mappedBy="ficha", cascade=CascadeType.ALL)
	@JsonIgnoreProperties("ficha")
	private List<Midia> midias;

	public Integer getIdFicha() {
		return idFicha;
	}

	public List<Midia> getMidias() {
		return midias;
	}

	public void setMidias(List<Midia> midias) {
		this.midias = midias;
	}

	public void setIdFicha(Integer idFicha) {
		this.idFicha = idFicha;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumeroComplemento() {
		return numeroComplemento;
	}

	public void setNumeroComplemento(String numeroComplemento) {
		this.numeroComplemento = numeroComplemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

	public String getDiagnosticoClinico() {
		return diagnosticoClinico;
	}

	public void setDiagnosticoClinico(String diagnosticoClinico) {
		this.diagnosticoClinico = diagnosticoClinico;
	}

	public String getQueixaPrincipal() {
		return queixaPrincipal;
	}

	public void setQueixaPrincipal(String queixaPrincipal) {
		this.queixaPrincipal = queixaPrincipal;
	}

	public String getHmpHma() {
		return hmpHma;
	}

	public void setHmpHma(String hmpHma) {
		this.hmpHma = hmpHma;
	}

	public String getMedicacoes() {
		return medicacoes;
	}

	public void setMedicacoes(String medicacoes) {
		this.medicacoes = medicacoes;
	}

	public String getExamesComplementares() {
		return examesComplementares;
	}

	public void setExamesComplementares(String examesComplementares) {
		this.examesComplementares = examesComplementares;
	}

	public String getExameFisico() {
		return exameFisico;
	}

	public void setExameFisico(String exameFisico) {
		this.exameFisico = exameFisico;
	}

	public String getCondutaClinica() {
		return condutaClinica;
	}

	public void setCondutaClinica(String condutaClinica) {
		this.condutaClinica = condutaClinica;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	
	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}
	
}
