package mx.com.trnetwork.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

@Entity
@SequenceGenerator(name = "player_Sequence", sequenceName = "PLAYER_SEQ")
public class Player {
	@Id
	
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_Sequence")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "sequences")
	@TableGenerator( name = "sequences", valueColumnName = "player_seq")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "num")
	private int num;

	@Column(name = "position")
	private String position;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id", nullable = false)
	private Team team;

	public Player() {
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", num=" + num + ", position=" + position + ", team=" + team
				+ "]";
	}

	
}