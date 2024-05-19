package study.likelionbeweekly.week2.manual.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long id);
}
