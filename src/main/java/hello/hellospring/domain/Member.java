package hello.hellospring.domain;

import javax.persistence.*;

// jpa가 관리하는 개체이며 PK(프라이머리키)를 설정
@Entity
public class Member {

    // IDENTITY는 값이 없어도 DB에서 알아서 지정해줌 = SEQUENCE, TABLE, 직접
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(name = "username") DB와 컬럼명이 다를때 지정가능
    private String name;
    
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
}
// jpa: 자바 퍼시스턴스 API로 기준만 정해지고 구현은 각 업체들마다 다른데 보통 하이버네이트(hibernate)를 사용한다.
// orm(오브젝트와 릴레이션널데이터베이스를 매핑)기술-DB를 객체로