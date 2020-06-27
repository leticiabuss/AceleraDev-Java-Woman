package challenge;

public class Jogador {
	
	public String id; 				//campo[0]
	public String name; 			//campo[1]
	public String full_name; 		//campo[2]
	public String club;				//campo[3]
	public String age;				//campo[6]
	public String birth_date;		//campo[8]
	public String nationality;		//campo[14]
	public String eur_wage;			//campo[17]	
	public String eur_release_clause;//campo[18]
	
	public Jogador(String id, String name, String full_name, String club, String age, String birth_date,
			String nationality, String eur_wage, String eur_release_clause) {
		this.id = id;
		this.name = name;
		this.full_name = full_name;
		this.club = club;
		this.age = age;
		this.birth_date = birth_date;
		this.nationality = nationality;
		this.eur_wage = eur_wage;
		this.eur_release_clause = eur_release_clause;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEur_wage() {
		return eur_wage;
	}

	public void setEur_wage(String eur_wage) {
		this.eur_wage = eur_wage;
	}

	public String getEur_release_clause() {
		return eur_release_clause;
	}

	public void setEur_release_clause(String eur_release_clause) {
		this.eur_release_clause = eur_release_clause;
	}

	@Override
	public String toString() {
		return "Jogador [id=" + id + ", name=" + name + ", full_name=" + full_name + ", club=" + club + ", age=" + age
				+ ", birth_date=" + birth_date + ", nationality=" + nationality + ", eur_wage=" + eur_wage
				+ ", eur_release_clause=" + eur_release_clause + "]";
	}	
}
