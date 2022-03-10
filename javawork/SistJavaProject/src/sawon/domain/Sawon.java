package sawon.domain;

public class Sawon {

	private Long id;
	private String name;
	private String gender;
	private String buseo;
	private Long pay;

	
	public Sawon(String name, String gender, String buseo, Long pay) {
		super();
		this.name = name;
		this.gender = gender;
		this.buseo = buseo;
		this.pay = pay;
	}

	public Sawon(Long id, String name, String gender, String buseo, Long pay) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.buseo = buseo;
		this.pay = pay;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBuseo() {
		return buseo;
	}

	public void setBuseo(String buseo) {
		this.buseo = buseo;
	}

	public Long getPay() {
		return pay;
	}

	public void setPay(Long pay) {
		this.pay = pay;
	}

}
