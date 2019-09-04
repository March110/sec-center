package cn.xdf.security.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 安全评估
 * @author Secguard
 * @date 2019/09/02
 */

@Entity(name="workorder")
public class WorkOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	@Column
	private String department;//部门
	@Column
	private String bizLine;//业务线
	@Column
	private String proName;//项目名称
	@Column
	private String proManager;//项目经理或开发负责人
	
	@Column
	private String applyer;
	@Column
	private String secTester;
	@Column
	private String priority;
	@Column
	//@Temporal(value=TemporalType.TIME)
	private String applyTime;//申请时间
	@Column
	private String expectedTime;//期望测试结束时间
	@Column
	private String startTime;//测试开始时间
	@Column
	private String endTime;//测试结束时间
	@Column
	private String fixedTime;//修复完成时间
	@Column
	private String status;
	@Column
	private String remarks;
	@Column
	private String appName;
	@Column
	private String link;  //ip  or  url
	@Column
	private String appDesc;//应用信息描述信息
	@Column
	private String framework;
	@Column
	private String db;
	@Column
	private String middleware;
	@OneToMany(mappedBy="workOrder",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY) 
	private List<VulInfo> vulInfos;
	@Column
	private String docPath;
	
	@Column
	private String ccEmail;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProManager() {
		return proManager;
	}

	public void setProManager(String proManager) {
		this.proManager = proManager;
	}

	public String getSecTester() {
		return secTester;
	}

	public void setSecTester(String secTester) {
		this.secTester = secTester;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getFixedTime() {
		return fixedTime;
	}

	public void setFixedTime(String fixedTime) {
		this.fixedTime = fixedTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getBizLine() {
		return bizLine;
	}

	public void setBizLine(String bizLine) {
		this.bizLine = bizLine;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAppDesc() {
		return appDesc;
	}

	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}

	public String getFramework() {
		return framework;
	}

	public void setFramework(String framework) {
		this.framework = framework;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getMiddleware() {
		return middleware;
	}

	public void setMiddleware(String middleware) {
		this.middleware = middleware;
	}

	public List<VulInfo> getVulInfos() {
		return vulInfos;
	}

	public void setVulInfos(List<VulInfo> vulInfos) {
		this.vulInfos = vulInfos;
	}

	public String getDocPath() {
		return docPath;
	}

	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}

	public String getApplyer() {
		return applyer;
	}

	public void setApplyer(String applyer) {
		this.applyer = applyer;
	}

	public String getCcEmail() {
		return ccEmail;
	}

	public void setCcEmail(String ccEmail) {
		this.ccEmail = ccEmail;
	}
	
	public String getExpectedTime() {
		return expectedTime;
	}

	public void setExpectedTime(String expectedTime) {
		this.expectedTime = expectedTime;
	}

	@Override
	public String toString() {
		return "WorkOrder [ID=" + ID + ", department=" + department + ", bizLine=" + bizLine + ", proName=" + proName
				+ ", proManager=" + proManager + ", applyer=" + applyer + ", secTester=" + secTester + ", priority="
				+ priority + ", applyTime=" + applyTime + ", expectedTime=" + expectedTime + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", fixedTime=" + fixedTime + ", status=" + status + ", remarks=" + remarks
				+ ", appName=" + appName + ", link=" + link + ", appDesc=" + appDesc + ", framework=" + framework
				+ ", db=" + db + ", middleware=" + middleware + ", vulInfos=" + vulInfos + ", docPath=" + docPath
				+ ", ccEmail=" + ccEmail + "]";
	}
	
}
