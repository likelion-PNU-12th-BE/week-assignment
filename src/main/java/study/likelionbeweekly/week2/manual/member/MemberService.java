package study.likelionbeweekly.week2.manual.member;

public interface MemberService {
    void join(Member member);
    Member findById(Long id);
}
