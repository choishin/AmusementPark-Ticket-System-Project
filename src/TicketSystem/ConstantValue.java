package TicketSystem;
/*
 * ConstantValue : 놀이공원에서 제공하는 상품 이름과 가격을 배열에 저장
 */
public class ConstantValue {

	final static String[] ticket_type = {
			//이용권 가격 (주간,야간)
			"normal_adult_day_pass", 
			"normal_student_day_pass", 
			"normal_child_day_pass", 
			"normal_senior_day_pass",
			"normal_adult_night_pass",
			"normal_student_night_pass",
			"normal_child_night_pass",
			"normal_senior_night_pass",
			//장애인 우대가격 (주간,야간)
			 "handicap_adult_day_pass",
			 "handicap_student_day_pass",
			 "handicap_child_day_pass",
			 "handicap_senior_day_pass",
			 "handicap_adult_night_pass",
			 "handicap_student_night_pass",
			 "handicap_child_night_pass",
			 "handicap_senior_night_pass",
			//국가유공자 우대가격
			 "honor_adult_day_pass",
			 "honor_student_day_pass",
			 "honor_child_day_pass",
			 "honor_senior_day_pass",
			 "honor_adult_night_pass",
			 "honor_student_night_pass",
			 "honor_child_night_pass",
			 "honor_senior_night_pass",
			//다자녀 우대가격
			 "3kidsfamily_adult_day_pass",
			 "3kidsfamily_student_day_pass",
			 "3kidsfamily_children_day_pass",
			 "3kidsfamily_senior_day_pass",
			 "3kidsfamily_adult_night_pass",
			 "3kidsfamily_student_night_pass",
			 "3kidsfamily_child_night_pass",
			 "3kidsfamily_senior_night_pass",
			//임신부 우대가격
			 "pregnant_adult_day_pass ",
			 "pregnant_adult_night_pass",
			
	};
	
	final static int[] ticket_price = {
			//이용권 가격 (주간,야간)
			56000,47000,44000,44000,
			46000,40000,37000,37000,
			//장애인 우대가격 (주간,야간)
			33000,28000,26000,26000,
			27000,24000,23000,23000,
			//국가유공자 우대가격
			28000,23500,22000,22000,
			23000,20000,18500,18500,
			//다자녀 우대가격
			44000,37000,35000,35000,
			36500,32000,29000,29000
	};
}
