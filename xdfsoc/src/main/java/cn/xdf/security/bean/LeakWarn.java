package cn.xdf.security.bean;
import java.util.Date;

public class LeakWarn {
	private long id;
	private String title;
	private String content;
	private String link;
	private String srcSite;
	private Date date;
	private String product;
	private String version;
	private String solution;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getSrcSite() {
		return srcSite;
	}
	public void setSrcSite(String srcSite) {
		this.srcSite = srcSite;
	}
	
	
	
	
	
	
	
	
}
