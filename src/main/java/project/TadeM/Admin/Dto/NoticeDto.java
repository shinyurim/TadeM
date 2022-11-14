package project.TadeM.Admin.Dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeDto {

	private Long id;

	private String title;
	private String contents;
	private LocalDateTime regDt;

}
