package Model;

public class ServicemanServicess {
	private int sid, serviceman_id, sprice;
	private String service_name, service_duration, service_category;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getServiceman_id() {
		return serviceman_id;
	}

	public void setServiceman_id(int serviceman_id) {
		this.serviceman_id = serviceman_id;
	}

	public int getSprice() {
		return sprice;
	}

	public void setSprice(int sprice) {
		this.sprice = sprice;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public String getService_duration() {
		return service_duration;
	}

	public void setService_duration(String service_duration) {
		this.service_duration = service_duration;
	}

	public String getService_category() {
		return service_category;
	}

	public void setService_category(String service_category) {
		this.service_category = service_category;
	}

	@Override
	public String toString() {
		return "ServicemanServicess [sid=" + sid + ", serviceman_id=" + serviceman_id + ", sprice=" + sprice
				+ ", service_name=" + service_name + ", service_duration=" + service_duration + ", service_category="
				+ service_category + "]";
	}

}

