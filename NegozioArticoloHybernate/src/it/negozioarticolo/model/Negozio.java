package it.negozioarticolo.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "negozio")
public class Negozio {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id")
		private Long id;
		@Column(name = "nome")
		private String nome;
		@Column(name = "indirizzo")
		private String indirizzo;
		@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "negozio", orphanRemoval = true)
		private Set<Articolo> abitanti = new HashSet<>();
		
		
		
		public Negozio() {};
		public Negozio( String nome, String indirizzo, Set<Articolo> abitanti) {
			super();
			
			this.nome = nome;
			this.indirizzo = indirizzo;
			this.abitanti = abitanti;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getIndirizzo() {
			return indirizzo;
		}
		public void setIndirizzo(String indirizzo) {
			this.indirizzo = indirizzo;
		}
		public Set<Articolo> getAbitanti() {
			return abitanti;
		}
		public void setAbitanti(Set<Articolo> abitanti) {
			this.abitanti = abitanti;
		}
		@Override
		public String toString() {
			return "Negozio [id=" + id + ", nome=" + nome + ", indirizzo=" + indirizzo + ", abitanti=" + abitanti + "]";
		}

		
}
