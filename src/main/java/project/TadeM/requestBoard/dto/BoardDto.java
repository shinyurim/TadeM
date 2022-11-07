package project.TadeM.requestBoard.dto;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {

	private Long id;

	private String title;
	private String contents;
	private LocalDateTime regDt;
	private int hits;
	private int price;
	private String period;


}
