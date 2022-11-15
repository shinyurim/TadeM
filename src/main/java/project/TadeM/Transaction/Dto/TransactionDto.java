package project.TadeM.Transaction.Dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TransactionDto {

	Long id;

	long productId;
	String userId;

	Long payPrice; // 결제 금액
	String status; // 거래 신청중 - 거래 진행중 - 거래 완료

	LocalDateTime regDt; // 신청일
	String period; // 의뢰종료일

	//join
	String name;

	long totalCount;
	long seq;

}
