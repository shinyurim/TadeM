package project.TadeM.requestBoard.entity;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "requestBoard")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class requestBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String contents;
	private LocalDateTime regDt;
	private int hits;
	private int price;
	private String period;

}
