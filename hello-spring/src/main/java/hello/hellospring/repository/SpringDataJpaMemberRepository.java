package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
// 인터페이스는 다중상속이 되며 extends로 나타낸다. 그리고 JpaRepository을 상속 받는 순간 Bean에 등록되며 스프링부트가 구현체를 구현해줌
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // 이건 공통API인 JpaRepository에 속하지않아서 따로 넣어둠 PK가 아닌 다른것을 만들때 하지만 findby로 비슷하게 만들어줌
    // JPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
// 만약 이렇게 쉬운 쿼리가 아니면 Querydsl 이라는 라이브러리나 네이티브 쿼리, jdbc 템플릿을 사용하자