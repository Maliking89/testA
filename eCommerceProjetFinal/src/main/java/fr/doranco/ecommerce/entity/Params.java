package fr.doranco.ecommerce.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "params")
public class Params implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "cle_cryptage_pwd", nullable = false)
	private byte[] cleCryptagePwd;

	@Column(name = "cle_cryptage_cp", nullable = false)
	private byte[] cleCryptageCp;
	
	

	public Params() {
		
	}

	@Override
	public String toString() {
		return "Params [id=" + id + ", cleCryptagePwd=" + Arrays.toString(cleCryptagePwd) + ", cleCryptageCp="
				+ Arrays.toString(cleCryptageCp) + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getCleCryptagePwd() {
		return cleCryptagePwd;
	}

	public void setCleCryptagePwd(byte[] cleCryptagePwd) {
		this.cleCryptagePwd = cleCryptagePwd;
	}

	public byte[] getCleCryptageCp() {
		return cleCryptageCp;
	}

	public void setCleCryptageCp(byte[] cleCryptageCp) {
		this.cleCryptageCp = cleCryptageCp;
	}

	
	
	

}
