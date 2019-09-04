package cn.xdf.security.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @desc 漏洞信息
 * @author Secguard
 * @date 2019-09-03
 * 
 * alter table vulinfo add foreign key(workorder_id) references workorder(id);
 * alter table vulinfo drop foreign key (workorder_id)
 */
@Entity(name="vulinfo")
public class VulInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	@Column
	private String vulName;
	@Column
	private String vulDesc;
	@Column
	private String vulDetail;
	@Column
	private String vulRes;
	@Column
	private int level;
	@Column
	private String docPath;
	@ManyToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="workorder_id",referencedColumnName="id") 
	private WorkOrder workOrder;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getVulDetail() {
		return vulDetail;
	}
	public void setVulDetail(String vulDetail) {
		this.vulDetail = vulDetail;
	}
	public String getDocPath() {
		return docPath;
	}
	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}
	@Override
	public String toString() {
		return "VulInfo [ID=" + ID + ", vulName=" + vulName + ", vulDesc=" + vulDesc + ", vulDetail=" + vulDetail
				+ ", vulRes=" + vulRes + ", level=" + level + ", docPath=" + docPath + "]";
	}
	
	
	
}
