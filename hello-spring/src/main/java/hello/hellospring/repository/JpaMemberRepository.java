package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    // 앞에서 한 DataSourse마냥 jpa를 동작시킴
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist (member); // 해당 객체를 영구저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find (Member.class, id);// 조회할 타입과 식별자
        return Optional.ofNullable (member);
    }

    @Override
    public Optional<Member> findByName(String name) { // 식별자인 PK가 아닌 다른 것으로 할때는 쿼리설정
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() { //마찬가지로 쿼리설정(JPQL)
        return  em.createQuery ("select m from Member m", Member.class)
                .getResultList ();
    }
}
