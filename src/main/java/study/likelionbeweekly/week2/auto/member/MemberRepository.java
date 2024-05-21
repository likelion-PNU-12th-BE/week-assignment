package study.likelionbeweekly.week2.auto.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long id);
}
