package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 회원정보를 받아 객체로 저장
    Member save(Member member);

    // 찾는데 없을 경우 널을 반환하는데 옵션을 줄 수 있다.
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
