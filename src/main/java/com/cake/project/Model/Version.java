package com.cake.project.Model;

public class Version {

	private String  pmallUrl;
	private String  feedbackUrl;
	private String  fmarketUrl;
	private String  billDetailUrl;
	private String  versionName;
	private int     versionCode;
	private String  updateUrl;
	private String  updateNote;
	private String code = "1";
	
	public Version(String pmallUrl,String feedbackUrl,String fmarketUrl,String billDetailUrl,
			String versionName,int versionCode,String updateUrl,String updateNote){
		this.setPmallUrl(pmallUrl);
		this.setFmarketUrl(fmarketUrl);
		this.setFeedbackUrl(feedbackUrl);
		this.setBillDetailUrl(billDetailUrl);
		this.setVersionName(versionName);
		this.setVersionCode(versionCode);
		this.setUpdateUrl(updateUrl);
		this.setUpdateNote(updateNote);
	}

	public String getPmallUrl() {
		return pmallUrl;
	}

	public void setPmallUrl(String pmallUrl) {
		this.pmallUrl = pmallUrl;
	}

	public String getFeedbackUrl() {
		return feedbackUrl;
	}

	public void setFeedbackUrl(String feedbackUrl) {
		this.feedbackUrl = feedbackUrl;
	}

	public String getBillDetailUrl() {
		return billDetailUrl;
	}

	public void setBillDetailUrl(String billDetailUrl) {
		this.billDetailUrl = billDetailUrl;
	}

	public String getFmarketUrl() {
		return fmarketUrl;
	}

	public void setFmarketUrl(String fmarketUrl) {
		this.fmarketUrl = fmarketUrl;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public int getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(int versionCode) {
		this.versionCode = versionCode;
	}

	public String getUpdateUrl() {
		return updateUrl;
	}

	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}

	public String getUpdateNote() {
		return updateNote;
	}

	public void setUpdateNote(String updateNote) {
		this.updateNote = updateNote;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
