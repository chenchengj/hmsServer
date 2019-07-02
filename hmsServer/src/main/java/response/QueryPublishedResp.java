package response;

import java.util.List;

import dao.HomeworkPublish;

public class QueryPublishedResp {

	private String code;
    private String msg;
    private List<HomeworkPublish> publishs;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<HomeworkPublish> getPublishs() {
		return publishs;
	}
	public void setPublishs(List<HomeworkPublish> publishs) {
		this.publishs = publishs;
	}
    
    
}
