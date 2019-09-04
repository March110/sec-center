package cn.xdf.security.bean.copy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 漏洞类型表
 * @author Secguard
 */

@Entity(name="vultype")
public class VulType {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String vulName;
	@Column
	private String vulDesc;
	@Column
	private String vulRes;
	
	
	
	public VulType() {
		super();
		// TODO Auto-generated constructor stub
	}



	public VulType(int id, String vulName, String vulDesc, String vulRes) {
		super();
		this.id = id;
		this.vulName = vulName;
		this.vulDesc = vulDesc;
		this.vulRes = vulRes;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getVulName() {
		return vulName;
	}



	public void setVulName(String vulName) {
		this.vulName = vulName;
	}



	public String getVulDesc() {
		return vulDesc;
	}



	public void setVulDesc(String vulDesc) {
		this.vulDesc = vulDesc;
	}



	public String getVulRes() {
		return vulRes;
	}



	public void setVulRes(String vulRes) {
		this.vulRes = vulRes;
	}



	@Override
	public String toString() {
		return "VulType [id=" + id + ", vulName=" + vulName + ", vulDesc=" + vulDesc + ", vulRes=" + vulRes + "]";
	}



	

	
	

}
