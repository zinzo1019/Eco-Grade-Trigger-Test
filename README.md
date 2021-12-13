# Eco-Grade-Trigger-Test

트리거(Trigger)를 사용해서 포인트에 따른 에코 등급 구현하기

예제)

0점 이상 ~ 100점 미만 -> C 등급
100점 이상 ~ 200점 미만 -> B 등급
200점 이상 -> A 등급

테스트 코드 실행법)

1. 빈 데이터베이스를 생성한다. 
2. application.properties에서 스프링부트 프로젝트와 연결한다. 
3. 스프링부트를 실행한다. -> user 테이블과 grade 테이블이 자동 생성된다.
4. heidi 또는 workbench에서 쿼리 탭을 하나 연 뒤, 트리거와 함수를 생성한다. (아래 구문 복사/붙여넣기)

/*
user 테이블에 업데이트가 진행되면 grade에 데이터도 업데이트된다. 
*/
DELIMITER //
CREATE TRIGGER define_grade
AFTER UPDATE ON user
	FOR EACH ROW
	BEGIN
		UPDATE grade 
		SET grade = setGrade(NEW.point)
		WHERE user_id = OLD.user_id;
	END //
DELIMITER;

/*
포인트에 따라 등급을 계산하는 함수
*/
DELIMITER $$
CREATE FUNCTION setGrade(POINT INT)
	RETURNS CHAR /* varchar은 사용 불가 */
BEGIN
	RETURN 
		case 
			when POINT > 199 then "A"
			when POINT > 99 AND POINT < 200 then "B"
			when POINT > 0 and POINT < 100 then "C"
		ELSE "D"
	END;
END $$
DELIMITER ;

5. 쿼리문을 실행한다.
6. 스프링부트 프로젝트의 Test > RepositoryTest 클래스 안에 있는 insertDummiesInUser() 함수를 실행한다. -> user 테이블에 데이터가 삽입된다.
7. insertDummiesInGrade() 함수를 실행한다. -> grade 테이블에 데이터가 삽입된다.
8. 마지막으로 updateGrade() 함수를 실행한다. -> user 테이블의 point 속성의 데이터 값이 업데이트 되면서 트리거가 실행되어 grade 테이블의 grade 속성의 데이터 값도 업데이트 된다. 
